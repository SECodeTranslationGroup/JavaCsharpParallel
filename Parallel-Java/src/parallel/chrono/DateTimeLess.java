package parallel.chrono;

import java.time.LocalDateTime;

public class DateTimeLess {
    //reuse
    // True if time1 is before time2
    public boolean timeLess(LocalDateTime time1, LocalDateTime time2){
        return time1.isBefore(time2);
    }

    public boolean yearLess(LocalDateTime time1, LocalDateTime time2){
        return time1.getYear() < time2.getYear();
    }

    public boolean monthLess(LocalDateTime time1, LocalDateTime time2){
        return time1.getMonth().getValue() < time2.getMonth().getValue();
    }

    public boolean dayOfMonthLess(LocalDateTime time1, LocalDateTime time2){
        return time1.getDayOfMonth() < time2.getDayOfMonth();
    }

    public boolean dayOfWeekLess(LocalDateTime time1, LocalDateTime time2){
        return time1.getDayOfWeek().getValue() < time2.getDayOfWeek().getValue();
    }

    public boolean hourLess(LocalDateTime time1, LocalDateTime time2){
        return time1.getHour() < time2.getHour();
    }

    public boolean minuteLess(LocalDateTime time1, LocalDateTime time2){
        return time1.getMinute() < time2.getMinute();
    }

    public boolean secondLess(LocalDateTime time1, LocalDateTime time2){
        return time1.getSecond() < time2.getSecond();
    }
    // reuse end
}
