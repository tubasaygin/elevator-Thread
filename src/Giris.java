
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Giris extends Thread {

    
    public int icerdekiKisi;
    public LinkedList<Passengers> passengers;
    Katlar[] katlar;

    public Giris() {
    }

    public Giris(Katlar[] katlar) {
      
        this.katlar = katlar;
        icerdekiKisi = 100; // Başlangıçta avm de kaç kişi olsun ?
        passengers = new LinkedList<>();
        for (int i = 0; i < icerdekiKisi; i++) {
            Random random = new Random();
            Random random2 = new Random();
            passengers.add(new Passengers(i));
            passengers.get(i).istek = random.nextInt(4) + 1;
            int sayi = random.nextInt(5);
            passengers.get(i).bulunduguKat = sayi;
            katlar[sayi].setKisiSayisi(katlar[sayi].getKisiSayisi() + 1);
            
        }

        for (int i = 0; i < katlar[0].getKisiSayisi(); i++) {
            katlar[0].getKuyruk().add(passengers.get(i));
      
        }
    
        /*
        for (int i = 0; i < 5; i++) {
            System.out.println(i + "  all : " + katlar[i].getKisiSayisi() + " queue " + katlar[i].getKuyruk().size());
        }
         */
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Giris.class.getName()).log(Level.SEVERE, null, ex);
            }
            int sayi = random.nextInt(10) + 1;
            icerdekiKisi += sayi;
            katlar[0].setKisiSayisi(katlar[0].getKisiSayisi() + sayi);
            for (int i = icerdekiKisi - sayi; i < icerdekiKisi; i++) {
                Random random1 = new Random();
                passengers.addLast(new Passengers(passengers.getLast().id + 1));
                passengers.getLast().istek = random1.nextInt(4) + 1;
                katlar[0].getKuyruk().add(passengers.getLast());
            }

            /*
            for (int i = 0; i < 5; i++) {
            System.out.println(i + "  all : " + katlar[i].getKisiSayisi()+" queue "+ katlar[i].getKuyruk().size());
            }
             */
 /*
            for(int i=0;i<katlar[0].getKuyruk().size();i++){
                System.out.println("Kisinin istegi.  " + katlar[0].getKuyruk().get(i).istek);
            }
             */
        }
    }

}
