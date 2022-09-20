package com.matheuslima.cadprocessos.processo.dto;

import com.matheuslima.cadprocessos.pessoa.Pessoa;
import com.matheuslima.cadprocessos.processo.Processo;
import lombok.Data;

import java.util.Objects;

@Data
public class ProcessoDTO {
    private Long id;
    private Long numero;
    private Integer ano;
    private String dataCadastro;
    private Pessoa pessoa;
    private String descricao;

    public ProcessoDTO(Processo processo){
        this.id = processo.getId();
        this.numero = processo.getNumero();
        this.ano = processo.getAno();;
        this.dataCadastro = Objects.nonNull(processo.getDataCadastro()) ? processo.getDataCadastro().toString(): null;
        this.pessoa = processo.getPessoa();
        this.descricao = processo.getDescricao();
    }
}
