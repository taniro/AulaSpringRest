package ufrn.br.aulaspringrest.dto;


import lombok.Data;

@Data
public class PessoaRequestDTO {
    String nome;
    String sobrenome;
    Integer idade;
}
