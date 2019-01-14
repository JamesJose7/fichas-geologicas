package com.arqapps.estructura_geologica;

import javax.persistence.Entity;

@Entity
public class Falla extends EstructuraGeologica {
    private float rumbo;
    private float buzamiento;
    private float azimut;
    private String claseFalla;
    private boolean estado;
    private String certeza;
    private String escarpe;

    public Falla(String categoria, String subcategoria, String descripcion, String institucionGeneradora, float rumbo,
                 float buzamiento, float azimut, String claseFalla, boolean estado, String certeza, String escarpe) {
        super(categoria, subcategoria, descripcion, institucionGeneradora);
        this.rumbo = rumbo;
        this.buzamiento = buzamiento;
        this.azimut = azimut;
        this.claseFalla = claseFalla;
        this.estado = estado;
        this.certeza = certeza;
        this.escarpe = escarpe;
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

    public float getAzimut() {
        return azimut;
    }

    public void setAzimut(float azimut) {
        this.azimut = azimut;
    }

    public String getClaseFalla() {
        return claseFalla;
    }

    public void setClaseFalla(String claseFalla) {
        this.claseFalla = claseFalla;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getCerteza() {
        return certeza;
    }

    public void setCerteza(String certeza) {
        this.certeza = certeza;
    }

    public String getEscarpe() {
        return escarpe;
    }

    public void setEscarpe(String escarpe) {
        this.escarpe = escarpe;
    }
}
