package com.govardhans.cucumber.pages;

public interface HomePage {
    String searchBox = "//input[@name='q']";
    String button = "(//input[@value='Google Search'])[2]";
    void load();
    void searchFor(String str);
    String getTitle();
}
