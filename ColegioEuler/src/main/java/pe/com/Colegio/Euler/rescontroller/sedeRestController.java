
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
import pe.com.Colegio.Euler.entity.sedeEntity;
import pe.com.Colegio.Euler.servicio.sedeService;

@RestController
@RequestMapping("/sede")
public class sedeRestController {
    @Autowired
    private sedeService servicio;
    
    @GetMapping
    public List<sedeEntity> findAll(){
        return servicio.findAll();
    }
    
    @GetMapping("/custom")
    public List<sedeEntity> findAllCustom(){
        return servicio.findAllCustom();
        
    }
    
    @GetMapping("/{id}")
    public Optional<sedeEntity> findById(@PathVariable Long id){
        return servicio.findById(id);
        
    }
    
    @PostMapping
    public sedeEntity add(@RequestBody sedeEntity s){
        return servicio.add(s);
    }
    @PutMapping("{id}")
    public sedeEntity update(@PathVariable Long id, @RequestBody sedeEntity s){
        s.setCodigo(id);
        return servicio.update(s);
    }
    @DeleteMapping("{id}")
    public sedeEntity delete(@PathVariable Long id){
        sedeEntity objsede = new sedeEntity();
        objsede.setEstado(false);
        return servicio.delete(sedeEntity.builder().codigo(id).build());
    } 
}

