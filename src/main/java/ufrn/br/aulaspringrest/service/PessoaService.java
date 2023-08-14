package ufrn.br.aulaspringrest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufrn.br.aulaspringrest.model.Pessoa;
import ufrn.br.aulaspringrest.repository.PessoaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public List<Pessoa> listAll(){
        return repository.findAll();
    }

    public Pessoa create(Pessoa p){
        return repository.save(p);
    }

    public Optional<Pessoa> getById(String id){
        return repository.findById(id);
    }
}
