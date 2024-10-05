package modelo;
public class Factura {
    //Atributos 
    private int nFactura;
    private String fecha;
    private String vendedor;
    private double monto;

    public Factura(int nFactura, String fecha, String vendedor, double monto) {
        this.nFactura = nFactura;
        this.fecha = fecha;
        this.vendedor = vendedor;
        this.monto = monto;
    }

    public int getnFactura() {
        return nFactura;
    }

    public void setnFactura(int nFactura) {
        this.nFactura = nFactura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    
    
}
