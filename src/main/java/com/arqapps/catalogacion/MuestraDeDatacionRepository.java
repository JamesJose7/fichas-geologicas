package com.arqapps.catalogacion;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.transaction.Transactional;

@Transactional
@RestResource(path = "muestrasdedatacion", rel = "muestras-de-datacion")
public interface MuestraDeDatacionRepository extends CatalogacionBaseRepository<MuestraDeDatacion> {
}
