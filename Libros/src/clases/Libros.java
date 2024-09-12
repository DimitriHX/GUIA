package clases;
public class Libros {
    //Atributos 
    private String nombre,editorial,tipo;
    private int year,paginas;
    private double precio;
    
    
    //Variable de clase estatica
    
    private static int tAnalisisB;
    
    
    //Constructor 

    public Libros(String nombre, String editorial, String tipo, int year, int paginas, double precio) {
        this.nombre = nombre;
        this.editorial = editorial;
        this.tipo = tipo;
        this.year = year;
        this.paginas = paginas;
        this.precio = precio;
        
        //Llamar al metodo "conteo" 
        conteos();
    }
    
    //Métodos get and set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    //Otros metodos de la clase 

    public static int gettAnalisisB() {
        return tAnalisisB;
    }

    public static void settAnalisisB(int tAnalisisB) {
        Libros.tAnalisisB = tAnalisisB;
    }
    
    
    //Metodo para contar libros pero de tipo "analisis"
    void conteos(){
        if (getTipo().equals("Analisis") && getEditorial().equals("B")){
            tAnalisisB++;
        }
    }
    
    
    
}
