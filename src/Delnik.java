public abstract class Delnik implements Runnable {
    SkladSurovin suroviny = new SkladSurovin();
    SkladSoucastek soucastky = new SkladSoucastek();
    private int id;
    private String jmeno;

    public Delnik(String jmeno, SkladSurovin suroviny, SkladSoucastek soucastky) {
        this.jmeno = jmeno;
        this.suroviny = suroviny;
        this.soucastky = soucastky;
    }

}