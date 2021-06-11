
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cikis extends Thread {

    public int kisiSayisi;
    Giris giris = new Giris();
    public Katlar[] katlar;
    public LinkedList<Passengers> passengers;

    public Cikis(Giris giris, Katlar[] katlar, LinkedList<Passengers> passengers) {
        this.passengers = passengers;
        this.katlar = katlar;
        this.giris = giris;

    }

    public Cikis(Katlar[] katlar) {
        this.katlar = katlar;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (true) {
            
            int sayi= random.nextInt(4)+1; // 1 ile 4 arasında bir sayı üretiyoruz Hangi kattan kisiyi avm den çıkması için kuyruğa alacağız?
            int sayi2=random.nextInt(5)+1; // yine 1 ile 5 arasında sayı üretip, o kadar kisiyi kuyruğa sokuyoruz. 
            int i=0;
            while(i<passengers.size()){
                if(passengers.get(i).bulunduguKat==sayi && sayi2!=0){
                        passengers.get(i).istek=0;
                        katlar[sayi].getKuyruk().add(passengers.get(i));
                        sayi2--;
                }
                i++;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cikis.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
        }
    }

}
