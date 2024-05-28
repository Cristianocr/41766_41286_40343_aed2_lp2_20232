package edu.ufp.inf.PROJETO_AED2LP2_2024;

public interface PublicacaoInterface {

    public void adicionarPublicacao(Publicacao publicacao);

    public void removerPublicacao(int id);

    public Publicacao pesquisarPublicacao(int id);

    public void listarPublicacoes();
}
