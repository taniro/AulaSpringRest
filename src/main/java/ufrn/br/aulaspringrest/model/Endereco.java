package ufrn.br.aulaspringrest.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "endereco_tbl")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String rua;
    String cidade;

    /*
    @OneToOne
    @MapsId
    @JoinColumn(name = "id_cliente")
    Pessoa pessoa;
     */

    /*
    @OneToOne(mappedBy = "endereco")
    Pessoa pessoa;
     */

    /*
    @OneToOne
    @JoinColumn(name = "pessoa_id")
    Pessoa pessoa;
     */

    @Override
    public String toString() {
        return "Endereco{" +
                "id='" + id + '\'' +
                ", rua='" + rua + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
