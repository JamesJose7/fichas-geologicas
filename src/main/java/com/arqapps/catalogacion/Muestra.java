package com.arqapps.catalogacion;

import javax.persistence.Entity;

@Entity
public class Muestra extends Catalogacion {
    private String naturaleza;
    private String tipoMuestra;
    private String consistenciaMaterial;
    private String codigo;
    private String sitio;
    private String tipoAnalisis;
    private String metodoAnalisis;
    private String nomMetodoAnalisis;
    private String cantidadMuestra;
    private String observaciones;

    public Muestra() {
    }

    public Muestra(String naturaleza, String tipoMuestra, String consistenciaMaterial, String codigo, String sitio, String tipoAnalisis, String metodoAnalisis, String nomMetodoAnalisis, String cantidadMuestra, String observaciones) {
        this.naturaleza = naturaleza;
        this.tipoMuestra = tipoMuestra;
        this.consistenciaMaterial = consistenciaMaterial;
        this.codigo = codigo;
        this.sitio = sitio;
        this.tipoAnalisis = tipoAnalisis;
        this.metodoAnalisis = metodoAnalisis;
        this.nomMetodoAnalisis = nomMetodoAnalisis;
        this.cantidadMuestra = cantidadMuestra;
        this.observaciones = observaciones;
    }

    public String getNaturaleza() {
        return naturaleza;
    }

    public void setNaturaleza(String naturaleza) {
        this.naturaleza = naturaleza;
    }

    public String getTipoMuestra() {
        return tipoMuestra;
    }

    public void setTipoMuestra(String tipoMuestra) {
        this.tipoMuestra = tipoMuestra;
    }

    public String getConsistenciaMaterial() {
        return consistenciaMaterial;
    }

    public void setConsistenciaMaterial(String consistenciaMaterial) {
        this.consistenciaMaterial = consistenciaMaterial;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    public String getTipoAnalisis() {
        return tipoAnalisis;
    }

    public void setTipoAnalisis(String tipoAnalisis) {
        this.tipoAnalisis = tipoAnalisis;
    }

    public String getMetodoAnalisis() {
        return metodoAnalisis;
    }

    public void setMetodoAnalisis(String metodoAnalisis) {
        this.metodoAnalisis = metodoAnalisis;
    }

    public String getNomMetodoAnalisis() {
        return nomMetodoAnalisis;
    }

    public void setNomMetodoAnalisis(String nomMetodoAnalisis) {
        this.nomMetodoAnalisis = nomMetodoAnalisis;
    }

    public String getCantidadMuestra() {
        return cantidadMuestra;
    }

    public void setCantidadMuestra(String cantidadMuestra) {
        this.cantidadMuestra = cantidadMuestra;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
