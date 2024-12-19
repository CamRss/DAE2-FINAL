
package pe.com.Colegio.Euler.servicio;
import java.util.List;
import java.util.Optional;
import pe.com.Colegio.Euler.entity.cursoEntity;

public interface cursoService {
    List<cursoEntity> findAll();
    List<cursoEntity> findAllCustom();
    Optional<cursoEntity> findById(long id);
    cursoEntity add(cursoEntity c);
    cursoEntity update(cursoEntity c);
    cursoEntity delete(cursoEntity c);
    cursoEntity enable(cursoEntity c);
}