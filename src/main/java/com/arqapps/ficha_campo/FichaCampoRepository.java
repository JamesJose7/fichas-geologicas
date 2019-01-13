package com.arqapps.ficha_campo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FichaCampoRepository extends CrudRepository<FichaCampo, Long> {
}
