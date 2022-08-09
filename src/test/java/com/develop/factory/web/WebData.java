package com.develop.factory.web;

import com.develop.domain.WebDomain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WebData {
    public static List<WebDomain> getAll() {
        WebDomain webDomain = new WebDomain();

        webDomain.setId(1);
        webDomain.setActive(true);
        webDomain.setName("Web");

        List<WebDomain> items = new ArrayList<>();

        items.add(webDomain);

        return items;
    }

    public static Optional<WebDomain> get() {
        WebDomain webDomain = new WebDomain();

        webDomain.setId(1);
        webDomain.setActive(true);
        webDomain.setName("Web");

        Optional<WebDomain> optional = Optional.ofNullable(webDomain);

        return optional;
    }

    public static WebDomain save() {
        WebDomain webDomain = new WebDomain();

        webDomain.setActive(true);
        webDomain.setName("Web 2");

        return webDomain;
    }
}
