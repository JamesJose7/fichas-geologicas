package com.arqapps.catalogacion;

import javax.persistence.Entity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class UnidadGeologica extends Catalogacion {
    @Size(min = 1, max = 1)
    @Pattern(regexp = "[emb]", message = "Valoes aceptados: " +
            "e - Excepcional | " +
            "m - Mediana | " +
            "b - Baja")
    private String era;
    private String nomEra;
    private String epoca;
    private String nomEpoca;
    private String piso;
    private String nomPiso;
    private String jerarquia;
    private String nombreUnidadGeologica;
    private String nombreIntrusivo;
    private String nomIntrusivo;

    public UnidadGeologica() {
    }

    public UnidadGeologica(String era, String nomEra, String epoca, String nomEpoca, String piso, String nomPiso, String jerarquia, String nombreUnidadGeologica, String nombreIntrusivo, String nomIntrusivo) {
        this.era = era;
        this.nomEra = nomEra;
        this.epoca = epoca;
        this.nomEpoca = nomEpoca;
        this.piso = piso;
        this.nomPiso = nomPiso;
        this.jerarquia = jerarquia;
        this.nombreUnidadGeologica = nombreUnidadGeologica;
        this.nombreIntrusivo = nombreIntrusivo;
        this.nomIntrusivo = nomIntrusivo;
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

    public String getJerarquia() {
        return jerarquia;
    }

    public void setJerarquia(String jerarquia) {
        this.jerarquia = jerarquia;
    }

    public String getNombreUnidadGeologica() {
        return nombreUnidadGeologica;
    }

    public void setNombreUnidadGeologica(String nombreUnidadGeologica) {
        this.nombreUnidadGeologica = nombreUnidadGeologica;
    }

    public String getNombreIntrusivo() {
        return nombreIntrusivo;
    }

    public void setNombreIntrusivo(String nombreIntrusivo) {
        this.nombreIntrusivo = nombreIntrusivo;
    }

    public String getNomIntrusivo() {
        return nomIntrusivo;
    }

    public void setNomIntrusivo(String nomIntrusivo) {
        this.nomIntrusivo = nomIntrusivo;
    }
}
