package br.com.agenda.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/*
 * FELIPE CAMPOS
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "Amigo.listar", query = "SELECT amigo FROM Amigo amigo"),
		@NamedQuery(name = "Amigo.buscarPorId", query = "SELECT amigo FROM Amigo amigo WHERE id = :id") })
public class Amigo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "amigo_id")
	private long id;

	@NotEmpty(message = "O campo Nome não pode ser vazio")
	@Size(min = 2, max = 50, message = "O campo Nome precisa conter entre 2 e 50 caracteres")
	@Column(name = "amigo_nome", length = 50, nullable = false)
	private String nome;
	
	@Email(message = "E-mail invalido")
	@Length(max = 50, message = "O E-mail não pode conter mais que 50 caracteres")
	@Column(name = "amigo_email", length = 50, nullable = false)
	private String email;
	
	@NotEmpty(message = "O campo Telefone não pode ser vazio")
	@Size(min = 5, max = 50, message = "O campo Telefone precisa conter entre 5 e 50 caracteres")
	@Column(name = "amigo_telefone", length = 50, nullable = false)
	private String telefone;
	
	@Length(max = 50, message = "O campo Empresa não pode conter mais que 50 caracteres")
	@Column(name = "amigo_empresa", length = 50)
	private String empresa;
	
	@NotEmpty(message = "O campo Pessoa não pode ser vazio")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pessoa_pessoa_id", referencedColumnName = "pessoa_id")
	private Pessoa pessoa;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Amigo [id=" + id + ", nome=" + nome + ", email=" + email
				+ ", telefone=" + telefone + ", empresa=" + empresa
				+ ", pessoa=" + pessoa + "]";
	}

}
