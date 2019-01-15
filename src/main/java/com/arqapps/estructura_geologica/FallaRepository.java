package com.arqapps.estructura_geologica;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.transaction.Transactional;

@Transactional
@RestResource(path = "fallas", rel = "EST-fallas")
public interface FallaRepository extends EstructuraGeologicaBaseRepository<Falla> {
}
