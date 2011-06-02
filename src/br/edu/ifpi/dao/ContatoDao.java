/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpi.dao;

import br.edu.ifpi.beans.Contato;
import java.util.ArrayList;
import org.hibernate.Session;

/**
 *
 * @author lucasaquiles
 */
public class ContatoDao implements Dao<Contato>{

     private Session session;

    public ContatoDao(Session session) {
        this.session = session;
    }

    public void save(Contato object) {

        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    public void update(Contato object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void remove(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<Contato> list() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
