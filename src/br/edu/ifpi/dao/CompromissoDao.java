/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpi.dao;

import br.edu.ifpi.beans.Compromisso;
import br.edu.ifpi.beans.Usuario;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;

/**
 *
 * @author lucasaquiles
 */
public class CompromissoDao implements Dao<Compromisso> {

    private Session session;

    public CompromissoDao(Session session) {
        this.session = session;
    }

    public boolean disponiblidade(Usuario u, GregorianCalendar gc) {

        boolean estaDisponivel = false;

        if (u.getCompromissos().size() > 0) {

            for (Compromisso c : u.getCompromissos()) {

                if (c.getDataInicio().equals(gc)) {

                    estaDisponivel = false;

                    System.out.println("-------------------------------------------------------------");
                    System.out.println("não ta disponível");
                    System.out.println("-------------------------------------------------------------");
                }
            }
        } else {

            estaDisponivel = true;
        }

        return estaDisponivel;
    }

    public void save(Compromisso object) {

        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    public void update(Compromisso object) {

        try {

            for(Usuario u : object.getParticipantes()){

                if(disponiblidade(u, object.getDataInicio())){
       
                }
            }

            try {
                
                session.beginTransaction();
                session.merge(object);
                session.getTransaction().commit();
            } catch (Exception e) {

            }
        } catch (Exception e) {
        }
    }

    public Compromisso getById(long id) {

        Compromisso c = null;

        try {

            c = (Compromisso) session.load(Compromisso.class, id);
        } catch (Exception e) {
        }
        return c;
    }

    public void remove(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<Compromisso> list() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
