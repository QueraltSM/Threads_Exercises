package gofio;
public class Cliente extends Thread {
    int id;
    ValoresSimulacion valoresSimulacion;
    boolean termina = false;
    Tienda t;
    int total_gofio = 0;
    
    public Cliente(int id, Tienda t){
        this.id=id;
        this.t = t;
    }
    public int comprado(){
        return total_gofio;
    }
    public void run() {
        while (!termina) {
            int gofioConsumir = valoresSimulacion.cantidadAComprar();
            if (t.comprar(id, gofioConsumir)) {
                total_gofio += gofioConsumir;
                System.out.println("Cliente comprando");
                try {
                    System.out.println("Cliente consumiendo");
                    sleep(valoresSimulacion.tiempoConsumoKilo());
                } catch (InterruptedException e) {}
            } else termina = false;
        }
    }
}
