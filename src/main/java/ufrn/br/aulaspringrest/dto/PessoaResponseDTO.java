package ufrn.br.aulaspringrest.dto;


import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import ufrn.br.aulaspringrest.controller.AuthController;
import ufrn.br.aulaspringrest.controller.PessoaController;
import ufrn.br.aulaspringrest.model.Endereco;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
public class PessoaResponseDTO extends RepresentationModel<PessoaResponseDTO> {

    String id;
    String nome;
    String sobrenome;
    Integer idade;
    String nomeDaRua;
    EnderecoResponseDTO endereco;

    public PessoaResponseDTO() {
    }

    public void addLinks(Endereco endereco) {
        this.add(linkTo(PessoaController.class).slash(id).withSelfRel());
        this.add(linkTo(PessoaController.class).slash(id).withRel("delete"));
        this.add(linkTo(PessoaController.class).withRel("allPessoas"));

        this.endereco.addLinks();
    }

}
