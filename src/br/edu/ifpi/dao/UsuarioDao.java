/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpi.dao;

import br.edu.ifpi.beans.Usuario;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

/**
 *
 * @author lucasaquiles
 */
public class UsuarioDao implements Dao<Usuario> {

    Session session;

    public UsuarioDao(Session session) {
        this.session = session;
    }

    public Usuario autentica(String login, String senha) {


        Usuario u = null;

        try {

            u = (Usuario) session.createQuery("from Usuario where username = :login and password = :senha ").setParameter("login", login).setParameter("senha", senha).uniqueResult();

        } catch (NullPointerException e) {
        }

        return u;
    }

    public void save(Usuario object) {

        session.beginTransaction();

        session.save(object);
        session.getTransaction().commit();
    }

    public void update(Usuario object) {
        session.beginTransaction();
        session.merge(object);
        session.getTransaction().commit();
    }

    public void remove(long id) {

        Usuario u = (Usuario) session.createCriteria(Usuario.class).add(Expression.idEq(id)).uniqueResult();

        try {

            session.beginTransaction();
            session.delete(u);
            session.getTransaction().commit();

            System.out.println("----- usuário removido");
        } catch (Exception e) {

            System.out.println("----- usuário inválido!");
        }

    }


    public ArrayList<Usuario> list() {
        ArrayList<Usuario> usuarioList = null;


        usuarioList = (ArrayList<Usuario>) session.createCriteria(Usuario.class).addOrder(Order.asc("username")).list();

        return usuarioList;
    }
}
