package com.matheuslima.cadprocessos.pessoa.dto;

import com.matheuslima.cadprocessos.pessoa.Pessoa;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@Data
@NoArgsConstructor
public class PessoaDto {
    private Long id;
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String dataCadastro;

    public PessoaDto(Pessoa pessoa){
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.cpf = pessoa.getCpf();
        this.dataNascimento = Objects.nonNull(pessoa.getDataNascimento()) ? pessoa.getDataNascimento().toString() : null;
        this.dataCadastro = Objects.nonNull(pessoa.getDataCadastro()) ? pessoa.getDataCadastro().toString() : null;
    }
}
