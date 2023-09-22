package ufrn.br.aulaspringrest.service;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ufrn.br.aulaspringrest.model.Pessoa;
import ufrn.br.aulaspringrest.repository.PessoaRepository;

import java.time.LocalDateTime;
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

    public Page<Pessoa> listAll(Pageable page){

        return repository.findAll(page);
    }

    public Pessoa create(Pessoa p){

        return repository.save(p);
    }

    public Pessoa getById(String id){
        Optional<Pessoa> p = repository.findById(id);
        if(p.isPresent()){
            return p.get();
        }else{
            //throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
            throw new EntityNotFoundException("Not found");
        }
    }

    public Pessoa saveOrUpdate(Pessoa p){
        Optional<Pessoa> busca = repository.findById(p.getId());
        if (busca.isPresent()){
            return repository.save(p);
        }else{
            //throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
            throw new EntityNotFoundException("Not found");
        }
    }

    public void delete (String id){
        Optional<Pessoa> busca = repository.findById(id);
        if (busca.isPresent()){
            repository.delete(busca.get());
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
    }

    public Pessoa patchUpdate(Pessoa p){
        Optional<Pessoa> busca = repository.findById(p.getId());
        if (busca.isPresent()){

            Pessoa buscado = busca.get();
            buscado.partialUpdate(p);

            return repository.save(buscado);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
    }
}
