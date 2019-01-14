package com.arqapps.catalogacion;

import javax.persistence.Entity;

@Entity
public class Fosil extends Catalogacion {
    private String reino;
    private String clase;
    private String tipo;
    private String flora;
    private String fauna;
    private float tamanio;
    private String era;
    private String nomenclaturaEra;
    private String periodo;
    private String nomenclaturaPeriodo;
    private String epoca;
    private String nomenclaturaEpoca;
    private String piso;
    private String nomenclaturaPiso;

    public Fosil() { }

    public Fosil(String reino, String clase, String tipo, String flora, String fauna, float tamanio, String era, String nomenclaturaEra, String periodo, String nomenclaturaPeriodo, String epoca, String nomenclaturaEpoca, String piso, String nomenclaturaPiso) {
        this.reino = reino;
        this.clase = clase;
        this.tipo = tipo;
        this.flora = flora;
        this.fauna = fauna;
        this.tamanio = tamanio;
        this.era = era;
        this.nomenclaturaEra = nomenclaturaEra;
        this.periodo = periodo;
        this.nomenclaturaPeriodo = nomenclaturaPeriodo;
        this.epoca = epoca;
        this.nomenclaturaEpoca = nomenclaturaEpoca;
        this.piso = piso;
        this.nomenclaturaPiso = nomenclaturaPiso;
    }

    public String getReino() {
        return reino;
    }

    public void setReino(String reino) {
        this.reino = reino;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public String getNomenclaturaEra() {
        return nomenclaturaEra;
    }

    public void setNomenclaturaEra(String nomenclaturaEra) {
        this.nomenclaturaEra = nomenclaturaEra;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getNomenclaturaPeriodo() {
        return nomenclaturaPeriodo;
    }

    public void setNomenclaturaPeriodo(String nomenclaturaPeriodo) {
        this.nomenclaturaPeriodo = nomenclaturaPeriodo;
    }

    public String getEpoca() {
        return epoca;
    }

    public void setEpoca(String epoca) {
        this.epoca = epoca;
    }

    public String getNomenclaturaEpoca() {
        return nomenclaturaEpoca;
    }

    public void setNomenclaturaEpoca(String nomenclaturaEpoca) {
        this.nomenclaturaEpoca = nomenclaturaEpoca;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getNomenclaturaPiso() {
        return nomenclaturaPiso;
    }

    public void setNomenclaturaPiso(String nomenclaturaPiso) {
        this.nomenclaturaPiso = nomenclaturaPiso;
    }
}
