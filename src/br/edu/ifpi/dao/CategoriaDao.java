/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpi.dao;

import br.edu.ifpi.beans.Categoria;
import br.edu.ifpi.beans.Compromisso;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

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

        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    public void update(Categoria object) {
        session.beginTransaction();
        session.merge(object);
        session.getTransaction().commit();
    }

    public boolean updateReferences(long id) {

        boolean isValid = false;

        try {
            ArrayList<Compromisso> compromissos = (ArrayList<Compromisso>) session.createQuery("from Compromisso where categoria_id = :categoria_id").setParameter("categoria_id", id).list();

            for (Compromisso c : compromissos) {

                c.setCategoria(null);

                session.beginTransaction();
                session.merge(c);
                session.getTransaction().commit();

                isValid = true;
            }


        } catch (Exception e) {
             System.out.println("atualizando referencias - Exception e: "+e);
            session.getTransaction().rollback();
        }

        return isValid;
    }

    public void remove(long id) {

        Categoria c = (Categoria) session.load(Categoria.class, id);

        try {

            if (updateReferences(id)) {
                
                session.beginTransaction();
                session.delete(c);
                session.getTransaction().commit();
            }
            
        } catch (Exception e) {
            System.out.println("Exception e: "+e);
        }

    }

    public ArrayList<Categoria> list() {

        ArrayList<Categoria> categorias = null;

        categorias = (ArrayList<Categoria>) session.createCriteria(Categoria.class).addOrder(Order.asc("nome")).list();





        return categorias;
    }
}
