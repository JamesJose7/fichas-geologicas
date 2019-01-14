package com.arqapps.estructura_geologica;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.transaction.Transactional;

@Transactional
@RestResource(path = "pliegues", rel = "pliegues")
public interface PliegueRepository extends EstructuraGeologicaBaseRepository<Pliegue> {
}
