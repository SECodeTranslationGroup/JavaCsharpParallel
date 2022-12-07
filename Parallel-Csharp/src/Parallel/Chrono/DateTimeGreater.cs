namespace Parallel.Linq101.Chrono;
using System;
public class DateTimeGreater {
    //reuse
    public bool TimeGreater(DateTime time1, DateTime time2){
        return time1 > time2;
    }

    public bool YearGreater(DateTime time1, DateTime time2){
        return time1.Year > time2.Year;
    }

    public bool MonthGreater(DateTime time1, DateTime time2){
        return time1.Month > time2.Month;
    }

    public bool DayOfMonthGreater(DateTime time1, DateTime time2){
        return time1.Day > time2.Day;
    }
    
    //Sunday is 0, while in Java Sunday is 7
    //We follow Java routine, convert Sunday to the highest order.
    public bool DayOfWeekGreater(DateTime time1, DateTime time2)
    {
        int value1 = (int)time1.DayOfWeek;
        int value2 = (int)time2.DayOfWeek;
        if (value1 == 0) value1 += 7;
        if (value2 == 0) value2 += 7;
        return value1 > value2;
    }

    public bool HourGreater(DateTime time1, DateTime time2){
        return time1.Hour > time2.Hour;
    }

    public bool MinuteGreater(DateTime time1, DateTime time2){
        return time1.Minute > time2.Minute;
    }

    public bool SecondGreater(DateTime time1, DateTime time2){
        return time1.Second > time2.Second;
    }
    // reuse end
}