package com.arqapps.estructura_geologica;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.transaction.Transactional;

@Transactional
@RestResource(path = "estructurasGeologicas", rel = "estructurasGeologicas")
public interface EstructuraGeologicaRepository extends EstructuraGeologicaBaseRepository<EstructuraGeologica> {
}
