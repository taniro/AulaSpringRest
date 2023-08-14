package ufrn.br.aulaspringrest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pessoas_tbl")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String nome;
    String sobrenome;
    String idade;

    public String getNomeCompleto(){
        return this.nome + " " + this.sobrenome;
    }
}