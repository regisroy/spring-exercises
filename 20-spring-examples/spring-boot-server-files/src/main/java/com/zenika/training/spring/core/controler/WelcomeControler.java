package com.zenika.training.spring.core.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
@SuppressWarnings("unused")
public class WelcomeControler {

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("DD/MM/YYYY");
        model.put("time", simpleDateFormat.format(new Date()));
        model.put("titre", "Spring core version 4");
        model.put("message", "Bonjour,");
        model.put("nom", "Régis ROY");
        model.put("societe", "Zenika");
        model.put("email", "regis.roy@zenika.com");

        return "welcome";
    }

}
