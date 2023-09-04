package ufrn.br.aulaspringrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufrn.br.aulaspringrest.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, String> {
}
