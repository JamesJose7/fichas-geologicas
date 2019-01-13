package com.arqapps.core;

import com.arqapps.ficha_campo.FichaCampo;
import com.arqapps.ficha_campo.FichaCampoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationRunner {
    private final FichaCampoRepository fichas;

    @Autowired
    public DatabaseLoader(FichaCampoRepository fichas) {
        this.fichas = fichas;
    }

    @Override
    public void run(ApplicationArguments args) {
        FichaCampo ficha = new FichaCampo("Muestra", "origen", "unidad", "contacto");
        fichas.save(ficha);
    }
}
