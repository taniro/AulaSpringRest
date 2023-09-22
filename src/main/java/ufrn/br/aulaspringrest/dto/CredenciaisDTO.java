package ufrn.br.aulaspringrest.dto;

import lombok.Data;

@Data
public class CredenciaisDTO {
    String username;
    String password;
    String role;
    String nome;
    String sobrenome;
}
