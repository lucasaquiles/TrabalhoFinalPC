/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpi.tests;

import br.edu.ifpi.jobs.AlertaCompromisso;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerUtils;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author lucasaquiles
 */
public class TestQuartz {

    public static void main(String[] args) {


        SchedulerFactory sf = new StdSchedulerFactory();
        try {

            Scheduler sched = sf.getScheduler();

            JobDetail job = new JobDetail("alerta_compromisso", "compromisso", AlertaCompromisso.class);

            
            Trigger t = TriggerUtils.makeDailyTrigger(2, 37);
            t.setName("oopa");
            sched.scheduleJob(job, t);

            sched.start();
        } catch (SchedulerException ex) {
            System.out.println("e: "+ex);
        }
    }
}
