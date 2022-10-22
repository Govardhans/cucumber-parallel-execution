package com.govardhans.cucumber.pages;

public interface HomePage {
    String searchBox = "//input[@name='q']";
    String searchButton = "(//input[@type='submit'])[3]";
    void load();
    void searchFor(String str);
    String getTitle();
    void acceptCookies();
}
