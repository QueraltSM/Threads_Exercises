package golf;
public class Jugador extends Thread {
    private String id;
    private int pelotas;
    private int palos;
    private Club club = new Club();
    private Simulador simulador;
    private boolean termina = false;
    
    public Jugador(String id, int pelotas, int palos) {
        this.id = id;
        this.pelotas = pelotas;
        this.palos = palos;
    }
    
    public void run () {
        while (!termina) {
            System.out.println("Registrado usuario: " + id);
            if (club.reservar(this, pelotas, palos)) {
                System.out.println(id + "[ " + pelotas + "," + palos + " reserva");
                
                try {
                   System.out.println(id + "[ " + pelotas + "," + palos + " juega");
                   sleep(simulador.tiempoJuego());
                } catch (InterruptedException e) {}
                
                club.devolucion(this, pelotas, palos);
                System.out.println(id + "[ " + pelotas + "," + palos + " devolucion");
                
                try {
                   System.out.println(id + "[ " + pelotas + "," + palos + " descansa");
                   sleep(simulador.tiempoDescanso());
                } catch (InterruptedException e) {}

            } else termina = true;
        }
    }
}
