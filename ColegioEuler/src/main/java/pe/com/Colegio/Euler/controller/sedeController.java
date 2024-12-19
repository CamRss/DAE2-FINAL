package pe.com.Colegio.Euler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.Colegio.Euler.entity.sedeEntity;
import pe.com.Colegio.Euler.servicio.sedeService;

@Controller
public class sedeController {

    @Autowired
    private sedeService servicio;

    // Listar sedes
    @GetMapping("/sede/listar")
    public String MostrarListarSede(Model modelo) {
        modelo.addAttribute("sedes", servicio.findAllCustom());
        return "sede/listar_sede";
    }

    // Mostrar formulario para registrar una sede
    @GetMapping("/sede/registro")
    public String MostrarRegistroSede() {
        return "sede/registrar_sede";
    }

    // Mostrar formulario para actualizar una sede
    @GetMapping("/sede/actualiza/{id}")
    public String MostrarActualizaSede(@PathVariable Long id, Model modelo) {
        // Obtén la información de la sede, asegurándote de que no sea nula
        sedeEntity sede = servicio.findById(id)
                                  .orElseThrow(() -> new RuntimeException("Sede no encontrada"));

        // Agrega la sede al modelo
        modelo.addAttribute("sede", sede); // Usar singular para el objeto específico

        return "sede/actualizar_sede"; // Retorna la vista correspondiente
    }


    // Eliminar una sede (Deshabilitar)
    @GetMapping("/sede/eliminar/{id}")
    public String EliminarSede(@PathVariable Long id) {
        sedeEntity objSede = new sedeEntity();
        objSede.setCodigo(id);
        servicio.delete(objSede);
        return "redirect:/sede/listar";
    }

    // Mostrar sedes habilitadas y deshabilitadas
    @GetMapping("/sede/habilita")
    public String MostrarHabilitarSede(Model modelo) {
        modelo.addAttribute("sedes", servicio.findAll());
        return "sede/habilitar_sede";
    }

    @GetMapping("/sede/habilitar/{id}")
    public String HabilitarSede(@PathVariable Long id) {
        sedeEntity objSede = new sedeEntity();
        objSede.setCodigo(id);
        servicio.enable(objSede);
        return "redirect:/sede/habilita";
    }

    @GetMapping("/sede/deshabilitar/{id}")
    public String DeshabilitarSede(@PathVariable Long id) {
        sedeEntity objSede = new sedeEntity();
        objSede.setCodigo(id);
        servicio.delete(objSede);
        return "redirect:/sede/habilita";
    }

    // Modelo para transportar datos del formulario
    @ModelAttribute("sede")
    public sedeEntity ModeloSede() {
        return new sedeEntity();
    }

    // Acción para registrar una sede
    @PostMapping("/sede/registrar")
    public String RegistrarSede(@ModelAttribute("sede") sedeEntity s) {
        servicio.add(s);
        return "redirect:/sede/listar";
    }

    // Acción para actualizar una sede
    @PostMapping("/sede/actualizar/{id}")
    public String ActualizarSede(@PathVariable Long id, @ModelAttribute("sede") sedeEntity s) {
        s.setCodigo(id);
        servicio.update(s);
        return "redirect:/sede/listar";
    }
}
