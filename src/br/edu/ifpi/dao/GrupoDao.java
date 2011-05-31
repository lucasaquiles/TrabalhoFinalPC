/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpi.dao;

import br.edu.ifpi.beans.Grupo;
import java.util.ArrayList;
import org.hibernate.Session;

/**
 *
 * @author lucasaquiles
 */
public class GrupoDao implements Dao<Grupo>{


    private Session session;

    public GrupoDao(Session session){
        this.session = session;
    }

    public void save(Grupo object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(Grupo object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void remove(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<Grupo> list() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
