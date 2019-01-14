package com.arqapps.estructura_geologica;

import javax.persistence.Entity;

@Entity
public class EstructuraPlanar extends EstructuraGeologica {
    private String buzamientoIntensidad;
    private float azimut;
    private String clivaje;
    private String estratificacion;
    private String fotogeologia;
    private String zonaDeCizalla;

    public EstructuraPlanar(String categoria, String subcategoria, String descripcion, String institucionGeneradora,
                            String buzamientoIntensidad, float azimut, String clivaje, String estratificacion, String fotogeologia, String zonaDeCizalla) {
        super(categoria, subcategoria, descripcion, institucionGeneradora);
        this.buzamientoIntensidad = buzamientoIntensidad;
        this.azimut = azimut;
        this.clivaje = clivaje;
        this.estratificacion = estratificacion;
        this.fotogeologia = fotogeologia;
        this.zonaDeCizalla = zonaDeCizalla;
    }

    public String getBuzamientoIntensidad() {
        return buzamientoIntensidad;
    }

    public void setBuzamientoIntensidad(String buzamientoIntensidad) {
        this.buzamientoIntensidad = buzamientoIntensidad;
    }

    public float getAzimut() {
        return azimut;
    }

    public void setAzimut(float azimut) {
        this.azimut = azimut;
    }

    public String getClivaje() {
        return clivaje;
    }

    public void setClivaje(String clivaje) {
        this.clivaje = clivaje;
    }

    public String getEstratificacion() {
        return estratificacion;
    }

    public void setEstratificacion(String estratificacion) {
        this.estratificacion = estratificacion;
    }

    public String getFotogeologia() {
        return fotogeologia;
    }

    public void setFotogeologia(String fotogeologia) {
        this.fotogeologia = fotogeologia;
    }

    public String getZonaDeCizalla() {
        return zonaDeCizalla;
    }

    public void setZonaDeCizalla(String zonaDeCizalla) {
        this.zonaDeCizalla = zonaDeCizalla;
    }
}
