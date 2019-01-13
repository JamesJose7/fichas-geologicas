package com.arqapps.estructura_geologica;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.transaction.Transactional;

@Transactional
@RestResource(path = "foliaciones", rel = "foliaciones")
public interface FoliacionRepository extends EstructuraGeologicaBaseRepository<Foliacion> {
}
