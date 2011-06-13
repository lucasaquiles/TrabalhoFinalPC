/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpi.dao;

import br.edu.ifpi.beans.Contato;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author lucasaquiles
 */
public class ContatoDao implements Dao<Contato>{

     private Session session;

    public ContatoDao(Session session) {
        this.session = session;
    }

    public Contato getById(long id){

        Contato c = null;

        try{

            c = (Contato) session.load(Contato.class, id);
        }catch(Exception e){

        }

        return c;
    }
    public void save(Contato object) {

        session.beginTransaction();
        session.save(object);
        session.flush();
        session.getTransaction().commit();
        
    }

    public void update(Contato object) {
         session.beginTransaction();
        session.merge(object);
        //session.flush();
        session.getTransaction().commit();
    }

    public void remove(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<Contato> list() {


        ArrayList<Contato> contatos = null;

        contatos = (ArrayList<Contato>) session.createCriteria(Contato.class).addOrder(Order.asc("nome")).list();

        return contatos;
    }

}
