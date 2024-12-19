
package pe.com.Colegio.Euler.servicio;
import java.util.List;
import java.util.Optional;
import pe.com.Colegio.Euler.entity.aulaEntity;

public interface aulaService {
    List<aulaEntity> findAll();
    List<aulaEntity> findAllCustom();
    Optional<aulaEntity> findById(long id);
    aulaEntity add(aulaEntity al);
    aulaEntity update(aulaEntity al);
    aulaEntity delete(aulaEntity al);
    aulaEntity enable(aulaEntity al);
}