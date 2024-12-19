
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
import pe.com.Colegio.Euler.entity.cursoEntity;
import pe.com.Colegio.Euler.servicio.cursoService;

@RestController
@RequestMapping("/curso")
public class cursoRestController {
    @Autowired
    private cursoService servicio;
    
    @GetMapping
    public List<cursoEntity> findAll(){
        return servicio.findAll();
    }
    
    @GetMapping("/custom")
    public List<cursoEntity> findAllCustom(){
        return servicio.findAllCustom();
        
    }
    
    @GetMapping("/{id}")
    public Optional<cursoEntity> findById(@PathVariable Long id){
        return servicio.findById(id);
        
    }
    
    @PostMapping
    public cursoEntity add(@RequestBody cursoEntity c){
        return servicio.add(c);
    }
    @PutMapping("{id}")
    public cursoEntity update(@PathVariable Long id, @RequestBody cursoEntity c){
        c.setCodigo(id);
        return servicio.update(c);
    }
    @DeleteMapping("{id}")
    public cursoEntity delete(@PathVariable Long id){
        cursoEntity objcurso = new cursoEntity();
        objcurso.setEstado(false);
        return servicio.delete(cursoEntity.builder().codigo(id).build());
    } 
}
