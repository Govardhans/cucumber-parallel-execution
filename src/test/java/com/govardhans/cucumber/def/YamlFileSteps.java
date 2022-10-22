package com.govardhans.cucumber.def;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.govardhans.cucumber.config.TestData;
import com.govardhans.cucumber.config.YamlFooProperties;
import io.cucumber.java.en.Given;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.*;
import java.util.Map;

public class YamlFileSteps {



    @Given("yaml config read")
    public void yaml_config_read() throws IOException {

        final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        final TestData yamlFooProperties = mapper.readValue(new File("foo.yml"), TestData.class);

        Assertions.assertThat(yamlFooProperties.getTestData().get(0).getModel()).isEqualTo("audi");
//        Assertions.assertThat(yamlFooProperties.getAliases()).containsExactly("abc", "xyz");
    }
}
