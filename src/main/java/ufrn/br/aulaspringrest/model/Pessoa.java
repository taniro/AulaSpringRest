package ufrn.br.aulaspringrest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import ufrn.br.aulaspringrest.dto.PessoaResponseDTO;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "pessoas_tbl")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SQLDelete(sql = "UPDATE pessoas_tbl SET deleted_at = CURRENT_TIMESTAMP WHERE id=?")
@Where(clause = "deleted_at is null")
@Builder
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @NotBlank (message = "O campo nome não pode estar em branco.")
    String nome;
    String sobrenome;

    @Min(value = 0, message = "A idade não deve ser menor que zero")
    Integer idade;
    Boolean admin = false;


    LocalDateTime deletedAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;
    @CreationTimestamp
    LocalDateTime createdAt;

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