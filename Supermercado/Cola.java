package supermercado;
import java.util.*;
class Cola extends Thread{
    private List<Cliente>clientes = new ArrayList<Cliente>();
    private int max = 0;
    private double precioCarrito;
    private boolean cerrar = false;
    private String nombreCliente;
    
    public synchronized void añadir(Cliente cliente) {
        if (!cerrar) {
            if (clientes.size() <= 5) System.out.println("Nuevo cliente en la cola");
            clientes.add(cliente);
            max++;
            notifyAll();  
        }
    }
    
    public synchronized Cliente sacar() {
        while (cerrar || clientes.size() > 0) {
            try {
                wait();
                return null;
            } catch (InterruptedException e) {}
        }
        Cliente cliente = clientes.get(0);
        double precioCarrito = cliente.damePrecioCarro();
        setPrecioCarritoActual(precioCarrito);
        setNombreClienteActual(cliente.dameNombre());
        clientes.remove(cliente);
        return cliente;
    }
    
    public synchronized void cerrar() {
        cerrar = true;
        notifyAll();
    }
    
    public int tamañoMaximo() {
        return max;
    }
    
    public void setPrecioCarritoActual(double precio) {
        this.precioCarrito = precio;
    }
    
    public double getPrecioCarritoActual(){
        return precioCarrito;
        
    }
    
    public String getNombreClienteActual(){
        return nombreCliente;
    }
    
    public void setNombreClienteActual(String nombreCliente){
        this.nombreCliente = nombreCliente;
    }
}