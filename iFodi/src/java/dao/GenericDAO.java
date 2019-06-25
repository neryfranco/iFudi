/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class GenericDAO<Entidade> {

    private Class<Entidade> classe;

    public void save(Entidade entidade) {
        Session sessao = HibernateUtil.getSessoes().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.save(entidade);
            transacao.commit();
        } catch (RuntimeException erro) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw erro;
        } finally {
            sessao.close();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Entidade> listar() {
        Session sessao = HibernateUtil.getSessoes().openSession();
        try {
            Criteria consulta = sessao.createCriteria(classe);
            List<Entidade> resultado = consulta.list();
            return resultado;
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }

    @SuppressWarnings("unchecked")
    public Entidade buscar(Integer id) {
        Session sessao = HibernateUtil.getSessoes().openSession();
        try {
            Criteria consulta = sessao.createCriteria(classe);
            consulta.add(Restrictions.idEq(id));
            Entidade resultado = (Entidade) consulta.uniqueResult();
            return resultado;
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }

    public void delete(Entidade entidade) {
        Session sessao = HibernateUtil.getSessoes().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.delete(entidade);
            transacao.commit();
        } catch (RuntimeException erro) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw erro;
        } finally {
            sessao.close();
        }
    }

}
