package pe.com.Colegio.Euler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.Colegio.Euler.entity.profesorEntity;
import pe.com.Colegio.Euler.servicio.profesorService;

@Controller
public class profesorController {

    @Autowired
    private profesorService servicio;

    // Listar profesores
    @GetMapping("/profesor/listar")
    public String MostrarListarProfesor(Model modelo) {
        modelo.addAttribute("profesores", servicio.findAllCustom());
        return "profesor/listar_profesor";
    }

    // Mostrar formulario para registrar un profesor
    @GetMapping("/profesor/registro")
    public String MostrarRegistroProfesor() {
        return "profesor/registrar_profesor";
    }

    // Mostrar formulario para actualizar un profesor
    @GetMapping("/profesor/actualiza/{id}")
    public String MostrarActualizaProfesor(@PathVariable Long id, Model modelo) {
        // Obtén la información del profesor, asegurándote de que no sea nula
        profesorEntity profesor = servicio.findById(id)
                                          .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        // Agrega el profesor al modelo
        modelo.addAttribute("profesor", profesor); // Usar singular para el objeto específico

        return "profesor/actualizar_profesor"; // Retorna la vista correspondiente
    }


    // Eliminar un profesor (Deshabilitar)
    @GetMapping("/profesor/eliminar/{id}")
    public String EliminarProfesor(@PathVariable Long id) {
        profesorEntity objProfesor = new profesorEntity();
        objProfesor.setCodigo(id);
        servicio.delete(objProfesor);
        return "redirect:/profesor/listar";
    }

    // Mostrar profesores habilitados y deshabilitados
    @GetMapping("/profesor/habilita")
    public String MostrarHabilitarProfesor(Model modelo) {
        modelo.addAttribute("profesores", servicio.findAll());
        return "profesor/habilitar_profesor";
    }

    @GetMapping("/profesor/habilitar/{id}")
    public String HabilitarProfesor(@PathVariable Long id) {
        profesorEntity objProfesor = new profesorEntity();
        objProfesor.setCodigo(id);
        servicio.enable(objProfesor);
        return "redirect:/profesor/habilita";
    }

    @GetMapping("/profesor/deshabilitar/{id}")
    public String DeshabilitarProfesor(@PathVariable Long id) {
        profesorEntity objProfesor = new profesorEntity();
        objProfesor.setCodigo(id);
        servicio.delete(objProfesor);
        return "redirect:/profesor/habilita";
    }

    // Modelo para transportar datos del formulario
    @ModelAttribute("profesor")
    public profesorEntity ModeloProfesor() {
        return new profesorEntity();
    }

    // Acción para registrar un profesor
    @PostMapping("/profesor/registrar")
    public String RegistrarProfesor(@ModelAttribute("profesor") profesorEntity p) {
        servicio.add(p);
        return "redirect:/profesor/listar";
    }

    // Acción para actualizar un profesor
    @PostMapping("/profesor/actualizar/{id}")
    public String ActualizarProfesor(@PathVariable Long id, @ModelAttribute("profesor") profesorEntity p) {
        p.setCodigo(id);
        servicio.update(p);
        return "redirect:/profesor/listar";
    }
}

