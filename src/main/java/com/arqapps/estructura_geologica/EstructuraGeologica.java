package com.arqapps.estructura_geologica;

import com.arqapps.core.BaseEntity;
import com.arqapps.ficha_campo.FichaCampo;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.OneToOne;

@Entity
@Inheritance
@DiscriminatorColumn(name = "estructura_geologica_type")
public abstract class EstructuraGeologica extends BaseEntity {
    private String categoria;
    private String subcategoria;
    private String descripcion;
    private String institucionGeneradora;

    @OneToOne(mappedBy = "estructuraGeologica")
    private FichaCampo fichaCampo;

    public EstructuraGeologica() {}

    public EstructuraGeologica(String categoria, String subcategoria, String descripcion, String institucionGeneradora) {
        this.categoria = categoria;
        this.subcategoria = subcategoria;
        this.descripcion = descripcion;
        this.institucionGeneradora = institucionGeneradora;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getInstitucionGeneradora() {
        return institucionGeneradora;
    }

    public void setInstitucionGeneradora(String institucionGeneradora) {
        this.institucionGeneradora = institucionGeneradora;
    }
}
