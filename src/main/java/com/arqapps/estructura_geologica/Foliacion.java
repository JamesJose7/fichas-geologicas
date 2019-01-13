package com.arqapps.estructura_geologica;

import javax.persistence.Entity;

@Entity
public class Foliacion extends EstructuraGeologica {
    private String foliacionRocasMetaforicas;
    private String foliacionRocasIgneas;

    public Foliacion() {}

    public Foliacion(String categoria, String subcategoria, String descripcion, String institucionGeneradora, String foliacionRocasMetaforicas, String foliacionRocasIgneas) {
        super(categoria, subcategoria, descripcion, institucionGeneradora);
        this.foliacionRocasMetaforicas = foliacionRocasMetaforicas;
        this.foliacionRocasIgneas = foliacionRocasIgneas;
    }

    public String getFoliacionRocasMetaforicas() {
        return foliacionRocasMetaforicas;
    }

    public void setFoliacionRocasMetaforicas(String foliacionRocasMetaforicas) {
        this.foliacionRocasMetaforicas = foliacionRocasMetaforicas;
    }

    public String getFoliacionRocasIgneas() {
        return foliacionRocasIgneas;
    }

    public void setFoliacionRocasIgneas(String foliacionRocasIgneas) {
        this.foliacionRocasIgneas = foliacionRocasIgneas;
    }
}
