
package pe.com.Colegio.Euler.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.com.Colegio.Euler.entity.profesorEntity;
import pe.com.Colegio.Euler.entity.sedeEntity;


public interface sedeRepository extends JpaRepository<sedeEntity, Long>{
    @Query("select s from sedeEntity s where s.estado=true")
    List<sedeEntity> findAllCustom();
    
       @Query("select s from sedeEntity s where LOWER(s.nombre) like LOWER(CONCAT('%', :nombre,'%'))")
    sedeEntity findByName(@Param("nombre") String nombre);

}