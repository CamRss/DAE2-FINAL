
package pe.com.Colegio.Euler.servicio.Impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.Colegio.Euler.entity.horarioEntity;
import pe.com.Colegio.Euler.entity.matriculaEntity;
import pe.com.Colegio.Euler.repository.matriculaRepository;
import pe.com.Colegio.Euler.servicio.matriculaService;

@Service
public class matriculaServiceImpl implements matriculaService{

    @Autowired
    private matriculaRepository repositorio;
    
    @Override
    public List<matriculaEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<matriculaEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<matriculaEntity> findById(long id) {
        return repositorio.findById(id);
    }

    @Override
    public matriculaEntity add(matriculaEntity m) {
        return repositorio.save(m);
    }

    @Override
    public matriculaEntity update(matriculaEntity m) {
        matriculaEntity objmatricula = repositorio.getById(m.getCodigo());
        BeanUtils.copyProperties(m, objmatricula);
        return repositorio.save(objmatricula);
    }

    @Override
    public matriculaEntity delete(matriculaEntity m) {
        matriculaEntity objmatricula = repositorio.getById(m.getCodigo());
        objmatricula.setEstado(false);
        return repositorio.save(objmatricula);
    }
    
      @Override
     public matriculaEntity enable(matriculaEntity m) {
        matriculaEntity objmatricula = repositorio.getById(m.getCodigo());
        objmatricula.setEstado(true);
        return repositorio.save(objmatricula);
    }
    
}
