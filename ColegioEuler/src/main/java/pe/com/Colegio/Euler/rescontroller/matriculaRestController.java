
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
import pe.com.Colegio.Euler.entity.matriculaEntity;
import pe.com.Colegio.Euler.servicio.matriculaService;

@RestController
@RequestMapping("/matricula")
public class matriculaRestController {
    @Autowired
    private matriculaService servicio;
    
    @GetMapping
    public List<matriculaEntity> findAll(){
        return servicio.findAll();
    }
    
    @GetMapping("/custom")
    public List<matriculaEntity> findAllCustom(){
        return servicio.findAllCustom();
        
    }
    
    @GetMapping("/{id}")
    public Optional<matriculaEntity> findById(@PathVariable Long id){
        return servicio.findById(id);
        
    }
    
    @PostMapping
    public matriculaEntity add(@RequestBody matriculaEntity m){
        return servicio.add(m);
    }
    @PutMapping("{id}")
    public matriculaEntity update(@PathVariable Long id, @RequestBody matriculaEntity m){
        m.setCodigo(id);
        return servicio.update(m);
    }
    @DeleteMapping("{id}")
    public matriculaEntity delete(@PathVariable Long id){
        matriculaEntity objmatricula = new matriculaEntity();
        objmatricula.setEstado(false);
        return servicio.delete(matriculaEntity.builder().codigo(id).build());
    } 
}
