
package pe.com.Colegio.Euler.servicio;

import java.util.List;
import java.util.Optional;
import pe.com.Colegio.Euler.entity.profesorEntity;

public interface profesorService {
    List<profesorEntity> findAll();
    List<profesorEntity> findAllCustom();
    Optional<profesorEntity> findById(long id);
    profesorEntity add(profesorEntity p);
    profesorEntity update(profesorEntity p);
    profesorEntity delete(profesorEntity p);
    profesorEntity enable(profesorEntity p);

    
}