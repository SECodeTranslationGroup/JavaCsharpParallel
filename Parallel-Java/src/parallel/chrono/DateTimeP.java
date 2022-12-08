package parallel.chrono;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class DateTimeP {
    public LocalDateTime getCurrentTime(){
        return LocalDateTime.now();
    }

    public LocalDateTime getTime(int year, int month, int dayOfMonth,
                                 int hour, int minute, int second){
        LocalDateTime time = LocalDateTime.of(
                year, month, dayOfMonth,
                hour, minute, second);
        return time;
    }

    //reuse
    public boolean timeEqual(LocalDateTime time1, LocalDateTime time2){
        return time1.isEqual(time2);
    }

    public boolean yearEqual(LocalDateTime time1, LocalDateTime time2){
        return time1.getYear() == time2.getYear();
    }

    public boolean monthEqual(LocalDateTime time1, LocalDateTime time2){
        return time1.getMonth() == time2.getMonth();
    }

    public boolean dayOfMonthEqual(LocalDateTime time1, LocalDateTime time2){
        return time1.getDayOfMonth() == time2.getDayOfMonth();
    }

    public boolean dayOfWeekEqual(LocalDateTime time1, LocalDateTime time2){
        return time1.getDayOfWeek() == time2.getDayOfWeek();
    }

    public boolean hourEqual(LocalDateTime time1, LocalDateTime time2){
        return time1.getHour() == time2.getHour();
    }

    public boolean minuteEqual(LocalDateTime time1, LocalDateTime time2){
        return time1.getMinute() == time2.getMinute();
    }

    public boolean secondEqual(LocalDateTime time1, LocalDateTime time2){
        return time1.getSecond() == time2.getSecond();
    }
    // reuse end

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

    public long milliSeconds(LocalDateTime time){
        return time.atZone(ZoneOffset.UTC).toInstant().toEpochMilli();
    }

    public LocalDateTime minusYears(LocalDateTime time, int year){
        return time.minusYears(year);
    }

    public LocalDateTime plusYears(LocalDateTime time, int year){
        return time.plusYears(year);
    }

    public LocalDateTime minusMonths(LocalDateTime time, int month){
        return time.minusMonths(month);
    }

    public LocalDateTime plusMonths(LocalDateTime time, int month){
        return time.plusMonths(month);
    }

    public LocalDateTime minusDays(LocalDateTime time, int day){
        return time.minusDays(day);
    }

    public LocalDateTime plusDays(LocalDateTime time, int day){
        return time.plusDays(day);
    }

    public LocalDateTime minusHours(LocalDateTime time, int hour){
        return time.minusHours(hour);
    }

    public LocalDateTime plusHours(LocalDateTime time, int hour){
        return time.plusHours(hour);
    }

    public LocalDateTime minusMinutes(LocalDateTime time, int minute){
        return time.minusMinutes(minute);
    }

    public LocalDateTime plusMinutes(LocalDateTime time, int minute){
        return time.plusMinutes(minute);
    }

    public LocalDateTime minusSeconds(LocalDateTime time, int second){
        return time.minusSeconds(second);
    }

    public LocalDateTime plusSeconds(LocalDateTime time, int second){
        return time.plusSeconds(second);
    }

    public LocalDateTime withYear(LocalDateTime time, int year){
        return time.withYear(year);
    }

    public LocalDateTime withMonth(LocalDateTime time, int month){
        return time.withMonth(month);
    }

    public LocalDateTime withDay(LocalDateTime time, int day){
        return time.withDayOfMonth(day);
    }

    public LocalDateTime withHour(LocalDateTime time, int hour){
        return time.withHour(hour);
    }

    public LocalDateTime withMinute(LocalDateTime time, int minute){
        return time.withMinute(minute);
    }

    public LocalDateTime withSecond(LocalDateTime time, int second){
        return time.withSecond(second);
    }

    public Duration timeDuration(LocalDateTime time1, LocalDateTime time2){
        return Duration.between(time1, time2);
    }

    public long daysDuration(Duration duration){
        return duration.toDays();
    }

    public long hoursDuration(Duration duration){
        return duration.toHours();
    }

    public long minutesDuration(Duration duration){
        return duration.toMinutes();
    }

    public long secondsDuration(Duration duration){
        return duration.toSeconds();
    }

    public Duration durationWithDay(int days){
        return Duration.ofDays(days);
    }

    public Duration durationWithHour(int hour){
        return Duration.ofHours(hour);
    }

    public Duration durationWithSecond(int seconds){
        return Duration.ofSeconds(seconds);
    }
}
