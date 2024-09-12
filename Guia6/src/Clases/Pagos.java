
package Clases;

/**
 *
 * @author josea
 */
public class Pagos {
    //Atributos}
    String categoria;
    double promedio;
    
    //constructor

    public Pagos(String categoria, double promedio) {
        this.categoria = categoria;
        this.promedio = promedio;
    }
     //metodo get y set

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    
    //otros metodos
    //metodo para calcular la cuota del estudiante
    public double asignarCuota(){
    switch(getCategoria()){
    
        case "A":
            return 85.00;
            
            case "B":
            return 70.00;
            
            case "C":
            return 65.00;
            
            case "D":
            return 60.00;
            
            default:
                return 0.00;
    }
    }
    
    //metodo para calcular descuento
    
    public double CalcularDescuento(){
    //verificar el promedio de notas
    
    if(getPromedio() <= 3.99) {
    return 0.00;
    }
    else if (getPromedio() <= 5.99){
    return asignarCuota() * 0.10;
    }
    else if (getPromedio() <= 7.99){
    return asignarCuota() *0.12;
    }
    else {
    return asignarCuota()*0.15;
    }
    
   }
    // metodo para calcular el valor a pagar por el estudiante
    public double determinaCuotaApagar(){
    return asignarCuota() - CalcularDescuento();
    }
}
