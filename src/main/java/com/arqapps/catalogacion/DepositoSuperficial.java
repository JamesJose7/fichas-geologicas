package com.arqapps.catalogacion;

import javax.persistence.Entity;

@Entity
public class DepositoSuperficial extends Catalogacion {
    private String clase;

    public DepositoSuperficial() {
    }

    public DepositoSuperficial(String clase) {
        this.clase = clase;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }
}
