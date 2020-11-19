package com.franklin.demo.controllers;

import com.franklin.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app") //ruta para acceder a los metodos del controlador
public class IndexController {

    @RequestMapping(value = {"/index", "", "/home"})
    public String index(Model model) {
        //pasar datos a la vista
        model.addAttribute("Titulo", "Hola mundo desde Spring framework");
        return "index";
    }

    @RequestMapping(value = "/perfil")
    public String usuario(Model model) {
        User usuario = new User();
        usuario.setNombre("franklin");
        usuario.setApellido("garces");
        model.addAttribute("usuario", usuario);
        model.addAttribute("Titulo", "Hola ".concat(usuario.getNombre()));
        return "perfil";
    }


}
