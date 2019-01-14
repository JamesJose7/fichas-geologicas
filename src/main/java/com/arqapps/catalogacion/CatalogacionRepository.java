package com.arqapps.catalogacion;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.transaction.Transactional;

@Transactional
@RestResource(path = "catalogaciones", rel = "catalogaciones")
public interface CatalogacionRepository extends CatalogacionBaseRepository<Catalogacion> {
}
