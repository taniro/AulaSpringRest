package ufrn.br.aulaspringrest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "pessoas_tbl")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String nome;
    String sobrenome;
    String idade;
    Boolean admin = false;

    /*
    @OneToOne(mappedBy = "pessoa")
    Endereco endereco;
     */

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "endereco_id")
    @JsonIgnore
    Endereco endereco;

    @OneToOne
    @JoinColumn(name = "chefe_id")
    @JsonIgnore
    Pessoa chefe;

    /*
    @OneToOne(mappedBy = "pessoa")
    Endereco endereco;
    */


    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    Set<Pedido> pedidos;



    /*
    @OneToMany
    @JoinColumn(name = "cliente_id")
    Set<Pedido> pedidos;

     */

    public String getNomeCompleto(){
        return this.nome + " " + this.sobrenome;
    }

    public void partialUpdate(Pessoa p){
        if (p.getNome() != null){
            this.setNome(p.getNome());
        }
        if (p.getSobrenome() != null){
            this.setSobrenome(p.getSobrenome());
        }
        if (p.getIdade() != null){
            this.setIdade(p.getIdade());
        }
        if (p.getAdmin() != null){
            this.setAdmin(p.getAdmin());
        }
    }
}