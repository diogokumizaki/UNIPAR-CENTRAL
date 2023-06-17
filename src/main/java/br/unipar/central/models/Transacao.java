/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.models;

import br.unipar.central.enums.TipoTransacaoEnum;

public class Transacao {

    private int id;
    private double valor;
    private TipoTransacaoEnum tipo;
    private String ra;
    private int conta_origem;
    private int conta_destino;

    public Transacao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoTransacaoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransacaoEnum tipo) {
        this.tipo = tipo;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public int getConta_origem() {
        return conta_origem;
    }

    public void setConta_origem(int conta_origem) {
        this.conta_origem = conta_origem;
    }

    public int getConta_destino() {
        return conta_destino;
    }

    public void setConta_destino(int conta_destino) {
        this.conta_destino = conta_destino;
    }

    public void message(){
        System.out.println("---------------------------------DADOS----------------------------------");
    }
    
    @Override
    public String toString() {
        return "\nId=" + id + ", valor=" + valor + ", tipo=" + tipo + ", ra=" + ra + ", conta_origem=" + conta_origem + ", conta_destino=" + conta_destino + '}';
    }

}
