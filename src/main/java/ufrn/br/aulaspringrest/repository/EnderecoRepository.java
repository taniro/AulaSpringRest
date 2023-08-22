package ufrn.br.aulaspringrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufrn.br.aulaspringrest.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, String> {
}
