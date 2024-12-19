package pe.com.Colegio.Euler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.Colegio.Euler.entity.matriculaEntity;
import pe.com.Colegio.Euler.entity.alumnoEntity;
import pe.com.Colegio.Euler.entity.cursoEntity;
import pe.com.Colegio.Euler.servicio.matriculaService;
import pe.com.Colegio.Euler.servicio.alumnoService;
import pe.com.Colegio.Euler.servicio.cursoService;

@Controller
public class matriculaController {

    @Autowired
    private matriculaService servicio;

    @Autowired
    private alumnoService servicioAlumno;

    @Autowired
    private cursoService servicioCurso;

    // Listar matrículas
    @GetMapping("/matricula/listar")
    public String MostrarListarMatricula(Model modelo) {
        modelo.addAttribute("matriculas", servicio.findAllCustom());
        return "matricula/listar_matricula";
    }

    // Mostrar formulario para registrar una matrícula
    @GetMapping("/matricula/registro")
    public String MostrarRegistroMatricula(Model modelo) {
        modelo.addAttribute("alumnos", servicioAlumno.findAllCustom());
        modelo.addAttribute("cursos", servicioCurso.findAllCustom());
        return "matricula/registrar_matricula";
    }

    // Mostrar formulario para actualizar una matrícula
    @GetMapping("/matricula/actualiza/{id}")
    public String MostrarActualizaMatricula(@PathVariable Long id, Model modelo) {
        // Obtén la información de la matrícula, asegurándote de que no sea nula
        matriculaEntity matricula = servicio.findById(id)
                                            .orElseThrow(() -> new RuntimeException("Matrícula no encontrada"));

        // Agrega la matrícula al modelo
        modelo.addAttribute("matricula", matricula); // Usar singular para el objeto específico

        // Agrega las listas de alumnos y cursos al modelo
        modelo.addAttribute("alumnos", servicioAlumno.findAllCustom());
        modelo.addAttribute("cursos", servicioCurso.findAllCustom());

        return "matricula/actualizar_matricula"; // Retorna la vista correspondiente
    }


    // Eliminar una matrícula (Deshabilitar)
    @GetMapping("/matricula/eliminar/{id}")
    public String EliminarMatricula(@PathVariable Long id) {
        matriculaEntity objMatricula = new matriculaEntity();
        objMatricula.setCodigo(id);
        servicio.delete(objMatricula);
        return "redirect:/matricula/listar";
    }

    // Mostrar matrículas habilitadas y deshabilitadas
    @GetMapping("/matricula/habilita")
    public String MostrarHabilitarMatricula(Model modelo) {
        modelo.addAttribute("matriculas", servicio.findAll());
        return "matricula/habilitar_matricula";
    }

    @GetMapping("/matricula/habilitar/{id}")
    public String HabilitarMatricula(@PathVariable Long id) {
        matriculaEntity objMatricula = new matriculaEntity();
        objMatricula.setCodigo(id);
        servicio.enable(objMatricula);
        return "redirect:/matricula/habilita";
    }

    @GetMapping("/matricula/deshabilitar/{id}")
    public String DeshabilitarMatricula(@PathVariable Long id) {
        matriculaEntity objMatricula = new matriculaEntity();
        objMatricula.setCodigo(id);
        servicio.delete(objMatricula);
        return "redirect:/matricula/habilita";
    }

    // Modelo para transportar datos del formulario
    @ModelAttribute("matricula")
    public matriculaEntity ModeloMatricula() {
        return new matriculaEntity();
    }

    // Acción para registrar una matrícula
    @PostMapping("/matricula/registrar")
    public String RegistrarMatricula(@ModelAttribute("matricula") matriculaEntity m) {
        servicio.add(m);
        return "redirect:/matricula/listar";
    }

    // Acción para actualizar una matrícula
    @PostMapping("/matricula/actualizar/{id}")
    public String ActualizarMatricula(@PathVariable Long id, @ModelAttribute("matricula") matriculaEntity m) {
        m.setCodigo(id);
        servicio.update(m);
        return "redirect:/matricula/listar";
    }
}
