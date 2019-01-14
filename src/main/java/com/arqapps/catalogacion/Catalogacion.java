package com.arqapps.catalogacion;

import com.arqapps.core.BaseEntity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Entity
@Inheritance
@DiscriminatorColumn(name = "catalogacion_type")
public abstract class Catalogacion extends BaseEntity {
    private String categoria;
    private String subcategoria;
    private String descripcion;
    private String institucionGeneradora;

    public Catalogacion() {}

    public Catalogacion(String categoria, String subcategoria, String descripcion, String institucionGeneradora) {
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
