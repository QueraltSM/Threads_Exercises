package supermercado;
public class Main{
    public static void main(String[] args){
        Contabilidad contabilidad = new Contabilidad();
        
        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
        Cliente cliente3 = new Cliente();
        Cliente cliente4 = new Cliente();
        Cliente cliente5 = new Cliente();
        Cliente cliente6 = new Cliente();
        Cliente cliente7 = new Cliente();
        Cliente cliente8 = new Cliente();
        Cliente cliente9 = new Cliente();
        
        // Cree aquí las 3 cajas e inicie los hilos
        Cola cola = new Cola();
        cola.añadir(cliente1);
        cola.añadir(cliente2);
        cola.añadir(cliente3);
        cola.añadir(cliente4);
        cola.añadir(cliente5);
        cola.añadir(cliente6);
        cola.añadir(cliente7);
        cola.añadir(cliente8);
        cola.añadir(cliente9);
        Caja caja1 = new Caja(cola,contabilidad);
        Caja caja2 = new Caja(cola,contabilidad);
        Caja caja3 = new Caja(cola,contabilidad);
        caja1.start();
        caja2.start();
        caja3.start();
        
        long tiempoActual = System.currentTimeMillis();
        java.util.Random r = new java.util.Random();
        for (int i = 0; i < 50; i++) {
            try {
                // cola.añadir(new Cliente());
                int random=r.nextInt(600);
                Thread.sleep(random);
            } catch (InterruptedException exc) {}
        }
        // Espere a que terminen las cajas
        // Muestre la información de la contabilidad
        // Muestre la información de clientes y facturación de cada caja
        
        try {
            caja1.join();
            caja2.join();
            caja3.join();
        } catch (Exception e) {}
    
    }
}
