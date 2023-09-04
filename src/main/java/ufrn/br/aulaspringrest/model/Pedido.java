package ufrn.br.aulaspringrest.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "pedido_tbl")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;


    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    Pessoa pessoa;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "pedido_produto_tbl",
            joinColumns = {@JoinColumn(name = "pedido_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "produto_id")})
    Set<Produto> produtos;
}
