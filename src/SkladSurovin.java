public class SkladSurovin {

    private int plast = 10000;
    private int vlasy = 1000;

    public synchronized Boolean overDostatekPlastu(int naklady){
        if (plast >= naklady){
            plast -= naklady;
            return true;
        }
        else {
            return false;
        }
    }

    public int getPlast() {
        return plast;
    }

    public int getVlasy() {
        return vlasy;
    }

    public void setPlast(int plast) {
        this.plast = plast;
    }

    public void setVlasy(int vlasy) {
        this.vlasy = vlasy;
    }
}
