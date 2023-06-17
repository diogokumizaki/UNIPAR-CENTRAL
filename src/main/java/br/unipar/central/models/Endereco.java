package br.unipar.central.models;

public class Endereco {

    private int id;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cep;
    private String complemento;
    private String ra;
    private Cidade cidade;
    private Pessoa pessoa;

    public Endereco() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void message(){
        System.out.println("---------------------------------DADOS----------------------------------");
    }
    
    @Override
    public String toString() {
        return "\nid=" + id + ", logradouro=" + logradouro + ", numero=" + numero + ", bairro=" + bairro + ", cep=" + cep + ", complemento=" + complemento + ", ra=" + ra + ", cidade=" + cidade + ", pessoa=" + pessoa + '}';
    }

}
