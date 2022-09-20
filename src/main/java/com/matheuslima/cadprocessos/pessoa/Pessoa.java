package com.matheuslima.cadprocessos.pessoa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pessoa")
@Data
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    public void setDataCadastroAtual(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro.toLocalDate();
    }
}
