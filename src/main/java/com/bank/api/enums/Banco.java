package com.bank.api.enums;

public enum Banco {

    BANCO_DO_BRASIL("001"),
    CAIXA_ECONOMICA_FEDERAL("104"),
    BRADESCO("237"),
    ITAU("341"),
    SANTANDER("033");

    private String descricao;

    Banco(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
