package com.darley.springconfig.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *  setx /M nomedavariavel = valor.
 * */
@RestController
public class AppController {

    @Value("${app.message}")
    private  String appMessagem;

    @Value("${ENV_DB_URL:NENHUMA}")
    private String dbVariavelAmb;

    @GetMapping("/")
    public String getAppMessagem(){
        return  appMessagem;
    }

    @GetMapping("/dbVariavelAmb")
    public String getVariavelAmb(){
        return "A seguinte variável de ambiente foi passada: "+dbVariavelAmb;
    }
}
