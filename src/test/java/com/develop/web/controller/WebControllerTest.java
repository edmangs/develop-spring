package com.develop.web.controller;

import com.develop.domain.service.WebService;
import com.develop.factory.web.WebData;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@WebMvcTest(WebController.class)
class WebControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @MockBean
    private WebService webService;


    @Test
    void shouldGetAll() throws Exception {
        when(webService.getAll()).thenReturn(WebData.getAll());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/web/all")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc.perform(requestBuilder).andReturn();

        String json = gson.toJson(WebData.getAll());

        JSONAssert.assertEquals(
                json,
                response.getResponse().getContentAsString(),
                false
        );

        assertEquals(
                HttpStatus.OK.value(),
                response.getResponse().getStatus()
        );
    }

    @Test
    void shouldGet() throws Exception {
        when(webService.get(1)).thenReturn(WebData.get());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/web/" + WebData.get().get().getId())
                .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc.perform(requestBuilder).andReturn();

        String json = gson.toJson(WebData.get().get());

        JSONAssert.assertEquals(
                json,
                response.getResponse().getContentAsString(),
                false
        );

        assertEquals(
                HttpStatus.OK.value(),
                response.getResponse().getStatus()
        );
    }

    @Test
    void shouldSave() throws Exception {
        when(webService.save(WebData.save())).thenReturn(WebData.save());

        String json = gson.toJson(WebData.save());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/web/save")
                .content(json)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc.perform(requestBuilder).andReturn();

        assertEquals(
                HttpStatus.CREATED.value(),
                response.getResponse().getStatus()
        );
    }

    @Test
    void shouldDelete() throws Exception {
        when(webService.delete(1)).thenReturn(true);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/web/delete/" + WebData.get().get().getId())
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc.perform(requestBuilder).andReturn();

        assertEquals(
                HttpStatus.OK.value(),
                response.getResponse().getStatus()
        );
    }

    @Test
    void shouldNotDelete() throws Exception {
        when(webService.delete(1)).thenReturn(false);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/web/delete/" + WebData.get().get().getId())
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc.perform(requestBuilder).andReturn();

        assertEquals(
                HttpStatus.NOT_FOUND.value(),
                response.getResponse().getStatus()
        );
    }
}