package util;

/**
 *
 * @author Aimad.JAOUHAR
 */
import com.jfoenix.controls.JFXDatePicker;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static java.sql.Date getSqlDate(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

    public static Calendar dateToCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static Date calendarToDate(Calendar calendar) {
        return calendar.getTime();
    }

    public static String strDateDefaultPattern(Date date) {
        return formateDate(date, "dd/MM/yyyy");
    }

    public static String formateDate(Date date, String pattern) {
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }

    public static Date stringToDate(String strDate, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            return simpleDateFormat.parse(strDate);
        } catch (ParseException e) {
        }
        return null;
    }
    
    public static void javaUtilToFxDate(JFXDatePicker datePicker, Date date){
        datePicker.setValue(LocalDate.of(date.getYear(), date.getMonth(), date.getDate()));
    }
    
    public static void javaUtilToFxTime(JFXDatePicker timePicker, Date date){
        timePicker.setTime(LocalTime.of(date.getHours(), date.getMinutes()));
    }
    
    public static Date fxDateTimeToJava(JFXDatePicker date, JFXDatePicker time){
        Date newDate = new Date();
        newDate.setDate(date.getValue().getDayOfMonth());
        newDate.setMonth(date.getValue().getMonthValue());
        newDate.setYear(date.getValue().getYear());
        newDate.setHours(time.getTime().getHour());
        newDate.setMinutes(time.getTime().getMinute());
        newDate.setSeconds(time.getTime().getSecond());
        return newDate;
    }
}
