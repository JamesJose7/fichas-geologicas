package com.arqapps.catalogacion;

import javax.persistence.Entity;

@Entity
public class AlteracionHidrotermal extends Catalogacion {
    private String factores;
    private String procesos;
    private String clases;

    public AlteracionHidrotermal() {}

    public AlteracionHidrotermal(String categoria, String subcategoria, String descripcion, String institucionGeneradora, String factores, String procesos, String clases) {
        super(categoria, subcategoria, descripcion, institucionGeneradora);
        this.factores = factores;
        this.procesos = procesos;
        this.clases = clases;
    }

    public String getFactores() {
        return factores;
    }

    public void setFactores(String factores) {
        this.factores = factores;
    }

    public String getProcesos() {
        return procesos;
    }

    public void setProcesos(String procesos) {
        this.procesos = procesos;
    }

    public String getClases() {
        return clases;
    }

    public void setClases(String clases) {
        this.clases = clases;
    }
}
