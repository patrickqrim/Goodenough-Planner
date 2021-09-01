
/**
 * Write a description of class Time here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Time
{
    private int hour;
    private int minute;
    private int day;
    private int month;
    private String monthWord;
    private int year;
    
    public Time(int h, int m, int d, int mo, int y){
        hour = h;
        minute = m;
        day = d;
        month = mo;
        switch(month){
            case 1: monthWord = "January"; break;
            case 2: monthWord = "February"; break;
            case 3: monthWord = "March"; break;
            case 4: monthWord = "April"; break;
            case 5: monthWord = "May"; break;
            case 6: monthWord = "June"; break;
            case 7: monthWord = "July"; break;
            case 8: monthWord = "August"; break;
            case 9: monthWord = "September"; break;
            case 10: monthWord = "October"; break;
            case 11: monthWord = "November"; break;
            case 12: monthWord = "December"; break;
            default: monthWord = "invalid"; break;
        }
        year = y;
    }
    public String toString(){
        return monthWord + " " + day + ", " + year + ", " + hour + ":" + minute;
    }
    public String getDate(){
        return monthWord + " " + day + ", " + year;
    }
    public String getDate(int x){
        return monthWord + " " + (day+x) + ", " + year;
    }
    public int getMonth(){
        return month;
    }
    public int getDay(){
        return day;
    }
    public String getTime(){
        return hour + ":" + minute;
    }
    public void setTime(int h, int m){
        hour = h;
        minute = m;
    }
    public void setDate(int m, int d, int y){
        month = m;
        day = d;
        year = y;
        switch(month){
            case 1: monthWord = "January"; break;
            case 2: monthWord = "February"; break;
            case 3: monthWord = "March"; break;
            case 4: monthWord = "April"; break;
            case 5: monthWord = "May"; break;
            case 6: monthWord = "June"; break;
            case 7: monthWord = "July"; break;
            case 8: monthWord = "August"; break;
            case 9: monthWord = "September"; break;
            case 10: monthWord = "October"; break;
            case 11: monthWord = "November"; break;
            case 12: monthWord = "December"; break;
            default: monthWord = "invalid"; break;
        }
    }
}
