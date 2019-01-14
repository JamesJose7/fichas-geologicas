package com.arqapps.estructura_geologica;

import javax.persistence.Entity;

@Entity
public class Foliacion extends EstructuraGeologica {
    private String rocasMetaforicas;
    private String rocasIgneas;

    public Foliacion() {}

    public Foliacion(String categoria, String subcategoria, String descripcion, String institucionGeneradora, String rocasMetaforicas, String rocasIgneas) {
        super(categoria, subcategoria, descripcion, institucionGeneradora);
        this.rocasMetaforicas = rocasMetaforicas;
        this.rocasIgneas = rocasIgneas;
    }

    public String getRocasMetaforicas() {
        return rocasMetaforicas;
    }

    public void setRocasMetaforicas(String rocasMetaforicas) {
        this.rocasMetaforicas = rocasMetaforicas;
    }

    public String getRocasIgneas() {
        return rocasIgneas;
    }

    public void setRocasIgneas(String rocasIgneas) {
        this.rocasIgneas = rocasIgneas;
    }
}
