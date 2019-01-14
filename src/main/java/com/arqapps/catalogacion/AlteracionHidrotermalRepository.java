package com.arqapps.catalogacion;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.transaction.Transactional;

@Transactional
@RestResource(path = "alteracionesHidrotermales", rel = "alteracionesHidrotermales")
public interface AlteracionHidrotermalRepository extends CatalogacionBaseRepository<AlteracionHidrotermal> {
}
