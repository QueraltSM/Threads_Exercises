package bicing;
import java.util.*;

public class Usuario extends Thread{
    int id;
    Estacion salida;
    Estacion llegada;
    boolean termina = false;
    
    public Usuario(int id, Estacion salida, Estacion llegada){
        this.id=id;
        this.salida = salida;
        this.llegada = llegada;
    }
    
    public int getRandom(int min, int max) {
        Random r = new Random();
        return r.nextInt((max-min) + 1) + min;
    }
    
    public void run(){
        while (!termina) {
            Bicicleta bici = salida.alquila(id);
            if (bici != null) {
                System.out.println("El usuario " + id + " alquila una bici");
                try {
                    int paseo = getRandom(4000, 7000);
                    sleep(paseo);
                    System.out.println("El usuario " + id + " da un paseo de " + paseo + " milisegundos.");
                    llegada.devuelve(bici,id);
                    System.out.println("El usuario " + id + " devuelve la bici");
                    termina = true;
                } catch (InterruptedException e) {}
            } else termina = true;
        }
    }
}