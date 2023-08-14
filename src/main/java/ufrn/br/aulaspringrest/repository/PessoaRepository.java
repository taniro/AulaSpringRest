package ufrn.br.aulaspringrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufrn.br.aulaspringrest.model.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa, String> {
}
