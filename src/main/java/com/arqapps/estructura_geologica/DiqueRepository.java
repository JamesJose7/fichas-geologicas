package com.arqapps.estructura_geologica;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.transaction.Transactional;

@Transactional
@RestResource(path = "diques", rel = "EST-diques")
public interface DiqueRepository extends EstructuraGeologicaBaseRepository<Dique> {
}
