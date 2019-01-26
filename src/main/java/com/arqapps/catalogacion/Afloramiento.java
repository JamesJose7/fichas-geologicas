package com.arqapps.catalogacion;

import com.arqapps.core.BaseEntity;
import com.arqapps.ficha_campo.FichaCampo;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Afloramiento extends BaseEntity {
    private String dimension;
    private String origen;
    private String tipoRoca;
    private String sitio;

    @OneToOne(mappedBy = "afloramiento")
    private FichaCampo fichaCampo;

    public Afloramiento() {
    }

    public Afloramiento(String dimension, String origen, String tipoRoca, String sitio) {
        this.dimension = dimension;
        this.origen = origen;
        this.tipoRoca = tipoRoca;
        this.sitio = sitio;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
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

    public FichaCampo getFichaCampo() {
        return fichaCampo;
    }

    public void setFichaCampo(FichaCampo fichaCampo) {
        this.fichaCampo = fichaCampo;
    }
}
