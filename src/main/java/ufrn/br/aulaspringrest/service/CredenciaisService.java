package ufrn.br.aulaspringrest.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ufrn.br.aulaspringrest.model.Credenciais;
import ufrn.br.aulaspringrest.repository.CredenciaisRepository;

import java.util.Optional;


@Service
public class CredenciaisService implements UserDetailsService {

    CredenciaisRepository repository;

    public CredenciaisService(CredenciaisRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Credenciais> credenciais = repository.findByUsername(username);
        if (credenciais.isPresent()){
            return credenciais.get();
        }else{
            throw new UsernameNotFoundException("Usuario não cadastrado com username "+username);
        }
    }
}
