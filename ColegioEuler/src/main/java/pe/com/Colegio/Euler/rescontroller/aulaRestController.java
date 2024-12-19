
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
import pe.com.Colegio.Euler.entity.aulaEntity;
import pe.com.Colegio.Euler.servicio.aulaService;

@RestController
@RequestMapping("/aula")
public class aulaRestController {
    @Autowired
    private aulaService servicio;
    
    @GetMapping
    public List<aulaEntity> findAll(){
        return servicio.findAll();
    }
    
    @GetMapping("/custom")
    public List<aulaEntity> findAllCustom(){
        return servicio.findAllCustom();
        
    }
    
    @GetMapping("/{id}")
    public Optional<aulaEntity> findById(@PathVariable Long id){
        return servicio.findById(id);
        
    }
    
    @PostMapping
    public aulaEntity add(@RequestBody aulaEntity al){
        return servicio.add(al);
    }
    @PutMapping("{id}")
    public aulaEntity update(@PathVariable Long id, @RequestBody aulaEntity al){
        al.setCodigo(id);
        return servicio.update(al);
    }
    @DeleteMapping("{id}")
    public aulaEntity delete(@PathVariable Long id){
        aulaEntity objaula = new aulaEntity();
        objaula.setEstado(false);
        return servicio.delete(aulaEntity.builder().codigo(id).build());
    } 
}
