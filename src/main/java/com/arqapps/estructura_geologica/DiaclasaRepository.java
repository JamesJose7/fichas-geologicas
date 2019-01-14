package com.arqapps.estructura_geologica;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.transaction.Transactional;

@Transactional
@RestResource(path = "diaclasas", rel = "diaclasas")
public interface DiaclasaRepository extends EstructuraGeologicaBaseRepository<Diaclasa> {
}
