package ufrn.br.aulaspringrest.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PessoaResponseDTO {

    String id;
    String nome;
    String sobrenome;
    Integer idade;
    String nomeDaRua;
}
