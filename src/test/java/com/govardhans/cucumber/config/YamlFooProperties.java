package com.govardhans.cucumber.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class YamlFooProperties {


    public String model;

    public List<String> subModel = null;

}