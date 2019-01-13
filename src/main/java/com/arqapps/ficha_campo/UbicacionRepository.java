package com.arqapps.ficha_campo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "ubicaciones", rel = "ubicaciones")
public interface UbicacionRepository extends CrudRepository<Ubicacion, Long> {
}
