package br.gov.sp.fatec.Calculo_do_Km.repository;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.springframework.dao.DataIntegrityViolationException;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import br.gov.sp.fatec.Calculo_do_Km.entity.Formulario;
import br.gov.sp.fatec.Calculo_do_Km.entity.Usuario;
import br.gov.sp.fatec.Calculo_do_Km.repository.FormularioRepository;
import br.gov.sp.fatec.Calculo_do_Km.repository.UsuarioRepository;

@SpringBootTest
@Transactional
@Rollback
class FormularioTests {

	@Autowired
	FormularioRepository formRepo;

	@Autowired
	UsuarioRepository usuarioRepo; 


	@Test
	void contextLoads() {
	}

	// save
	@Test
    void testaCriacaoFormulario() {
		Usuario usuario = new Usuario();
		usuario.setNome("Lucas");
		usuario.setSenha("123");
		usuarioRepo.save(usuario);

		Formulario form = new Formulario();
		form.setUsuario(usuario);
		form.setModelo("renault kwid");
		form.setValorAutomovel(new BigDecimal("40000"));
		formRepo.save(form);

		assertEquals("renault kwid", form.getModelo());
		assertNotNull(form.getId());
	}	

	//buscar (id)
	@Test
	void TestaFindById() {
		Usuario usuario = usuarioRepo.findByNome("victor");

		Formulario form = new Formulario();
		form.setUsuario(usuario);
		form.setModelo("Gol G3");
		form.setValorAutomovel(new BigDecimal("30000"));
		formRepo.save(form);
		
		assertNotNull(formRepo.findById(form.getId()));
	}
	
	//delete
	@Test
    void testaDeleteFormulario() {
		Usuario usuario = usuarioRepo.findByNome("victor");

		Formulario form = new Formulario();
		form.setUsuario(usuario);
		form.setModelo("Gol G3");
		form.setValorAutomovel(new BigDecimal("30000"));
		formRepo.save(form);

		formRepo.deleteById(form.getId());
		Optional opt = formRepo.findById(form.getId());
		assertEquals(Optional.empty(),opt);
	}

	@Test
	public void testaDeleteFormulario2() {
		Usuario usuario = new Usuario();
		usuario.setNome("testando");
		usuario.setSenha("123");
		usuarioRepo.save(usuario);

		Formulario form = new Formulario();
		form.setUsuario(usuario);
		form.setModelo("test");
		form.setValorAutomovel(new BigDecimal("1000"));
		formRepo.save(form);

		formRepo.deleteById(form.getId());

		Optional optional = formRepo.findById(form.getId());
		assertTrue(optional.isEmpty());
	}
	
	// update
	@Test
	void testaAtualizacaoFormulario() {
		Usuario usuario = new Usuario();
		usuario.setNome("Joao");
		usuario.setSenha("123");
		usuarioRepo.save(usuario);

		Formulario form = new Formulario();
		form.setUsuario(usuario);
		form.setModelo("Honda Civic");
		form.setValorAutomovel(new BigDecimal("90000"));
		formRepo.save(form);

		Formulario form2 = formRepo.querybuscaFormularioPorId(form.getId());
		form2.setModelo("Fiat Palio");
		formRepo.save(form2);
		assertEquals("Fiat Palio",form.getModelo());
	}

	@Test
	void TesteUpdateDadosBanco()
	{
		Formulario form2 = new Formulario();
		form2.setId(1L);
		form2.setModelo("Fiat Palio");
		formRepo.save(form2);

		assertEquals("Fiat Palio", form2.getModelo());
	}

	// restrições (exceptions)
	

	// teste repository
	@Test
	void testaBuscaFormularioPorModeloQuery() {
		List<Formulario> formulario = formRepo.querybuscaFormularioPorModelo("Corolla");
		assertNotNull(formulario);
	}

	@Test
	void testaBuscaTodosFormularioPorUsuarioNomeQuery() {
		List<Formulario> formulario = formRepo.querybuscaTodosFormularioPorUsuarioNome("victor");
		assertNotNull(formulario);
	}

	// relacionamentos
	@Test
	void testaBuscaFormularioPorUsuarioNomeEValorQuery() {
		List<Formulario> formulario = formRepo.querybuscaFormularioPorUsuarioNomeEValor("hercules", new BigDecimal("5001"));
		assertTrue(formulario.isEmpty());
	}

	@Test
	void testaFormulario () {
		Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
			Formulario form = new Formulario();
			formRepo.save(form);
		});
	}

}
