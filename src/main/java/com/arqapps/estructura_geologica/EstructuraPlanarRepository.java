package com.arqapps.estructura_geologica;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "estructuraPlanar", rel = "estructura-planar")
public interface EstructuraPlanarRepository extends PagingAndSortingRepository<EstructuraPlanar, Long> {
}
