/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpi.dao;

import br.edu.ifpi.beans.Categoria;
import java.util.ArrayList;
import org.hibernate.Session;

/**
 *
 * @author lucasaquiles
 */
public class CategoriaDao implements Dao<Categoria> {

     private Session session;

    public CategoriaDao(Session session) {
        this.session = session;
    }



    public void save(Categoria object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(Categoria object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void remove(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<Categoria> list() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
