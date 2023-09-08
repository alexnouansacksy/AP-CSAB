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
    public int getAb() {return myab;}
    public int getBb() {return mybb;}
    public int getHp() {return myhp;}
    public int getSac() {return mysac;}
    public int getHits() {return myhits;}
    public int getb1() {return my1b;}
    public int getb2() {return my2b;}
    public int getb3() {return my3b;}
    public int getHr() {return myhr;}

    public double getAvg() {return myavg;}
    public double getSlug() {return myslug;}
    public double getOnBasePerc() {return myonbaseperc;}

}