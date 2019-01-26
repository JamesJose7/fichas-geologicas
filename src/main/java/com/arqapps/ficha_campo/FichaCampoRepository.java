package com.arqapps.ficha_campo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "fichasCampo", rel = "fichasCampo")
public interface FichaCampoRepository extends PagingAndSortingRepository<FichaCampo, Long> {
}
