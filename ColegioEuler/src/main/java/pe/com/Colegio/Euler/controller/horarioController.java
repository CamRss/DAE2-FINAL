/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.Colegio.Euler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.Colegio.Euler.entity.horarioEntity;
import pe.com.Colegio.Euler.entity.horarioEntity;
import pe.com.Colegio.Euler.servicio.horarioService;

/**
 *
 * @author Dev
 */
@Controller
public class horarioController {

    @Autowired
    private horarioService servicio;

    // Listar horarios
    @GetMapping("/horario/listar")
    public String MostrarListarHorario(Model modelo) {
        modelo.addAttribute("horarios", servicio.findAllCustom());
        return "horario/listar_horario";
    }

    // Registrar horario
    @GetMapping("/horario/registro")
    public String MostrarRegistroHorario() {
        return "horario/registrar_horario";
    }

    // Mostrar formulario para actualizar un horario
    @GetMapping("/horario/actualiza/{id}")
    public String MostrarActualizaHorario(@PathVariable Long id, Model modelo) {
        // Obtén la información del horario, asegurándote de que no sea nulo
        horarioEntity horario = servicio.findById(id).orElseThrow(() -> new RuntimeException("Horario no encontrado"));

        // Agrega el horario al modelo
        modelo.addAttribute("horario", horario); // Usa singular para el objeto específico

        return "horario/actualizar_horario"; // Retorna la vista correspondiente
    }


    // Eliminar horario
    @GetMapping("/horario/eliminar/{id}")
    public String EliminarHorario(@PathVariable Long id) {
        horarioEntity objHorario = new horarioEntity();
        objHorario.setCodigo(id);
        servicio.delete(objHorario);
        return "redirect:/horario/listar";
    }
    
     @GetMapping("/horario/habilita")
    public String MostrarHabilitarhorario(Model modelo) {
        modelo.addAttribute("horarios", servicio.findAll());
        return "horario/habilitar_horario";
    }

     @GetMapping("/horario/habilitar/{id}")
    public String Habilitarhorario(@PathVariable Long id,
            Model modelo) {
        horarioEntity objhorario = new horarioEntity();
        objhorario.setCodigo(id);
        servicio.enable(objhorario);
        return "redirect:/horario/habilita";
    }
    
    @GetMapping("/horario/deshabilitar/{id}")
    public String Deshabilitarhorario(@PathVariable Long id,
            Model modelo) {
        horarioEntity objhorario = new horarioEntity();
        objhorario.setCodigo(id);
        servicio.delete(objhorario);
        return "redirect:/horario/habilita";
    }

    // Modelo para transporte de datos
    @ModelAttribute("horario")
    public horarioEntity ModeloHorario() {
        return new horarioEntity();
    }

    // Acción para registrar
    @PostMapping("/horario/registrar")
    public String RegistrarHorario(@ModelAttribute("horario") horarioEntity h) {
        servicio.add(h);
        return "redirect:/horario/listar";
    }

    // Acción para actualizar
    @PostMapping("/horario/actualizar/{id}")
    public String ActualizarHorario(@PathVariable Long id, @ModelAttribute("horario") horarioEntity h) {
        h.setCodigo(id);
        servicio.update(h);
        return "redirect:/horario/listar";
    }
}
