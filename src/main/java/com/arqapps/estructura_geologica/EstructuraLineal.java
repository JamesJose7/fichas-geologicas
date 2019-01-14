package com.arqapps.estructura_geologica;

import javax.persistence.Entity;

@Entity
public class EstructuraLineal extends EstructuraGeologica {
    private float rumbo;
    private float buzamiento;
    private String claseEstrLineal;
    private String lineacion;

    public EstructuraLineal(String categoria, String subcategoria, String descripcion, String institucionGeneradora,
                            float rumbo, float buzamiento, String claseEstrLineal, String lineacion) {
        super(categoria, subcategoria, descripcion, institucionGeneradora);
        this.rumbo = rumbo;
        this.buzamiento = buzamiento;
        this.claseEstrLineal = claseEstrLineal;
        this.lineacion = lineacion;
    }

    public float getRumbo() {
        return rumbo;
    }

    public void setRumbo(float rumbo) {
        this.rumbo = rumbo;
    }

    public float getBuzamiento() {
        return buzamiento;
    }

    public void setBuzamiento(float buzamiento) {
        this.buzamiento = buzamiento;
    }

    public String getClaseEstrLineal() {
        return claseEstrLineal;
    }

    public void setClaseEstrLineal(String claseEstrLineal) {
        this.claseEstrLineal = claseEstrLineal;
    }

    public String getLineacion() {
        return lineacion;
    }

    public void setLineacion(String lineacion) {
        this.lineacion = lineacion;
    }
}
