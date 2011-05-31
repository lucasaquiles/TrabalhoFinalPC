/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpi.dao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucasaquiles
 */
public interface Dao<T> {

    public void save(T object);
    public void update(T object);
    public void remove(long id);
    public ArrayList<T> list();
    
}
