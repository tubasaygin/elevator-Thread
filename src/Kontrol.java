
import java.util.logging.Level;
import java.util.logging.Logger;

public class Kontrol extends Thread {

    private Katlar[] katlar = new Katlar[5];
    private int toplamKuyruktaBekleyenler;
    private int kacAsansorCalisiyor;

    Giris giris = new Giris();
    Asansor asansor;
    Asansor1 asansor1;
    Asansor2 asansor2;
    Asansor3 asansor3;
    Asansor4 asansor4;

    public Kontrol() {
    }

    public Kontrol(Katlar[] katlar, int kacAsansorCalisiyor, Asansor asansor, Asansor1 asansor1, Asansor2 asansor2, Asansor3 asansor3, Asansor4 asansor4) {
        this.asansor = asansor;
        this.asansor1 = asansor1;
        this.asansor2 = asansor2;
        this.asansor3 = asansor3;
        this.asansor4 = asansor4;
        this.kacAsansorCalisiyor = kacAsansorCalisiyor;
        this.katlar = katlar;
        toplamKuyruktaBekleyenler = 0;

    }

    public void run() {

        while (true) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Kontrol.class.getName()).log(Level.SEVERE, null, ex);
            }
            toplamKuyruktaBekleyenler = katlar[0].getKuyruk().size() + katlar[1].getKuyruk().size() + katlar[2].getKuyruk().size() + katlar[3].getKuyruk().size() + katlar[4].getKuyruk().size();
            if (toplamKuyruktaBekleyenler <= 20) {
                System.out.println("Toplam kuyrukta bekleyen : " + toplamKuyruktaBekleyenler);
                asansor.kilidiAc();
                if (asansor1.iceridekiYolcular.size() > 0) {
                    asansor1.kilidiAc();
                }
                if (asansor2.iceridekiYolcular.size() > 0) {
                    asansor2.kilidiAc();
                }
                if (asansor3.iceridekiYolcular.size() > 0) {
                    asansor3.kilidiAc();
                }
                if (asansor4.iceridekiYolcular.size() > 0) {
                    asansor4.kilidiAc();
                }
                asansor.setAktifMi(true);
                asansor1.setAktifMi(false);
                asansor2.setAktifMi(false);
                asansor3.setAktifMi(false);
                asansor4.setAktifMi(false);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Kontrol.class.getName()).log(Level.SEVERE, null, ex);
                }
                asansorBilgiYazdir(asansor, asansor1, asansor2, asansor3, asansor4);

            } else if (toplamKuyruktaBekleyenler <= 40 && toplamKuyruktaBekleyenler > 20) {
                System.out.println("Toplam kuyrukta bekleyen : " + toplamKuyruktaBekleyenler);
                asansor.kilidiAc();
                asansor1.kilidiAc();
                if (asansor2.iceridekiYolcular.size() > 0) {
                    asansor2.kilidiAc();
                }
                if (asansor3.iceridekiYolcular.size() > 0) {
                    asansor3.kilidiAc();
                }
                if (asansor4.iceridekiYolcular.size() > 0) {
                    asansor4.kilidiAc();
                }
                asansor.setAktifMi(true);
                asansor1.setAktifMi(true);
                asansor2.setAktifMi(false);
                asansor3.setAktifMi(false);
                asansor4.setAktifMi(false);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Kontrol.class.getName()).log(Level.SEVERE, null, ex);
                }
                asansorBilgiYazdir(asansor, asansor1, asansor2, asansor3, asansor4);

            } else if (toplamKuyruktaBekleyenler <= 60 && toplamKuyruktaBekleyenler > 40) {
                System.out.println("Toplam kuyrukta bekleyen :" + toplamKuyruktaBekleyenler);
                asansor.kilidiAc();
                asansor1.kilidiAc();
                asansor2.kilidiAc();
                if (asansor3.iceridekiYolcular.size() > 0) {
                    asansor3.kilidiAc();
                }
                if (asansor4.iceridekiYolcular.size() > 0) {
                    asansor4.kilidiAc();
                }
                asansor.setAktifMi(true);
                asansor1.setAktifMi(true);
                asansor2.setAktifMi(true);
                asansor3.setAktifMi(true);
                asansor4.setAktifMi(false);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Kontrol.class.getName()).log(Level.SEVERE, null, ex);
                }
                asansorBilgiYazdir(asansor, asansor1, asansor2, asansor3, asansor4);

            } else if (toplamKuyruktaBekleyenler <= 80 && toplamKuyruktaBekleyenler > 60) {
                System.out.println("Toplam kuyrukta bekleyenler: " + toplamKuyruktaBekleyenler);
                asansor.kilidiAc();
                asansor1.kilidiAc();
                asansor2.kilidiAc();
                asansor3.kilidiAc();
                if (asansor4.iceridekiYolcular.size() > 0) {
                    asansor4.kilidiAc();
                }
                asansor.setAktifMi(true);
                asansor1.setAktifMi(true);
                asansor2.setAktifMi(true);
                asansor3.setAktifMi(true);
                asansor4.setAktifMi(false);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Kontrol.class.getName()).log(Level.SEVERE, null, ex);
                }
                asansorBilgiYazdir(asansor, asansor1, asansor2, asansor3, asansor4);

            } else {
                System.out.println("Toplam kuyrukta bekleyenler : " + toplamKuyruktaBekleyenler);
                asansor.kilidiAc();
                asansor1.kilidiAc();
                asansor2.kilidiAc();
                asansor3.kilidiAc();
                asansor4.kilidiAc();
                asansor.setAktifMi(true);
                asansor1.setAktifMi(true);
                asansor2.setAktifMi(true);
                asansor3.setAktifMi(true);
                asansor4.setAktifMi(true);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Kontrol.class.getName()).log(Level.SEVERE, null, ex);
                }
                asansorBilgiYazdir(asansor, asansor1, asansor2, asansor3, asansor4);

            }

        }
    }

    public synchronized void asansorBilgiYazdir(Asansor asansor, Asansor1 asansor1, Asansor2 asansor2, Asansor3 asansor3, Asansor4 asansor4) {

        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                System.out.println(i + "  all : " + katlar[i].getKisiSayisi() + " queue " + katlar[i].getKisiSayisi());
            } else {
                System.out.println(i + "  all : " + katlar[i].getKisiSayisi() + " queue " + katlar[i].getKuyruk().size());
            }

        }
        System.out.println("Asansor 0 Aktif Mi : " + asansor.isAktifMi());

        if (asansor.isAktifMi() == true) {
            System.out.println("            mode :  working");
        } else {
            System.out.println("            mode :  idle");
        }
        System.out.println("            floor : " + asansor.getMevcutKat());
        System.out.println("            destination : " + asansor.getDestination());
        if (asansor.isUp() == true) {
            System.out.println("            direction : up");
        } else {
            System.out.println("            direction : down");
        }
        System.out.println("            Capacity : 10");
        System.out.println("            Count inside :" + asansor.getIceridekiYolcular().size());

        System.out.format("             inside [(0, %d), (1,%d), (2,%d), (3,%d), (4,%d)]\n", asansor.getZeminKatIstekSayisi(), asansor.getBirinciKatIstekSayisi(), asansor.getIkinciKatIstekSayisi(), asansor.getUcuncuKatIstekSayisi(), asansor.getDorduncuKatIstekSayisi());

        System.out.println("Asansor 1 Aktif Mi : " + asansor1.isAktifMi());

        if (asansor1.isAktifMi() == true) {
            System.out.println("            mode :  working");
        } else {
            System.out.println("            mode :  idle");
        }
        System.out.println("            floor : " + asansor1.getMevcutKat());
        System.out.println("            destination : " + asansor1.getDestination());
        if (asansor1.isUp() == true) {
            System.out.println("            direction : up");
        } else {
            System.out.println("            direction : down");
        }
        System.out.println("            Capacity : 10");
        System.out.println("            Count inside :" + asansor1.getIceridekiYolcular().size());

        System.out.format("             inside [(0, %d), (1,%d), (2,%d), (3,%d), (4,%d)]\n", asansor1.getZeminKatIstekSayisi(), asansor1.getBirinciKatIstekSayisi(), asansor1.getIkinciKatIstekSayisi(), asansor1.getUcuncuKatIstekSayisi(), asansor1.getDorduncuKatIstekSayisi());

        System.out.println("Asansor 2 Aktif Mi : " + asansor2.isAktifMi());

        if (asansor2.isAktifMi() == true) {
            System.out.println("            mode :  working");
        } else {
            System.out.println("            mode :  idle");
        }
        System.out.println("            floor : " + asansor2.getMevcutKat());
        System.out.println("            destination : " + asansor2.getDestination());
        if (asansor2.isUp() == true) {
            System.out.println("            direction : up");
        } else {
            System.out.println("            direction : down");
        }
        System.out.println("            Capacity : 10");
        System.out.println("            Count inside :" + asansor2.getIceridekiYolcular().size());

        System.out.format("             inside [(0, %d), (1,%d), (2,%d), (3,%d), (4,%d)]\n", asansor2.getZeminKatIstekSayisi(), asansor2.getBirinciKatIstekSayisi(), asansor2.getIkinciKatIstekSayisi(), asansor2.getUcuncuKatIstekSayisi(), asansor2.getDorduncuKatIstekSayisi());

        System.out.println("Asansor 3 Aktif Mi : " + asansor3.isAktifMi());
        if (asansor3.isAktifMi() == true) {
            System.out.println("            mode :  working");
        } else {
            System.out.println("            mode :  idle");
        }
        System.out.println("            floor : " + asansor3.getMevcutKat());
        System.out.println("            destination : " + asansor3.getDestination());
        if (asansor3.isUp() == true) {
            System.out.println("            direction : up");
        } else {
            System.out.println("            direction : down");
        }
        System.out.println("            Capacity : 10");
        System.out.println("            Count inside :" + asansor3.getIceridekiYolcular().size());

        System.out.format("             inside [(0, %d), (1,%d), (2,%d), (3,%d), (4,%d)]\n", asansor3.getZeminKatIstekSayisi(), asansor3.getBirinciKatIstekSayisi(), asansor3.getIkinciKatIstekSayisi(), asansor3.getUcuncuKatIstekSayisi(), asansor3.getDorduncuKatIstekSayisi());

        System.out.println("Asansor 4 Aktif Mi : " + asansor4.isAktifMi());

        if (asansor4.isAktifMi() == true) {
            System.out.println("            mode :  working");
        } else {
            System.out.println("            mode :  idle");
        }
        System.out.println("            floor : " + asansor4.getMevcutKat());
        System.out.println("            destination : " + asansor4.getDestination());
        if (asansor4.isUp() == true) {
            System.out.println("            direction : up");
        } else {
            System.out.println("            direction : down");
        }
        System.out.println("            Capacity : 10");
        System.out.println("            Count inside :" + asansor4.getIceridekiYolcular().size());

        System.out.format("             inside [(0, %d), (1,%d), (2,%d), (3,%d), (4,%d)]\n", asansor4.getZeminKatIstekSayisi(), asansor4.getBirinciKatIstekSayisi(), asansor4.getIkinciKatIstekSayisi(), asansor4.getUcuncuKatIstekSayisi(), asansor4.getDorduncuKatIstekSayisi());

    }
}
