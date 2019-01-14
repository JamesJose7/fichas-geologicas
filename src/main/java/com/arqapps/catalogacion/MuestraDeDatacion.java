package com.arqapps.catalogacion;

import javax.persistence.Entity;

@Entity
public class MuestraDeDatacion extends Catalogacion {
    private String codigoDatacion;
    private String fechaDatacion;
    private String sitio;
    private String metodoDatacionRadiometrica;
    private String observaciones;

    public MuestraDeDatacion() {
    }

    public MuestraDeDatacion(String codigoDatacion, String fechaDatacion, String sitio, String metodoDatacionRadiometrica, String observaciones) {
        this.codigoDatacion = codigoDatacion;
        this.fechaDatacion = fechaDatacion;
        this.sitio = sitio;
        this.metodoDatacionRadiometrica = metodoDatacionRadiometrica;
        this.observaciones = observaciones;
    }

    public String getCodigoDatacion() {
        return codigoDatacion;
    }

    public void setCodigoDatacion(String codigoDatacion) {
        this.codigoDatacion = codigoDatacion;
    }

    public String getFechaDatacion() {
        return fechaDatacion;
    }

    public void setFechaDatacion(String fechaDatacion) {
        this.fechaDatacion = fechaDatacion;
    }

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    public String getMetodoDatacionRadiometrica() {
        return metodoDatacionRadiometrica;
    }

    public void setMetodoDatacionRadiometrica(String metodoDatacionRadiometrica) {
        this.metodoDatacionRadiometrica = metodoDatacionRadiometrica;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
