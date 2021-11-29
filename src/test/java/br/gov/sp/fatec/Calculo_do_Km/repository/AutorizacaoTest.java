package br.gov.sp.fatec.Calculo_do_Km.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.Calculo_do_Km.entity.Autorizacao;
import br.gov.sp.fatec.Calculo_do_Km.entity.Usuario;
import br.gov.sp.fatec.Calculo_do_Km.repository.AutorizacaoRepository;
import br.gov.sp.fatec.Calculo_do_Km.repository.UsuarioRepository;

@SpringBootTest
@Transactional
@Rollback
class AutorizacaoTest {

	@Autowired
    private AutorizacaoRepository autRepo;

	@Autowired
    private UsuarioRepository userRepo;

	@Test
	void contextLoads() {
	}

	/*Testando a classe de autorizacao*/

	/*save*/

	@Test
	void TestaInsercaoAutorizacao()
	{
		Autorizacao aut = new Autorizacao();
		aut.setNome("ROLE_TESTER");
		autRepo.save(aut);
		assertNotNull(aut.getId());
	}

	/*delete*/

	@Test
	void TesteAutorizacaoDelete()
	{
		Autorizacao aut = new Autorizacao();
		aut.setNome("ROLE_TESTER");
		autRepo.save(aut);

		autRepo.deleteById(aut.getId());
		Optional opt = autRepo.findById(aut.getId());
		assertEquals(Optional.empty(),opt);
	}

	/*update*/

	@Test
	void TesteAutorizacaoUpdate()
	{
		Autorizacao aut = autRepo.findByNome("ROLE_ADMIN");
		aut.setNome("ROLE_TESTER");
		autRepo.save(aut);
		assertEquals("ROLE_TESTER",aut.getNome());
	}

	/*buscar(id)*/

	@Test
	void TesteFindById()
	{
		Autorizacao aut = new Autorizacao();
		aut.setNome("ROLE_TESTER");
		autRepo.save(aut);
		assertNotNull(autRepo.findById(aut.getId()));
	}

	@Test
	void TesteAutorizacaobuscaId()
	{
		Autorizacao aut = new Autorizacao();
		aut.setNome("ROLE_TESTER");
		autRepo.save(aut);

		Autorizacao aut2 = autRepo.findById(aut.getId()).get();
		assertNotNull(aut2);
	}

	@Test
	void TesteAutorizacaoNomebuscaId()
	{
		Autorizacao aut = new Autorizacao();
		aut.setNome("ROLE_TESTER");
		autRepo.save(aut);

		Autorizacao aut2 = autRepo.findById(aut.getId()).get();
		assertEquals("ROLE_TESTER",aut2.getNome());
	}

	@Test
	void TesteQuerybuscaAutorizacaoTodosSet()
	{
		Autorizacao aut = new Autorizacao();
		aut.setNome("ROLE_TESTER");
		autRepo.save(aut);

		Set<Autorizacao> aut2 = autRepo.QuerybuscaAutorizacaoTodos();
		assertFalse(aut2.isEmpty());
	}
	/*restrições (exceptions)*/
	/**Nome de autorizacao unique */

	/*relacionamentos*/

	/**Relacionamento N:N entre Autorizacao e Usuario */
	@Test
	void TesteAutorizacaoNparaNUsuario()
	{
		Autorizacao aut = new Autorizacao();
		aut.setNome("ROLE_TESTER");
		autRepo.save(aut);

		Usuario user = new Usuario();
		user.setNome("NomeUser");
		user.setSenha("SenhaUser");
		user.setAutorizacoes(new HashSet<Autorizacao>());
		user.getAutorizacoes().add(aut);
		userRepo.save(user);

		assertNotNull(user.getAutorizacoes().iterator().next().getId());
	}


	@Test
	void TesteAutorizacaoporUsuarioNome()
	{
		Usuario user = new Usuario();
		user.setNome("NomeUser");
		user.setSenha("SenhaUser");
		userRepo.save(user);

		Autorizacao aut = new Autorizacao();
		aut.setNome("ROLE_TESTER");
		aut.setUsuarios(new HashSet<Usuario>());
		aut.getUsuarios().add(user);
		autRepo.save(aut);

		assertNotNull(aut.getUsuarios().iterator().next().getId());

	}

	/*teste repository*/

	@Test
	void TesteFindByNome()
	{
		Autorizacao aut = new Autorizacao();
		aut.setNome("ROLE_TESTER");
		autRepo.save(aut);

		Autorizacao aut2 = autRepo.findByNome("ROLE_TESTER");
		assertEquals("ROLE_TESTER",aut2.getNome());
	}

	@Test
	void TesteQuerybuscaAutorizacaoNome()
	{
		Autorizacao aut = new Autorizacao();
		aut.setNome("ROLE_TESTER");
		autRepo.save(aut);

		Autorizacao aut2 = autRepo.QuerybuscaAutorizacaoNome("ROLE_TESTER");
		assertEquals("ROLE_TESTER",aut2.getNome());
		
	}

	/*@Test
	void testets()
	{
		Autorizacao aut2 = autRepo.QuerybuscaAutorizacaoNome("ROLE_ADMIN");
		assertEquals("ROLE_ADMIN",aut2.getNome());
	}*/

	@Test
	void TesteQuerybuscaAutorizacaoTodos()
	{
		Autorizacao aut = new Autorizacao();
		aut.setNome("ROLE_TESTER");
		autRepo.save(aut);

		Autorizacao aut2 = new Autorizacao();
		aut2.setNome("ROLE_TESTER2");
		autRepo.save(aut2);

		assertFalse(autRepo.QuerybuscaAutorizacaoTodos().isEmpty());
	}

	@Test
	void TesteQuerybuscaSetAutorizacaoTodos()
	{
		Autorizacao aut = new Autorizacao();
		aut.setNome("ROLE_TESTER");
		autRepo.save(aut);

		Autorizacao aut2 = new Autorizacao();
		aut2.setNome("ROLE_TESTER2");
		autRepo.save(aut2);

		Set <Autorizacao> auts = autRepo.QuerybuscaAutorizacaoTodos();
		assertFalse(auts.isEmpty());
	}

}