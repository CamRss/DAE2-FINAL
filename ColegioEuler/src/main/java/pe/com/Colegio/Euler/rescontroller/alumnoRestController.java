
package pe.com.Colegio.Euler.rescontroller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.Colegio.Euler.entity.alumnoEntity;
import pe.com.Colegio.Euler.servicio.alumnoService;

@RestController
@RequestMapping("/alumno")
public class alumnoRestController {
    @Autowired
    private alumnoService servicio;
    
    @GetMapping
    public List<alumnoEntity> findAll(){
        return servicio.findAll();
    }
    
    @GetMapping("/custom")
    public List<alumnoEntity> findAllCustom(){
        return servicio.findAllCustom();
        
    }
    
    @GetMapping("/{id}")
    public Optional<alumnoEntity> findById(@PathVariable Long id){
        return servicio.findById(id);
        
    }
    
    @PostMapping
    public alumnoEntity add(@RequestBody alumnoEntity a){
        return servicio.add(a);
    }
    @PutMapping("{id}")
    public alumnoEntity update(@PathVariable Long id, @RequestBody alumnoEntity a){
        a.setCodigo(id);
        return servicio.update(a);
    }
    @DeleteMapping("{id}")
    public alumnoEntity delete(@PathVariable Long id){
        alumnoEntity objalumno = new alumnoEntity();
        objalumno.setEstado(false);
        return servicio.delete(alumnoEntity.builder().codigo(id).build());
    } 
}
