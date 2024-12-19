
package pe.com.Colegio.Euler.servicio.Impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.Colegio.Euler.entity.alumnoEntity;
import pe.com.Colegio.Euler.repository.alumnoRepository;
import pe.com.Colegio.Euler.servicio.alumnoService;

@Service
public class alumnoServiceImpl implements alumnoService{

    @Autowired
    private alumnoRepository repositorio;
    
    @Override
    public List<alumnoEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<alumnoEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<alumnoEntity> findById(long id) {
        return repositorio.findById(id);
    }

    @Override
    public alumnoEntity add(alumnoEntity a) {
        return repositorio.save(a);
    }

    @Override
    public alumnoEntity update(alumnoEntity a) {
        alumnoEntity objalumno = repositorio.getById(a.getCodigo());
        BeanUtils.copyProperties(a, objalumno);
        return repositorio.save(objalumno);
    }

    @Override
    public alumnoEntity delete(alumnoEntity a) {
        alumnoEntity objalumno = repositorio.getById(a.getCodigo());
        objalumno.setEstado(false);
        return repositorio.save(objalumno);
    }
    
     @Override
     public alumnoEntity enable(alumnoEntity a) {
        alumnoEntity objalumno = repositorio.getById(a.getCodigo());
        objalumno.setEstado(true);
        return repositorio.save(objalumno);
    }

}
