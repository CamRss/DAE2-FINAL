package pe.com.Colegio.Euler.servicio.Impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.Colegio.Euler.entity.matriculaEntity;
import pe.com.Colegio.Euler.entity.profesorEntity;
import pe.com.Colegio.Euler.repository.profesorRepository;
import pe.com.Colegio.Euler.servicio.profesorService;

@Service
public class profesorServiceImpl implements profesorService{

    @Autowired
    private profesorRepository repositorio;
    
    @Override
    public List<profesorEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<profesorEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<profesorEntity> findById(long id) {
        return repositorio.findById(id);
    }

    @Override
    public profesorEntity add(profesorEntity p) {
        return repositorio.save(p);
    }

    @Override
    public profesorEntity update(profesorEntity p) {
        profesorEntity objprofesor = repositorio.getById(p.getCodigo());
        BeanUtils.copyProperties(p, objprofesor);
        return repositorio.save(objprofesor);
    }

    @Override
    public profesorEntity delete(profesorEntity p) {
        profesorEntity objprofesor = repositorio.getById(p.getCodigo());
        objprofesor.setEstado(false);
        return repositorio.save(objprofesor);
    }
    
    @Override
     public profesorEntity enable(profesorEntity p) {
        profesorEntity objprofesor = repositorio.getById(p.getCodigo());
        objprofesor.setEstado(true);
        return repositorio.save(objprofesor);
    }
    
}
