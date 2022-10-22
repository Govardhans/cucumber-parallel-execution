package com.govardhans.cucumber.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class TestData {
    public List<YamlFooProperties> testData = null;
}
