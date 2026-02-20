import java.util.concurrent.Semaphore;

public class Main {
    public static synchronized void main(String[] args) throws InterruptedException {

            SkladSoucastek soucastky = new SkladSoucastek();
            SkladSurovin  suroviny = new SkladSurovin();

            VyrobceHlav hlava = new VyrobceHlav("Honza", suroviny,soucastky);
            VyrobceNohou nohy = new VyrobceNohou("Pepa",  suroviny,soucastky);
            VyrobceRukou ruce = new VyrobceRukou("Franta",  suroviny,soucastky);
            VyrobceTel telo = new VyrobceTel("Bonifác",   suroviny,soucastky);
            Thread t1 = new Thread(hlava);
            Thread t2 = new Thread(nohy);
            Thread t3 = new Thread(ruce);
            Thread t4 = new Thread(telo);
            t1.start();
            t2.start();
            t3.start();
            t4.start();

            t1.join();
            t2.join();
            t3.join();
            t4.join();

    }
}