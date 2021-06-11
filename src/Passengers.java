
import java.util.ArrayList;
import java.util.LinkedList;
public class Passengers {
    public int id;
    public int istek;
    public int bulunduguKat;
    
   
    public Passengers() {
      
    }
    
    public Passengers(int id) {
        this.id = id;
    }

    public Passengers(int id, int istek, int bulunduguKat) {
        this.id = id;
        this.istek = istek;
        this.bulunduguKat = bulunduguKat;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIstek() {
        return istek;
    }

    public void setIstek(int istek) {
        this.istek = istek;
    }

    public int getBulunduguKat() {
        return bulunduguKat;
    }

    public void setBulunduguKat(int bulunduguKat) {
        this.bulunduguKat = bulunduguKat;
    }
    
        
}
