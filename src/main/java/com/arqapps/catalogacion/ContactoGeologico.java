package com.arqapps.catalogacion;

import javax.persistence.Entity;

@Entity
public class ContactoGeologico extends Catalogacion {
    private String tipo;
    private String limite;
    private String certeza;

    public ContactoGeologico() {
    }

    public ContactoGeologico(String tipo, String limite, String certeza) {
        this.tipo = tipo;
        this.limite = limite;
        this.certeza = certeza;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLimite() {
        return limite;
    }

    public void setLimite(String limite) {
        this.limite = limite;
    }

    public String getCerteza() {
        return certeza;
    }

    public void setCerteza(String certeza) {
        this.certeza = certeza;
    }
}
