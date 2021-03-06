
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Asansor1 extends Thread {

    private int maxKapasite;  // MAX 10 kisi asansore binebilir. 
    private int mevcutKat;
    private int altIstekSayisi, ustIstekSayisi;
    public LinkedList<Passengers> passengers;
    LinkedList<Passengers> iceridekiYolcular = new LinkedList<>();
    private boolean up;
    private boolean aktifMi;
    ArrayList<Integer> asansorHangiKataGidecek = new ArrayList<>();
    private Katlar[] katlar = new Katlar[5];
    Object lock1;
    private int destination;
    private int birinciKatIstekSayisi; 
    private int zeminKatIstekSayisi;
    private int ikinciKatIstekSayisi;
    private int ucuncuKatIstekSayisi;
    private int dorduncuKatIstekSayisi;

    public int getBirinciKatIstekSayisi() {
        return birinciKatIstekSayisi;
    }

    public void setBirinciKatIstekSayisi(int birinciKatIstekSayisi) {
        this.birinciKatIstekSayisi = birinciKatIstekSayisi;
    }

    public int getZeminKatIstekSayisi() {
        return zeminKatIstekSayisi;
    }

    public void setZeminKatIstekSayisi(int zeminKatIstekSayisi) {
        this.zeminKatIstekSayisi = zeminKatIstekSayisi;
    }

    public int getIkinciKatIstekSayisi() {
        return ikinciKatIstekSayisi;
    }

    public void setIkinciKatIstekSayisi(int ikinciKatIstekSayisi) {
        this.ikinciKatIstekSayisi = ikinciKatIstekSayisi;
    }

    public int getUcuncuKatIstekSayisi() {
        return ucuncuKatIstekSayisi;
    }

    public void setUcuncuKatIstekSayisi(int ucuncuKatIstekSayisi) {
        this.ucuncuKatIstekSayisi = ucuncuKatIstekSayisi;
    }

    public int getDorduncuKatIstekSayisi() {
        return dorduncuKatIstekSayisi;
    }

    public void setDorduncuKatIstekSayisi(int dorduncuKatIstekSayisi) {
        this.dorduncuKatIstekSayisi = dorduncuKatIstekSayisi;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public Asansor1(Katlar[] katlar, Object lock1, LinkedList<Passengers> passengers) {
        this.passengers = passengers;
        this.lock1 = lock1;
        this.katlar = katlar;
        maxKapasite = 10;
        altIstekSayisi = 0;
        ustIstekSayisi = 0;
        mevcutKat = 0;
        aktifMi = false;

    }

    public LinkedList<Passengers> getIceridekiYolcular() {
        return iceridekiYolcular;
    }

    public void setIceridekiYolcular(LinkedList<Passengers> iceridekiYolcular) {
        this.iceridekiYolcular = iceridekiYolcular;
    }

    public int getMevcutKat() {
        return mevcutKat;
    }

    public void setMevcutKat(int mevcutKat) {
        this.mevcutKat = mevcutKat;
    }

    public boolean isAktifMi() {
        return aktifMi;
    }

    public void setAktifMi(boolean aktifMi) {
        this.aktifMi = aktifMi;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    @Override
    public void run() {
        // Asansor nas??l ??al????acak??

        while (true) {

            synchronized (lock1) {
                try {
                    lock1.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Asansor1.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    Thread.sleep(40);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Asansor1.class.getName()).log(Level.SEVERE, null, ex);
                }  
                //    System.out.println("Asansor 1 calisiyor... ");

                // Asansorun bulundugu katta yolcu var m??? 
                // Varsa asansorun icindeki yolcu say??s?? max 10 olana kadar asansore al. 
                if (katlar[mevcutKat].getKuyruk().size() != 0) {
                    for (int i = 0; i < katlar[mevcutKat].getKuyruk().size(); i++) {
                        if (iceridekiYolcular.size() < maxKapasite) {
                            iceridekiYolcular.add(katlar[mevcutKat].getKuyruk().get(i));  // Asansore ekleme. 
                            //  System.out.println("??cindeki yolcu sayisi : " + iceridekiYolcular.size() + " Gelen yolcunun id si : " + katlar[mevcutKat].getKuyruk().get(i).id + " Ve istegi : " + katlar[mevcutKat].getKuyruk().get(i).istek);
                            katlar[mevcutKat].getKuyruk().removeFirst();
                            i--;

                        }

                    }
                } else {
                    //System.out.println("Mevcut katta kimse yok, bir sonraki kata git. ");
                }

                
                zeminKatIstekSayisi=0;
                birinciKatIstekSayisi=0;
                ikinciKatIstekSayisi=0;
                ucuncuKatIstekSayisi=0;
                dorduncuKatIstekSayisi=0;
                 for(int i=0;i<iceridekiYolcular.size();i++){
                    if(iceridekiYolcular.get(i).istek==0){
                        zeminKatIstekSayisi++;
                    }else if(iceridekiYolcular.get(i).istek==1){
                        birinciKatIstekSayisi++;
                    }else if(iceridekiYolcular.get(i).istek==2){
                        ikinciKatIstekSayisi++;
                    }else if(iceridekiYolcular.get(i).istek==3){
                        ucuncuKatIstekSayisi++;
                    }else{
                        dorduncuKatIstekSayisi++;
                    }
                }
                
                //Asansor hangi kata gidecegini belirleyece -> istek say??s??n??n ??oklu??una g??re alta veya ??ste
                for (int i = 0; i < iceridekiYolcular.size(); i++) {
                    if (iceridekiYolcular.get(i).istek > mevcutKat) {
                        ustIstekSayisi++;
                    } else if (iceridekiYolcular.get(i).istek < mevcutKat) {
                        altIstekSayisi++;
                    }
                }

                if (altIstekSayisi < ustIstekSayisi) {
                    up = true;
                    mevcutKat++;
                    if (mevcutKat == 5) {
                        destination = 4;
                    } else {
                        destination = mevcutKat + 1;
                    }
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Asansor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    // System.out.println("Mevcut kat : " + mevcutKat);
                    for (int i = 0; i < iceridekiYolcular.size(); i++) {
                        if (iceridekiYolcular.get(i).istek == mevcutKat) {

                            //  System.out.println("Yolcu indiriliyor.. " + " ??ndiridilen yolcunun id si : " + iceridekiYolcular.get(i).id);
                            iceridekiYolcular.remove(i);
                            i--;

                        } else if (iceridekiYolcular.get(i).istek != mevcutKat) {
                            //  System.out.println("Asansorde kalmaya devam et daha gelmedi . ");
                        }
                    }
                    //  System.out.println("Asansorde kac kisi kaldi : 1 " + iceridekiYolcular.size());

                } else {
                    up = false;
                    mevcutKat--;
                    if (mevcutKat == 0) {
                        destination = 1;
                    } else {
                        destination = mevcutKat - 1;
                    }
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Asansor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    // System.out.println("Mevcut kat : " + mevcutKat);

                    for (int i = 0; i < iceridekiYolcular.size(); i++) {
                        if (iceridekiYolcular.get(i).istek == mevcutKat) {

                            iceridekiYolcular.remove(i);
                            i--;
                        } else {

                            //  System.out.println("Asansorde kalmaya devam et daha gelmedi .. ");
                        }
                    }
                    //  System.out.println("Asansorde kac kisi kaldi : 2 " + iceridekiYolcular.size());

                }
                zeminKatIstekSayisi=0;
                birinciKatIstekSayisi=0;
                ikinciKatIstekSayisi=0;
                ucuncuKatIstekSayisi=0;
                dorduncuKatIstekSayisi=0;
                 for(int i=0;i<iceridekiYolcular.size();i++){
                    if(iceridekiYolcular.get(i).istek==0){
                        zeminKatIstekSayisi++;
                    }else if(iceridekiYolcular.get(i).istek==1){
                        birinciKatIstekSayisi++;
                    }else if(iceridekiYolcular.get(i).istek==2){
                        ikinciKatIstekSayisi++;
                    }else if(iceridekiYolcular.get(i).istek==3){
                        ucuncuKatIstekSayisi++;
                    }else{
                        dorduncuKatIstekSayisi++;
                    }
                }
                altIstekSayisi = 0;
                ustIstekSayisi = 0;

            }
        }

    }

    public void kilidiAc() {
        synchronized (lock1) {
            lock1.notify();
        }
    }

}
