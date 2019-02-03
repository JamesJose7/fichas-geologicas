package com.arqapps.pliegue;

import com.arqapps.core.BaseEntity;
import com.arqapps.ficha_campo.FichaCampo;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Pliegue extends BaseEntity {
    private float rumbo;
    private float buzamiento;
    private String tipo;
    private float altura;
    private float separacion;
    private String posicion;
    private String anguloEntreFlancos;
    private String perfil;
    private String sistema;

    @OneToOne(mappedBy = "pliegue")
    private FichaCampo fichaCampo;

    public Pliegue() {
    }

    public Pliegue(float rumbo, float buzamiento, String tipo, float altura, float separacion,
                   String posicion, String anguloEntreFlancos, String perfil, String sistema) {
        this.rumbo = rumbo;
        this.buzamiento = buzamiento;
        this.tipo = tipo;
        this.altura = altura;
        this.separacion = separacion;
        this.posicion = posicion;
        this.anguloEntreFlancos = anguloEntreFlancos;
        this.perfil = perfil;
        this.sistema = sistema;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getSeparacion() {
        return separacion;
    }

    public void setSeparacion(float separacion) {
        this.separacion = separacion;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getAnguloEntreFlancos() {
        return anguloEntreFlancos;
    }

    public void setAnguloEntreFlancos(String anguloEntreFlancos) {
        this.anguloEntreFlancos = anguloEntreFlancos;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public FichaCampo getFichaCampo() {
        return fichaCampo;
    }

    public void setFichaCampo(FichaCampo fichaCampo) {
        this.fichaCampo = fichaCampo;
    }
}
