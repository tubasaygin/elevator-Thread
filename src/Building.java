
import java.util.logging.Level;
import java.util.logging.Logger;

public class Building {
    Object lock = new Object();
    Object lock1 = new Object();
    Object lock2 = new Object();
    Object lock3 = new Object();
    Object lock4 = new Object();
  
    
    Katlar[] katlar = new Katlar[5];
    private int kacAsansorCalisiyor = 1;

    public int getKacAsansorCalisiyor() {
        return kacAsansorCalisiyor;
    }

    public synchronized void setKacAsansorCalisiyor(int kacAsansorCalisiyor) {
        this.kacAsansorCalisiyor = kacAsansorCalisiyor;
    }

    public Building() {
        for (int i = 0; i < 5; i++) {
            katlar[i] = new Katlar();
            katlar[i].setKisiSayisi(0);

        }

        Giris giris = new Giris(katlar);
        Cikis cikis = new Cikis(giris, katlar, giris.passengers);
        Asansor asansor = new Asansor(katlar, lock, giris.passengers);
        Asansor1 asansor1 = new Asansor1(katlar, lock1,giris.passengers);
        Asansor2 asansor2 = new Asansor2(katlar, lock2, giris.passengers);
        Asansor3 asansor3 = new Asansor3(katlar, lock3, giris.passengers);
        Asansor4 asansor4 = new Asansor4(katlar, lock4, giris.passengers);
        Kontrol kontrol = new Kontrol(katlar, kacAsansorCalisiyor,asansor, asansor1,asansor2,asansor3,asansor4);

        giris.start();
        cikis.start();
        asansor.start();
        kontrol.start();
        asansor1.start();
        asansor2.start();
        asansor3.start();
        asansor4.start();
        try {
            giris.join();
            cikis.join();
            asansor.join();
            kontrol.join();
            asansor1.join();
            asansor2.join();
            asansor3.join();
            asansor4.join();

        } catch (InterruptedException ex) {
            Logger.getLogger(Building.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static void main(String[] args) {
        Building building= new Building();
    }

}
