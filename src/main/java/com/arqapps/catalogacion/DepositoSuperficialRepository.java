package com.arqapps.catalogacion;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.transaction.Transactional;

@Transactional
@RestResource(path = "depositossuperficiales", rel = "depositos-superficiales")
public interface DepositoSuperficialRepository extends CatalogacionBaseRepository<DepositoSuperficial> {
}
