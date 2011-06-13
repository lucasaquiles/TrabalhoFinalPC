/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpi.dao;

import br.edu.ifpi.beans.Grupo;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

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

        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    public void update(Grupo object) {
       session.beginTransaction();
        session.merge(object);
        session.getTransaction().commit();
    }

    public Grupo getById(long id){

        Grupo g = null;

        g = (Grupo) session.load(Grupo.class, id);

        return g;
    }


    public void remove(long id) {

        Grupo g = (Grupo) session.load(Grupo.class, id);

        try{

            session.beginTransaction();
            session.delete(g);
            session.getTransaction().commit();
            
        }catch(Exception e){
            try {
                
                throw new Exception("usuário não existe para id: " + id);

            } catch (Exception ex) {

                Logger.getLogger(GrupoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ArrayList<Grupo> list() {

       ArrayList<Grupo> grupos = null;

        grupos = (ArrayList<Grupo>) session.createCriteria(Grupo.class).addOrder(Order.asc("nome")).list();

        return grupos;
    }

}
