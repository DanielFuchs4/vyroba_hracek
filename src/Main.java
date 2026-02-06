import java.util.concurrent.Semaphore;

public class Main {
    public static synchronized void main(String[] args) throws InterruptedException {

            VyrobceHlav hlava = new VyrobceHlav();
            VyrobceNohou nohy = new VyrobceNohou();
            VyrobceRukou ruce = new VyrobceRukou();
            VyrobceTel telo = new VyrobceTel();
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