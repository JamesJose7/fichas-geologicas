package com.arqapps.estructura_geologica;

import javax.persistence.Entity;

@Entity
public class Dique extends EstructuraGeologica {
    private String claseDique;
    private String texturaDeRoca;

    public Dique() {}

    public Dique(String categoria, String subcategoria, String descripcion, String institucionGeneradora, String claseDique, String texturaDeRoca) {
        super(categoria, subcategoria, descripcion, institucionGeneradora);
        this.claseDique = claseDique;
        this.texturaDeRoca = texturaDeRoca;
    }

    public String getClaseDique() {
        return claseDique;
    }

    public void setClaseDique(String claseDique) {
        this.claseDique = claseDique;
    }

    public String getTexturaDeRoca() {
        return texturaDeRoca;
    }

    public void setTexturaDeRoca(String texturaDeRoca) {
        this.texturaDeRoca = texturaDeRoca;
    }
}
