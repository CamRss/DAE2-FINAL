
package pe.com.Colegio.Euler.servicio;

import java.util.List;
import java.util.Optional;
import pe.com.Colegio.Euler.entity.matriculaEntity;

public interface matriculaService {
    List<matriculaEntity> findAll();
    List<matriculaEntity> findAllCustom();
    Optional<matriculaEntity> findById(long id);
    matriculaEntity add(matriculaEntity m);
    matriculaEntity update(matriculaEntity m);
    matriculaEntity delete(matriculaEntity m);
    matriculaEntity enable(matriculaEntity m);

    
}
