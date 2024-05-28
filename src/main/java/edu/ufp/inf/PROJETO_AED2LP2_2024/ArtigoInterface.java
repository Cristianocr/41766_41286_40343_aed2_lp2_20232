package edu.ufp.inf.PROJETO_AED2LP2_2024;

public interface ArtigoInterface {

    public void adicionarArtigo(Artigo artigo);

    public void removerArtigo(int id);

    public Artigo pesquisarArtigo(int id);

    public void listarArtigos();
}
