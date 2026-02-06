
public class VyrobceHlav extends Delnik {



    private int id = 1;
    private int naklady = 10;
    private int vlasy = 2;
    private String jmeno;



    public void vyrobHlavu() throws InterruptedException {
        if (suroviny.overDostatekPlastu(naklady)){
            soucastky.setHlava(soucastky.getHlava()+1);
        }
        else {
            Log.log("Dělník " + id + " vyrobil hlavu.  Zbývá "+ suroviny.getPlast()+"plastu");
            Thread.sleep(2000);
        }
    }

    @Override
    public void run() {
        while(naklady <= suroviny.getPlast()){
            System.out.println("Dělník " + id + " vyrábí hlavu.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                vyrobHlavu();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Dělník " + id + " vyrobil hlavu. Zbývá "+ suroviny.getPlast()+"plastu");

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
