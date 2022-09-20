package com.matheuslima.cadprocessos.processo;

import com.matheuslima.cadprocessos.pessoa.Pessoa;
import com.matheuslima.cadprocessos.processo.service.ProcessoService;
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
public class ProcessoServiceTest {
    @Autowired
    ProcessoService processoService;

    @Test
    public void persistirProcesso(){
        Processo processo = new Processo();
        processo.setDescricao("teste");
        Processo processoReturn = processoService.save(processo);
        Assert.assertEquals(true, Objects.nonNull(processoReturn.getId()));
        processoService.delete(processoReturn.getId());
        Assert.assertEquals(true, processoService.getPorId(processoReturn.getId()).isEmpty());
    }
}
