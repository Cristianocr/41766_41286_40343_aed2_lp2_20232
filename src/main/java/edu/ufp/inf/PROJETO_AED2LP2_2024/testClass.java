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
        Artigo artigo1 = new Artigo("TESTE1", palavrasChave, "texto bueda grande e fixe", "Journal", 2020, 0, 0, 0, autores);
        System.out.println(artigo1);
    }

    public static void testAutor() {
        ArrayList<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("Afgdh");
        palavrasChave.add("fdg");
        palavrasChave.add("ghjk");
        ArrayList<Autor> autores = new ArrayList<>();
        Autor autor1 = new Autor("Zé", "muita", "José", "bfvdfv", "dfgh", "fgghj", null);
        Autor autor2 = new Autor("Zé", "muita", "José", "bfvdfv", "dfgh", "fgghj", null);
        autores.add(autor2);
        autores.add(autor2);
        Artigo artigo1 = new Artigo("TESTE1", palavrasChave, "texto bueda grande e fixe", "Journal", 2020, 0, 0, 0, autores);
        System.out.println(artigo1);
        Artigo artigo2 = new Artigo("TESTE2", palavrasChave, "texto bueda grande e fixe", "Journal", 2020, 0, 0, 0, autores);
        System.out.println(artigo2);
        Artigo artigo3 = new Artigo("TESTE3", palavrasChave, "texto bueda grande e fixe", "Journal", 2020, 0, 0, 0, autores);

        BD bd = new BD();

        bd.getGrafoArtigos().adicionarArtigo(artigo1);
        bd.getGrafoArtigos().adicionarArtigo(artigo2);
        bd.getGrafoArtigos().adicionarArtigo(artigo3);
        bd.getGrafoArtigos().adicionarCitacao(artigo1, artigo2);
        bd.getGrafoArtigos().adicionarCitacao(artigo2, artigo3);
        bd.getGrafoArtigos().adicionarCitacao(artigo3, artigo1);
        bd.getGrafoArtigos().imprimirGrafo();

    }

    public static void testGrafoArtigos() {
        BD bd = new BD();

        Autor autor1 = new Autor("Autor1", "A1", "A1Cientifico", "Filiação1", "ORCID1", "CienciaID1", null);
        Autor autor2 = new Autor("Autor2", "A2", "A2Cientifico", "Filiação2", "ORCID2", "CienciaID2", null);

        ArrayList<Autor> autores1 = new ArrayList<>();
        autores1.add(autor1);
        autores1.add(autor2);

        Artigo artigo1 = new Artigo("Título1", new ArrayList<>(Arrays.asList("palavra1", "palavra2")), "abstract1", "journal", 2024, 100, 200, 50, autores1);
        Artigo artigo2 = new Artigo("Título2", new ArrayList<>(Arrays.asList("palavra3", "palavra4")), "abstract2", "journal", 2024, 150, 250, 60, autores1);

        bd.adicionarArtigo(artigo1);
        bd.adicionarArtigo(artigo2);

        bd.getGrafoArtigos().adicionarCitacao(artigo1, artigo2);

        bd.getGrafoArtigos().imprimirGrafo();
    }

    public static void testGrafoAutores() {

        BD bd = new BD();

        Autor autor1 = new Autor("Nome Científico 1", "Filiação 1", "Nome 1", "CienciaID1", "GoogleScholarID1", "ScopusID1", new ArrayList<>());
        Autor autor2 = new Autor("Nome Científico 2", "Filiação 2", "Nome 2", "CienciaID2", "GoogleScholarID2", "ScopusID2", new ArrayList<>());
        Autor autor3 = new Autor("Nome Científico 3", "Filiação 3", "Nome 3", "CienciaID3", "GoogleScholarID3", "ScopusID3", new ArrayList<>());

        ArrayList<Autor> autores1 = new ArrayList<>(Arrays.asList(autor1, autor2));
        ArrayList<Autor> autores2 = new ArrayList<>(Arrays.asList(autor2, autor3));

        Artigo artigo1 = new Artigo("Título 1", new ArrayList<>(Arrays.asList("palavra1", "palavra2")), "abstract1", "journal", 2024, 100, 200, 50, autores1);
        Artigo artigo2 = new Artigo("Título 2", new ArrayList<>(Arrays.asList("palavra3", "palavra4")), "abstract2", "journal", 2024, 150, 250, 60, autores2);

        bd.adicionarArtigo(artigo1);
        bd.adicionarArtigo(artigo2);

        bd.adicionarAutor(autor1);
        bd.adicionarAutor(autor2);
        bd.adicionarAutor(autor3);

        bd.getGrafoAutores().adicionarCoautoria(autor1, autor2);
        bd.getGrafoAutores().adicionarCoautoria(autor2, autor3);

        bd.getGrafoAutores().imprimirGrafo();
    }

}
