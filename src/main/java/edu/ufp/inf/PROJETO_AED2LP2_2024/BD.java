package edu.ufp.inf.PROJETO_AED2LP2_2024;

import edu.princeton.cs.algs4.RedBlackBST;

import java.util.*;

public class BD implements ArtigoInterface, AutorInterface, PublicacaoInterface {
    private static BD instance;

    private Hashtable<Integer, Artigo> artigos;
    private Hashtable<String, Autor> autores;
    private Hashtable<Integer, Autor> autoresID;
    private Hashtable<Integer, Publicacao> publicacoes;
    //private Hashtable<Integer, Stats> statsArtigo;

    private GrafoArtigos grafoArtigos;
    private GrafoAutores grafoAutores;

    private RedBlackBST<String, Integer> artigoTitulo;
    private RedBlackBST<Integer, Integer> artigoAno;
    private RedBlackBST<String, Integer> nomeAutor;
    private RedBlackBST<String, Integer> nomePublicacao;

    public BD() {
        this.artigos = new Hashtable<>();
        this.autores = new Hashtable<>();
        this.autoresID = new Hashtable<>();
        this.publicacoes = new Hashtable<>();
        this.grafoArtigos = new GrafoArtigos(artigos);
        this.grafoAutores = new GrafoAutores(autoresID);
        this.artigoTitulo = new RedBlackBST<>();
        this.artigoAno = new RedBlackBST<>();
        this.nomeAutor = new RedBlackBST<>();
        this.nomePublicacao = new RedBlackBST<>();

    }

    public static synchronized BD getInstance() {
        if (instance == null) {
            instance = new BD();
        }
        return instance;
    }

    // Métodos para adicionar, remover e pesquisar artigos
    @Override
    public void adicionarArtigo(Artigo artigo) {
        artigos.put(artigo.getId(), artigo);
        artigoAno.put(artigo.getId(), artigo.getAno());
        artigoTitulo.put(artigo.getTitulo(), artigo.getId());
    }

    public void adicionarCitacao(Artigo from, Artigo to) {
        if (!artigos.contains(from)) {
            artigos.put(from.getId(), from);
        }
        if (!artigos.contains(to)) {
            artigos.put(from.getId(), to);
        }
        grafoArtigos.adicionarCitacao(from, to);

    }

    @Override
    public void removerArtigo(int id) {
        artigos.get(id).setActive(false);
    }

    @Override
    public Artigo pesquisarArtigo(int id) {
        return artigos.get(id);
    }

    @Override
    public void listarArtigos() {
        for (int id : artigos.keySet()) {
            System.out.println(artigos.get(id));
        }
    }


    // Métodos para adicionar, remover e pesquisar autores
    @Override
    public void adicionarAutor(Autor autor) {
        autoresID.put(autor.getId(), autor);
        autores.put(autor.getOrcid(), autor);
        nomeAutor.put(autor.getNome(), autor.getId());
    }

    public void adicionarColaboracao(Autor a, Autor b, Integer artigo) {
        if (grafoAutores.getColaboracoes().V() <= a.getId()) {
            grafoAutores.increaseGraph(a.getId());

        }
        if (grafoAutores.getColaboracoes().V() <= b.getId()) {
            grafoAutores.increaseGraph(b.getId());
        }
        grafoAutores.addColaboracao(a, b, artigo);
    }

    public void adicionarColaboracao(Autor a, Autor b, ArrayList<Integer> artigos) {
        if (grafoAutores.getColaboracoes().V() <= a.getId()) {
            grafoAutores.increaseGraph(a.getId());
        }
        if (grafoAutores.getColaboracoes().V() <= b.getId()) {
            grafoAutores.increaseGraph(b.getId());
        }
        grafoAutores.addColaboracao(a, b, artigos);
    }

    @Override
    public void removerAutor(String orcid) {
        autores.get(orcid).setActive(false);
    }

    public void removerAutor(Integer id) {
        autoresID.get(id).setActive(false);
    }

    @Override
    public Autor pesquisarAutor(String orcid) {
        return autores.get(orcid);
    }

    @Override
    public void listarAutores() {
        for (String orcid : autores.keySet()) {
            System.out.println(autores.get(orcid));
        }
    }


    // Métodos para adicionar, remover e pesquisar publicações
    @Override
    public void adicionarPublicacao(Publicacao publicacao) {
        publicacoes.put(publicacao.getId(), publicacao);
        nomePublicacao.put(publicacao.getTitulo(), publicacao.getId());
    }

    @Override
    public void removerPublicacao(int id) {
        publicacoes.get(id).setActive(false);
    }

    @Override
    public Publicacao pesquisarPublicacao(int id) {
        return publicacoes.get(id);
    }

    @Override
    public void listarPublicacoes() {
        for (int id : publicacoes.keySet()) {
            System.out.println(publicacoes.get(id));
        }
    }

    // Métodos para manipular grafos de artigos e autores
    public GrafoArtigos getGrafoArtigos() {
        return grafoArtigos;
    }

    public GrafoAutores getGrafoAutores() {
        return grafoAutores;
    }

    public Hashtable<Integer, Autor> getAutoresID() {
        return autoresID;
    }

    public Autor getAutor(Integer id) {
        Hashtable<Integer, Autor> a= getAutoresID();
        return a.get(id);
    }


    //-------------------------------------------------------------------------//

