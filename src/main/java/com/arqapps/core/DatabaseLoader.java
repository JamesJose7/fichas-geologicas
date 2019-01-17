package com.arqapps.core;

import com.arqapps.catalogacion.AlteracionHidrotermal;
import com.arqapps.catalogacion.Catalogacion;
import com.arqapps.catalogacion.ContactoGeologico;
import com.arqapps.estructura_geologica.Dique;
import com.arqapps.estructura_geologica.EstructuraGeologica;
import com.arqapps.estructura_geologica.Foliacion;
import com.arqapps.ficha_campo.FichaCampo;
import com.arqapps.ficha_campo.FichaCampoRepository;
import com.arqapps.ficha_campo.Ubicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@Component
public class DatabaseLoader implements ApplicationRunner {
    private final FichaCampoRepository fichas;

    @Autowired
    public DatabaseLoader(FichaCampoRepository fichas) {
        this.fichas = fichas;
    }

    @Override
    public void run(ApplicationArguments args) {
        // Delete previous data !!!
        fichas.deleteAll();

        /*// Ficha de campo
        FichaCampo ficha = new FichaCampo("Muestra", "origen", "unidad", "contacto");
        FichaCampo ficha2 = new FichaCampo("Muestra", "origen", "unidad", "contacto");

        // Ubicacion de ficha de campo
        Ubicacion ubicacion = new Ubicacion(new Date(), "dd", "dd", "d", "fsdf");
        Ubicacion ubicacion2 = new Ubicacion(new Date(), "sdf", "sdf", "fsd", "fsdf");

        // Estructuras geologicas
        Dique dique = new Dique("estructura geologica", "dique", "description", "institucion",
                "c", "c");
        Foliacion foliacion = new Foliacion("estructura geologica", "foliacion", "description", "institucion",
                "m", "i");

        // Catalogacion
        AlteracionHidrotermal alteracionHidrotermal = new AlteracionHidrotermal("catalogacion", "alteracion hidrotermal",
                "descripcion", "institucion", "cr", "d", "gs");

        // Save ficha de campo
        ficha.setUbicacion(ubicacion);
        ficha.setEstructuraGeologica(dique);
        ficha.setCatalogacion(alteracionHidrotermal);
        fichas.save(ficha);
        ficha2.setUbicacion(ubicacion2);
        ficha2.setEstructuraGeologica(foliacion);
        ficha2.setCatalogacion(new AlteracionHidrotermal());
        fichas.save(ficha2);*/


        // Generate test data

         /* Ubicaciones */

        String[] provincias = {
                "Azuay",
                "Bolivar",
                "Carchi",
                "Chimborazo",
                "Cotopaxi",
                "El oro",
                "Esmeraldas",
                "Galapagos",
                "Loja",
                "Manabi"
        };
        String[] cantones = {
                "lorenzo",
                "eloy alfaro",
                "rio verde",
                "esmeraldas",
                "atacames",
                "mira",
                "tulcan",
                "espejo",
                "montufar",
                "bolivar",
                "ibarra"
        };

        String[] parroquias = {
                "Baños",
                "Bulan",
                "Jima",
                "Molleturo",
                "Quingeo",
                "Ricaurte"
        };

        /* Estructuras geologicas */

        // Diques
        String[] texturasRoca = {
                "a", "i"
        };

        // Foliaciones
        String[] rocasMetaforicas = {
                "ic", "ho", "vt"
        };


        /* Catalogaciones */

        // Alteracion Hidrotermal
        String[] factores = {
                "t", "cf", "pc", "di", "cr", "p"
        };

        String[] procesos = {
                "d", "r", "l"
        };

        String[] clases = {
                "sf", "st", "ag", "cl", "ep", "ac", "pl", "ai", "cs", "aa", "ps", "sc", "sk", "gs"
        };

        // Contacto geologico
        String[] tipos = {
                "g", "q", "m", "p", "r", "n"
        };

        String[] limites = {
                "fo", "fi", "fc", "co", "ci", "cf", "cc"
        };

        String[] certezas = {
                "i", "o", "c"
        };

        List<FichaCampo> generatedFichas = new ArrayList<>();
        // Create 25 Fichas with Diques and Alteracion Hidrotermal
        IntStream.range(0, 25)
                .forEach(i -> {
                    //Ubicacion
                    Ubicacion ranUbicacion = new Ubicacion(getRandomDate(),
                            provincias[i % provincias.length],
                            cantones[i % cantones.length],
                            parroquias[i % parroquias.length],
                            randBetween(1, 10) + "");
                    // Diques - Estr Geologica
                    EstructuraGeologica randDique = new Dique("estructura geologica",
                            "dique",
                            "descripcion" + randBetween(1, 50),
                            "insitucion" + randBetween(1, 50),
                            clases[i % clases.length],
                            texturasRoca[i % texturasRoca.length]);
                    // Alteracion Hidrotermal - Catalogacion
                    Catalogacion ranAltHidro = new AlteracionHidrotermal("catalogacion",
                            "alteracion hidrotermal",
                            "descripcion" + randBetween(1, 50),
                            "institucion" + randBetween(1, 50),
                            factores[i % factores.length],
                            procesos[i % procesos.length],
                            clases[i % clases.length]);
                    FichaCampo fichaCampo = new FichaCampo("muestra " + randBetween(100, 1000),
                            "origen " + randBetween(100, 1000),
                            "unidad geologica " + randBetween(100, 1000),
                            "contacto " + randBetween(100, 1000));
                    fichaCampo.setUbicacion(ranUbicacion);
                    fichaCampo.setEstructuraGeologica(randDique);
                    fichaCampo.setCatalogacion(ranAltHidro);
                    generatedFichas.add(fichaCampo);
                });
        // Create 25 Fichas with Foliaciones and Contactos geologicos
        IntStream.range(0, 25)
                .forEach(i -> {
                    //Ubicacion
                    Ubicacion ranUbicacion = new Ubicacion(getRandomDate(),
                            provincias[i % provincias.length],
                            cantones[i % cantones.length],
                            parroquias[i % parroquias.length],
                            randBetween(1, 10) + "");
                    // Foliacion - Estr Geologica
                    EstructuraGeologica randFoliacion = new Foliacion("estructura geologica",
                            "foliacion",
                            "descripcion" + randBetween(1, 50),
                            "institucion" + randBetween(1, 50),
                            rocasMetaforicas[i % rocasMetaforicas.length],
                            texturasRoca[i % texturasRoca.length]);
                    // Contacto geologico - Catalogacion
                    Catalogacion randContactoGeo = new ContactoGeologico("catalogacion",
                            "Contacto geologico",
                            "descripcion" + randBetween(1, 50),
                            "institucion" + randBetween(1, 50),
                            tipos[i % tipos.length],
                            limites[i % limites.length],
                            certezas[i % certezas.length]);
                    FichaCampo fichaCampo = new FichaCampo("muestra " + randBetween(200, 2000),
                            "origen " + randBetween(200, 2000),
                            "unidad geologica " + randBetween(200, 2000),
                            "contacto " + randBetween(200, 2000));
                    fichaCampo.setUbicacion(ranUbicacion);
                    fichaCampo.setEstructuraGeologica(randFoliacion);
                    fichaCampo.setCatalogacion(randContactoGeo);
                    generatedFichas.add(fichaCampo);
                });

        fichas.save(generatedFichas);

    }

    private Date getRandomDate() {
        return new Date(ThreadLocalRandom.current()
                .nextLong((new Date(1263602081000L)).getTime(), (new Date()).getTime()));
    }

    private int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}
