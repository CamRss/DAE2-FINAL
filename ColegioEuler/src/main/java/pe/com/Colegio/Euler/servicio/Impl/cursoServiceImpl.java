
package pe.com.Colegio.Euler.servicio.Impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.Colegio.Euler.entity.aulaEntity;
import pe.com.Colegio.Euler.entity.cursoEntity;
import pe.com.Colegio.Euler.repository.cursoRepository;
import pe.com.Colegio.Euler.servicio.cursoService;

@Service
public class cursoServiceImpl implements cursoService{

    @Autowired
    private cursoRepository repositorio;
    
    @Override
    public List<cursoEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<cursoEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<cursoEntity> findById(long id) {
        return repositorio.findById(id);
    }

    @Override
    public cursoEntity add(cursoEntity c) {
        return repositorio.save(c);
    }

    @Override
    public cursoEntity update(cursoEntity c) {
        cursoEntity objcurso = repositorio.getById(c.getCodigo());
        BeanUtils.copyProperties(c, objcurso);
        return repositorio.save(objcurso);
    }

    @Override
    public cursoEntity delete(cursoEntity c) {
        cursoEntity objcurso = repositorio.getById(c.getCodigo());
        objcurso.setEstado(false);
        return repositorio.save(objcurso);
    }
    
    @Override
     public cursoEntity enable(cursoEntity c) {
        cursoEntity objcurso = repositorio.getById(c.getCodigo());
        objcurso.setEstado(true);
        return repositorio.save(objcurso);
    }
    
}
