package com.develop.web.controller;

import com.develop.domain.WebDomain;
import com.develop.domain.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/web")
public class WebController {
    @Autowired
    private WebService webService;

    @GetMapping("/all")
    public ResponseEntity<List<WebDomain>> getAll() {
        return new ResponseEntity<>(webService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WebDomain> get(@PathVariable("id") int id) {
        return webService.get(id)
                .map(domain -> new ResponseEntity<>(domain, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<WebDomain> save(@RequestBody WebDomain domain) {
        return new ResponseEntity<>(webService.save(domain), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int id) {
        if (webService.delete(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
