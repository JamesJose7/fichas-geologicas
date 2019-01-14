package com.arqapps.catalogacion;

import javax.persistence.Entity;

@Entity
public class Afloramiento extends Catalogacion {
    private float dimension;
    private String origenRoca;
    private String tipoRoca;
    private String sitio;

    public Afloramiento() {
    }

    public Afloramiento(float dimension, String origenRoca, String tipoRoca, String sitio) {
        this.dimension = dimension;
        this.origenRoca = origenRoca;
        this.tipoRoca = tipoRoca;
        this.sitio = sitio;
    }

    public float getDimension() {
        return dimension;
    }

    public void setDimension(float dimension) {
        this.dimension = dimension;
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

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }
}
