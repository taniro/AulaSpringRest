package ufrn.br.aulaspringrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufrn.br.aulaspringrest.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
}
