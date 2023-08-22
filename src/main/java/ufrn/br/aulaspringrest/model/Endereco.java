package ufrn.br.aulaspringrest.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "endereco_tbl")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Endereco {
    @Id
    String id;

    String rua;
    String cidade;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_cliente")
    Pessoa pessoa;

}
