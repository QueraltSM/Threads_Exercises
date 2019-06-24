package gofio;
public class Tienda extends Thread {
    int capacidad;
    ValoresSimulacion valoresSimulacion;
    
    public Tienda(int capacidad){
        this.capacidad = capacidad;
    }
    
    public boolean vender(int idAgricultor, int sacos){ //El agricultor intenta vender N sacos de 20kg
        if (sacos + capacidad > capacidad) {
            try {
                System.out.println("Espera venta");
                sleep(valoresSimulacion.esperaVenta());
                return false;
            } catch (InterruptedException e) {}
        }
        return true;
    }
    public boolean comprar(int idCliente, int kilos){//El cliente intenta comprar N kilos
        if (kilos > capacidad + stock()) {
            try {
                System.out.println("Espera compra");
                sleep(valoresSimulacion.esperaCompra());
                return false;
            } catch(InterruptedException e) {}
        }
        return true;
    }
    public int stock(){ //kilos en stock
        return 0;
    }
}
