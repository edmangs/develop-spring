package com.develop.persistence;

import com.develop.domain.WebDomain;
import com.develop.domain.repository.WebRepository;
import com.develop.persistence.crud.WebCrudRepository;
import com.develop.persistence.entity.WebEntity;
import com.develop.persistence.mapper.WebMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class WebPersistenceRepository implements WebRepository {
    @Autowired
    private WebCrudRepository webCrudRepository;

    @Autowired
    private WebMapper webMapper;

    @Override
    public List<WebDomain> getAll() {
        List<WebEntity> elements = (List<WebEntity>) webCrudRepository.findAll();
        return webMapper.toDomains(elements);
    }


    @Override
    public Optional<WebDomain> get(int id) {
        return webCrudRepository.findById(id).map(entity -> webMapper.toDomain(entity));
    }

    @Override
    public WebDomain save(WebDomain domain) {
        WebEntity entity = webMapper.toEntity(domain);
        return webMapper.toDomain(webCrudRepository.save(entity));
    }

    @Override
    public void delete(int id) {
        webCrudRepository.deleteById(id);
    }
}
