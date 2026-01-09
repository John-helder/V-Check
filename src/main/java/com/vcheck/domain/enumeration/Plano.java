package com.vcheck.domain.enumeration;

public enum Plano {
    FREE("Free"),
    PRO("Pro"),
    BUSINESS("Business");

    private String plano;

    Plano(String plano){
        this.plano = plano;
    }

    public String getPlano(){
        return plano;
    }

    public static Plano fromString(String text) {
        for (Plano plano : Plano.values()) {
            if (plano.plano.equalsIgnoreCase(text)) {
                return plano;
            }
        }
        throw new IllegalArgumentException("Nenhum plano encontrado: " + text);
    }
}
