package ufrn.br.aulaspringrest.controller;


import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ufrn.br.aulaspringrest.dto.PessoaMapper;
import ufrn.br.aulaspringrest.dto.PessoaRequestDTO;
import ufrn.br.aulaspringrest.dto.PessoaResponseDTO;
import ufrn.br.aulaspringrest.model.Endereco;
import ufrn.br.aulaspringrest.model.Pessoa;
import ufrn.br.aulaspringrest.service.PessoaService;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/api/pessoas/")
public class PessoaController {

    PessoaService service;
    PessoaMapper mapper;

    public PessoaController(PessoaService service, PessoaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<PessoaResponseDTO> create(@RequestBody PessoaRequestDTO dto){
        Pessoa pessoa = mapper.toPessoa(dto);
        Pessoa created = service.create(pessoa);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(created.getId())
                .toUri();

        PessoaResponseDTO responseDTO = mapper.toPessoaResponseDTO(created);
        return ResponseEntity.created(location).body(responseDTO);
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


    /*
    @GetMapping
    public List<Pessoa> listAll(){
        return service.listAll();
    }*/

    @GetMapping("{id}")
    public PessoaResponseDTO getById(@PathVariable String id){

        Pessoa p = service.getById(id);


        Endereco end = new Endereco();
        end.setCidade("Natal");
        end.setRua("UFRN");

        p.setEndereco(end);

        PessoaResponseDTO responseDTO = mapper.toPessoaResponseDTO(p);
        responseDTO.addLinks(p.getEndereco());


        return responseDTO;
    }



    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
