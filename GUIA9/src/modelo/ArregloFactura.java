package modelo;

import java.util.ArrayList;

public class ArregloFactura {
    //Atributos del arregloFactura
    private ArrayList <Factura> facturas;
    private int indice;
    
    
    //Contructor 
    public ArregloFactura(){
        //Crear el arraylist
        facturas = new ArrayList<Factura>();
    }
    
    //Otros métodos 
    //Agregar Factura
    
    public void agregarFactura(Factura fac){
        //LLamar al metodo "add"
        facturas.add(fac);
    }
    
    //Método que retorna la cantidad de facturas 
    public int obtenerTamaño(){
        //llamar al método "size"
        return facturas.size();
    }
    
    public Factura obtener(int posicion){
        //llamar al método "get"
        return facturas.get(posicion);
    }
    
    //Método para buscar factura
    public Factura buscar(int numFact){
        //Usar un "foreach"
        for (Factura f:facturas) {
            //Verificamos si se encuentra la factura retorna la factura encontrada
            //caso contrario retornara nulo 
            // f es buscar numero de factura
                if (f.getnFactura() == numFact) {
                return f;
            }
        }
        return null;
    }
    
    //Método para eliminar una factura en concreto
    public void  eliminar (Factura fac){
        // Llamar al metodo "remove"
        facturas.remove(fac);
    }
    
    
    
}
