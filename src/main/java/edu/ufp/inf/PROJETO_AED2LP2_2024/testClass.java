package edu.ufp.inf.PROJETO_AED2LP2_2024;

import java.util.ArrayList;
import java.util.Arrays;

public class testClass {
    public static void main(String[] args) {
        BD bd = new BD();

        // Criar 5 Journal objects
        Journal journal1 = new Journal("Journal Title 1", "Journal Name 1", "Publisher 1", 2021, "Monthly", 3.5, 2.8);
        Journal journal2 = new Journal("Journal Title 2", "Journal Name 2", "Publisher 2", 2022, "Bi-monthly", 4.2, 3.1);
        Journal journal3 = new Journal("Journal Title 3", "Journal Name 3", "Publisher 3", 2020, "Quarterly", 2.9, 2.5);
        Journal journal4 = new Journal("Journal Title 4", "Journal Name 4", "Publisher 4", 2023, "Weekly", 4.8, 3.9);
        Journal journal5 = new Journal("Journal Title 5", "Journal Name 5", "Publisher 5", 2019, "Bi-annual", 3.1, 2.2);

        // Criar 5 Conference objects
        Conference conference1 = new Conference("Conference Title 1", "Conference Name 1", 2021, 1, "Location 1");
        Conference conference2 = new Conference("Conference Title 2", "Conference Name 2", 2022, 2, "Location 2");
        Conference conference3 = new Conference("Conference Title 3", "Conference Name 3", 2020, 3, "Location 3");
        Conference conference4 = new Conference("Conference Title 4", "Conference Name 4", 2023, 4, "Location 4");
        Conference conference5 = new Conference("Conference Title 5", "Conference Name 5", 2019, 5, "Location 5");

        // Criar 5 Autores objects
        Autor autor1 = new Autor("John Doe", "University of X", "John", "123-456", "john_doe_scholar", "scopus_john", new ArrayList<>());
        Autor autor2 = new Autor("Jane Smith", "University of Y", "Jane", "789-012", "jane_smith_scholar", "scopus_jane", new ArrayList<>());
        Autor autor3 = new Autor("Alice Johnson", "University of Z", "Alice", "456-789", "alice_johnson_scholar", "scopus_alice", new ArrayList<>());
        Autor autor4 = new Autor("Bob Brown", "University of W", "Bob", "321-654", "bob_brown_scholar", "scopus_bob", new ArrayList<>());
        Autor autor5 = new Autor("Eva Green", "University of V", "Eva", "987-654", "eva_green_scholar", "scopus_eva", new ArrayList<>());

        //Criar 5 Artigos objects
        Artigo artigo1 = new Artigo("Artigo 1", new ArrayList<>(Arrays.asList("Key1", "Key2")), "Abstract 1", 2021, 100, 200, 50, new ArrayList<>(Arrays.asList(autor1)), new Journal("Journal Title 1", "Journal Name 1", "Publisher 1", 2021, "Monthly", 3.5, 2.8));
        Artigo artigo2 = new Artigo("Artigo 2", new ArrayList<>(Arrays.asList("Key3", "Key4")), "Abstract 2", 2022, 150, 250, 70, new ArrayList<>(Arrays.asList(autor2)), new Journal("Journal Title 2", "Journal Name 2", "Publisher 2", 2022, "Bi-monthly", 4.2, 3.1));
        Artigo artigo3 = new Artigo("Artigo 3", new ArrayList<>(Arrays.asList("Key5", "Key6")), "Abstract 3", 2020, 200, 300, 90, new ArrayList<>(Arrays.asList(autor3)), new Journal("Journal Title 3", "Journal Name 3", "Publisher 3", 2020, "Quarterly", 2.9, 2.5));
        Artigo artigo4 = new Artigo("Artigo 4", new ArrayList<>(Arrays.asList("Key7", "Key8")), "Abstract 4", 2023, 250, 350, 110, new ArrayList<>(Arrays.asList(autor4)), new Journal("Journal Title 4", "Journal Name 4", "Publisher 4", 2023, "Weekly", 4.8, 3.9));
        Artigo artigo5 = new Artigo("Artigo 5", new ArrayList<>(Arrays.asList("Key9", "Key10")), "Abstract 5", 2019, 300, 400, 130, new ArrayList<>(Arrays.asList(autor5)), new Journal("Journal Title 5", "Journal Name 5", "Publisher 5", 2019, "Bi-annual", 3.1, 2.2));


        //inserir publicacoes
        bd.adicionarPublicacao(journal1);
        bd.adicionarPublicacao(journal2);
        bd.adicionarPublicacao(journal3);
        bd.adicionarPublicacao(journal4);
        bd.adicionarPublicacao(journal5);

        bd.adicionarPublicacao(conference1);
        bd.adicionarPublicacao(conference2);
        bd.adicionarPublicacao(conference3);
        bd.adicionarPublicacao(conference4);
        bd.adicionarPublicacao(conference5);

        //Adiciona autores à BD
        bd.adicionarAutor(autor1);
        bd.adicionarAutor(autor2);
        bd.adicionarAutor(autor3);
        bd.adicionarAutor(autor4);
        bd.adicionarAutor(autor5);

        // Adiciona os artigos à BD
        bd.adicionarArtigo(artigo1);
        bd.adicionarArtigo(artigo2);
        bd.adicionarArtigo(artigo3);
        bd.adicionarArtigo(artigo4);
        bd.adicionarArtigo(artigo5);

        testBD(bd);
        testArtigo(bd);
        testAutor(bd);
        testGrafoArtigos(bd);
        testGrafoArtigos(bd);

    }

