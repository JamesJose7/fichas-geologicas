package com.arqapps.estructura_geologica;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.transaction.Transactional;

@Transactional
@RestResource(path = "estructuraPlanar", rel = "estructuraPlanar")
public interface EstructuraPlanarRepository extends EstructuraGeologicaBaseRepository<EstructuraPlanar> {
}