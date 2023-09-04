package ufrn.br.aulaspringrest.controller;


import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ufrn.br.aulaspringrest.model.Pessoa;
import ufrn.br.aulaspringrest.service.PessoaService;

import javax.xml.crypto.dsig.XMLObject;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pessoas/")
public class PessoaController {

    PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Pessoa> create(@RequestBody Pessoa p){
        Pessoa created = service.create(p);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.created(location).body(created);
    }

    @PutMapping
    public Pessoa saveOrUpdate(@RequestBody Pessoa p){
        return service.saveOrUpdate(p);
    }

    @PatchMapping
    public Pessoa patchUpdate(@RequestBody Pessoa p){
        return service.patchUpdate(p);
    }

    /*
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Pessoa p){
        Pessoa created = service.create(p);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }*/

    /*
    @GetMapping
    public List<Pessoa> listAll(){
        return service.listAll();
    }

     */


    @GetMapping
    public Page<Pessoa> listAll(Pageable page){
        return service.listAll(page);
    }

    @GetMapping("{id}")
    public Pessoa getById(@PathVariable String id){
        return service.getById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
