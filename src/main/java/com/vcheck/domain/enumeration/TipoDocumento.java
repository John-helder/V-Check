package com.vcheck.domain.enumeration;

public enum TipoDocumento {
    NR_01("NR-01"),
    NR_05("NR-05"),
    NR_06("NR-06"),
    NR_07("NR-07"),
    NR_09("NR-09"),
    NR_10("NR-10"),
    NR_12("NR-12"),
    NR_18("NR-18"),
    NR_33("NR-33"),
    NR_35("NR-35"),
    ASO("ASO"),
    PCMSO("PCMSO"),
    PPRA("PPRA"),
    LTCAT("LTCAT"),
    CND("CND"),
    SEGURO("Seguro"),
    CONTRATO("Contrato"),
    OUTRO("Outro");

    private String label;

    TipoDocumento(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static TipoDocumento fromString(String text) {
        for (TipoDocumento tipoDocumento : TipoDocumento.values()) {
            if (tipoDocumento.label.equalsIgnoreCase(text)) {
                return tipoDocumento;
            }
        }
        throw new IllegalArgumentException("Nenhum tipo de Documento encontrado: " + text);
    }
}
