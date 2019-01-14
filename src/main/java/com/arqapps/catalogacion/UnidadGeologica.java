package com.arqapps.catalogacion;

import javax.persistence.Entity;

@Entity
public class UnidadGeologica extends Catalogacion {
    private String era;
    private String nomenclaturaEra;
    private String epoca;
    private String nomenclaturaEpoca;
    private String piso;
    private String nomenclaturaPiso;
    private String jerarquia;
    private String nombreUnidadGeologica;
    private String nombreIntrusivo;
    private String nomenclaturaIntrusivo;

    public UnidadGeologica() {
    }

    public UnidadGeologica(String era, String nomenclaturaEra, String epoca, String nomenclaturaEpoca, String piso, String nomenclaturaPiso, String jerarquia, String nombreUnidadGeologica, String nombreIntrusivo, String nomenclaturaIntrusivo) {
        this.era = era;
        this.nomenclaturaEra = nomenclaturaEra;
        this.epoca = epoca;
        this.nomenclaturaEpoca = nomenclaturaEpoca;
        this.piso = piso;
        this.nomenclaturaPiso = nomenclaturaPiso;
        this.jerarquia = jerarquia;
        this.nombreUnidadGeologica = nombreUnidadGeologica;
        this.nombreIntrusivo = nombreIntrusivo;
        this.nomenclaturaIntrusivo = nomenclaturaIntrusivo;
    }
}
