package com.arqapps.catalogacion;

import javax.persistence.Entity;

@Entity
public class Roca extends Catalogacion {
    private String origenRoca;
    private String tipoRoca;
    private String estructura;

    public Roca() {
    }

    public Roca(String origen, String tipo, String estructura) {
        this.origen = origen;
        this.tipo = tipo;
        this.estructura = estructura;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstructura() {
        return estructura;
    }

    public void setEstructura(String estructura) {
        this.estructura = estructura;
    }
}
