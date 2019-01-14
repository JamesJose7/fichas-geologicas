package com.arqapps.core;

import com.arqapps.catalogacion.AlteracionHidrotermal;
import com.arqapps.catalogacion.CatalogacionRepository;
import com.arqapps.estructura_geologica.Dique;
import com.arqapps.estructura_geologica.EstructuraGeologicaRepository;
import com.arqapps.estructura_geologica.Foliacion;
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

    private final EstructuraGeologicaRepository mEstructuraGeologicaRepository;
    private final CatalogacionRepository mCatalogacionRepository;

    @Autowired
    public DatabaseLoader(FichaCampoRepository fichas, UbicacionRepository ubicaciones,
                          EstructuraGeologicaRepository estructuraGeologicaRepository,
                          CatalogacionRepository catalogacionRepository) {
        this.fichas = fichas;
        this.ubicaciones = ubicaciones;
        mEstructuraGeologicaRepository = estructuraGeologicaRepository;
        mCatalogacionRepository = catalogacionRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        // Delete previous data !!!
        fichas.deleteAll();
        ubicaciones.deleteAll();
        mEstructuraGeologicaRepository.deleteAll();

        // Ficha de campo
        FichaCampo ficha = new FichaCampo("Muestra", "origen", "unidad", "contacto");
        FichaCampo ficha2 = new FichaCampo("Muestra", "origen", "unidad", "contacto");

        // Ubicacion de ficha de campo
        Ubicacion ubicacion = new Ubicacion(new Date(), "sdf", "sdf", "fsd", "fsdf");
        ubicaciones.save(ubicacion);
        Ubicacion ubicacion2 = new Ubicacion(new Date(), "sdf", "sdf", "fsd", "fsdf");
        ubicaciones.save(ubicacion2);

        // Estructuras geologicas
        Dique dique = new Dique("estructura geologica", "dique", "description", "institucion",
                "clase", "textura");
        mEstructuraGeologicaRepository.save(dique);
        Foliacion foliacion = new Foliacion("estructura geologica", "foliacion", "description", "institucion",
                "metaforicas", "igneas");
        mEstructuraGeologicaRepository.save(foliacion);

        // Catalogacion
        AlteracionHidrotermal alteracionHidrotermal = new AlteracionHidrotermal("catalogacion", "alteracion hidrotermal",
                "descripcion", "institucion", "facctores", "procesos", "classes");
        mCatalogacionRepository.save(alteracionHidrotermal);

        // Save ficha de campo
        ficha.setUbicacion(ubicacion);
        ficha.setEstructuraGeologica(dique);
        ficha.setCatalogacion(alteracionHidrotermal);
        fichas.save(ficha);
        ficha2.setUbicacion(ubicacion2);
        ficha2.setEstructuraGeologica(foliacion);
        ficha2.setCatalogacion(alteracionHidrotermal);
        fichas.save(ficha2);


    }
}
