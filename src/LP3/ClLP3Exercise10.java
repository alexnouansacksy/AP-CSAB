package LP3;

// Alex Nouansacksy
// Class file for LP3-10 w/classes
// 09/05/2023
public class ClLP3Exercise10 {
    private int myBurgers;
    private double myBurgerCosts;
    private int myFries;
    private double myFryCost;
    private int mySodas;
    private double mySodasCost;
    private double myCash;


    private double myTotal;
    private double myTax;
    private double myFinalTotal;
    private double myChange;

    public ClLP3Exercise10(int burgers, int fries, int sodas, double cash) {
        myBurgers =  burgers;
        myBurgerCosts = 0;
        myFries = fries;
        myFryCost = 0;
        mySodas = sodas;
        mySodasCost = 0;
        myCash = cash;
        myChange = 0;
    }

    public void calculate() {
        myBurgerCosts = myBurgers * 1.69;
        myFryCost = myFries *1.09;
        mySodasCost = mySodas *0.99;
        myTotal = myBurgerCosts + myFryCost + mySodasCost;
        myTax = myTotal * 0.065;
        myFinalTotal = myTotal + myTax;
        myChange = myCash - myFinalTotal;
    }

    public String toString() {return String.format("Total before tax: $%.2f\nTax: $%.2f\nTotal: $%.2f\nChange: $%.2f", myTotal, myTax, myFinalTotal, myChange);}

    public void print() {
        System.out.println(this.toString());
    }

}

/* output

Part A:
Enter the number of burgers: 2
Enter the number of fries: 5
Enter the number of sodas: 5
Total before tax: $13.78
Tax: $0.90
Total: $14.68

Process finished with exit code 0

Part B:
Enter the number of burgers: 2
Enter the number of fries: 5
Enter the number of sodas: 5
Enter amount tendered: 20
Total before tax: $13.78
Tax: $0.90
Total: $14.68
Change: $5.32

Process finished with exit code 0
 */