// Alex Nouansacksy
// CL 3-9 w/classes (class file)
// 09/05/2023
public class ClLP3Exercise9 {
    private int myBirthYear;
    private int myBirthMonth;
    private int myBirthDay;
    private int myYear;
    private int myMonth;
    private int myDay;

    private int myDaysAtBirth;
    private int myDaysNow;
    private int myDaysAlive;
    private int myHoursSlept;

    public ClLP3Exercise9(int birthYear, int birthMonth, int birthDay, int year, int month, int day) {
        myBirthYear = birthYear;
        myBirthMonth = birthMonth;
        myBirthDay = birthDay;
        myYear = year;
        myMonth = month;
        myDay = day;
        myDaysAtBirth = 0;
        myDaysNow = 0;
        myDaysAlive = 0;
        myHoursSlept = 0;
    }

    public void setStuff() {
        myDaysNow = (365 * myYear + 30 * myMonth + myDay);
        myDaysAtBirth = (365 * myBirthYear + 30 * myBirthMonth + myBirthDay);
    }

    public void calculate() {
        myDaysAlive = myDaysNow - myDaysAtBirth;
        myHoursSlept =myDaysAlive * 8;
    }

    public String toString() {return String.format("You have been alive for %d days.\nYou have slept for %d hours",
            myDaysAlive, myHoursSlept);}
    public void print() {System.out.println(this.toString());}
}

/* output

Enter your birthdate:
Year: 1997
Month: 2
Day: 12
Enter today's date:
Year: 2012
Month: 8
Day: 3
You have been alive for 5646 days.
You have slept for 45168 hours

Process finished with exit code 0
 */