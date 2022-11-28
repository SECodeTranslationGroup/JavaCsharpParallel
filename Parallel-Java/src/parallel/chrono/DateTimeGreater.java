package parallel.chrono;

import java.time.LocalDateTime;
public class DateTimeGreater {
    //reuse
    // True if time1 is after time2
    public boolean timeGreater(LocalDateTime time1, LocalDateTime time2){
        return time1.isAfter(time2);
    }

    public boolean yearGreater(LocalDateTime time1, LocalDateTime time2){
        return time1.getYear() > time2.getYear();
    }

    public boolean monthGreater(LocalDateTime time1, LocalDateTime time2){
        return time1.getMonth().getValue() > time2.getMonth().getValue();
    }

    public boolean dayOfMonthGreater(LocalDateTime time1, LocalDateTime time2){
        return time1.getDayOfMonth() > time2.getDayOfMonth();
    }
    // Monday is 1 and Sunday is 7
    public boolean dayOfWeekGreater(LocalDateTime time1, LocalDateTime time2){
        return time1.getDayOfWeek().getValue() > time2.getDayOfWeek().getValue();
    }

    public boolean hourGreater(LocalDateTime time1, LocalDateTime time2){
        return time1.getHour() > time2.getHour();
    }

    public boolean minuteGreater(LocalDateTime time1, LocalDateTime time2){
        return time1.getMinute() > time2.getMinute();
    }

    public boolean secondGreater(LocalDateTime time1, LocalDateTime time2){
        return time1.getSecond() > time2.getSecond();
    }
    // reuse end

}
