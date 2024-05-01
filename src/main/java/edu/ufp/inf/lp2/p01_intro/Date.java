package edu.ufp.inf.lp2.p01_intro;


import java.util.Objects;

public class Date {

    private short day;

    private short month;

    private int year;

    public Date(short day, short month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date(long l) {

    }


    public int compareTo(Date d) {
        if (this.year == d.year && this.day == d.day && this.month == d.month) {
            return 0;
        } else if (this.year == d.year) {
            if (this.month == d.month) {
                return (this.day - d.day) / Math.abs(this.day - d.day);
            } else {
                return (this.month - d.month) / Math.abs(this.month - d.month);
            }
        } else {
            return (this.year - d.year) / Math.abs(this.year - d.year);
        }
    }

    public boolean afterDate(Date d) {
        if (this.compareTo(d) == 0) {
            return false;
        }else{
            return !beforeDate(d);
        }
    }

    public boolean beforeDate(Date d) {
        return this.compareTo(d) == -1;
    }

    public int differenceDays(Date d) {
        return 0;
    }

    public int differenceMonths(Date d) {
        return 0;
    }

    public int differenceYears(Date d) {
        return 0;
    }

    public void incrementDate() {
        if(this.month == 12 &&(this.day == daysMonth(this.month, this.year))){
            this.day =1;
            this.month =1;
            this.year ++;
        }
    }

    private static long daysCrawlerRecursiveAux(Date begin, Date end) {
        if(begin.beforeDate(end)){
            begin.incrementDate();
            return(1+ Date.daysCrawlerRecursiveAux(begin, end));
        }
        return 0;
    }

    public static int daysCrawlerRecursive(Date begin, Date end) {
        return 0;
    }

    public static int daysCrawler(Date begin, Date end) {
        return 0;
    }

    public static int monthsCrawler(Date begin, Date end) {
        return 0;
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public static int daysMonth(short month, int year) {
        switch (month){
            case 11:
            case 4:
            case 6:
            case 9:
                return 30;
            case 2:
                return (isLeapYear(year) ? 29 : 28);
        }
        return 31;

    }

    public static int daysBetweenMonths(short beginDay, short beginMonth, short endDay, short endMonth, int year) {
        return 0;
    }

    public static void monthsBetweenMonths(short beginDay, short beginMonth, short endDay, short endMonth, int year) {
    }

    public static void main(String[] args) {
    }

    public short getDay() {
        return day;
    }

    public void setDay(short day) {
        this.day = day;
    }

    public short getMonth() {
        return month;
    }

    public void setMonth(short month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return day == date.day && month == date.month && year == date.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}