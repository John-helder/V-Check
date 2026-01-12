package com.vcheck.domain.enumeration;

public enum TipoFornecedor {

    PF("Pessoa Física"),
    PJ("Pessoa Jurídica");

    private String tipo;

    TipoFornecedor(String tipo){
        this.tipo = tipo;
    }

    public String getTipo(){
        return tipo;
    }

    public static TipoFornecedor fromString(String text) {
        for (TipoFornecedor tipo : TipoFornecedor.values()) {
            if (tipo.tipo.equalsIgnoreCase(text)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Nenhum tipo encontrado: " + text);
    }
}
