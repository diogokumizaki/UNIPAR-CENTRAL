package br.unipar.central.models;

public class Agencia {

    private int id;
    private String codigo;
    private String digito;
    private String razaoSocial;
    private String cnpj;
    private String ra;
    private Banco banco;

    public Agencia() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDigito() {
        return digito;
    }

    public void setDigito(String digito) {
        this.digito = digito;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public void message(){
        System.out.println("---------------------------------DADOS----------------------------------");
    }

    @Override
    public String toString() {
        return "\nid=" + id + ", codigo=" + codigo + ", digito=" + digito + ", razaosocial=" + razaoSocial + ", cnpj=" + cnpj + ", ra=" + ra + ", banco=" + banco + '}';
    }
}
