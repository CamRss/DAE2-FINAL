
package pe.com.Colegio.Euler.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.com.Colegio.Euler.entity.alumnoEntity;
import pe.com.Colegio.Euler.entity.aulaEntity;


public interface aulaRepository extends JpaRepository<aulaEntity, Long>{
    @Query("select al from aulaEntity al where al.estado=true")
    List<aulaEntity> findAllCustom();

     @Query("SELECT a FROM aulaEntity a WHERE LOWER(a.descripcion) LIKE LOWER(CONCAT('%', :descripcion, '%'))")
    aulaEntity findByDescripcion(@Param("descripcion") String descripcion);

}