package com.arqapps.catalogacion;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "afloramientos", rel = "afloramientos")
public interface AfloramientoRepository extends PagingAndSortingRepository<Afloramiento, Long> {
}
