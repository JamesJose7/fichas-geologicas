package com.arqapps.estructura_geologica;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "estructurasLineales", rel = "estructuras-lineales")
public interface EstructuraLinealRepository extends PagingAndSortingRepository<EstructuraLineal, Long> {
}
