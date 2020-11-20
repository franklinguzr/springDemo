package com.franklin.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String home(){
        return "redirect:/app/";
        //forward no recarga la pagina y tambien redirige
        //redirect redirige y cambia la pagina

    }

}
