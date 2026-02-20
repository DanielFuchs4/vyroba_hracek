
public class VyrobceTel extends Delnik {


    private int id = 2;
    private int naklady = 50;

    public VyrobceTel(String jmeno, SkladSurovin suroviny, SkladSoucastek soucastky) {
        super(jmeno, suroviny, soucastky);
    }


    public void vyrobTelo() throws InterruptedException {
        if (suroviny.overDostatekPlastu(naklady)){
            soucastky.setHlava(soucastky.getTelo()+1);
        }
        else {
            System.out.println("Došlel plast. Tělo nelze vyrobit");
            Thread.sleep(2000);
        }
    }

    @Override
    public void run() {
        while(naklady <= suroviny.getPlast()){
            System.out.println("Dělník " + id + " vyrábí tělo.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                vyrobTelo();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Log.log("Dělník " + id + " vyrobil tělo.  Zbývá "+ suroviny.getPlast()+"plastu");

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
