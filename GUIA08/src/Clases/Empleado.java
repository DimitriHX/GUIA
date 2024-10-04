package Clases;
public class Empleado {
    //Se deben agregar los atributos
    private int codigo;
    private String nombre;
    private double horas, tarifa;
    
    //Constructor 

    public Empleado(int codigo, String nombre, double horas, double tarifa) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.horas = horas;
        this.tarifa = tarifa;
    }
    
    //Metodos get y set

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }
    
}
