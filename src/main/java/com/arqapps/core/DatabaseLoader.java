package com.arqapps.core;

import com.arqapps.catalogacion.Afloramiento;
import com.arqapps.muestra.Muestra;
import com.arqapps.estructura_geologica.EstructuraLineal;
import com.arqapps.estructura_geologica.EstructuraPlanar;
import com.arqapps.pliegue.Pliegue;
import com.arqapps.ficha_campo.FichaCampo;
import com.arqapps.ficha_campo.FichaCampoRepository;
import com.arqapps.ubicacion.Ubicacion;
import com.arqapps.user.User;
import com.arqapps.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@Component
public class DatabaseLoader implements ApplicationRunner {
    private final FichaCampoRepository fichas;
    private final UserRepository users;

    @Autowired
    public DatabaseLoader(FichaCampoRepository fichas, UserRepository users) {
        this.fichas = fichas;
        this.users = users;
    }

    @Override
    public void run(ApplicationArguments args) {
        // Delete previous data !!!
        fichas.deleteAll();
        users.deleteAll();

        // Generate test users
        List<User> testUsers = Arrays.asList(
                new User("raherrera", "andre", "herrera", "password", new String[] {"ROLE_USER"}),
                new User("jeeguiguren", "jose", "eguiguren", "password", new String[] {"ROLE_USER"}),
                new User("mjmora", "maria jose", "more", "password", new String[] {"ROLE_USER"})
        );
        users.save(testUsers);
        // Admin
        users.save(new User("admin", "super", "admin",
                "admin", new String[] {"ROLE_ADMIN", "ROLE_ADMIN"}));



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
                            getLorem(randBetween(1, 2)),
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
                    fichaCampo.setUser(testUsers.get(i % testUsers.size()));
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

    private String getLorem(int repeats) {
        return  "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod";
//        return lorem.repeat(repeats);
    }
}
