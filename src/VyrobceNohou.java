
public class VyrobceNohou extends Delnik {


    private int id = 4;
    private int naklady = 30;
    private String jmeno;



    public void vyrobNohy() throws InterruptedException {
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
            System.out.println("Dělník " + id + " vyrábí nohy.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                vyrobNohy();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Log.log("Dělník " + id + " vyrobil nohy.  Zbývá "+ suroviny.getPlast()+"plastu");

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
