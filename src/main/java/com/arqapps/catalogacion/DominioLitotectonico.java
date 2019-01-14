package com.arqapps.catalogacion;

import javax.persistence.Entity;

@Entity
public class DominioLitotectonico extends Catalogacion {
    private String region;

    public DominioLitotectonico() {
    }

    public DominioLitotectonico(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
