package com.develop.persistence.crud;

import com.develop.persistence.entity.WebEntity;
import org.springframework.data.repository.CrudRepository;

public interface WebCrudRepository extends CrudRepository<WebEntity, Integer> {

}
