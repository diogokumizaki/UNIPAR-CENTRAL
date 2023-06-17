package br.unipar.central.enums;

public enum TipoOperadoraEnum {

    TIM(1),
    CLARO(2),
    VIVO(3),
    OI(4),
    CORREIOS(5),
    LARICELL(6),
    TESLA(7),
    IPHONE(8),
    OUTROS(9);

    private final int numero;

    private TipoOperadoraEnum(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

}
