namespace Parallel.Linq101.Chrono;
using System;
public class DateTimeEqual {
    public DateTime GetCurrentTime(){
        return DateTime.Now;
    }

    public DateTime GetTime(int year, int month, int dayOfMonth,
                                 int hour, int minute, int second){
        DateTime time = new DateTime(
                year, month, dayOfMonth,
                hour, minute, second);
        return time;
    }

    //reuse
    public bool TimeEqual(DateTime time1, DateTime time2){
        return time1 == time2;
    }

    public bool YearEqual(DateTime time1, DateTime time2){
        return time1.Year == time2.Year;
    }

    public bool MonthEqual(DateTime time1, DateTime time2){
        return time1.Month == time2.Month;
    }

    public bool DayOfMonthEqual(DateTime time1, DateTime time2){
        return time1.Day == time2.Day;
    }

    public bool DayOfWeekEqual(DateTime time1, DateTime time2){
        return time1.DayOfWeek == time2.DayOfWeek;
    }

    public bool HourEqual(DateTime time1, DateTime time2){
        return time1.Hour == time2.Hour;
    }

    public bool MinuteEqual(DateTime time1, DateTime time2){
        return time1.Minute == time2.Minute;
    }

    public bool SecondEqual(DateTime time1, DateTime time2){
        return time1.Second == time2.Second;
    }
    // reuse end


    public long MilliSeconds(DateTime time){
        return Convert.ToInt64((time - DateTime.UnixEpoch).TotalMilliseconds);
    }

    public DateTime MinusYears(DateTime time, int year){
        return time.AddYears(-year);
    }

    public DateTime PlusYears(DateTime time, int year){
        return time.AddYears(year);
    }

    public DateTime MinusMonths(DateTime time, int month){
        return time.AddMonths(-month);
    }

    public DateTime PlusMonths(DateTime time, int month){
        return time.AddMonths(month);
    }

    public DateTime MinusDays(DateTime time, int day){
        return time.AddDays(-day);
    }

    public DateTime PlusDays(DateTime time, int day){
        return time.AddDays(day);
    }

    public DateTime MinusHours(DateTime time, int hour){
        return time.AddHours(-hour);
    }

    public DateTime PlusHours(DateTime time, int hour){
        return time.AddHours(hour);
    }

    public DateTime MinusMinutes(DateTime time, int minute){
        return time.AddMinutes(-minute);
    }

    public DateTime PlusMinutes(DateTime time, int minute){
        return time.AddMinutes(minute);
    }

    public DateTime MinusSeconds(DateTime time, int second){
        return time.AddSeconds(-second);
    }

    public DateTime PlusSeconds(DateTime time, int second){
        return time.AddSeconds(second);
    }

    public DateTime WithYear(DateTime time, int year){
        return time.AddYears(year-time.Year);
    }

    public DateTime WithMonth(DateTime time, int month){
        return time.AddMonths(month-time.Month);
    }

    public DateTime WithDay(DateTime time, int day){
        return time.AddYears(day-time.Day);
    }

    public DateTime WithHour(DateTime time, int hour){
        return time.AddHours(hour-time.Hour);
    }

    public DateTime WithMinute(DateTime time, int minute){
        return time.AddMinutes(minute-time.Minute);
    }

    public DateTime WithSecond(DateTime time, int second){
        return time.AddSeconds(second-time.Second);
    }

    public TimeSpan TimeTimeSpan(DateTime time1, DateTime time2){
        return time1 - time2;
    }

    public long DaysTimeSpan(TimeSpan span){
        return span.Days;
    }

    public long HoursTimeSpan(TimeSpan span){
        return span.Hours;
    }

    public long MinutesTimeSpan(TimeSpan span){
        return span.Minutes;
    }

    public long SecondsTimeSpan(TimeSpan span){
        return span.Seconds;
    }

    public TimeSpan TimeSpanWithDay(int days){
        return TimeSpan.FromDays(days);
    }

    public TimeSpan TimeSpanWithHour(int hour){
        return TimeSpan.FromHours(hour);
    }

    public TimeSpan TimeSpanWithSecond(int seconds){
        return TimeSpan.FromSeconds(seconds);
    }
}