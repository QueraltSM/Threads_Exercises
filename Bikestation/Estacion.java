package bicing;
import java.util.*;
import java.util.Queue;

public class Estacion extends Thread{
    int id;
    int max_bicis;
    private Queue<Bicicleta> bicicletas = new LinkedList<Bicicleta>();
    
    public Estacion(int id, int max_bicis){
        this.id=id;
        this.max_bicis=max_bicis;
        inicializaBicis();
    }
    
    public synchronized void devuelve(Bicicleta bici, int userID) {
        while (bicicletas.size() == max_bicis) {
            try {
                wait();
            } catch(InterruptedException e) {}  
        }
        bicicletas.add(bici);
        notifyAll();
    }
    
    public synchronized Bicicleta alquila(int userID) {
        while (bicicletas.size() == 0) {
            try {
                sleep(10000);
                return null;
            } catch(InterruptedException e) {}  
        }
        notifyAll();
        return bicicletas.remove();
    }
    
    public String getIDBici(){
        int j = 0;
        String result = "";
        while(j<max_bicis){
            result += j;
            j++;
        }
        int number = id*1000;
        return String.valueOf(number) +  result;
    }
    
    public void inicializaBicis() {
        int i = 0;
        while (i<max_bicis) {
            bicicletas.add(new Bicicleta(Integer.parseInt(getIDBici())));
            i++;
        }
    }
}