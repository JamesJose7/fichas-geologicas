package com.arqapps.catalogacion;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.transaction.Transactional;

@Transactional
@RestResource(path = "dominioslitotectonicos", rel = "CAT-dominios-litotectonicos")
public interface DominioLitotectonicoRepository extends CatalogacionBaseRepository<DominioLitotectonico> {
}
