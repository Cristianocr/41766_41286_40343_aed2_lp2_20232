package edu.ufp.inf.PROJETO_AED2LP2_2024;

public interface AutorInterface {

    public void adicionarAutor(Autor autor);

    public void removerAutor(String orcid);

    public Autor pesquisarAutor(String orcid);

    public void listarAutores();
}
