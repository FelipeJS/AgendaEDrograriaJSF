package br.com.agenda.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.agenda.dao.AmigoDao;
import br.com.agenda.dao.PessoaDao;
import br.com.agenda.domain.Amigo;
import br.com.agenda.domain.Pessoa;

/*
 * FELIPE CAMPOS
 */

public class AmigoDaoTest {
	@Test
	@Ignore
	public void salvar() {
		PessoaDao pessoaDao = new PessoaDao();
		Pessoa pessoa = pessoaDao.buscarPorId(3L);

		Amigo amigo = new Amigo();
		amigo.setNome("Felipe");
		amigo.setEmail("Tecnologia");
		amigo.setTelefone("3542");
		amigo.setPessoa(pessoa);

		AmigoDao amigoDao = new AmigoDao();
		amigoDao.salvar(amigo);

	}

	@Test
	@Ignore
	public void buscarPorId() {
		AmigoDao amigoDao = new AmigoDao();
		Amigo amigo = amigoDao.buscarPorId(2L);

		System.out.println(amigo);
	}

	@Test
	@Ignore
	public void listar() {
		AmigoDao amigoDao = new AmigoDao();
		List<Amigo> amigos = amigoDao.listar();

		System.out.println(amigos);
	}

	@Test
	@Ignore
	public void excluir() {
		AmigoDao amigoDao = new AmigoDao();
		Amigo amigo = amigoDao.buscarPorId(3L);

		amigoDao.excluir(amigo);
	}
	
	@Test
	@Ignore
	public void editar() {
		AmigoDao amigoDao = new AmigoDao();
		Amigo amigo = amigoDao.buscarPorId(2L);
		
		amigo.setNome("Mudei d novo");
		
		PessoaDao pessoaDao = new PessoaDao();
		Pessoa pessoa = pessoaDao.buscarPorId(7L);
		amigo.setPessoa(pessoa);
		
		amigoDao.editar(amigo);
	}
	
	
}
