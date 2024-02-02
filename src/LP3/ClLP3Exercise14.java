package LP3;

// Alex Nouansacksy
// Class file for LP3-14 w/classes
// 09/05/2023
public class ClLP3Exercise14 {
    private int myAwbreyNY;
    private int myMartinezNY;
    private int myAwbreyNJ;
    private int myMartinezNJ;
    private int myAwbreyCT;
    private int myMartinezCT;

    private int myAwbreyTotal;
    private int myMartinezTotal;

    private double myAwbreyPercentage;
    private double myMartinezPercentage;

    private int myTotal;

    public ClLP3Exercise14 (int awbreyNY, int martinezNY, int awbreyNJ, int martinezNJ, int awbreyCT, int martinezCT) {
        myAwbreyNY = awbreyNY;
        myMartinezNY = martinezNY;
        myAwbreyNJ = awbreyNJ;
        myMartinezNJ = martinezNJ;
        myAwbreyCT = awbreyCT;
        myMartinezCT = martinezCT;

        myAwbreyTotal = 0;
        myMartinezTotal = 0;
        myAwbreyPercentage = 0;
        myMartinezPercentage = 0;
        myTotal = 0;
    }

    public void calculate() {
        myAwbreyTotal = (myAwbreyNY + myAwbreyNJ + myAwbreyCT);
        myMartinezTotal = (myMartinezNY + myMartinezNJ + myMartinezCT);
        myTotal = myAwbreyTotal + myMartinezTotal;
        myAwbreyPercentage = (double) myAwbreyTotal /  myTotal;
        myAwbreyPercentage *= 100;
        myMartinezPercentage = (double) myMartinezTotal / myTotal;
        myMartinezPercentage *= 100;
    }

    public String toString() {return String.format("Candidates\t\tVotes\tPercentage\nAwbrey\t\t\t%d\t%.2f\nMartinez\t\t%d\t%.2f\nTOTAL VOTES:\t%d", myAwbreyTotal, myAwbreyPercentage, myMartinezTotal, myMartinezPercentage, myTotal);}

    public void print() {
        System.out.println(this.toString());
    }
}
/* output

Election Results for New York:
Awbrey: 314159
Martinez: 271860
Election Results for New Jersey:
Awbrey: 89008
Martinez: 121032
Election Results for Connecticut:
Awbrey: 213451
Martinez: 231034
Candidates		Votes	Percentage
Awbrey			616618	49.71
Martinez		623926	50.29
TOTAL VOTES:	1240544

Process finished with exit code 0

 */