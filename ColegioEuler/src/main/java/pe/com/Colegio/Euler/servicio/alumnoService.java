
package pe.com.Colegio.Euler.servicio;

import java.util.List;
import java.util.Optional;
import pe.com.Colegio.Euler.entity.alumnoEntity;

public interface alumnoService {
    List<alumnoEntity> findAll();
    List<alumnoEntity> findAllCustom();
    Optional<alumnoEntity> findById(long id);
    alumnoEntity add(alumnoEntity a);
    alumnoEntity update(alumnoEntity a);
    alumnoEntity delete(alumnoEntity a);
    alumnoEntity enable(alumnoEntity a);


    
}
