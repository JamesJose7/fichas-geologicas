package com.arqapps.estructura_geologica;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.transaction.Transactional;

@Transactional
@RestResource(path = "estructurasLineales", rel = "EST-estructuras-lineales")
public interface EstructuraLinealRepository extends EstructuraGeologicaBaseRepository<EstructuraLineal> {
}
