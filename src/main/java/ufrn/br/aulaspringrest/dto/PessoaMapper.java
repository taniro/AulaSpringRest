package ufrn.br.aulaspringrest.dto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ufrn.br.aulaspringrest.model.Pessoa;

@Component
public class  PessoaMapper {

    ModelMapper mapper;

    public PessoaMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Pessoa toPessoa(PessoaRequestDTO dto) {
        Pessoa pessoa = this.mapper.map(dto, Pessoa.class);
        /*
        Pessoa pessoa = Pessoa.builder()
                .idade(dto.getIdade())
                .nome(dto.getNome())
                .sobrenome(dto.getSobrenome()).build();*/
        return pessoa;
    }

    public PessoaResponseDTO toPessoaResponseDTO(Pessoa created) {
        PessoaResponseDTO responseDTO = this.mapper.map(created, PessoaResponseDTO.class);
        responseDTO.setNomeDaRua("/logicadenegocio");

        /*
        PessoaResponseDTO responseDTO = PessoaResponseDTO.builder()
                .id(created.getId())
                .nome(created.getNome())
                .idade(created.getIdade())
                .sobrenome(created.getSobrenome())
                .nomeDaRua("Nome da rua").build();*/
        return responseDTO;
    }
}
