    package edu.ufp.inf.PROJETO_AED2LP2_2024;

    import edu.princeton.cs.algs4.RedBlackBST;

    import java.util.*;

    public class BD implements ArtigoInterface, AutorInterface, PublicacaoInterface{
        private Hashtable<Integer, Artigo> artigos;
        private Hashtable<String, Autor> autores;
        private Hashtable<Integer, Publicacao> publicacoes;
        private GrafoArtigos grafoArtigos;
        private GrafoAutores grafoAutores;

        private RedBlackBST<Integer, Artigo> artigoTitulo;
        private RedBlackBST<Integer, Artigo> artigoAno;
        private RedBlackBST<String, Autor> nomeAutor;
        private RedBlackBST<String, Publicacao> nomePublicacao;

        public BD() {
            this.artigos = new Hashtable<>();
            this.autores = new Hashtable<>();
            this.publicacoes = new Hashtable<>();
            this.grafoArtigos = new GrafoArtigos();
            this.grafoAutores = new GrafoAutores();
        }

        // Métodos para adicionar, remover e pesquisar artigos
        @Override
        public void adicionarArtigo(Artigo artigo) {
            artigos.put(artigo.getId(), artigo);
            grafoArtigos.adicionarArtigo(artigo);
        }
        @Override
        public void removerArtigo(int id) {
            //artigos.remove(id);
            artigos.remove(id);
        }
        @Override
        public Artigo pesquisarArtigo(int id) {
            return artigos.get(id);
        }

        @Override
        public void listarArtigos(){
            for (int id : artigos.keySet()){
                System.out.println(artigos.get(id));
            }
        }


        // Métodos para adicionar, remover e pesquisar autores
        @Override
        public void adicionarAutor(Autor autor) {
            autores.put(autor.getOrcid(), autor);
            grafoAutores.adicionarAutor(autor);
        }

        @Override
        public void removerAutor(String orcid) {
            autores.remove(orcid);
        }

        @Override
        public Autor pesquisarAutor(String orcid) {
            return autores.get(orcid);
        }

        @Override
        public void listarAutores(){
            for (String orcid : autores.keySet()){
                System.out.println(autores.get(orcid));
            }
        }


        // Métodos para adicionar, remover e pesquisar publicações
        @Override
        public void adicionarPublicacao(Publicacao publicacao) {
            publicacoes.put(publicacao.getId(), publicacao);
        }
        @Override
        public void removerPublicacao(int id) {
            //publicacoes.remove(id);
            publicacoes.remove(id);
        }

        @Override
        public Publicacao pesquisarPublicacao(int id) {
            return publicacoes.get(id);
        }

        @Override
        public void listarPublicacoes(){
            for (int id : publicacoes.keySet()){
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


        //-------------------------------------------------------------------------//



        // Outros métodos da classe BD...

        // 1. Todos os artigos escritos por um autor num dado período
        public ArrayList<Artigo> artigosPorAutorNoPeriodo(Autor autor, int anoInicio, int anoFim) {
            ArrayList<Artigo> artigosPorAutor = new ArrayList<>();
            for (Integer key : artigos.keySet()) {
                Artigo artigo = artigos.get(key);
                if(artigo.getAno() >= anoInicio && artigo.getAno() <= anoFim){
                    if (artigo.getAutores().contains(autor)){
                        artigosPorAutor.add(artigo);
                    }
                }
            }
            return artigosPorAutor;
        }

        // 2. Todos os artigos que não foram descarregados ou visualizados num dado período
        public ArrayList<Artigo> artigosNaoVisualizadosNoPeriodo(int anoInicio, int anoFim) {
            ArrayList<Artigo> artigosNaoVisualizados = new ArrayList<>();
            for (Integer key : artigos.keySet()) {
                Artigo artigo = artigos.get(key);
                if(artigo.getAno() >= anoInicio && artigo.getAno() <= anoFim){
                    if (artigo.getNumDownloads() == 0 && artigo.getNumVisualizacoes() == 0){
                        artigosNaoVisualizados.add(artigo);
                    }
                }
            }
            return artigosNaoVisualizados;
        }

        // 3. Todos os autores que já citaram uma dada lista de artigos e num dado período
        public ArrayList<Autor> autoresQueCitaramArtigosNoPeriodo(ArrayList<Artigo> listaArtigos, int anoInicio, int anoFim) {
            ArrayList<Autor> autoresCitadores = new ArrayList<>();
            for (Autor autor : autores.values()) {
                for (Artigo artigo : autor.getArtigos()) {
                    if (artigo.getAno() >= anoInicio && artigo.getAno() <= anoFim){
                        if (listaArtigos.contains(artigo)){
                            autoresCitadores.add(autor);
                            break;
                        }
                    }
                }
            }
            return autoresCitadores;
        }

        // 4. O Top-3 dos Artigos que foram mais usados num dado período
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

        // 5. As citações de todos os artigos de um journal para um determinado período temporal
        public int numeroCitasJournalNoPeriodo(String nomeJournal, int anoInicio, int anoFim) {
            int totalCitas = 0;
            for (Integer key : artigos.keySet()) {
                Artigo artigo = artigos.get(key);
                if (artigo.getAno() >= anoInicio && artigo.getAno() <= anoFim){
                    if (artigo.getTipoPublicacao().equals(nomeJournal)){
                        totalCitas += artigo.getNumlikes();
                    }
                }
                if (artigo.getTipoPublicacao().equals(nomeJournal) && artigo.getAno() >= anoInicio && artigo.getAno() <= anoFim) {
                    totalCitas += artigo.getNumlikes(); // Supondo que "likes" são contados como citações
                }
            }
            return totalCitas;
        }

        //----------------------------------------------------R5----------------------------------------------------------

        public void listarLigacoesEntreArtigos(){

        }

        public void estatisticasUtilizacaoArtigos(){

        }

        public void numeroLikesArtigos(){
            int totallikes= 0;

            for (Artigo artigo : artigos.values()){
                totallikes += artigo.getNumlikes();
            }

            System.out.println("Total de Likes dos Artigos: " + totallikes);
        }



        public void gerar_relatorio_global(){
            System.out.println("Relatorio Global do Sistema: \n");

            System.out.println("Lista de Artigos: \n");
            listarArtigos();


            System.out.println("Lista de Autores: \n");
            listarAutores();

            System.out.println("Lista de ligacoes entre artigos: \n");
            //listarLigacoesEntreArtigos();


            System.out.println("Vezes que um artigo é descarregado ou visualizado: \n");
            //estatisticasUtilizacaoArtigos();


            System.out.println("Numero de likes de um artigo: \n");
            //numeroLikesArtigos();
        }


    }


