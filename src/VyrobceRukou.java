
public class VyrobceRukou extends Delnik {


    private int id = 3;
    private int naklady = 20;

    public VyrobceRukou(String jmeno, SkladSurovin suroviny, SkladSoucastek soucastky) {
        super(jmeno, suroviny, soucastky);
    }


    public void vyrobRuce() throws InterruptedException {
        if (suroviny.overDostatekPlastu(naklady)){
            soucastky.setHlava(soucastky.getHlava()+1);
        }
        else {
            System.out.println("Došlel plast. Hlavu nelze vyrobit");
            Thread.sleep(2000);
        }
    }

    @Override
    public void run() {
        while(naklady <= suroviny.getPlast()){
            System.out.println("Dělník " + id + " vyrábí ruce.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                vyrobRuce();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Log.log("Dělník " + id + " vyrobil ruce.  Zbývá "+ suroviny.getPlast()+"plastu");

        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getNaklady() {
        return naklady;
    }

    public void setNaklady(int naklady) {
        this.naklady = naklady;
    }

}
