package com.arqapps.estructura_geologica;

import javax.persistence.Entity;

@Entity
public class Diaclasa extends EstructuraGeologica {
    private float direccion;
    private String buzamiento;
    private String asociacion;
    private String formacion;
    private String diaclasaClase;

    public Diaclasa(String categoria, String subcategoria, String descripcion, String institucionGeneradora, float direccion,
                    String buzamiento, String asociacion, String formacion, String diaclasaClase) {
        super(categoria, subcategoria, descripcion, institucionGeneradora);
        this.direccion = direccion;
        this.buzamiento = buzamiento;
        this.asociacion = asociacion;
        this.formacion = formacion;
        this.diaclasaClase = diaclasaClase;
    }

    public float getDireccion() {
        return direccion;
    }

    public void setDireccion(float direccion) {
        this.direccion = direccion;
    }

    public String getBuzamiento() {
        return buzamiento;
    }

    public void setBuzamiento(String buzamiento) {
        this.buzamiento = buzamiento;
    }

    public String getAsociacion() {
        return asociacion;
    }

    public void setAsociacion(String asociacion) {
        this.asociacion = asociacion;
    }

    public String getFormacion() {
        return formacion;
    }

    public void setFormacion(String formacion) {
        this.formacion = formacion;
    }

    public String getDiaclasaClase() {
        return diaclasaClase;
    }

    public void setDiaclasaClase(String diaclasaClase) {
        this.diaclasaClase = diaclasaClase;
    }
}
