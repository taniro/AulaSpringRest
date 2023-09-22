package ufrn.br.aulaspringrest.dto;


import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import ufrn.br.aulaspringrest.controller.CredenciaisController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
public class EnderecoResponseDTO extends RepresentationModel<EnderecoResponseDTO> {

    String id;
    String rua;
    String cidade;

    public void addLinks(){
        add(linkTo(CredenciaisController.class).withRel("enderecos"));
    }
}
