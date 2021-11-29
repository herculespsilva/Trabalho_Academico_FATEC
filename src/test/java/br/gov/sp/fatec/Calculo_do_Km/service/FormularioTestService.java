package br.gov.sp.fatec.Calculo_do_Km.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import br.gov.sp.fatec.Calculo_do_Km.entity.Formulario;

@SpringBootTest
@Transactional
@Rollback
public class FormularioTestService {

    @Autowired
    private FormularioService formServ;

	@Test
	void contextLoads() {
	}

	@Test
    void testaBuscaFormularioPorId() {
		Formulario formulario = formServ.buscarFormularioPorId(1l);
		assertNotNull(formulario);
	}

	@Test
	void testaBuscarFormularioPorModelo() {
		List<Formulario> formulario = formServ.buscarFormularioPorModelo("fusca");
		assertTrue(formulario.isEmpty());
	}

	@Test
	void testaBuscaFormularioPorUsuarioNomeEValorSuperior() {
		List<Formulario> formulario = formServ.buscaFormularioPorUsuarioNomeEValorSuperior("fusca",new BigDecimal("10000"));
		assertTrue(formulario.isEmpty());
	}

    @Test
    void testaCriacaoFormulario() {
		Formulario formulario = formServ.criaFormulario ("Matheus", "123", "Ford Ka", new BigDecimal("40000"));
        assertNotNull(formulario);
	}	

	@Test
	void testaUpdateFormulario() {
		Formulario formulario = formServ.updateFormulario(2l, "Hilux", new BigDecimal("150000"));
		assertEquals("Hilux", formulario.getModelo());
	}

	@Test
	void testaDeleteFormulario() {
		Formulario formulario = formServ.criaFormulario ("Leandro", "123", "Fiat Siena", new BigDecimal("20000"));
		//formulario inserido no DDL
		formServ.deleteFormulario(formulario.getId());
		//verificando se o valor foi realmente deletado
		Formulario formDelete = formServ.buscarFormularioPorId(formulario.getId());
		assertNull(formDelete);
	}

	@Test
	void testaFormulario () {
		Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
			Formulario form = formServ.criaFormulario("", "", "", new BigDecimal(""));
		});
	}

}
