package br.unipar.central.enums;

public enum TipoTransacaoEnum {

    DEBITO(1),
    CREDITO(2),
    PIX(3);

    private final int numero;

    private TipoTransacaoEnum(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

}
