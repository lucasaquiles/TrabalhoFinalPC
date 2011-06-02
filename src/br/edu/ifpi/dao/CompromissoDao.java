/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpi.dao;

import br.edu.ifpi.beans.Compromisso;
import br.edu.ifpi.beans.Usuario;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;

/**
 *
 * @author lucasaquiles
 */
public class CompromissoDao implements Dao<Compromisso>{
 private Session session;

    public CompromissoDao(Session session) {
        this.session = session;
    }

 
    public void save(Compromisso object) {

        

        // verificar se o usuário está com horário disponível para aquela reunião

        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    public void update(Compromisso object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void remove(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<Compromisso> list() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
