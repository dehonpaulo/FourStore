package com.foursys.fourstore.enums;

public enum PaymentMethod {
    DINHEIRO("dinheiro"),
    CARTAO_DE_CREDITO("cartão de crédito"),
    CARTAO_DE_DEBITO("cartão de débito"),
    PIX("pix");

    private final String value;

    private PaymentMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}