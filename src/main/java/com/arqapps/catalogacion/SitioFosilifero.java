package com.arqapps.catalogacion;

import javax.persistence.Entity;

@Entity
public class SitioFosilifero extends Catalogacion {
    private String localizacion;
    private String nombre;
    private float densidad;
    private String era;
    private String periodo;
    private String epoca;
    private String nomEpoca;
    private String piso;
    private String nomPiso;

    public SitioFosilifero() {
    }

    public SitioFosilifero(String localizacion, String nombre, float densidad, String era, String periodo, String epoca,
                           String nomEpoca, String piso, String nomPiso) {
        this.localizacion = localizacion;
        this.nombre = nombre;
        this.densidad = densidad;
        this.era = era;
        this.periodo = periodo;
        this.epoca = epoca;
        this.nomEpoca = nomEpoca;
        this.piso = piso;
        this.nomPiso = nomPiso;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getDensidad() {
        return densidad;
    }

    public void setDensidad(float densidad) {
        this.densidad = densidad;
    }

    public String getEra() {
        return era;
    }

    public void setEra(String era) {
        this.era = era;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getEpoca() {
        return epoca;
    }

    public void setEpoca(String epoca) {
        this.epoca = epoca;
    }

    public String getNomEpoca() {
        return nomEpoca;
    }

    public void setNomEpoca(String nomEpoca) {
        this.nomEpoca = nomEpoca;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getNomPiso() {
        return nomPiso;
    }

    public void setNomPiso(String nomPiso) {
        this.nomPiso = nomPiso;
    }
}
