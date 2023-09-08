public class player
{
    private String myname;
    private offense myoff;
    private defense mydef;

    public player (String name, offense off, defense def){
        myname = name;
        myoff = off;
        mydef = def;
    }
    public String getName() {return myname;}

    public double getbattingavg () {return myoff.getAvg();}
    public double getonbasepercentage () {
        return myoff.getOnBasePerc();
    }
    public double getsluggingpercentage () {return myoff.getSlug();}
    public double getfieldingpercentage () {return mydef.getFieldingPercentage();}
}
