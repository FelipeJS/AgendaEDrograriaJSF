package br.com.agenda.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.agenda.dao.PessoaDao;
import br.com.agenda.domain.Pessoa;

/*
 * FELIPE CAMPOS
 */

public class PessoaDaoTest {

	@Test
	@Ignore
	public void salvar() {
		Pessoa p1 = new Pessoa();
		p1.setNome("Joao");
		p1.setEmail("Jao");
		p1.setTelefone("Jao");

		Pessoa p2 = new Pessoa();
		p2.setNome("Felipe");
		p2.setEmail("Felipe");
		p2.setTelefone("Felipe");

		PessoaDao dao = new PessoaDao();

		dao.salvar(p1);
		dao.salvar(p2);
	}

	@Test
	@Ignore
	public void listar() {
		PessoaDao dao = new PessoaDao();
		List<Pessoa> pessoas = dao.listar();

		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
		}
	}

	@Test
	@Ignore
	public void buscarPorId() {
		PessoaDao dao = new PessoaDao();

		Pessoa p1 = dao.buscarPorId(3L);
		Pessoa p2 = dao.buscarPorId(7L);

		System.out.println(p1);
		System.out.println(p2);
	}

	@Test
	@Ignore
	public void exlcuir() {
		PessoaDao dao = new PessoaDao();
		Pessoa pessoa = dao.buscarPorId(4L);
		dao.excluir(pessoa);
	}

	@Test
	@Ignore
	public void editar() {
		PessoaDao dao = new PessoaDao();
		Pessoa pessoa = dao.buscarPorId(5L);
		pessoa.setNome("Jorge");
		pessoa.setEmail("Teste@teste");
		pessoa.setTelefone("5555");
		pessoa.setEmpresa("Canvas");

		dao.editar(pessoa);
	}
}
