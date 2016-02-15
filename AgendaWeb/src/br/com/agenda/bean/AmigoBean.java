package br.com.agenda.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.agenda.dao.AmigoDao;
import br.com.agenda.domain.Amigo;
import br.com.agenda.util.FacesUtil;

/*
 * FELIPE CAMPOS
 */

@ManagedBean
@ViewScoped
public class AmigoBean {
	private Amigo amigoCadastro;
	private List<Amigo> listarAmigos;
	private List<Amigo> listarAmigosFiltradas;

	private String acao;
	private Long id;

	public void salvar() {

		try {
			AmigoDao amigoDao = new AmigoDao();
			amigoDao.salvar(amigoCadastro);
			amigoCadastro = new Amigo();

			FacesUtil.addMsgInfo("Amigo Cadastrado com Sucesso");
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Falha ao Cadastrar Amigo");
		}
	}

	public void carregarPesquisa() {
		try {
			AmigoDao amigoDao = new AmigoDao();
			listarAmigos = amigoDao.listar();
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Falha ao Listar Amigos");
		}
	}

	public void carregarCadastro() {
		try {
			if (id != null) {
				AmigoDao amigoDao = new AmigoDao();
				amigoCadastro = amigoDao.buscarPorId(id);
			} else {
				amigoCadastro = new Amigo();
			}
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao Obter os Dados do Amigo");
		}
	}

	public void editar() {

		try {
			AmigoDao amigoDao = new AmigoDao();
			amigoDao.editar(amigoCadastro);

			FacesUtil.addMsgInfo("Amigo Editado com Sucesso");
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Falha ao Editar Amigo");
		}
	}

	public void excluir() {
		try {
			AmigoDao amigoDao = new AmigoDao();
			amigoDao.excluir(amigoCadastro);

			FacesUtil.addMsgInfo("Amigo Removido com Sucesso");
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Falha ao Remover Amigo");
		}
	}

	public Amigo getAmigoCadastro() {
		return amigoCadastro;
	}

	public void setAmigoCadastro(Amigo amigoCadastro) {
		this.amigoCadastro = amigoCadastro;
	}

	public List<Amigo> getListarAmigos() {
		return listarAmigos;
	}

	public void setListarAmigos(List<Amigo> listarAmigos) {
		this.listarAmigos = listarAmigos;
	}

	public List<Amigo> getListarAmigosFiltradas() {
		return listarAmigosFiltradas;
	}

	public void setListarAmigosFiltradas(List<Amigo> listarAmigosFiltradas) {
		this.listarAmigosFiltradas = listarAmigosFiltradas;
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
