
package pe.com.Colegio.Euler.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.com.Colegio.Euler.entity.aulaEntity;
import pe.com.Colegio.Euler.entity.cursoEntity;


public interface cursoRepository extends JpaRepository<cursoEntity, Long>{
    @Query("select c from cursoEntity c where c.estado=true ")
    List<cursoEntity> findAllCustom();
    
    
     @Query("SELECT c FROM cursoEntity c WHERE LOWER(c.nombre) LIKE LOWER(CONCAT('%', :descripcion, '%'))")
    cursoEntity findByName(@Param("nombre") String descripcion);

}