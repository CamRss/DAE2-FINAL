
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
import pe.com.Colegio.Euler.entity.profesorEntity;
import pe.com.Colegio.Euler.servicio.profesorService;

@RestController
@RequestMapping("/profesor")
public class profesorRestController {
    @Autowired
    private profesorService servicio;
    
    @GetMapping
    public List<profesorEntity> findAll(){
        return servicio.findAll();
    }
    
    @GetMapping("/custom")
    public List<profesorEntity> findAllCustom(){
        return servicio.findAllCustom();
        
    }
    
    @GetMapping("/{id}")
    public Optional<profesorEntity> findById(@PathVariable Long id){
        return servicio.findById(id);
        
    }
    
    @PostMapping
    public profesorEntity add(@RequestBody profesorEntity p){
        return servicio.add(p);
    }
    @PutMapping("{id}")
    public profesorEntity update(@PathVariable Long id, @RequestBody profesorEntity p){
        p.setCodigo(id);
        return servicio.update(p);
    }
    @DeleteMapping("{id}")
    public profesorEntity delete(@PathVariable Long id){
        profesorEntity objprofesor = new profesorEntity();
        objprofesor.setEstado(false);
        return servicio.delete(profesorEntity.builder().codigo(id).build());
    } 
}
