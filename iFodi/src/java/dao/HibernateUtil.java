/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/**
 *
 * @author Jessica
 */
public class HibernateUtil {

    private static SessionFactory Sessoes = criarSessoes();

    public static SessionFactory getSessoes() {
        return Sessoes;
    }

    private static SessionFactory criarSessoes() {
        try {
            Configuration configuracao = new Configuration().configure();

            ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();

            SessionFactory sessao = configuracao.buildSessionFactory(registro);

            return sessao;
        } catch (Throwable ex) {
            System.err.println("Sessões não pode ser criada." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

}
