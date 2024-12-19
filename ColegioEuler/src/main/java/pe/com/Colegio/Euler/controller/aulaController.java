package pe.com.Colegio.Euler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.Colegio.Euler.entity.aulaEntity;
import pe.com.Colegio.Euler.entity.sedeEntity;
import pe.com.Colegio.Euler.servicio.aulaService;
import pe.com.Colegio.Euler.servicio.sedeService;

@Controller
public class aulaController {

    @Autowired
    private aulaService servicio;

    @Autowired
    private sedeService servicioSede;

    // Listar aulas
    @GetMapping("/aula/listar")
    public String MostrarListarAula(Model modelo) {
        modelo.addAttribute("aulas", servicio.findAllCustom());
        return "aula/listar_aula";
    }

    // Mostrar formulario para registrar un aula
    @GetMapping("/aula/registro")
    public String MostrarRegistroAula(Model modelo) {
        modelo.addAttribute("sedes", servicioSede.findAllCustom()); // Para seleccionar la sede
        return "aula/registrar_aula";
    }

    // Mostrar formulario para actualizar un aula
    @GetMapping("/aula/actualiza/{id}")
    public String MostrarActualizaAula(@PathVariable Long id, Model modelo) {
        // Obtén la información del aula, asegurándote de que no sea nula
        aulaEntity aula = servicio.findById(id).orElseThrow(() -> new RuntimeException("Aula no encontrada"));

        // Agrega el aula a actualizar al modelo
        modelo.addAttribute("aula", aula); // Usar singular para el objeto específico

        // Agrega las sedes disponibles al modelo para un selector
        modelo.addAttribute("sedes", servicioSede.findAllCustom());

        return "aula/actualizar_aula"; // Retorna la vista correspondiente
    }


    // Eliminar un aula (Deshabilitar)
    @GetMapping("/aula/eliminar/{id}")
    public String EliminarAula(@PathVariable Long id) {
        aulaEntity objAula = new aulaEntity();
        objAula.setCodigo(id);
        servicio.delete(objAula);
        return "redirect:/aula/listar";
    }

    // Mostrar aulas habilitadas y deshabilitadas
    @GetMapping("/aula/habilita")
    public String MostrarHabilitarAula(Model modelo) {
        modelo.addAttribute("aulas", servicio.findAll());
        return "aula/habilitar_aula";
    }

    @GetMapping("/aula/habilitar/{id}")
    public String HabilitarAula(@PathVariable Long id) {
        aulaEntity objAula = new aulaEntity();
        objAula.setCodigo(id);
        servicio.enable(objAula);
        return "redirect:/aula/habilita";
    }

    @GetMapping("/aula/deshabilitar/{id}")
    public String DeshabilitarAula(@PathVariable Long id) {
        aulaEntity objAula = new aulaEntity();
        objAula.setCodigo(id);
        servicio.delete(objAula);
        return "redirect:/aula/habilita";
    }

    // Modelo para transportar datos del formulario
    @ModelAttribute("aula")
    public aulaEntity ModeloAula() {
        return new aulaEntity();
    }

    // Acción para registrar un aula
    @PostMapping("/aula/registrar")
    public String RegistrarAula(@ModelAttribute("aula") aulaEntity a) {
        servicio.add(a);
        return "redirect:/aula/listar";
    }

    // Acción para actualizar un aula
    @PostMapping("/aula/actualizar/{id}")
    public String ActualizarAula(@PathVariable Long id, @ModelAttribute("aula") aulaEntity a) {
        a.setCodigo(id);
        servicio.update(a);
        return "redirect:/aula/listar";
    }
}
