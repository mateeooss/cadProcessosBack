package com.matheuslima.cadprocessos.processo.api;

import com.matheuslima.cadprocessos.processo.Processo;
import com.matheuslima.cadprocessos.processo.dto.ProcessoDTO;
import com.matheuslima.cadprocessos.processo.service.ProcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/processo")
public class ProcessoAPI {

    @Autowired
    ProcessoService processoService;

    @GetMapping()
    public List<ProcessoDTO> getAll(@RequestParam(name = "search") String search){
        return processoService.getAll(search);
    }

    @Transactional
    @PostMapping()
    public Processo save(@RequestBody Processo processo){
        return this.processoService.save(processo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        this.processoService.delete(id);
    }
}
