package service;

import model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import repository.PessoaRepository;
import service.exceptions.DataIntegrityException;
import service.exceptions.ObjetoNaoEncontradoException;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public Pessoa find(Integer id) {
        Optional<Pessoa> obj = this.repository.findById(id);
        return obj.orElseThrow(() -> new ObjetoNaoEncontradoException(""));
    }

    public Pessoa insert(Pessoa obj) {
        obj.setId(null);
        return this.repository.save(obj);
    }

    public Pessoa update(Pessoa obj) {
        this.find(obj.getId());
        return this.repository.save(obj);
    }

    public void delete(Integer id) {
        this.find(id);
        try {
            this.repository.deleteById(id);
        } catch (DataIntegrityViolationException exc) {
            throw new DataIntegrityException("Pessoa possui endereços, não é possível deletar!");
        }
    }

    public List<Pessoa> findAll() {
        return this.repository.findAll();
    }

}
