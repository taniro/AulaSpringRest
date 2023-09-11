package ufrn.br.aulaspringrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufrn.br.aulaspringrest.model.Credenciais;

import java.util.Optional;

public interface CredenciaisRepository extends JpaRepository<Credenciais, String > {
    Optional<Credenciais> findByUsername(String username);
}
