package com.arqapps.catalogacion;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.transaction.Transactional;

@Transactional
@RestResource(path = "sitiosfosiliferos", rel = "sitios-fosiliferos")
public interface SitioFosiliferoRepository extends CatalogacionBaseRepository<SitioFosilifero> {
}
