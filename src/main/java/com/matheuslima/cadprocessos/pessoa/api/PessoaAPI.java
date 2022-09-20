package com.matheuslima.cadprocessos.pessoa.api;

import com.matheuslima.cadprocessos.pessoa.Pessoa;
import com.matheuslima.cadprocessos.pessoa.dto.PessoaDto;
import com.matheuslima.cadprocessos.pessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/pessoa")
public class PessoaAPI {

    @Autowired
    PessoaService pessoaService;

    @GetMapping()
    public List<PessoaDto> getAll(@RequestParam(name = "search") String search){
        return pessoaService.getAll(search);
    }

    @PostMapping()
    public Pessoa save(@RequestBody Pessoa pessoa){
        return this.pessoaService.save(pessoa);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        this.pessoaService.delete(id);
    }
}
