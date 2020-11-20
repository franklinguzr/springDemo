package com.franklin.demo.controllers;

import com.franklin.demo.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app") //ruta para acceder a los metodos del controlador
public class IndexController {

    @Value("${texto.indexcontroller.index.titulo}")
    private String tituloIndex;
    @Value("${texto.indexcontroller.listaUsuarios.titulo}")
    private String tituloLista;
    @Value("${texto.indexcontroller.perfil.titulo}")
    private String tituloPerfil;

    @RequestMapping(value = {"/index", "", "/home"})
    public String index(Model model) {
        //pasar datos a la vista
        model.addAttribute("Titulo", tituloIndex);
        return "index";
    }

    @RequestMapping(value = "/perfil")
    public String usuario(Model model) {
        User usuario = new User();
        usuario.setNombre("franklin");
        usuario.setApellido("garces");
        model.addAttribute("usuario", usuario);
        model.addAttribute("Titulo", tituloPerfil.concat(usuario.getNombre()));
        return "perfil";
    }
    @RequestMapping(value = "/listar")
    public String listar(Model model) {
        User usuario = new User();
        usuario.setNombre("franklin");
        usuario.setApellido("garces");
        List usuarios = new ArrayList<User>();
        usuarios.add(usuario);
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("Titulo", tituloLista);
        return "ListaUsuarios";
    }
    //otra forma de enviar datos a la vista
    @ModelAttribute("usuarios")
    public List<User> listar(){
        User usuario = new User();
        usuario.setNombre("franklin");
        usuario.setApellido("garces");
        List usuarios = new ArrayList<User>();
        usuarios.add(usuario);
    return usuarios;
    }

}