    public static void testBD(BD bd) {
        System.out.println("Testar métodos da classe BD:");

        System.out.println("Testando métodos da classe BD:");

        /*/ Testar adicionar, remover e pesquisar publicações, autores e artigos
        System.out.println("\nTestando adicionar, remover e pesquisar publicações, autores e artigos:");
        System.out.println("Pesquisando publicação por ID:");
        System.out.println(bd.pesquisarPublicacao(1)); // Deve imprimir as informações da publicação de teste 1
        System.out.println("Pesquisando autor por ORCID:");
        System.out.println(bd.pesquisarAutor("john_doe_scholar")); // Deve imprimir as informações do autor John Doe
        System.out.println("Pesquisando artigo por ID:");
        System.out.println(bd.pesquisarArtigo(1)); // Deve imprimir as informações do artigo 1

        // Testar outros métodos da classe BD
        // 1. Todos os artigos escritos por um autor num dado período
        System.out.println("\nTestando artigosPorAutorNoPeriodo:");
        Autor autorTeste = bd.pesquisarAutor("john_doe_scholar");
        ArrayList<Artigo> artigosPorAutor = bd.artigosPorAutorNoPeriodo(autorTeste, 2020, 2023);
        for (Artigo artigo : artigosPorAutor) {
            System.out.println(artigo);
        }

        // 2. Todos os artigos que não foram descarregados ou visualizados num dado período
        System.out.println("\nTestando artigosNaoVisualizadosNoPeriodo:");
        ArrayList<Artigo> artigosNaoVisualizados = bd.artigosNaoVisualizadosNoPeriodo(2020, 2023);
        for (Artigo artigo : artigosNaoVisualizados) {
            System.out.println(artigo);
        }*/

        // 3. O Top-3 dos Artigos que foram mais usados num dado período
        System.out.println("\nTestando topArtigosMaisUsadosNoPeriodo:");
        ArrayList<Artigo> topArtigosMaisUsados = bd.topArtigosMaisUsadosNoPeriodo(2019, 2023);
        for (Artigo artigo : topArtigosMaisUsados) {
            System.out.println(artigo);
        }

        // 3. Todos os autores que já citaram uma dada lista de artigos e num dado período
        System.out.println("\nTestando autoresQueCitaramArtigosNoPeriodo:");
        ArrayList<Artigo> listaArtigosTeste = new ArrayList<>();
        listaArtigosTeste.add(bd.pesquisarArtigo(1));
        listaArtigosTeste.add(bd.pesquisarArtigo(2));
        ArrayList<Autor> autoresCitadores = bd.autoresQueCitaramArtigosNoPeriodo(listaArtigosTeste, 2020, 2022);
        for (Autor autor : autoresCitadores) {
            System.out.println(autor);
        }

        bd.gerar_relatorio_global();
    }


