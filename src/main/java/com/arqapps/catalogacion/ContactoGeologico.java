package com.arqapps.catalogacion;

import javax.persistence.Entity;

@Entity
public class ContactoGeologico extends Catalogacion {
    private String tipoContacto;
    private String limite;
    private String certeza;

    public ContactoGeologico() {
    }

    public ContactoGeologico(String tipoContacto, String limite, String certeza) {
        this.tipoContacto = tipoContacto;
        this.limite = limite;
        this.certeza = certeza;
    }

    public String getTipoContacto() {
        return tipoContacto;
    }

    public void setTipoContacto(String tipoContacto) {
        this.tipoContacto = tipoContacto;
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
