package br.unipar.central.exceptions;

public class TamanhoMaximoDoCampoExcedidoException extends Exception {

    public TamanhoMaximoDoCampoExcedidoException(String campo, int tamanho) {
        super("O campo " + campo + " foi informado com tamanho superior a (" + tamanho + " caracteres)");
    }

}
