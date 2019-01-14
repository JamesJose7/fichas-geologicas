package com.arqapps.catalogacion;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.transaction.Transactional;

@Transactional
@RestResource(path = "contactosgeologicos", rel = "contactos-geologicos")
public interface ContactoGeologicoRepository extends CatalogacionBaseRepository<ContactoGeologico> {
}
