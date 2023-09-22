package ufrn.br.aulaspringrest;

import ch.qos.logback.core.net.server.Client;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ufrn.br.aulaspringrest.config.RsaKeyProperties;
import ufrn.br.aulaspringrest.model.*;
import ufrn.br.aulaspringrest.repository.*;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class AulaSpringRestApplication implements CommandLineRunner {


    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(AulaSpringRestApplication.class, args);
    }

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ProdutoRepository produtoRepository;


    /*
    @Bean
    CommandLineRunner commandLineRunner(CredenciaisRepository repository, BCryptPasswordEncoder encoder){
        return args -> {
            Pessoa p = new Pessoa();
            p.setSobrenome("Ortins");
            p.setNome("Jose");

            Credenciais c = new Credenciais();
            c.setUsername("jose");
            c.setPassword(encoder.encode("123"));
            c.setRoles("user");

            c.setPessoa(p);

            repository.save(c);
        };
    }

     */

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        /*
        Produto prod1 = new Produto();
        Produto prod2 = new Produto();

        produtoRepository.save(prod1);
        produtoRepository.save(prod2);


        Pedido p1 = new Pedido();
        Pedido p2 = new Pedido();
        Pedido p3 = new Pedido();
        Pedido p4 = new Pedido();

        Pessoa pessoa = new Pessoa();
        pessoaRepository.save(pessoa);


        p1.setPessoa(pessoa);
        p2.setPessoa(pessoa);
        p3.setPessoa(pessoa);
        p4.setPessoa(pessoa);

        Set<Pedido> pedidos = new HashSet<>();
        pedidos.add(p1);
        pedidos.add(p2);
        pedidos.add(p3);
        pedidos.add(p4);

        pessoa.setPedidos(pedidos);


        Set<Produto> produtos = new HashSet<>();
        produtos.add(prod1);
        produtos.add(prod2);

        p1.setProdutos(produtos);

        pedidoRepository.save(p1);



        pedidoRepository.save(p2);
        pedidoRepository.save(p3);
        pedidoRepository.save(p4);

        pessoaRepository.save(pessoa);

        pessoaRepository.findById(pessoa.getId());

         */
    }
}
