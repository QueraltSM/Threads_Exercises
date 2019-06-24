package golf;
import java.util.*;

public class Club extends Thread {
    private int pelotas_reservadas;
    private int palos_reservados;
    private int max_pelotas = 20;
    private int max_palos = 20;
    private List<Jugador> reservasJugadores = new ArrayList<Jugador>();
    
    public synchronized boolean reservar(Jugador jugador, int pelotas, int palos) {
        while (pelotas_reservadas >= max_pelotas || palos_reservados >= max_palos) {
            try {
                System.out.println("No hay material suficiente disponible");
                wait(); 
                return false;
            } catch(InterruptedException e) {}
        }
        reservasJugadores.add(jugador);
        pelotas_reservadas += pelotas;
        palos_reservados += palos;
        notifyAll();
        return true;
    }
    
    public synchronized void devolucion(Jugador jugador, int pelotas, int palos) {
        while (pelotas_reservadas == 0 || palos_reservados == 0) {
            try {
                System.out.println("No hay material que ser devuelto");
                wait(); 
            } catch(InterruptedException e) {}
        }
        reservasJugadores.remove(jugador);
        pelotas_reservadas -= pelotas;
        palos_reservados -= palos;
        notifyAll();    
    }
}
