/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpi.dao;

import br.edu.ifpi.beans.Usuario;
import java.util.ArrayList;
import org.hibernate.Session;

/**
 *
 * @author lucasaquiles
 */
public class UsuarioDao implements Dao<Usuario>{

    Session session;

    public UsuarioDao(Session session){
        this.session = session;
    }

    public void save(Usuario object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(Usuario object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void remove(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
    public ArrayList<Usuario> list() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
}
