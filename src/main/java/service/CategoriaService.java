package service;

import model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import repository.CategoriaRepository;
import service.exceptions.DataIntegrityException;
import service.exceptions.ObjetoNaoEncontradoException;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria find(Integer id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjetoNaoEncontradoException(""));
    }

    public Categoria insert(Categoria obj) {
        obj.setId(null);
        return this.repository.save(obj);
    }

    public Categoria update(Categoria obj) {
        this.find(obj.getId());
        return this.repository.save(obj);
    }

    public void delete(Integer id) {
        this.find(id);
        try {
            this.repository.deleteById(id);
        } catch (DataIntegrityViolationException exc) {
            throw new DataIntegrityException("Categoria possui produtos, não é possível deletar!");
        }
    }
}
