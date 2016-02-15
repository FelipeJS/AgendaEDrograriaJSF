package br.com.agenda.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.agenda.domain.Amigo;
import br.com.agenda.util.HibernateUtil;

/*
 * FELIPE CAMPOS
 */

public class AmigoDao {

	public void salvar(Amigo amigo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(amigo);
			transaction.commit();
		} catch (RuntimeException ex) {
			if (transaction != null)
				transaction.rollback();
			throw ex;
		} finally {
			session.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Amigo> listar() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Amigo> amigos = null;

		try {
			Query consulta = session.getNamedQuery("Amigo.listar");
			amigos = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return amigos;
	}

	public Amigo buscarPorId(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Amigo amigo = null;

		try {
			Query consulta = session.getNamedQuery("Amigo.buscarPorId");
			consulta.setLong("id", id);

			amigo = (Amigo) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return amigo;
	}

	public void excluir(Amigo amigo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.delete(amigo);
			transaction.commit();
		} catch (RuntimeException ex) {
			if (transaction != null)
				transaction.rollback();
			throw ex;
		} finally {
			session.close();
		}

	}

	public void editar(Amigo amigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = sessao.beginTransaction();
			sessao.update(amigo);
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
