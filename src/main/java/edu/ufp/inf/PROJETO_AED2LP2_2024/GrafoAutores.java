package edu.ufp.inf.PROJETO_AED2LP2_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GrafoAutores {
    private HashMap<Autor, HashSet<Autor>> coAutores;

    public GrafoAutores() {
        coAutores = new HashMap<>();
    }

    public void adicionarCoAutoria(Artigo artigo) {
        ArrayList<Autor> autores = artigo.getAutores();
        for (int i = 0; i < autores.size(); i++) {
            Autor autor1 = autores.get(i);
            for (int j = i + 1; j < autores.size(); j++) {
                Autor autor2 = autores.get(j);
                adicionarAresta(autor1, autor2);
            }
        }
    }

    private void adicionarAresta(Autor autor1, Autor autor2) {
        if (!coAutores.containsKey(autor1)) {
            coAutores.put(autor1, new HashSet<>());
        }
        if (!coAutores.containsKey(autor2)) {
            coAutores.put(autor2, new HashSet<>());
        }
        coAutores.get(autor1).add(autor2);
        coAutores.get(autor2).add(autor1);
    }

    public void mostrarCoautores() {
        for (Autor autor : coAutores.keySet()) {
            System.out.println("Autor: " + autor.getNome());
            System.out.print("Coautores: ");
            for (Autor coautor : coAutores.get(autor)) {
                System.out.print(coautor.getNome() + " ");
            }
            System.out.println();
        }
    }
}

