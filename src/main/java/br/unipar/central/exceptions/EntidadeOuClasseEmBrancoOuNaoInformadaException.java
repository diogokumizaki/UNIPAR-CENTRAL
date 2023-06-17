package br.unipar.central.exceptions;

public class EntidadeOuClasseEmBrancoOuNaoInformadaException extends Exception {

    public EntidadeOuClasseEmBrancoOuNaoInformadaException(String entidade) {
        super(entidade + " não foi informada(o) e deve ser preenchida(o). "
                + "Verifique!");
    }

}
