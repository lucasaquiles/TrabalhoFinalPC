/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpi.util;

import br.edu.ifpi.beans.Categoria;
import br.edu.ifpi.beans.Grupo;
import br.edu.ifpi.dao.CategoriaDao;
import br.edu.ifpi.dao.GrupoDao;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author lucasaquiles
 */
public class ComboboxUtil {

    public static DefaultComboBoxModel mountComboboxGrupos(DefaultComboBoxModel comboBoxModel, GrupoDao grupoDao){

        comboBoxModel.removeAllElements();

        ArrayList<Grupo> grupos = grupoDao.list();

        if (grupos != null && grupos.size() > 0) {
            System.out.println("Uhuuu! "+grupos.size()+" grupos");

            for (Grupo g : grupos) {
                System.out.println("pegou: "+g);
                comboBoxModel.addElement(g);
            }

        } else {
            comboBoxModel.addElement(new String("sem grupos"));
        }

        return comboBoxModel;
    }


    public static DefaultComboBoxModel mountComboBoxCategorias(DefaultComboBoxModel comboBoxModel, CategoriaDao categoriaDao){
        comboBoxModel.removeAllElements();
        ArrayList<Categoria> categorias = categoriaDao.list();

        if (categorias != null && categorias.size() > 0) {
            System.out.println("Uhuuu! "+categorias.size()+" Categorias");

            for (Categoria c : categorias) {
                System.out.println("pegou: "+c);
                comboBoxModel.addElement(c);
            }

        } else {
            System.out.println("nulo ou vazio! "+categorias.size()+" Categorias");
            
            comboBoxModel.addElement(new String("sem categorias"));
        }

        return comboBoxModel;
    }
}
