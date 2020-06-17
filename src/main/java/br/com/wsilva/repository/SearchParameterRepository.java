package br.com.wsilva.repository;

import br.com.wsilva.model.entity.SearchParameterEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchParameterRepository extends CrudRepository<SearchParameterEntity, Integer> {

    SearchParameterEntity findByCode(String code);
}
