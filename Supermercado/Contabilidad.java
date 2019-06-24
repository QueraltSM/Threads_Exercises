package supermercado;
class Contabilidad {
    private double totalSaldo;
    
    public Contabilidad () {
        totalSaldo = 0.0;
    }
    
    public void añadeSaldo(double saldo) {
        totalSaldo += saldo;
    }
    
    public double dameSaldo(){
        return totalSaldo;
    }
}