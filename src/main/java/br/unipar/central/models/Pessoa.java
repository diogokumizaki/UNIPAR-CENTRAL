package br.unipar.central.models;

;

public class Pessoa {

    private int id;
    private String email;
    private String ra;

    public Pessoa() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return "\nId=" + id + ", Email=" + email + ", Ra=" + ra + "";
    }
}
