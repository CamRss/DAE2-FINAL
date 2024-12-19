
package pe.com.Colegio.Euler.servicio.Impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.Colegio.Euler.entity.alumnoEntity;
import pe.com.Colegio.Euler.entity.aulaEntity;
import pe.com.Colegio.Euler.repository.aulaRepository;
import pe.com.Colegio.Euler.servicio.aulaService;

@Service
public class aulaServiceImpl implements aulaService{

    @Autowired
    private aulaRepository repositorio;
    
    @Override
    public List<aulaEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<aulaEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<aulaEntity> findById(long id) {
        return repositorio.findById(id);
    }

    @Override
    public aulaEntity add(aulaEntity al) {
        return repositorio.save(al);
    }

    @Override
    public aulaEntity update(aulaEntity al) {
        aulaEntity objaula = repositorio.getById(al.getCodigo());
        BeanUtils.copyProperties(al, objaula);
        return repositorio.save(objaula);
    }
    
    @Override
    public aulaEntity delete(aulaEntity al) {
        aulaEntity objaula = repositorio.getById(al.getCodigo());
        objaula.setEstado(false);
        return repositorio.save(objaula);
    }

     @Override
     public aulaEntity enable(aulaEntity al) {
        aulaEntity objaula = repositorio.getById(al.getCodigo());
        objaula.setEstado(true);
        return repositorio.save(objaula);
    }
    
}
