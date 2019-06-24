package supermercado;
import java.util.*;
class Caja extends Thread{
    private Cola cola;
    private Contabilidad contabilidad;
    private boolean finaliza = false;
    private double totalCaja;
    private List<Cliente>clientes = new ArrayList<Cliente>();
    
    public Caja(Cola cola, Contabilidad contabilidad) {
        this.cola = cola;
        this.contabilidad = contabilidad;
    }
    
    public void setResult(double totalCajaX){
        for (Cliente cliente : clientes) {
            totalCaja += cliente.damePrecioCarro();
        }
    }
    public String getResult() {
        return "Caja facturó " + totalCaja;
    }
    
    public void guardarCliente(Cliente cliente) {
        clientes.add(cliente);
    }
    
    public void run() {
        while (!finaliza) {
            Cliente cliente = cola.sacar();
            if (cliente != null) {
                guardarCliente(cliente);
                try {
                    System.out.println("Atendiendo al cliente");
                    int tiempoAtencion = (int) (cola.getPrecioCarritoActual() / 50.0);
                    contabilidad.añadeSaldo(cola.getPrecioCarritoActual());
                    Thread.sleep(tiempoAtencion*1000);
                } catch (Exception e) {}
            } else {
                finaliza = true;
                System.out.println(getResult());
            }
        }
        System.out.println ("Clientes atendidos = " + cola.tamañoMaximo() + 
        " y facturación total de las cajas = " + contabilidad.dameSaldo());
    }
}