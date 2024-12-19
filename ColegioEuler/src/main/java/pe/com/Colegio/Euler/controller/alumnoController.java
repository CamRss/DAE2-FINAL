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
import pe.com.Colegio.Euler.entity.alumnoEntity;
import pe.com.Colegio.Euler.servicio.alumnoService;

@Controller
public class alumnoController {
    //inyeccion de dependencia
    @Autowired
    private alumnoService servicio;
    
    @GetMapping("/alumno/listar")
    public String MostrarListaralumno(Model modelo) {
        modelo.addAttribute("alumnos", servicio.findAllCustom());
        return "alumno/listar_alumno";
    }
    
    @GetMapping("/alumno/registro")
    public String MostrarRegistroalumno() {
        return "alumno/registrar_alumno";
    }
    
    @GetMapping("/alumno/actualiza/{id}")
    public String MostrarActualizaalumno(@PathVariable Long id, Model modelo) {
        alumnoEntity alumno = servicio.findById(id).orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        modelo.addAttribute("alumno", alumno); // Asegúrate de usar "alumno" en singular
        return "alumno/actualizar_alumno"; // Nombre de la plantilla
    }

    
    @GetMapping("/alumno/eliminar/{id}")
    public String Eliminaralumno(@PathVariable Long id,
            Model modelo) {
        alumnoEntity objalumno = new alumnoEntity();
        objalumno.setCodigo(id);
        servicio.delete(objalumno);
        return "redirect:/alumno/listar";
    }
    
    @GetMapping("/alumno/habilita")
    public String MostrarHabilitaralumno(Model modelo) {
        modelo.addAttribute("alumnos", servicio.findAll());
        return "alumno/habilitar_alumno";
    }

     @GetMapping("/alumno/habilitar/{id}")
    public String Habilitaralumno(@PathVariable Long id,
            Model modelo) {
        alumnoEntity objalumno = new alumnoEntity();
        objalumno.setCodigo(id);
        servicio.enable(objalumno);
        return "redirect:/alumno/habilita";
    }
    
    @GetMapping("/alumno/deshabilitar/{id}")
    public String Deshabilitaralumno(@PathVariable Long id,
            Model modelo) {
        alumnoEntity objalumno = new alumnoEntity();
        objalumno.setCodigo(id);
        servicio.delete(objalumno);
        return "redirect:/alumno/habilita";
    }
    
    //modelo para trsportar datos para las acciones
    @ModelAttribute("alumno")
    public alumnoEntity Modeloalumno() {
        return new alumnoEntity();
    }
    
    //accion
    @PostMapping("/alumno/registrar")
    public String Registraralumno(@ModelAttribute("alumno") alumnoEntity a) {
        servicio.add(a);
        return "redirect:/alumno/listar";
    }
    
    @PostMapping("/alumno/actualizar/{id}")
    public String Actualizaralumno(@PathVariable Long id,
            @ModelAttribute("alumno") alumnoEntity a) {
        servicio.update(a);
        return "redirect:/alumno/listar";
    }
}
