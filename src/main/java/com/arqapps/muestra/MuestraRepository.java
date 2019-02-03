package com.arqapps.muestra;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "muestras", rel = "muestras")
public interface MuestraRepository extends PagingAndSortingRepository<Muestra, Long> {
}
