package com.vcheck.domain.enumeration;

public enum StatusDocumento {
    VERDE("Verde"),
    AMARELO("Amarelo"),
    VERMELHO("Vermelho");

    private String status;

    StatusDocumento(String label) {
        this.status = label;
    }

    public String getStatus() {
        return status;
    }

    public static StatusDocumento fromString(String text) {
        for (StatusDocumento statusDocumento : StatusDocumento.values()) {
            if (statusDocumento.status.equalsIgnoreCase(text)) {
                return statusDocumento;
            }
        }
        throw new IllegalArgumentException("Nenhum Status encontrado: " + text);
    }
}
