package ufrn.br.aulaspringrest.dto;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class PessoaResponseDTO {

    String id;
    String nome;
    String sobrenome;
    Integer idade;
    String nomeDaRua;

    public PessoaResponseDTO() {
    }
}
