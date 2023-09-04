package ufrn.br.aulaspringrest.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Venda {


    @ManyToOne
    @JoinColumn(name = "pedido_id")
    Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    Produto produto;

    Integer quantidade;
}
