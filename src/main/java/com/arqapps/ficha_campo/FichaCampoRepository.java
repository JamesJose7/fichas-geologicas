package com.arqapps.ficha_campo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "fichasCampo", rel = "fichasCampo")
public interface FichaCampoRepository extends CrudRepository<FichaCampo, Long> {
}
