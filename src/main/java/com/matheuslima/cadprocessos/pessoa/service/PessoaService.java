package com.matheuslima.cadprocessos.pessoa.service;

import com.matheuslima.cadprocessos.pessoa.Pessoa;
import com.matheuslima.cadprocessos.pessoa.dto.PessoaDto;
import com.matheuslima.cadprocessos.pessoa.repository.PessoaRepository;
import com.matheuslima.cadprocessos.processo.repository.ProcessoRepository;
import com.matheuslima.cadprocessos.processo.service.ProcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {
    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    ProcessoRepository processoRepository;

    public List<PessoaDto> getAll(String search){
        search = Objects.isNull(search) ? "%%" : "%"+search+"%";

        return pessoaRepository.getAll(search).stream().map(PessoaDto::new).collect(Collectors.toList());
    }

    public Pessoa save(Pessoa pessoa) {
        this.verificarCampos(pessoa);
        return this.pessoaRepository.save(pessoa);
    }

    private void verificarCampos(Pessoa pessoa) {
        if(Objects.isNull(pessoa.getDataCadastro())){
            pessoa.setDataCadastroAtual(LocalDateTime.now());
        }
    }

    @Transactional
    public void delete(Long id) {
        this.verificarProcessos(id);
        this.pessoaRepository.deleteById(id);
    }

    private void verificarProcessos(Long id) {
        if(this.verificarDelete(id)){
            this.processoRepository.deleteAllByPessoaId(id);
        }
    }


    public Optional<Pessoa> getPorId(Long id){
        return pessoaRepository.findById(id);
    }

    public Boolean verificarDelete(Long id) {
        return this.pessoaRepository.findProcessosByPessoa(id);
    }
}
