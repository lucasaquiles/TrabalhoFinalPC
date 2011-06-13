/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpi.util;

import br.edu.ifpi.beans.Contato;
import br.edu.ifpi.beans.Grupo;
import br.edu.ifpi.beans.Usuario;
import br.edu.ifpi.dao.ContatoDao;
import br.edu.ifpi.dao.GrupoDao;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author lucasaquiles
 */
public class TableUtil {

    public static DefaultTableModel mountTableContatos(DefaultTableModel defaultTableModel, ContatoDao contatoDao) {

        Vector v;

        if (contatoDao.list().size() > 0) {
            for (Contato c : contatoDao.list()) {
                v = new Vector();

                v.add(c);
                defaultTableModel.addRow(v);
            }
        }

        return defaultTableModel;

    }

    public static DefaultTableModel mountTableContatosUsuario(DefaultTableModel defaultTableModel, Usuario u) {

        Vector v;

        if (u.getContatos().size() > 0) {

            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            for (Contato c : u.getContatos()) {
                v = new Vector();

                v.add(c);
                v.add(c.getEmail());
                v.add(c.getTelefone());

                if (c.getDataNascimento() != null) {

                    v.add(DateFormat.getInstance().format(c.getDataNascimento().getTime()));
                } else {

                    v.add(null);
                }

                if (c.getEndereco() != null) {

                    v.add(c.getEndereco().getNome());
                } else {

                    v.add(null);
                }


                if (c.getGrupos().size() > 0 && c.getGrupos() != null) {

                    String grupos = "";

                    for (Grupo g : c.getGrupos()) {

                        System.out.println("adicionou: " + g.getNome());

                        grupos += g.getNome();
                    }

                    v.add(grupos);
                } else {
                    v.add(null);
                }

                defaultTableModel.addRow(v);
            }
        }

        return defaultTableModel;
    }

    public static DefaultTableModel mountTableGrupos(DefaultTableModel model, GrupoDao gDao) {

        //Vector v = null;

        if (gDao.list().size() > 0) {

            for (Grupo g : gDao.list()) {

                Vector v = new Vector();

                v.add(g);

                model.addRow(v);

                v = null;
            }

        } else {
            Vector v = new Vector();

            Contato c = null;
            v.add(c);
        }
        
        return model;
    }
}
