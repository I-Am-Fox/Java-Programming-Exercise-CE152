package ex4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PriceDate implements Comparable<PriceDate> {
    private int day; //Variable to store the day of the month
    private int month; //Variable to store the month of the year
    private int year; //Variable to store the year

    public PriceDate(Date date) {
        SimpleDateFormat sdfDay = new SimpleDateFormat("dd");
        this.day = Integer.parseInt(sdfDay.format(date)); // parse the day from the Date object
        SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
        this.month = Integer.parseInt(sdfMonth.format(date)); // parse the month from the Date object
        SimpleDateFormat sdfYear = new SimpleDateFormat("yy");
        this.year = Integer.parseInt(sdfYear.format(date)); // parse the year from the Date object
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(PriceDate other) {
        //Compare the years of the two PriceDate objects
        int yearComparison = Integer.compare(this.year, other.year);
        if (yearComparison != 0) {
            return yearComparison; // return the result of the year comparison if it's not equal to 0
        }
        //If the years are equal, compare the months of the two PriceDate objects
        int monthComparison = Integer.compare(this.month, other.month);
        if (monthComparison != 0) {
            return monthComparison; // return the result of the month comparison if it's not equal to 0
        }
        //If the months are equal, compare the days of the two PriceDate objects
        return Integer.compare(this.day, other.day);
    }

    @Override
    public String toString() {
        //Format the date as "dd-MMM-yy"
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
        //Create a new Date object with the year, month, and day values
        Date date = new Date(year, month - 1, day);
        //Return the formatted date string
        return sdf.format(date);
    }

    public Date toDate() {
        //Create a new Date object with the year, month, and day values and return it
        return new Date(year, month - 1, day);
    }
}
