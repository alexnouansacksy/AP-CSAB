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

        int year = 1970;
        while (unix > yearSeconds) {
            if (year % 4 == 0) unix -= (daySeconds * 366);
            else unix -= daySeconds * 365;
            year++;
        }

        int month = 1;
        int monthDays = 31;
        int monthSeconds = monthDays * daySeconds;

        while (unix > monthSeconds) {
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
                monthDays = 31;
            else if (month == 2) {
                if (year % 4 == 0) monthDays = 29;
                else monthDays = 28;
            } else {
                monthDays = 30;
            }
            monthSeconds = monthDays * daySeconds;
            unix -= monthSeconds;
            month++;
        }

        int days = (int) unix / daySeconds;
        unix -= days * daySeconds;
        days++;
        int hours = (int) unix / hourSeconds;
        unix -= hours * hourSeconds;

        String ampm = "AM";
        if (hours > 12) {
            hours -= 12;
            ampm = "PM";
        }
        if (unix == 0) {
            hours = 12;
            days = 1;
        }
        int minutes = (int) unix / minuteSeconds;
        if  (hours < 10 && minutes < 10) out.printf("0%d:%d %s", hours, minutes, ampm);
        else if (hours < 10) out.printf("0%d:%d %s", hours, minutes, ampm);
        else if (minutes < 10) out.printf("%d:0%d %s", hours, minutes, ampm);
        else out.printf("%d:%d %s", hours, minutes, ampm);

        if (month < 10 && days < 10) out.printf("\t0%d/0%d/%d", month, days, year);
        else if (month < 10) out.printf("\t0%d/%d/%d", month, days, year);
        else if (days < 10) out.printf("\t%d/0%d/%d", month, days, year);
        else out.printf("\t%d/%d/%d", month, days, year);



    }
}
/*
Enter UNIX time: 0
12:00 AM	01/01/1970
Process finished with exit code 0

Enter UNIX time: 1234567890
11:31 PM	02/13/2009
Process finished with exit code 0

Enter UNIX time: 1111111111
01:58 AM	03/18/2005
Process finished with exit code 0

 */
