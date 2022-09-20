package com.matheuslima.cadprocessos.processo;

import com.matheuslima.cadprocessos.pessoa.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "processo")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Processo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "numero")
    private Long numero;
    @Column(name = "ano")
    private Integer ano;
    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;
    @ManyToOne( cascade = CascadeType.MERGE)
    private Pessoa pessoa;
    @Column(name = "descricao")
    private String descricao;

    public void setDataCadastroAtual(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro.toLocalDate();
    }
}
