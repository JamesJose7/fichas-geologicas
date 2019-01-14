package com.arqapps.estructura_geologica;

public class Falla extends EstructuraGeologica {
    private float rumbo;

    public Falla(String categoria, String subcategoria, String descripcion, String institucionGeneradora, float rumbo) {
        super(categoria, subcategoria, descripcion, institucionGeneradora);
        this.rumbo = rumbo;
    }

    public float getRumbo() {
        return rumbo;
    }

    public void setRumbo(float rumbo) {
        this.rumbo = rumbo;
    }
}
