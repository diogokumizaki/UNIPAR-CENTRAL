package br.unipar.central.exceptions;

public class ValorInvalidoException extends Exception {

    public ValorInvalidoException(String campo) {
        super("O valor do campo " + campo + "é inválido de acordo com o que você está inserindo");
    }
}
