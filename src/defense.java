public class defense {
    private int myassists;
    private int myputouts;
    private int myerrors;
    private double myfieldingpercentage;

    public defense(int a, int p, int e) {
        myassists = a;
        myputouts = p;
        myerrors = e;
        myfieldingpercentage = 0;
    }

    public void calculate() {
        myfieldingpercentage = (myputouts + myassists) / (double) (myputouts + myassists + myerrors);
    }
    public int getAssists() {return myassists;}
    public int getPutouts() {return myputouts;}
    public int getErrors() {return myerrors;}
    public double getFieldingPercentage() {return myfieldingpercentage;}
}