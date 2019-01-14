package com.arqapps.catalogacion;

import javax.persistence.Entity;

@Entity
public class DepositoSuperficial extends Catalogacion {
    private String claseDeposito;

    public DepositoSuperficial() {
    }

    public DepositoSuperficial(String claseDeposito) {
        this.claseDeposito = claseDeposito;
    }

    public String getClaseDeposito() {
        return claseDeposito;
    }

    public void setClaseDeposito(String claseDeposito) {
        this.claseDeposito = claseDeposito;
    }
}
