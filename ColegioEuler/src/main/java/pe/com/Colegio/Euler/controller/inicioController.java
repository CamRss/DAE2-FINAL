/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.Colegio.Euler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pe.com.Colegio.Euler.entity.alumnoEntity;

/**
 *
 * @author Dev
 */
@Controller
public class inicioController {

    //@GetMapping --> manejo de rutas
    @GetMapping()
    public String MostrarInicio() {
        return "index";
    }

    @GetMapping("/menuprincipal")
    public String MostrarMenuPrincipal() {
        return "menuprincipal";
    }
}