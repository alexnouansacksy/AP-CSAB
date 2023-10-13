// Alex Nouansacksy
// MSOE 2018 Question 7
// 10/12/2023
import java.util.*;
import static java.lang.System.out;

public class MSOE2018_7 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        out.print("Enter UNIX time: ");
        double unix = keyboard.nextInt();

        int minuteSeconds = 60;
        int hourSeconds = minuteSeconds * 60;
        int daySeconds = hourSeconds * 24;
        double yearSeconds = daySeconds * 365.25;

        int year = 1970 + (int)(unix / yearSeconds);
        out.println("Year: " + year);

        unix -= (year - 1970) * yearSeconds;
        out.println("unix: " + unix) ;

        out.println("year seconds: " + yearSeconds) ;


        int month = 1;
        int monthDays = 31;
        int monthSeconds = 31 * daySeconds;

        boolean leapYear = year % 4 == 0;

        while (unix >= monthSeconds) {
            month++;
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
                monthDays = 31;
            else if (month == 2) {
                if (leapYear) monthDays = 29;
                else monthDays = 28;
            } else {
                monthDays = 30;
            }
            unix -= monthSeconds;
            monthSeconds = monthDays * daySeconds;

        }

        int day = (int) unix / daySeconds;
        unix -= day * daySeconds;
        out.println("Month: " + month);
        out.println("Day: " + day);
        int hours = (int) unix / hourSeconds;
        out.println("hours: " + hours);
        out.println(unix);
    }
}

