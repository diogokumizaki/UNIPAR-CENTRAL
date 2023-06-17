package br.unipar.central.models;

public class Cidade {

    private int id;
    private String nome;
    private String ra;
    private Estado estado;

    public Cidade() {
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void message(){
        System.out.println("---------------------------------DADOS----------------------------------");
    }

    @Override
    public String toString() {
        return "\nid=" + id + ", nome=" + nome + ", ra=" + ra + ", estado=" + estado + '}';
    }
    

}
