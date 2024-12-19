
package pe.com.Colegio.Euler.servicio.Impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.Colegio.Euler.entity.profesorEntity;
import pe.com.Colegio.Euler.entity.sedeEntity;
import pe.com.Colegio.Euler.repository.sedeRepository;
import pe.com.Colegio.Euler.servicio.sedeService;

@Service
public class sedeServiceImpl implements sedeService{

    @Autowired
    private sedeRepository repositorio;
    
    @Override
    public List<sedeEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<sedeEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<sedeEntity> findById(long id) {
        return repositorio.findById(id);
    }

    @Override
    public sedeEntity add(sedeEntity s) {
        return repositorio.save(s);
    }

    @Override
    public sedeEntity update(sedeEntity s) {
        sedeEntity objsede = repositorio.getById(s.getCodigo());
        BeanUtils.copyProperties(s, objsede);
        return repositorio.save(objsede);
    }

    @Override
    public sedeEntity delete(sedeEntity s) {
        sedeEntity objsede = repositorio.getById(s.getCodigo());
        objsede.setEstado(false);
        return repositorio.save(objsede);
    }
    
   @Override
     public sedeEntity enable(sedeEntity s) {
        sedeEntity objsede = repositorio.getById(s.getCodigo());
        objsede.setEstado(true);
        return repositorio.save(objsede);
    }
    
    
}

