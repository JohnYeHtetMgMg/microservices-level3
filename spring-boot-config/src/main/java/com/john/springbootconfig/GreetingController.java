package com.john.springbootconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GreetingController {

    @Value("${my.greeting: default value}")
    private String greetingMessage;

    @Value("(:static message:)")
    private String staticMsg;

    @Value("${my.list.value}")
    private List<String> list;

    @Autowired
    private DbSettings dbSettings;

    @Autowired
    Environment env;

    @GetMapping("/greeting")
    public String greeting() {
        return greetingMessage + staticMsg + list + "<br />" + dbSettings.toString();
    }

    @GetMapping("/envdetails")
    public String envDetials(){
        return env.toString();
    }
}
