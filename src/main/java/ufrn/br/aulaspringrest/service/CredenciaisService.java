package ufrn.br.aulaspringrest.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ufrn.br.aulaspringrest.repository.CredenciaisRepository;

@Service
public class CredenciaisService implements UserDetailsService {

    private final CredenciaisRepository repository;

    public CredenciaisService(CredenciaisRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("chamou "+username);


        return this.repository
                .findByUsername(username)
                .orElseThrow( () -> new UsernameNotFoundException("Not found user " + username));
    }
}
