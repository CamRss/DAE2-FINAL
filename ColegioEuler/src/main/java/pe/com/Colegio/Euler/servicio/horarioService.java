
package pe.com.Colegio.Euler.servicio;
import java.util.List;
import java.util.Optional;
import pe.com.Colegio.Euler.entity.horarioEntity;

public interface horarioService {
    List<horarioEntity> findAll();
    List<horarioEntity> findAllCustom();
    Optional<horarioEntity> findById(long id);
    horarioEntity add(horarioEntity h);
    horarioEntity update(horarioEntity h);
    horarioEntity delete(horarioEntity h);
    horarioEntity enable(horarioEntity h);

    
}