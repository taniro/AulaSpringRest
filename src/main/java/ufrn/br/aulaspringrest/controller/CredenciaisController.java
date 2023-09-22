package ufrn.br.aulaspringrest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ufrn.br.aulaspringrest.dto.CredenciaisDTO;
import ufrn.br.aulaspringrest.model.Credenciais;
import ufrn.br.aulaspringrest.model.Pessoa;
import ufrn.br.aulaspringrest.service.CredenciaisService;

@RestController
@RequestMapping("/credenciais")
public class CredenciaisController {


    CredenciaisService service;

    public CredenciaisController(CredenciaisService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CredenciaisDTO credenciaisDTO){

        Pessoa p = new Pessoa();
        p.setSobrenome(credenciaisDTO.getSobrenome());
        p.setNome(credenciaisDTO.getNome());

        Credenciais c = new Credenciais();
        c.setPessoa(p);
        c.setPassword(credenciaisDTO.getPassword());
        c.setUsername(credenciaisDTO.getUsername());
        c.setRoles(credenciaisDTO.getRole());

        service.create(c);

        return ResponseEntity.noContent().build();

    }
}
