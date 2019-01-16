package com.arqapps.catalogacion;

import javax.persistence.Entity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class AlteracionHidrotermal extends Catalogacion {
    @Size(min = 1, max = 2)
    @Pattern(regexp = "t|cf|pc|di|cr|p", message = "Valores aceptados: " +
            "t - Temperatura | " +
            "cf - Composición del Fluido | " +
            "pc - Permeabilidad de la roca | " +
            "di - Duracción de interacción agua/roca | " +
            "cr - Composición de la roca | " +
            "p - Presión")
    private String factores;
    @Size(min = 1, max = 1)
    @Pattern(regexp = "[drl]", message = "Valores aceptados: " +
            "d - Depositación directa | " +
            "r - Reemplazo | " +
            "l - Lixiviación")
    private String procesos;
    @Size(min = 1, max = 2)
    @Pattern(regexp = "sf|st|ag|cl|ep|ac|pl|ai|cs|aa|ps|sc|sk|gs", message = "Valores aceptados: " +
            "sf - Silicificación | " +
            "st - Sericitización | " +
            "ag - Argilitización | " +
            "cl - Cloritización | " +
            "ep - Epidotización | " +
            "ac - Actinolización | " +
            "pl - Propilítica | " +
            "ai - Argílica Intermedia | " +
            "cs - Sericítica o cuarzo-sericítica | " +
            "aa - Argílica avanzada | " +
            "ps - Potásica | " +
            "sc - Sódico-cálcica | " +
            "sk - Skarn | " +
            "gs - Greissen")
    private String altHidrClases;

    public AlteracionHidrotermal() {}

    public AlteracionHidrotermal(String categoria, String subcategoria, String descripcion, String institucionGeneradora, String factores, String procesos, String altHidrClases) {
        super(categoria, subcategoria, descripcion, institucionGeneradora);
        this.factores = factores;
        this.procesos = procesos;
        this.altHidrClases = altHidrClases;
    }

    public String getFactores() {
        return factores;
    }

    public void setFactores(String factores) {
        this.factores = factores;
    }

    public String getProcesos() {
        return procesos;
    }

    public void setProcesos(String procesos) {
        this.procesos = procesos;
    }

    public String getAltHidrClases() {
        return altHidrClases;
    }

    public void setAltHidrClases(String altHidrClases) {
        this.altHidrClases = altHidrClases;
    }
}
