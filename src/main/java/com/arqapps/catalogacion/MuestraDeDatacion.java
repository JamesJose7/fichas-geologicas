package com.arqapps.catalogacion;

import javax.persistence.Entity;

@Entity
public class MuestraDeDatacion extends Catalogacion {
    private String codigo;
    private String fecha;
    private String sitio;
    private String metodoDatacionRadiometrica;
    private String observaciones;

    public MuestraDeDatacion() {
    }

    public MuestraDeDatacion(String codigo, String fecha, String sitio, String metodoDatacionRadiometrica, String observaciones) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.sitio = sitio;
        this.metodoDatacionRadiometrica = metodoDatacionRadiometrica;
        this.observaciones = observaciones;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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
