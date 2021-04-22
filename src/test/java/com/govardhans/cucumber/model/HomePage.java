package com.govardhans.cucumber.model;

import org.springframework.stereotype.Component;

public interface HomePage {
    void load();
    void searchFor(String str);
}
