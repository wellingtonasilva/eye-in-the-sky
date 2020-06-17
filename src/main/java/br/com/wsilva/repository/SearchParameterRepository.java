package br.com.wsilva.repository;

import br.com.wsilva.model.entity.SearchParameterEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "searchParameter")
public interface SearchParameterRepository extends CrudRepository<SearchParameterEntity, Integer> {

    @RestResource(exported = false)
    SearchParameterEntity findByCode(String code);
}
