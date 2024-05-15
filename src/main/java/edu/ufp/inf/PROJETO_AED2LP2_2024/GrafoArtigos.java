package edu.ufp.inf.PROJETO_AED2LP2_2024;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GrafoArtigos {
    private Map<Artigo, Set<Artigo>> citacoes;

    public GrafoArtigos() {
        this.citacoes = new HashMap<>();
    }

    public void adicionarArtigo(Artigo artigo) {
        if (!citacoes.containsKey(artigo)) {
            citacoes.put(artigo, new HashSet<>());
        }
    }

    public void adicionarCitacao(Artigo citante, Artigo citado) {
        adicionarArtigo(citante);
        adicionarArtigo(citado);
        citacoes.get(citante).add(citado);
    }

    public Set<Artigo> getArtigosCitados(Artigo artigo) {
        return citacoes.getOrDefault(artigo, new HashSet<>());
    }

    public Set<Artigo> getArtigosCitantes(Artigo artigo) {
        Set<Artigo> citantes = new HashSet<>();
        for (Map.Entry<Artigo, Set<Artigo>> entry : citacoes.entrySet()) {
            if (entry.getValue().contains(artigo)) {
                citantes.add(entry.getKey());
            }
        }
        return citantes;
    }
}
