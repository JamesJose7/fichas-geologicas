package com.arqapps.catalogacion;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.transaction.Transactional;

@Transactional
@RestResource(path = "muestras", rel = "CAT-muestras")
public interface MuestraRepository extends CatalogacionBaseRepository<Muestra> {
}
