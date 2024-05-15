package edu.ufp.inf.PROJETO_AED2LP2_2024;

import java.util.Objects;

public class Conference extends Publicacao {
    private String nome;
    private int ano;
    private int numeroEdicao;
    private String local;

    public Conference(String titulo, String nome, int ano, int numeroEdicao, String local) {
        super(titulo, "Conference");
        this.nome = nome;
        this.ano = ano;
        this.numeroEdicao = numeroEdicao;
        this.local = local;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getNumeroEdicao() {
        return numeroEdicao;
    }

    public void setNumeroEdicao(int numeroEdicao) {
        this.numeroEdicao = numeroEdicao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Conference that = (Conference) o;
        return ano == that.ano && numeroEdicao == that.numeroEdicao && Objects.equals(nome, that.nome) && Objects.equals(local, that.local);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nome, ano, numeroEdicao, local);
    }

    @Override
    public String toString() {
        return "Conference{" +
                "nome='" + nome + '\'' +
                ", ano=" + ano +
                ", numeroEdicao=" + numeroEdicao +
                ", local='" + local + '\'' +
                '}';
    }
}
