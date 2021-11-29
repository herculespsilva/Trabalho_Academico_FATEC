package br.gov.sp.fatec.Calculo_do_Km.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.Calculo_do_Km.entity.Usuario;

@SpringBootTest
@Transactional
@Rollback
public class SegurancaServiceTest {

    @Autowired
    private SegurancaService segServ;

    @Test
    void TestecadastroUsuario()
    {
        Usuario user = segServ.cadastroUsuario("NomeTest", "SenhaTest", "ROLE_TEST");
        assertNotNull(user.getId());
    }

}
