/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpi.factory;

import br.edu.ifpi.dao.CategoriaDao;
import br.edu.ifpi.dao.CompromissoDao;
import br.edu.ifpi.dao.ContatoDao;
import br.edu.ifpi.dao.GrupoDao;
import br.edu.ifpi.dao.UsuarioDao;
import br.edu.ifpi.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author lucasaquiles
 */
public class DaoFactory {

    private Session session;

    public DaoFactory() {
        this.session = HibernateUtil.getSession();
    }

    public UsuarioDao buildUsuarioDao() {
        return new UsuarioDao(session);
    }

    public ContatoDao buildContatoDao() {
        return new ContatoDao(session);
    }

    public CategoriaDao buildCateoriaDao() {
        return new CategoriaDao(session);
    }

    public CompromissoDao buildCompromissoDao() {
        return new CompromissoDao(session);
    }

    public GrupoDao buildGrupoDao() {
        return new GrupoDao(session);
    }
}
