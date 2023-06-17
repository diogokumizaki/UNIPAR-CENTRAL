package br.unipar.central.models;

public class Banco {

    private int id;
    private String nome;
    private String ra;

    public Banco() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public void message(){
        System.out.println("---------------------------------DADOS----------------------------------");
    }

    @Override
    public String toString() {
        return "\nId=" + id + ", Nome=" + nome + ", Digito=" + ra ;
    }
}
