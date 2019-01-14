package com.arqapps.catalogacion;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.transaction.Transactional;

@Transactional
@RestResource(path = "unidadesgeologicas", rel = "unidades-geologicas")
public interface UnidadGeologicaRepository extends CatalogacionBaseRepository<UnidadGeologica> {
}
