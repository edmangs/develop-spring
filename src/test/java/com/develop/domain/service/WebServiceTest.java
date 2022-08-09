package com.develop.domain.service;

import com.develop.domain.WebDomain;
import com.develop.domain.repository.WebRepository;
import com.develop.factory.web.WebData;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WebServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @InjectMocks
    private WebService webService = new WebService();

    @Mock
    private WebRepository webRepository;

    @Test
    void shouldGetAll() {
        List<WebDomain> items = WebData.getAll();

        when(webRepository.getAll()).thenReturn(items);

        List<WebDomain> results = webService.getAll();

        Assertions.assertEquals(items, results);
    }

    @Test
    void shouldGet() {
        Optional<WebDomain> item = WebData.get();

        when(webRepository.get(1)).thenReturn(item);

        Optional<WebDomain> result = webService.get(item.get().getId());

        Assertions.assertEquals(item, result);
    }

    @Test
    void shouldSave() {
        WebDomain item = WebData.save();

        when(webRepository.save(item)).thenReturn(item);

        WebDomain result = webService.save(item);

        Assertions.assertEquals(item, result);
    }

    @Test
    void shouldDelete() {
        Optional<WebDomain> item = WebData.get();

        when(webRepository.get(item.get().getId())).thenReturn(item);

        Boolean result = webService.delete(item.get().getId());

        Assertions.assertTrue(result);
    }

    @Test
    void shouldNotDelete() {
        Optional<WebDomain> item = WebData.get();

        Boolean result = webService.delete(item.get().getId());

        Assertions.assertFalse(result);
    }
}