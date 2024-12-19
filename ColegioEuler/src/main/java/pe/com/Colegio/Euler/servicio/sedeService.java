
package pe.com.Colegio.Euler.servicio;
import java.util.List;
import java.util.Optional;
import pe.com.Colegio.Euler.entity.sedeEntity;

public interface sedeService {
    List<sedeEntity> findAll();
    List<sedeEntity> findAllCustom();
    Optional<sedeEntity> findById(long id);
    sedeEntity add(sedeEntity s);
    sedeEntity update(sedeEntity s);
    sedeEntity delete(sedeEntity s);
    sedeEntity enable(sedeEntity s);
}
