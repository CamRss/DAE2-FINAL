
package pe.com.Colegio.Euler.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.com.Colegio.Euler.entity.alumnoEntity;
import pe.com.Colegio.Euler.entity.horarioEntity;


public interface horarioRepository extends JpaRepository<horarioEntity, Long>{
    @Query("select h from horarioEntity h where h.estado=true")
    List<horarioEntity> findAllCustom();
    
    @Query("select h from horarioEntity h where LOWER(h.dias) like LOWER(CONCAT('%', :dias,'%'))")
    horarioEntity findByDias(@Param("dias") String nombre);
}
