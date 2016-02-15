package br.com.agenda.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.agenda.domain.Pessoa;
import br.com.agenda.util.HibernateUtil;

/*
 * FELIPE CAMPOS
 */

public class PessoaDao {

	public void salvar(Pessoa pessoa) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = sessao.beginTransaction();
			sessao.save(pessoa);
			transaction.commit();
		} catch (RuntimeException ex) {
			if (transaction != null)
				transaction.rollback();
			throw ex;
		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> listar() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Pessoa> pessoa = null;

		try {
			Query consulta = session.getNamedQuery("Pessoa.listar");
			pessoa = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return pessoa;
	}

	public Pessoa buscarPorId(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Pessoa pessoa = null;

		try {
			Query consulta = session.getNamedQuery("Pessoa.buscarPorId");
			consulta.setLong("id", id);

			pessoa = (Pessoa) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return pessoa;
	}

	public void excluir(Pessoa pessoa) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = sessao.beginTransaction();
			sessao.delete(pessoa);
			transaction.commit();
		} catch (RuntimeException ex) {
			if (transaction != null)
				transaction.rollback();
			throw ex;
		} finally {
			sessao.close();
		}
	}

	public void editar(Pessoa pessoa) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = sessao.beginTransaction();
			sessao.update(pessoa);
			transaction.commit();
		} catch (RuntimeException ex) {
			if (transaction != null)
				transaction.rollback();
			throw ex;
		} finally {
			sessao.close();
		}
	}
}
