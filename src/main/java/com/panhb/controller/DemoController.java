package com.panhb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    public String init() {
        log.info("============init============");
        return "init";
    }

}
