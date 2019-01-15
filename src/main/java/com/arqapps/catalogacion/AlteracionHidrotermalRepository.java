package com.arqapps.catalogacion;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.transaction.Transactional;

@Transactional
@RestResource(path = "alteracionesHidrotermales", rel = "CAT-alteracionesHidrotermales")
public interface AlteracionHidrotermalRepository extends CatalogacionBaseRepository<AlteracionHidrotermal> {
}
