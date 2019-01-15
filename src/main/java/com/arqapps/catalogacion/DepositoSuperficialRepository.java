package com.arqapps.catalogacion;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.transaction.Transactional;

@Transactional
@RestResource(path = "depositossuperficiales", rel = "CAT-depositos-superficiales")
public interface DepositoSuperficialRepository extends CatalogacionBaseRepository<DepositoSuperficial> {
}
