package com.matheuslima.cadprocessos.pessoa.repository;

import com.matheuslima.cadprocessos.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query(nativeQuery = true, value =
            "select * from pessoa p where p.nome ilike :search order by id desc")
    List<Pessoa> getAll(@Param("search") String search);

    @Query(nativeQuery = true, value =
            "select count(*) > 0 from processo p where p.pessoa_id = :id")
    Boolean findProcessosByPessoa(@Param("id") Long id);
}
