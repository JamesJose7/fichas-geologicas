package com.arqapps.catalogacion;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.transaction.Transactional;

@Transactional
@RestResource(path = "rocas", rel = "CAT-rocas")
public interface RocaRepository extends CatalogacionBaseRepository<Roca> {
}
