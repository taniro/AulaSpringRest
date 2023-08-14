package ufrn.br.aulaspringrest.controller;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ufrn.br.aulaspringrest.model.Pessoa;
import ufrn.br.aulaspringrest.service.PessoaService;

import javax.xml.crypto.dsig.XMLObject;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @PostMapping
    public Pessoa create(@RequestBody Pessoa p){
        return service.create(p);
    }

    @GetMapping
    public List<Pessoa> listAll(){
        return service.listAll();
    }

    @GetMapping("{id}")
    public Pessoa getById(@PathVariable String id){
        Optional<Pessoa> p = service.getById(id);
        if(p.isPresent()){
            return p.get();
        }else{
            throw new EntityNotFoundException();
        }
    }
}
