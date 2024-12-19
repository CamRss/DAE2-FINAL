
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
import pe.com.Colegio.Euler.entity.horarioEntity;
import pe.com.Colegio.Euler.servicio.horarioService;

@RestController
@RequestMapping("/horario")
public class horarioRestController {
    @Autowired
    private horarioService servicio;
    
    @GetMapping
    public List<horarioEntity> findAll(){
        return servicio.findAll();
    }
    
    @GetMapping("/custom")
    public List<horarioEntity> findAllCustom(){
        return servicio.findAllCustom();
        
    }
    
    @GetMapping("/{id}")
    public Optional<horarioEntity> findById(@PathVariable Long id){
        return servicio.findById(id);
        
    }
    
    @PostMapping
    public horarioEntity add(@RequestBody horarioEntity h){
        return servicio.add(h);
    }
    @PutMapping("{id}")
    public horarioEntity update(@PathVariable Long id, @RequestBody horarioEntity h){
        h.setCodigo(id);
        return servicio.update(h);
    }
    @DeleteMapping("{id}")
    public horarioEntity delete(@PathVariable Long id){
        horarioEntity objhorario = new horarioEntity();
        objhorario.setEstado(false);
        return servicio.delete(horarioEntity.builder().codigo(id).build());
    } 
}
