package com.arqapps.catalogacion;

import javax.persistence.Entity;

@Entity
public class Fosil extends Catalogacion {
    private String reino;
    private String claseFosil;
    private String tipoFosil;
    private String flora;
    private String fauna;
    private float tamanio;
    private String era;
    private String nomEra;
    private String periodo;
    private String nomPeriodo;
    private String epoca;
    private String nomEpoca;
    private String piso;
    private String nomPiso;

    public Fosil() { }

    public Fosil(String reino, String claseFosil, String tipoFosil, String flora, String fauna, float tamanio, String era, String nomEra, String periodo, String nomPeriodo, String epoca, String nomEpoca, String piso, String nomPiso) {
        this.reino = reino;
        this.claseFosil = claseFosil;
        this.tipoFosil = tipoFosil;
        this.flora = flora;
        this.fauna = fauna;
        this.tamanio = tamanio;
        this.era = era;
        this.nomEra = nomEra;
        this.periodo = periodo;
        this.nomPeriodo = nomPeriodo;
        this.epoca = epoca;
        this.nomEpoca = nomEpoca;
        this.piso = piso;
        this.nomPiso = nomPiso;
    }

    public String getReino() {
        return reino;
    }

    public void setReino(String reino) {
        this.reino = reino;
    }

    public String getClaseFosil() {
        return claseFosil;
    }

    public void setClaseFosil(String claseFosil) {
        this.claseFosil = claseFosil;
    }

    public String getTipoFosil() {
        return tipoFosil;
    }

    public void setTipoFosil(String tipoFosil) {
        this.tipoFosil = tipoFosil;
    }

    public String getFlora() {
        return flora;
    }

    public void setFlora(String flora) {
        this.flora = flora;
    }

    public String getFauna() {
        return fauna;
    }

    public void setFauna(String fauna) {
        this.fauna = fauna;
    }

    public float getTamanio() {
        return tamanio;
    }

    public void setTamanio(float tamanio) {
        this.tamanio = tamanio;
    }

    public String getEra() {
        return era;
    }

    public void setEra(String era) {
        this.era = era;
    }

    public String getNomEra() {
        return nomEra;
    }

    public void setNomEra(String nomEra) {
        this.nomEra = nomEra;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getNomPeriodo() {
        return nomPeriodo;
    }

    public void setNomPeriodo(String nomPeriodo) {
        this.nomPeriodo = nomPeriodo;
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
