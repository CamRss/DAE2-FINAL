
package pe.com.Colegio.Euler.servicio.Impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.Colegio.Euler.entity.cursoEntity;
import pe.com.Colegio.Euler.entity.horarioEntity;
import pe.com.Colegio.Euler.repository.horarioRepository;
import pe.com.Colegio.Euler.servicio.horarioService;

@Service
public class horarioServiceImpl implements horarioService{

    @Autowired
    private horarioRepository repositorio;
    
    @Override
    public List<horarioEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<horarioEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<horarioEntity> findById(long id) {
        return repositorio.findById(id);
    }

    @Override
    public horarioEntity add(horarioEntity h) {
        return repositorio.save(h);
    }

    @Override
    public horarioEntity update(horarioEntity h) {
        horarioEntity objhorario = repositorio.getById(h.getCodigo());
        BeanUtils.copyProperties(h, objhorario);
        return repositorio.save(objhorario);
    }
    
     @Override
    public horarioEntity delete(horarioEntity h) {
        horarioEntity objhorario = repositorio.getById(h.getCodigo());
        objhorario.setEstado(false);
        return repositorio.save(objhorario);
    }

   @Override
     public horarioEntity enable(horarioEntity h) {
        horarioEntity objhorario = repositorio.getById(h.getCodigo());
        objhorario.setEstado(true);
        return repositorio.save(objhorario);
    }
    
}
