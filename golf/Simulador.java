package golf;
public class Simulador {
    private static long tini=System.currentTimeMillis();
    private static java.util.Random rand= new java.util.Random();
    
    static int veces_Jugadas = 0;
    
    static Jugador jugador1 = new Jugador("1e", 1, 2);
    static Jugador jugador2 = new Jugador("2e", 1, 3);
    static Jugador jugador3 = new Jugador("3e", 1, 4);
    static Jugador jugador4 = new Jugador("4e", 1, 5);
    static Jugador jugador5 = new Jugador("5e", 1, 2);
    static Jugador jugador6 = new Jugador("6e", 1, 3);
    static Jugador jugador7 = new Jugador("7e", 1, 4);
    static Jugador jugador8 = new Jugador("8n", 2, 2);
    static Jugador jugador9 = new Jugador("9n", 3, 2);
    static Jugador jugador10 = new Jugador("10n", 4, 2);
    static Jugador jugador11 = new Jugador("11n", 5, 2);
    static Jugador jugador12 = new Jugador("12n", 2, 2);
    static Jugador jugador13 = new Jugador("13n", 3, 2);
    static Jugador jugador14 = new Jugador("14n", 4, 2);
    
    public static void main(String[] args) {
        
        while (veces_Jugadas < 5) {
            
            jugador1.start();
            jugador2.start();
            jugador3.start();
            jugador4.start();
            jugador5.start();
            jugador6.start();
            jugador7.start();
            jugador8.start();
            jugador9.start();
            jugador10.start();
            jugador11.start();
            jugador12.start();
            jugador13.start();
            jugador14.start();
            
            try {
                jugador1.join();
                jugador2.join();
                jugador3.join();
                jugador4.join();
                jugador5.join();
                jugador6.join();
                jugador7.join();
                jugador8.join();
                jugador9.join();
                jugador10.join();
                jugador11.join();
                jugador12.join();
                jugador13.join();
                jugador14.join();  
                
            } catch(Exception e) {}    
            
            veces_Jugadas += 1;
            System.out.println("----------------------------");
        }
        
        
        // Complete aquí la simulación
        log("Termina Simulador.main");
    }
    
    // Muestra información en la pantalla
    public static void log(String message) {
            long cur=System.currentTimeMillis();
            String t= String.format("%6.1fs      \033[1;33m%s\033[m\n", (cur-tini)/1000.0, message);
            System.out.print(t);
    }
    
    // Devuelve tiempo de juego en milisegundos
    public static int tiempoJuego() {
        return rand.nextInt(1000);
    }
    
    // Devuelve tiempo de descanso en milisegundos
    public static int tiempoDescanso() {
        return rand.nextInt(1000);
    }
}
