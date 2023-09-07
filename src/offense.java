public class offense {
    private int myab;
    private int mybb;
    private int myhp;
    private int mysac;
    private int myhits;
    private int my1b;
    private int my2b;
    private int my3b;
    private int myhr;
    private double myavg;
    private double myslug;
    private double myonbaseperc;
    public offense(int ab,int bb, int hp,int sac, int hits, int b1, int b2, int b3, int hr) {
        myab = ab;
        mybb = bb;
        myhp = hp;
        mysac = sac;
        myhits = hits;
        my1b = b1;
        my2b = b2;
        my3b = b3;
        myhr = hr;
        myavg = 0;
        myslug = 0;
        myonbaseperc = 0;
    }

    public void calculate() {
        myavg = (double) myhits / myab;
        myslug = (my1b + (my2b * 2) + (my3b * 3) + (myhr * 4)) / (double) myab;
        myonbaseperc = (myhits + mybb + myhp) / (double) (myab + mybb + myhp + mysac);
    }

}