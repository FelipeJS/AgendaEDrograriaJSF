package br.com.agenda.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.agenda.dao.PessoaDao;
import br.com.agenda.domain.Pessoa;
import br.com.agenda.util.FacesUtil;

/*
 * FELIPE CAMPOS
 */

@ManagedBean
@ViewScoped
public class PessoaBean {
	private Pessoa pessoaCadastro;
	private List<Pessoa> listarPessoas;
	private List<Pessoa> listarPessoasFiltradas;

	private String acao;
	private Long id;

	public void salvar() {

		try {
			PessoaDao pessoaDao = new PessoaDao();
			pessoaDao.salvar(pessoaCadastro);
			pessoaCadastro = new Pessoa();

			FacesUtil.addMsgInfo("Amigo Cadastrado com Sucesso");
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Falha ao Cadastrar Amigo");
		}
	}

	public void carregarPesquisa() {
		try {
			PessoaDao pessoaDao = new PessoaDao();
			listarPessoas = pessoaDao.listar();
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Falha ao Listar Amigos");
		}
	}

	public void carregarCadastro() {
		try {
			if (id != null) {
				PessoaDao pessoaDao = new PessoaDao();
				pessoaCadastro = pessoaDao.buscarPorId(id);
			} else {
				pessoaCadastro = new Pessoa();
			}
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao Obter os Dados do Amigo");
		}
	}

	public void editar() {

		try {
			PessoaDao pessoaDao = new PessoaDao();
			pessoaDao.editar(pessoaCadastro);

			FacesUtil.addMsgInfo("Amigo Editado com Sucesso");
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Falha ao Editar Amigo");
		}
	}

	public void excluir() {
		try {
			PessoaDao pessoaDao = new PessoaDao();
			pessoaDao.excluir(pessoaCadastro);

			FacesUtil.addMsgInfo("Amigo Removido com Sucesso");
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Falha ao Remover Amigo");
		}
	}

	public Pessoa getPessoaCadastro() {
		return pessoaCadastro;
	}

	public void setPessoaCadastro(Pessoa pessoaCadastro) {
		this.pessoaCadastro = pessoaCadastro;
	}

	public List<Pessoa> getListarPessoas() {
		return listarPessoas;
	}

	public void setListarPessoas(List<Pessoa> listarPessoas) {
		this.listarPessoas = listarPessoas;
	}

	public List<Pessoa> getListarPessoasFiltradas() {
		return listarPessoasFiltradas;
	}

	public void setListarPessoasFiltradas(List<Pessoa> listarPessoasFiltradas) {
		this.listarPessoasFiltradas = listarPessoasFiltradas;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
