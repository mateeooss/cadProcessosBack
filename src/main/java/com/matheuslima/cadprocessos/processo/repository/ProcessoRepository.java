package com.matheuslima.cadprocessos.processo.repository;

import com.matheuslima.cadprocessos.pessoa.Pessoa;
import com.matheuslima.cadprocessos.processo.Processo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessoRepository extends JpaRepository<Processo, Long> {

    @Query(nativeQuery = true, value =
            "select * from processo p where cast(p.numero as text) ilike :search order by id desc")
    List<Processo> getAll(@Param("search") String search);

    @Modifying
    @Query(nativeQuery = true,
            value = "DELETE FROM processo WHERE pessoa_id = :id")
    void deleteAllByPessoaId(Long id);
}
