package com.arqapps.pliegue;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "pliegues", rel = "pliegues")
public interface PliegueRepository extends PagingAndSortingRepository<Pliegue, Long> {
}
