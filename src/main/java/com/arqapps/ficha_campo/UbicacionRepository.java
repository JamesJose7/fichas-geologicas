package com.arqapps.ficha_campo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "ubicaciones", rel = "ubicaciones")
public interface UbicacionRepository extends PagingAndSortingRepository<Ubicacion, Long> {
}
