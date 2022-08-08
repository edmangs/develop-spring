package com.develop.domain.repository;

import com.develop.domain.WebDomain;

import java.util.List;
import java.util.Optional;

public interface WebRepository {
    List<WebDomain> getAll();
    Optional<WebDomain> get(int id);
    WebDomain save(WebDomain domain);

    void delete(int id);
}
