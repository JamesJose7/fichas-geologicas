package com.arqapps.catalogacion;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@NoRepositoryBean
public interface CatalogacionBaseRepository<T extends Catalogacion>
        extends CrudRepository<T, Long> {
    @RestResource(rel = "buscar-en-descripcion", path = "descripcionContiene")
    List<T> findByDescripcionContains(@Param("desc") String desc);
    @RestResource(rel = "buscar-subcategorias", path = "buscarSubcategoria")
    List<T> findBySubcategoriaEquals(@Param("sub") String sub);
}
