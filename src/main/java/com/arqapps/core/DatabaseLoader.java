package com.arqapps.core;

import com.arqapps.catalogacion.Afloramiento;
import com.arqapps.catalogacion.Muestra;
import com.arqapps.estructura_geologica.EstructuraLineal;
import com.arqapps.estructura_geologica.EstructuraPlanar;
import com.arqapps.estructura_geologica.Pliegue;
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

        IntStream.range(0, 25)
                .forEach(i -> {
                    //Ubicacion
                    Ubicacion ranUbicacion = new Ubicacion(getRandomDate(),
                            provincias[i % provincias.length],
                            cantones[i % cantones.length],
                            parroquias[i % parroquias.length],
                            randBetween(1, 10) + "");
                    // Catalogaciones
                    Muestra muestra = new Muestra(
                            clases[i % clases.length],
                            clases[i % clases.length],
                            clases[i % clases.length],
                            randBetween(50, 500),
                            clases[i % clases.length],
                            clases[i % clases.length],
                            clases[i % clases.length],
                            clases[i % clases.length],
                            randBetween(600, 1000),
                            clases[i % clases.length]
                            );
                    Afloramiento afloramiento = new Afloramiento(
                            clases[i % clases.length],
                            clases[i % clases.length],
                            clases[i % clases.length],
                            clases[i % clases.length]
                            );
                    // Estructuras Geologicas
                    EstructuraPlanar estructuraPlanar = new EstructuraPlanar(
                            clases[i % clases.length],
                            randBetween(20, 500),
                            clases[i % clases.length],
                            clases[i % clases.length],
                            clases[i % clases.length],
                            clases[i % clases.length],
                            clases[i % clases.length],
                            clases[i % clases.length]
                            );
                    EstructuraLineal estructuraLineal = new EstructuraLineal(
                            randBetween(20, 200),
                            clases[i % clases.length],
                            clases[i % clases.length],
                            randBetween(500, 999),
                            clases[i % clases.length],
                            clases[i % clases.length],
                            clases[i % clases.length],
                            clases[i % clases.length]
                            );
                    Pliegue pliegue = new Pliegue(
                            randBetween(500, 888),
                            randBetween(10, 100),
                            clases[i % clases.length],
                            randBetween(100, 500),
                            randBetween(100, 500),
                            clases[i % clases.length],
                            clases[i % clases.length],
                            clases[i % clases.length],
                            clases[i % clases.length]
                            );
                    FichaCampo fichaCampo = new FichaCampo(
                            "datum " + randBetween(100, 1000),
                            "escala " + randBetween(100, 1000),
                            "proyecto " + randBetween(100, 1000),
                            getLorem(randBetween(1, 5)),
                            "descritaPor " + randBetween(100, 1000),
                            clases[i % clases.length],
                            clases[i % clases.length],
                            clases[i % clases.length],
                            clases[i % clases.length],
                            clases[i % clases.length],
                            clases[i % clases.length]
                    );
                    fichaCampo.setUbicacion(ranUbicacion);
                    fichaCampo.setMuestra(muestra);
                    fichaCampo.setAfloramiento(afloramiento);
                    fichaCampo.setEstructuraPlanar(estructuraPlanar);
                    fichaCampo.setEstructuraLineal(estructuraLineal);
                    fichaCampo.setPliegue(pliegue);
                    generatedFichas.add(fichaCampo);
                });

        // Create 25 Fichas with Diques and Alteracion Hidrotermal
        /*IntStream.range(0, 25)
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
                });*/

        fichas.save(generatedFichas);

    }

    private Date getRandomDate() {
        return new Date(ThreadLocalRandom.current()
                .nextLong((new Date(1263602081000L)).getTime(), (new Date()).getTime()));
    }

    private int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }

    private String getLorem(int repeats) {
        String lorem = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                "consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n" +
                "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n" +
                "proident, sunt in culpa qui officia deserunt mollit anim id est laborum. ";
        return lorem.repeat(repeats);
    }
}
