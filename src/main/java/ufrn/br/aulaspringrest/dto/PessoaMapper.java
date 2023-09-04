package ufrn.br.aulaspringrest.dto;

import ufrn.br.aulaspringrest.model.Pessoa;

public class  PessoaMapper {

    public static Pessoa toPessoa(PessoaRequestDTO dto) {
        Pessoa pessoa = Pessoa.builder()
                .idade(dto.getIdade())
                .nome(dto.getNome())
                .sobrenome(dto.getSobrenome()).build();
        return pessoa;
    }

    public static PessoaResponseDTO toPessoaResponseDTO(Pessoa created) {
        PessoaResponseDTO responseDTO = PessoaResponseDTO.builder()
                .id(created.getId())
                .nome(created.getNome())
                .idade(created.getIdade())
                .sobrenome(created.getSobrenome())
                .nomeDaRua("Nome da rua").build();
        return responseDTO;
    }
}
