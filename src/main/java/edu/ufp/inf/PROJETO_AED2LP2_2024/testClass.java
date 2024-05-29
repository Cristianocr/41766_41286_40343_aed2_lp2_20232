package edu.ufp.inf.PROJETO_AED2LP2_2024;

import java.util.ArrayList;
import java.util.Arrays;

public class testClass {
    public static void main(String[] args) {
        //testArtigo();
        //testAutor();
        //testGrafoArtigos();
        testGrafoAutores();
    }

    public static void testArtigo() {
        ArrayList<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("Afgdh");
        palavrasChave.add("fdg");
        palavrasChave.add("ghjk");
        palavrasChave.add("rtyru");
        palavrasChave.add("21345");
        ArrayList<Autor> autores = new ArrayList<>();
        Autor autor1 = new Autor("Zé", "muita", "José", "bfvdfv", "dfgh", "fgghj", null);
        Autor autor2 = new Autor("Zé", "muita", "José", "bfvdfv", "dfgh", "fgghj", null);
        autores.add(autor1);
        autores.add(autor2);
        Conference c= new Conference("Ola", "nome1", 2020, 1, "Local1");
        Artigo artigo1 = new Artigo("TESTE1", palavrasChave, "texto bueda grande e fixe", 2020, 0, 0, 0, autores, c);
        System.out.println(artigo1);
    }

    public static void testAutor() {
        ArrayList<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("Afgdh");
        palavrasChave.add("fdg");
        palavrasChave.add("ghjk");
        ArrayList<Autor> autores = new ArrayList<>();
        Journal j = new Journal("Titulo1", "nome", "Publicador", 2019, "mensal", 0.0f, 0.0f);
        Autor autor1 = new Autor("Zé", "muita", "José", "bfvdfv", "dfgh", "fgghj", null);
        Autor autor2 = new Autor("Zé", "muita", "José", "bfvdfv", "dfgh", "fgghj", null);
        autores.add(autor2);
        autores.add(autor2);
        Artigo artigo1 = new Artigo("TESTE1", palavrasChave, "texto bueda grande e fixe", 2020, 0, 0, 0, autores, j);
        System.out.println(artigo1);
        Artigo artigo2 = new Artigo("TESTE2", palavrasChave, "texto bueda grande e fixe", 2020, 0, 0, 0, autores, j);
        System.out.println(artigo2);
        Artigo artigo3 = new Artigo("TESTE3", palavrasChave, "texto bueda grande e fixe", 2020, 0, 0, 0, autores, j);

        BD bd = new BD();

        bd.adicionarArtigo(artigo1);
        bd.adicionarArtigo(artigo2);
        bd.adicionarArtigo(artigo3);
        bd.getGrafoArtigos().adicionarCitacao(artigo1, artigo2);
        bd.getGrafoArtigos().adicionarCitacao(artigo2, artigo3);
        bd.getGrafoArtigos().adicionarCitacao(artigo3, artigo1);
        bd.getGrafoArtigos().imprimirGrafo();

    }

    public static void testGrafoArtigos() {
        BD bd = new BD();

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

        bd.adicionarArtigo(artigo1);
        bd.adicionarArtigo(artigo2);

        bd.getGrafoArtigos().adicionarCitacao(artigo1, artigo2);

        bd.getGrafoArtigos().imprimirGrafo();
    }

    public static void testGrafoAutores() {

        BD bd = new BD();

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
        Conference c= new Conference("Ola", "nome1", 2020, 1, "Local1");


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
