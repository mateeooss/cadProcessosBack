package com.matheuslima.cadprocessos.processo.service;

import com.matheuslima.cadprocessos.processo.Processo;
import com.matheuslima.cadprocessos.processo.dto.ProcessoDTO;
import com.matheuslima.cadprocessos.processo.repository.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProcessoService {
    @Autowired
    ProcessoRepository processoRepository;

    public List<ProcessoDTO> getAll(String search){
        search = Objects.isNull(search) ? "%%" : "%"+search+"%";

        return processoRepository.getAll(search).stream().map(ProcessoDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public Processo save(Processo processo) {
        this.verificarCampos(processo);
        return this.processoRepository.save(processo);
    }

    public void delete(Long id) {
        this.processoRepository.deleteById(id);
    }

    public Optional<Processo> getPorId(Long id){
        return processoRepository.findById(id);
    }

    private void verificarCampos(Processo processo) {
        if(Objects.isNull(processo.getDataCadastro())){
            processo.setDataCadastroAtual(LocalDateTime.now());
        }
    }
}