    // 3. Todos os autores que já citaram uma dada lista de artigos e num dado período
    public ArrayList<Autor> autoresQueCitaramArtigosNoPeriodo(ArrayList<Artigo> listaArtigos, int anoInicio, int anoFim) {
        ArrayList<Autor> autoresCitadores = new ArrayList<>();
        for (Autor autor : autores.values()) {
            for (Artigo artigo : autor.getArtigos()) {
                if (artigo.getAno() >= anoInicio && artigo.getAno() <= anoFim) {
                    if (listaArtigos.contains(artigo)) {
                        autoresCitadores.add(autor);
                        break;
                    }
                }
            }
        }
        return autoresCitadores;
    }

    // 1. Todos os artigos escritos por um autor num dado período
    public ArrayList<Artigo> artigosPorAutorNoPeriodo(Autor autor, int anoInicio, int anoFim) {
        ArrayList<Artigo> artigosPorAutor = new ArrayList<>();
        for (Integer key : artigos.keySet()) {
            Artigo artigo = artigos.get(key);
            if (artigo.getAno() >= anoInicio && artigo.getAno() <= anoFim) {
                if (artigo.getAutores().contains(autor)) {
                    artigosPorAutor.add(artigo);
                }
            }
        }
        return artigosPorAutor;
    }

    // 2. Todos os artigos que não foram descarregados ou visualizados num dado período
    public ArrayList<Artigo> artigosNaoVisualizadosNoPeriodo(int anoInicio, int anoFim) {
        ArrayList<Artigo> artigosNaoVisualizados_NaoDescarregados = new ArrayList<>();
        for (Integer key : artigos.keySet()) {
            Artigo artigo = artigos.get(key);
            if (artigo.getAno() >= anoInicio && artigo.getAno() <= anoFim) {
                if (artigo.getNumDownloads() == 0 || artigo.getNumVisualizacoes() == 0) {
                    artigosNaoVisualizados_NaoDescarregados.add(artigo);
                }
            }
        }
        return artigosNaoVisualizados_NaoDescarregados;
    }


    // 3. O Top-3 dos Artigos que foram mais usados num dado período
    public ArrayList<Artigo> topArtigosMaisUsadosNoPeriodo(int anoInicio, int anoFim) {
        ArrayList<Artigo> artigosMaisUsados = new ArrayList<>();
        for (Integer key : artigos.keySet()) {
            Artigo artigo = artigos.get(key);
            if (artigo.getAno() >= anoInicio && artigo.getAno() <= anoFim) {
                artigosMaisUsados.add(artigo);
            }
        }
        // Ordena os artigos pelo número total de interações (downloads + visualizações + likes)
        artigosMaisUsados.sort((a1, a2) -> {
            int interacoesA1 = a1.getNumDownloads() + a1.getNumVisualizacoes() + a1.getNumlikes();
            int interacoesA2 = a2.getNumDownloads() + a2.getNumVisualizacoes() + a2.getNumlikes();
            return Integer.compare(interacoesA2, interacoesA1);
        });
        // Retorna os top 3 artigos mais usados
        return new ArrayList<>(artigosMaisUsados.subList(0, Math.min(3, artigosMaisUsados.size())));
    }


    //----------------------------------------------------R5----------------------------------------------------------

    public void estatisticasUtilizacaoArtigos() {
        Map<Integer, Integer> UtilizacaoMensalVisualizacoes = new HashMap<>();
        Map<Integer, Integer> UtilizacaoAnualVisualizacoes = new HashMap<>();
        Map<Integer, Integer> UtilizacaoMensalDownloads = new HashMap<>();
        Map<Integer, Integer> UtilizacaoAnualDownloads = new HashMap<>();


        for (Artigo artigo : artigos.values()) {

            int ano = artigo.getAno();
            int downloads = artigo.getNumDownloads();
            int visualizacoes = artigo.getNumVisualizacoes();

            UtilizacaoAnualDownloads.put(ano, UtilizacaoAnualDownloads.getOrDefault(ano, 0) + downloads);
            UtilizacaoAnualVisualizacoes.put(ano, UtilizacaoAnualVisualizacoes.getOrDefault(ano, 0) + visualizacoes);

            System.out.println("Utilizacao Anual dos artigos (Donwloads): \n");
            for (Map.Entry<Integer, Integer> entry : UtilizacaoAnualDownloads.entrySet()) {
                System.out.println("Ano: " + entry.getKey() + ": " + entry.getValue() + "downloads");
            }

            System.out.println("Utilizacao Anual dos artigos (Visualizacoes): \n");
            for (Map.Entry<Integer, Integer> entry : UtilizacaoAnualVisualizacoes.entrySet()) {
                System.out.println("Ano: " + entry.getKey() + ": " + entry.getValue() + "visualizacoes");
            }
        }


    }

    public void numeroLikesArtigos() {

        Map<Integer, Integer> likesanuais = new HashMap<>();

        for (Artigo artigo : artigos.values()) {

            int ano = artigo.getAno();
            int likes = artigo.getNumlikes();

            likesanuais.put(ano, likesanuais.getOrDefault(ano, 0) + likes);
        }


        System.out.println("Numero likes anuais dos Artigos: \n");
        for (Map.Entry<Integer, Integer> entry : likesanuais.entrySet()) {
            System.out.println("Ano " + entry.getValue() + ": " + entry.getValue() + "likes \n");
        }
    }


    public void gerar_relatorio_global() {
        System.out.println("Relatorio Global do Sistema: \n");

        System.out.println("Lista de Artigos: \n");
        listarArtigos();


        System.out.println("Lista de Autores: \n");
        listarAutores();

        System.out.println("Lista de ligacoes entre artigos: \n");
        //listarLigacoesEntreArtigos();


        System.out.println("Vezes que um artigo é descarregado ou visualizado: \n");
        estatisticasUtilizacaoArtigos();


        System.out.println("Numero de likes de um artigo: \n");
        numeroLikesArtigos();
    }


}