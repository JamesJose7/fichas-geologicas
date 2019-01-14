package com.arqapps.catalogacion;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.transaction.Transactional;

@Transactional
@RestResource(path = "fosiles", rel = "fosiles")
public interface FosilRepository extends CatalogacionBaseRepository<Fosil> {
}
