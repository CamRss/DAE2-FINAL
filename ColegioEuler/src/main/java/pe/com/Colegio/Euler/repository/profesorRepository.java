
package pe.com.Colegio.Euler.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.com.Colegio.Euler.entity.alumnoEntity;
import pe.com.Colegio.Euler.entity.profesorEntity;


public interface profesorRepository extends JpaRepository<profesorEntity, Long>{
    @Query("select p from profesorEntity p where p.estado=true")
    List<profesorEntity> findAllCustom();
    
    @Query("select p from profesorEntity p where LOWER(p.nombre) like LOWER(CONCAT('%', :nombre,'%'))")
    profesorEntity findByName(@Param("nombre") String nombre);

}