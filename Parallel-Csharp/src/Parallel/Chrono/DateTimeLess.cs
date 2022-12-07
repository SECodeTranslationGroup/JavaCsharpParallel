namespace Parallel.Linq101.Chrono;
using System;
public class DateTimeLess {
    //reuse
    public bool TimeLess(DateTime time1, DateTime time2){
        return time1 < time2;
    }

    public bool YearLess(DateTime time1, DateTime time2){
        return time1.Year < time2.Year;
    }

    public bool MonthLess(DateTime time1, DateTime time2){
        return time1.Month < time2.Month;
    }

    public bool DayOfMonthLess(DateTime time1, DateTime time2){
        return time1.Day < time2.Day;
    }
    
    //Sunday is 0, while in Java Sunday is 7
    //We follow Java routine, convert Sunday to the highest order.
    public bool DayOfWeekLess(DateTime time1, DateTime time2)
    {
        int value1 = (int)time1.DayOfWeek;
        int value2 = (int)time2.DayOfWeek;
        if (value1 == 0) value1 += 7;
        if (value2 == 0) value2 += 7;
        return value1 < value2;
    }

    public bool HourLess(DateTime time1, DateTime time2){
        return time1.Hour < time2.Hour;
    }

    public bool MinuteLess(DateTime time1, DateTime time2){
        return time1.Minute < time2.Minute;
    }

    public bool SecondLess(DateTime time1, DateTime time2){
        return time1.Second < time2.Second;
    }
    // reuse end
}