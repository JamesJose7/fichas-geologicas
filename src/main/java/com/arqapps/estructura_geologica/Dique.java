package com.arqapps.estructura_geologica;

import javax.persistence.Entity;

@Entity
public class Dique extends EstructuraGeologica {
    private String clase;
    private String texturaDeRoca;

    public Dique() {}

    public Dique(String categoria, String subcategoria, String descripcion, String institucionGeneradora, String clase, String texturaDeRoca) {
        super(categoria, subcategoria, descripcion, institucionGeneradora);
        this.clase = clase;
        this.texturaDeRoca = texturaDeRoca;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getTexturaDeRoca() {
        return texturaDeRoca;
    }

    public void setTexturaDeRoca(String texturaDeRoca) {
        this.texturaDeRoca = texturaDeRoca;
    }
}
