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
    public double getFielding () {return mydef.getFieldingPercentage();}

    public double getAtBats () {return myoff.getAb();}
    public double getWalks() {return myoff.getBb();}
    public double getHitByPitches() {return myoff.getHp();}
    public double getSacrifices() {return myoff.getSac();}
    public double getHits() {return myoff.getHits();}
    public double getSingles() {return myoff.getb1();}
    public double getDoubles() {return myoff.getb2();}
    public double getTriples() {return myoff.getb3();}
    public double getHomeRuns() {return myoff.getHr();}

    public double getAssists() {return mydef.getAssists();}
    public double getPutouts() {return mydef.getPutouts();}
    public double getErrors() {return mydef.getErrors();}
    public void calculate() {
        myoff.calculate();
        mydef.calculate();
    }
}
/*
out.printf("%s %d %d %d %d %d %d %d %d %d %d %d %d", wow.getName(), offenseStats.getAb(),
                        offenseStats.getBb(), offenseStats.getHp(), offenseStats.getSac(), offenseStats.getHits(),
                        offenseStats.getb1(), offenseStats.getb2(), offenseStats.getb3(), offenseStats.getHr(),
                        defenseStats.getAssists(), defenseStats.getPutouts(), defenseStats.getErrors());
                out.println();
 */