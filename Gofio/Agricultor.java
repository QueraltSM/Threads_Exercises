package gofio;
public class Agricultor extends Thread {
    int id;
    ValoresSimulacion valoresSimulacion;
    boolean termina = false;
    int vendido = 0;
    Tienda t;
    
    public Agricultor(int id, Tienda t){
        this.id=id;
        this.t = t;
    }
    public int vendido(){ 
        // RETORNAR nº de Kg
        return vendido; 
    }
    public void run() {
        for (int i = 0; i<5; i++) {
            System.out.println("Agricultor cosechando");
            try {
                sleep(valoresSimulacion.tiempoCosecha());
            } catch (InterruptedException e) {}
            int cantidadCosechada = valoresSimulacion.cantidadCosechada();
            if (t.vender(id, cantidadCosechada)) {
                System.out.println("Agricultor vende");
                vendido += cantidadCosechada;
            }
        }
    }
}
