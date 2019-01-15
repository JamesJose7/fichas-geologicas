package com.arqapps.catalogacion;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.transaction.Transactional;

@Transactional
@RestResource(path = "afloramientos", rel = "CAT-afloramientos")
public interface AfloramientoRepository extends CatalogacionBaseRepository<Afloramiento> {
}