    public static void testArtigo(BD bd) {
        System.out.println("\nTestando métodos da classe Artigo:");

        // Pesquisar artigo pelo ID
        System.out.println("\nPesquisando artigo pelo ID 1:");
        Artigo artigoPesquisado = bd.pesquisarArtigo(1);
        if (artigoPesquisado != null) {
            System.out.println("Artigo encontrado:\n" + artigoPesquisado);
        } else {
            System.out.println("Artigo não encontrado.");
        }

        // Remover artigo pelo ID
        System.out.println("\nRemovendo artigo pelo ID 1:");
        bd.removerArtigo(1);
        artigoPesquisado = bd.pesquisarArtigo(1);
        if (artigoPesquisado == null || !artigoPesquisado.isActive()) {
            System.out.println("Artigo removido com sucesso.");
        } else {
            System.out.println("Falha ao remover o artigo.");
        }

        // Listar todos os artigos
        System.out.println("\nListando todos os artigos:");
        bd.listarArtigos();

        // Adicionar palavra-chave a um artigo
        System.out.println("\nAdicionando palavra-chave ao artigo com ID 2:");
        Artigo artigo2 = bd.pesquisarArtigo(2);
        if (artigo2 != null) {
            artigo2.addPlavraChave("Nova Palavra-Chave");
            System.out.println("Palavra-chave adicionada com sucesso:\n" + artigo2);
        } else {
            System.out.println("Artigo não encontrado.");
        }

        // Remover palavra-chave de um artigo
        System.out.println("\nRemovendo palavra-chave do artigo com ID 2:");
        if (artigo2 != null) {
            artigo2.removePlavraChave("Nova Palavra-Chave");
            System.out.println("Palavra-chave removida com sucesso:\n" + artigo2);
        } else {
            System.out.println("Artigo não encontrado.");
        }

        // Incrementar likes de um artigo
        System.out.println("\nIncrementando likes do artigo com ID 2:");
        if (artigo2 != null) {
            artigo2.incrementarLikes();
            System.out.println("Likes incrementados com sucesso:\n" + artigo2);
        } else {
            System.out.println("Artigo não encontrado.");
        }

        // Incrementar visualizações de um artigo
        System.out.println("\nIncrementando visualizações do artigo com ID 2:");
        if (artigo2 != null) {
            artigo2.incrementarVisualizacoes();
            System.out.println("Visualizações incrementadas com sucesso:\n" + artigo2);
        } else {
            System.out.println("Artigo não encontrado.");
        }

        // Incrementar downloads de um artigo
        System.out.println("\nIncrementando downloads do artigo com ID 2:");
        if (artigo2 != null) {
            artigo2.incrementarDownloads();
            System.out.println("Downloads incrementados com sucesso:\n" + artigo2);
        } else {
            System.out.println("Artigo não encontrado.");
        }
    }

    public static void testAutor(BD bd) {

        System.out.println("\nTestando métodos da classe Autor:");

        // Pesquisar autor pelo ID
        System.out.println("\nPesquisando autor pelo ID 1:");
        Autor autorPesquisado = bd.getAutoresID().get(1);
        if (autorPesquisado != null) {
            System.out.println("Autor encontrado:\n" + autorPesquisado);
        } else {
            System.out.println("Autor não encontrado.");
        }

        // Remover autor pelo ID
        System.out.println("\nRemovendo autor pelo ID 1:");
        bd.removerAutor(1);
        autorPesquisado = bd.pesquisarAutor(bd.getAutoresID().get(1).getOrcid());
        if (autorPesquisado == null || !autorPesquisado.isActive()) {
            System.out.println("Autor removido com sucesso.");
        } else {
            System.out.println("Falha ao remover o autor.");
        }

        // Listar todos os autores
        System.out.println("\nListando todos os autores:");
        bd.listarAutores();

        // Adicionar artigo a um autor
        /*System.out.println("\nAdicionando artigo ao autor com ID 2:");
        Autor autor2 = bd.pesquisarAutor(bd.getAutoresID().get(2).getOrcid());
        Artigo artigo2 = bd.pesquisarArtigo(2);
        if (autor2 != null && artigo2 != null) {
            autor2.getArtigos().add(artigo2);
            System.out.println("Artigo adicionado com sucesso ao autor:\n" + autor2);
        } else {
            System.out.println("Autor ou artigo não encontrado.");
        }

        // Remover artigo de um autor
        System.out.println("\nRemovendo artigo do autor com ID 2:");
        if (autor2 != null && artigo2 != null) {
            autor2.getArtigos().remove(artigo2);
            System.out.println("Artigo removido com sucesso do autor:\n" + autor2);
        } else {
            System.out.println("Autor ou artigo não encontrado.");
        }*/

    }

