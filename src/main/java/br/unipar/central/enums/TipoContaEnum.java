package br.unipar.central.enums;

public enum TipoContaEnum {
    CORRENTE(1),
    POUPANCA(2),
    SALARIO(3);

    private final int numero;

    private TipoContaEnum(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
    public static TipoContaEnum paraEnum(int codigo) {
        for (TipoContaEnum tipo : TipoContaEnum.values()) {
            if (tipo.getNumero() == codigo) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Código inválido!");
    } 
    
}
