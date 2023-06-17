package br.unipar.central.models;

import br.unipar.central.enums.TipoOperadoraEnum;

public class Telefone {

    private int id;
    private String numero;
    private TipoOperadoraEnum operadora;
    private String ra;
    private Agencia agencia;
    private Pessoa pessoa;

    public Telefone() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoOperadoraEnum getOperadora() {
        return operadora;
    }

    public void setOperadora(TipoOperadoraEnum operadora) {
        this.operadora = operadora;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
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
        return "\nId=" + id + ", numero=" + numero + ", operadora=" + operadora + ", ra=" + ra + ", agencia=" + agencia + ", pessoa=" + pessoa + '}';
    }

}
