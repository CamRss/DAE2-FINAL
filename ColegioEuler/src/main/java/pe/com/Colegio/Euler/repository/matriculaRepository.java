
package pe.com.Colegio.Euler.repository;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.com.Colegio.Euler.entity.horarioEntity;
import pe.com.Colegio.Euler.entity.matriculaEntity;


public interface matriculaRepository extends JpaRepository<matriculaEntity, Long>{
    @Query("select m from matriculaEntity m where m.estado=true")
    List<matriculaEntity> findAllCustom();
    
     @Query("select m from matriculaEntity m where LOWER(m.fecha) like LOWER(CONCAT('%', :fecha,'%'))")
    matriculaEntity findByDate(@Param("fecha") Date fecha);

}