    public static void testGrafoArtigos(BD bd) {

        Journal j = new Journal("Titulo1", "nome", "Publicador", 2019, "mensal", 0.0f, 0.0f);

        Autor autor1 = new Autor("Autor1", "A1", "A1Cientifico", "Filiação1", "ORCID1", "CienciaID1", null);
        Autor autor2 = new Autor("Autor2", "A2", "A2Cientifico", "Filiação2", "ORCID2", "CienciaID2", null);

        ArrayList<Autor> autores1 = new ArrayList<>();
        autores1.add(autor1);
        autores1.add(autor2);

        ArrayList<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("Afgdh");
        palavrasChave.add("fdg");
        palavrasChave.add("ghjk");

        Artigo artigo1 = new Artigo("TESTE1", palavrasChave, "texto bueda grande e fixe", 2020, 0, 0, 0, autores1, j);
        Artigo artigo2 = new Artigo("TESTE2", palavrasChave, "texto bueda grande e fixe", 2020, 0, 0, 0, autores1, j);
        Artigo artigo3 = new Artigo("TESTE1", palavrasChave, "texto bueda grande e fixe", 2020, 0, 0, 0, autores1, j);
        Artigo artigo4 = new Artigo("TESTE2", palavrasChave, "texto bueda grande e fixe", 2020, 0, 0, 0, autores1, j);


        bd.adicionarArtigo(artigo1);
        bd.adicionarArtigo(artigo2);

        bd.getGrafoArtigos().adicionarCitacao(artigo1, artigo2);

        bd.getGrafoArtigos().imprimirGrafo();
    }

    public static void testGrafoAutores(BD bd) {

        Autor autor1 = new Autor("Nome Científico 1", "Tecnologia", "Nome 1", "CienciaID1", "GoogleScholarID1", "ScopusID1", new ArrayList<>());
        Autor autor2 = new Autor("Nome Científico 2", "Tecnologia", "Nome 2", "CienciaID2", "GoogleScholarID2", "ScopusID2", new ArrayList<>());
        Autor autor3 = new Autor("Nome Científico 3", "Computacao", "Nome 3", "CienciaID3", "GoogleScholarID3", "ScopusID3", new ArrayList<>());

        ArrayList<Autor> autores1 = new ArrayList<>(Arrays.asList(autor1, autor2));
        ArrayList<Autor> autores2 = new ArrayList<>(Arrays.asList(autor2, autor3));

        ArrayList<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("Afgdh");
        palavrasChave.add("fdg");
        palavrasChave.add("ghjk");

        Journal j = new Journal("Titulo1", "nome", "Publicador", 2019, "mensal", 0.0f, 0.0f);
        Conference c = new Conference("Ola", "nome1", 2020, 1, "Local1");


        Artigo artigo1 = new Artigo("TESTE1", palavrasChave, "texto bueda grande e fixe", 2020, 0, 0, 0, autores1, j);
        Artigo artigo2 = new Artigo("TESTE1", palavrasChave, "texto bueda grande e fixe", 2020, 0, 0, 0, autores2, c);
        Artigo artigo3 = new Artigo("TESTE1", palavrasChave, "texto bueda grande e fixe", 2020, 0, 0, 0, autores1, j);
        Artigo artigo4 = new Artigo("TESTE1", palavrasChave, "texto bueda grande e fixe", 2020, 0, 0, 0, autores2, c);

        bd.adicionarArtigo(artigo1);
        bd.adicionarArtigo(artigo2);
        bd.adicionarArtigo(artigo3);
        bd.adicionarArtigo(artigo4);

        bd.adicionarAutor(autor1);
        bd.adicionarAutor(autor2);
        bd.adicionarAutor(autor3);

        ArrayList<Integer> teste = new ArrayList<>();

        teste.add(artigo1.getId());
        teste.add(artigo2.getId());
        teste.add(artigo3.getId());

        bd.adicionarCitacao(artigo1, artigo2);
        bd.adicionarCitacao(artigo2, artigo3);
        bd.adicionarCitacao(artigo3, artigo4);
        bd.adicionarCitacao(artigo4, artigo1);


        bd.adicionarColaboracao(autor1, autor2, teste);
        bd.adicionarColaboracao(autor2, autor3, artigo4.getId());
        bd.adicionarColaboracao(autor3, autor2, artigo3.getId());
        bd.adicionarColaboracao(autor1, autor3, artigo2.getId());
        bd.adicionarColaboracao(autor1, autor3, artigo3.getId());
        teste.add(artigo2.getId());
        bd.adicionarColaboracao(autor1, autor2, teste);

        bd.getGrafoArtigos().imprimirGrafo();

        System.out.println("\n");

        bd.getGrafoAutores().imprimirGrafo();
    }
}
