package ufrn.br.aulaspringrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ufrn.br.aulaspringrest.model.Endereco;
import ufrn.br.aulaspringrest.model.Pessoa;
import ufrn.br.aulaspringrest.repository.EnderecoRepository;
import ufrn.br.aulaspringrest.repository.PessoaRepository;

@SpringBootApplication
public class AulaSpringRestApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AulaSpringRestApplication.class, args);
    }

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    public void run(String... args) throws Exception {

        Endereco endereco = new Endereco();

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("João");

        //pessoa.setEndereco(endereco);

        endereco.setPessoa(pessoa);
        enderecoRepository.save(endereco);

        System.out.println(pessoa.toString());
    }
}
