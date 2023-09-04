package ufrn.br.aulaspringrest.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "produtos_tbl")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    /*
    @ManyToMany(mappedBy = "produtos")
    Set<Pedido> pedidos;

     */
}
