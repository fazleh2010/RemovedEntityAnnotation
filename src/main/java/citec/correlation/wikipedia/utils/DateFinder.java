/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citec.correlation.wikipedia.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *
 * @author elahi
 */
public class DateFinder {

    private static Integer findYear(String mystring) throws ParseException {
        Calendar mydate = new GregorianCalendar();
        Date thedate = new SimpleDateFormat("yyyy", Locale.ENGLISH).parse(mystring);
        mydate.setTime(thedate);
        /*System.out.println("mydate -> " + mydate);
        System.out.println("year   -> " + mydate.get(Calendar.YEAR));
        System.out.println("month  -> " + mydate.get(Calendar.MONTH));
        System.out.println("dom    -> " + mydate.get(Calendar.DAY_OF_MONTH));
        System.out.println("dow    -> " + mydate.get(Calendar.DAY_OF_WEEK));
        System.out.println("hour   -> " + mydate.get(Calendar.HOUR));
        System.out.println("minute -> " + mydate.get(Calendar.MINUTE));
        System.out.println("second -> " + mydate.get(Calendar.SECOND));
        System.out.println("milli  -> " + mydate.get(Calendar.MILLISECOND));
        System.out.println("ampm   -> " + mydate.get(Calendar.AM_PM));
        System.out.println("hod    -> " + mydate.get(Calendar.HOUR_OF_DAY));*/
        return mydate.get(Calendar.YEAR);
    }

}
