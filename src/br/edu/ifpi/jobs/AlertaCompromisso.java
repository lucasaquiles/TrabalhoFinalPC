/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpi.jobs;

import javax.swing.JOptionPane;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author lucasaquiles
 */
public class AlertaCompromisso implements Job{

    public void execute(JobExecutionContext jec) throws JobExecutionException {
       JOptionPane.showMessageDialog(null, "OOOpa!");
    }

}
