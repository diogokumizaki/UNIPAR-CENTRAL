package br.unipar.central.exceptions;

public class CampoEspecificoNaoInformadoException extends Exception {

    public CampoEspecificoNaoInformadoException(String campo) {
        super("O campo " + campo + " não Foi Informado. Verifique!");
    }

}
