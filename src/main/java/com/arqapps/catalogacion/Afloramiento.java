package com.arqapps.catalogacion;

import javax.persistence.Entity;

@Entity
public class Afloramiento extends Catalogacion {
    private float dimension;
    private String origen;
    private String tipoRoca;
    private String sitio;

    public Afloramiento() {
    }

    public Afloramiento(float dimension, String origen, String tipoRoca, String sitio) {
        this.dimension = dimension;
        this.origen = origen;
        this.tipoRoca = tipoRoca;
        this.sitio = sitio;
    }

    public float getDimension() {
        return dimension;
    }

    public void setDimension(float dimension) {
        this.dimension = dimension;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
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
