package com.arqapps.ficha_campo;

import com.arqapps.core.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Ubicacion extends BaseEntity {
    private Date fecha;
    private String provincia;
    private String canton;
    private String sector;
    private String escala;
    private byte[] foto;

    @OneToOne(mappedBy = "ubicacion")
    private FichaCampo fichaCampo;

    public Ubicacion() { super(); }

    public Ubicacion(Date fecha, String provincia, String canton, String sector, String escala) {
        this.fecha = fecha;
        this.provincia = provincia;
        this.canton = canton;
        this.sector = sector;
        this.escala = escala;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getEscala() {
        return escala;
    }

    public void setEscala(String escala) {
        this.escala = escala;
    }

    public FichaCampo getFichaCampo() {
        return fichaCampo;
    }

    public void setFichaCampo(FichaCampo fichaCampo) {
        this.fichaCampo = fichaCampo;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}
