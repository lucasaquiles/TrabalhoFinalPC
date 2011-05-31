/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpi.database;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author lucasaquiles
 */
public class CreateSchema {

    public static void main(String[] args) {

        Configuration conf = new AnnotationConfiguration();
        conf.configure();

        SchemaExport ex = new SchemaExport(conf);
        ex.create(true, true);
    }
}
