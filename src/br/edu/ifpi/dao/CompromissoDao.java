/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpi.dao;

import br.edu.ifpi.beans.Compromisso;
import java.util.ArrayList;
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
        throw new UnsupportedOperationException("Not supported yet.");
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
