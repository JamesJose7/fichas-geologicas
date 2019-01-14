package com.arqapps.catalogacion;

import javax.persistence.Entity;

@Entity
public class SitioFosilifero extends Catalogacion {
    private String localizacion;
    private String nombre;
    private float densidad;
    private String era;
    private String nomenclaturaEra;
    private String periodo;
    private String nomenclaturaPeriodo;
    private String epoca;
    private String nomenclaturaEpoca;
    private String piso;
    private String nomenclaturaPiso;

    public SitioFosilifero() {
    }

    public SitioFosilifero(String localizacion, String nombre, float densidad, String era, String nomenclaturaEra, String periodo, String nomenclaturaPeriodo, String epoca, String nomenclaturaEpoca, String piso, String nomenclaturaPiso) {
        this.localizacion = localizacion;
        this.nombre = nombre;
        this.densidad = densidad;
        this.era = era;
        this.nomenclaturaEra = nomenclaturaEra;
        this.periodo = periodo;
        this.nomenclaturaPeriodo = nomenclaturaPeriodo;
        this.epoca = epoca;
        this.nomenclaturaEpoca = nomenclaturaEpoca;
        this.piso = piso;
        this.nomenclaturaPiso = nomenclaturaPiso;
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
