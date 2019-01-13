package com.arqapps.core;

import com.arqapps.ficha_campo.FichaCampo;
import com.arqapps.ficha_campo.FichaCampoRepository;
import com.arqapps.ficha_campo.Ubicacion;
import com.arqapps.ficha_campo.UbicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DatabaseLoader implements ApplicationRunner {
    private final FichaCampoRepository fichas;
    private final UbicacionRepository ubicaciones;

    @Autowired
    public DatabaseLoader(FichaCampoRepository fichas, UbicacionRepository ubicaciones) {
        this.fichas = fichas;
        this.ubicaciones = ubicaciones;
    }

    @Override
    public void run(ApplicationArguments args) {
        FichaCampo ficha = new FichaCampo("Muestra", "origen", "unidad", "contacto");
        Ubicacion ubicacion = new Ubicacion(new Date(), "sdf", "sdf", "fsd", "fsdf");
        ubicaciones.save(ubicacion);
        ficha.setUbicacion(ubicacion);
        fichas.save(ficha);
    }
}
