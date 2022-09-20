package com.matheuslima.cadprocessos.pessoa;

import com.matheuslima.cadprocessos.pessoa.service.PessoaService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Objects;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class PessoaServiceTest {

    @Autowired
    PessoaService pessoaService;

    @Test
    public void persistirPessoa(){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("teste");
        pessoa.setCpf("teste");
        Pessoa pessoaReturn = pessoaService.save(pessoa);
        Assert.assertEquals(true, Objects.nonNull(pessoaReturn.getId()));
        pessoaService.delete(pessoaReturn.getId());
        Assert.assertEquals(true, pessoaService.getPorId(pessoaReturn.getId()).isEmpty());
    }
}
