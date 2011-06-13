/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpi.util;

import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author lucasaquiles
 */
public class DateFormatUtil {


    public static String dateToString(Date date){

        String formatedDate = DateFormat.getInstance().format(date.getTime());
        return formatedDate;
    }

    public static GregorianCalendar stringToDate(String date){

        GregorianCalendar gc = new GregorianCalendar();
        
        try{
            
            gc.setTime(DateFormat.getInstance().parse(date));
            
        }catch(Exception e){
            System.out.println("exception: "+e);
        }

        return gc;
    }

    
}
