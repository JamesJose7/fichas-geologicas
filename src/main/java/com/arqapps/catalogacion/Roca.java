package com.arqapps.catalogacion;

import javax.persistence.Entity;

@Entity
public class Roca extends Catalogacion {
    private String origenRoca;
    private String tipoRoca;
    private String estructura;

    public Roca() {
    }

    public Roca(String categoria, String subcategoria, String descripcion, String institucionGeneradora, String origenRoca, String tipoRoca, String estructura) {
        super(categoria, subcategoria, descripcion, institucionGeneradora);
        this.origenRoca = origenRoca;
        this.tipoRoca = tipoRoca;
        this.estructura = estructura;
    }

    public String getOrigenRoca() {
        return origenRoca;
    }

    public void setOrigenRoca(String origenRoca) {
        this.origenRoca = origenRoca;
    }

    public String getTipoRoca() {
        return tipoRoca;
    }

    public void setTipoRoca(String tipoRoca) {
        this.tipoRoca = tipoRoca;
    }

    public String getEstructura() {
        return estructura;
    }

    public void setEstructura(String estructura) {
        this.estructura = estructura;
    }
}
