package classesf; /**
 * Created by Home on 21.11.2016.
 */
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class DateHelper {
    private Calendar calendar;
    private Date battle_beginning;

    public String getFormattedStartDate(){
        calendar = new GregorianCalendar();
        calendar.add(Calendar.YEAR, -1500);
        battle_beginning = calendar.getTime();
        Date date = calendar.getTime();
        SimpleDateFormat format1 = new SimpleDateFormat("dd MMMM yyy года G HH:mm z");
        String formatted_date = format1.format(date)+"\n";
        return formatted_date;
    }

    public void skipTime(){
        calendar.add(Calendar.MINUTE, 45);
    }

    public String getFormattedDiff(){
        Date current_date = calendar.getTime();
        long diff = current_date.getTime() - battle_beginning.getTime();
        long hours = TimeUnit.MILLISECONDS.toHours(diff);
        diff -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(diff);
        if(hours%10==1) return String.format("%h час %d минут", hours, minutes);
        if((hours%10==2) || (hours%10==3) || (hours%10==4)) return String.format("%h часа %d минут", hours, minutes);
        return String.format("Сражение длилось %h часов %d минут", hours, minutes);
    }
}
