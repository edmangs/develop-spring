package com.develop.domain.service;

import com.develop.domain.WebDomain;
import com.develop.domain.repository.WebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WebService {
    @Autowired
    private WebRepository webRepository;

    public List<WebDomain> getAll() {
        return webRepository.getAll();
    }

    public Optional<WebDomain> get(int id) {
        return webRepository.get(id);
    }

    public WebDomain save(WebDomain domain) {
        return webRepository.save(domain);
    }

    public boolean delete(int id) {
        return get(id).map(domain -> {
            webRepository.delete(id);
            return true;
        }).orElse(false);
    }
}
