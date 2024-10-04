package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class ArregloEmpleados {
    //Atributo de la clase ArregloEmpleados
      private Empleado vectorEmpleados[];
      private int indice;
      
      //Contructor
      public ArregloEmpleados(){
          vectorEmpleados = new Empleado[100];
          indice = 0;
          
          //llamamos al metodo cargar datos
          cargarDatos();
      }
      
      //Métodos a utilizar segun el enunciado
      //Método que registra los valores de un empleado
      public void adiciona(Empleado objEmp){
          vectorEmpleados[indice] = objEmp;
          indice++;
      }
      
      //Método que devuelve los datos del empleado
      //indicado desde el arreglo
      
      public Empleado obtenerEmpleado (int pos){
          return vectorEmpleados[pos];
      }
      
      public int obtenerTamaño(){
          return indice;
      }
      
      //Método que busca un empleado por su codigo
      public int buscar(int codigo){
          for (int i = 0; i < obtenerTamaño();i++){
              if (codigo == vectorEmpleados[i].getCodigo()) {
                  return i;
              }
          }
          return -1;
      }
      
      //Método que permite eliminar un empleado 
      public void eliminar (int codigo){
          int pos = buscar(codigo);
          for (int i = 0; i < obtenerTamaño(); i++) {
              vectorEmpleados[i] = vectorEmpleados[i + 1];
          }
          indice--;
      }
      
      //Método que permite grabar en un archivo el contenido del arreglo Empleados
    public void grabar(){
        try {
            //Llamamos al método "PrintWriter" para crear el objeto de flujo-
            //que nos permitira escribir en el archivo 
            PrintWriter pw = new PrintWriter(new FileWriter(".Empleados.txt"));
            
            //Recorremos el arreglo
            for (int i = 0; i < obtenerTamaño(); i++) {
                pw.println(obtenerEmpleado(i).getCodigo() + ","
                + obtenerEmpleado(i).getNombre() + ","
                + obtenerEmpleado(i).getHoras() + "."
                + obtenerEmpleado(i).getTarifa() + ","
                + obtenerEmpleado(i).getTarifa()
                * obtenerEmpleado(i).getHoras());
            }
            pw.close(); //cerramos el flujo
            JOptionPane.showMessageDialog(null, "Operación exitosa");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Guardado del archivo Exitoso",
                    "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Método que permite abrir el archivo Empleados.txt y obtener los valores contenidos
    // almacenadolo en variables locales 
    public void cargarDatos(){
        try {
            //Definimos un objeto para cargar el archivo
            File archivo = new File("Empleados.txt");
            
            //SI el archivo existe
            if (archivo.exists()) {
                //Llamamos a clase "BufferedReader" para crear el objeto de flujo
                // que nos permitira leer del archivo
                BufferedReader br = new BufferedReader(new FileReader("Empleados.txt"));
                String linea; // variable que almacena la linea del archivo
                
                // SI la variable linea contiene información
                while ((linea = br.readLine()) != null) {
                    //Definición del separador de valores en Empleados.txt
                    StringTokenizer st = new StringTokenizer(linea , ",");
                    
                    //Definimos las variables donde se almacenara temporalmente la 
                    //informacion de cada empleado en el archivo
                    int cod = Integer.parseInt(st.nextToken().trim());
                    String nom = st.nextToken().trim();
                    double horas = Double.parseDouble(st.nextToken().trim());
                    double precio = Double.parseDouble(st.nextToken().trim());
                    //Crear el archivo registro de empleado obtenido del
                    //archivo Empleados.txt
                    Empleado x = new Empleado(cod, nom, horas, precio);
                    adiciona(x);                    
                }
                br.close(); //cerramos el flujo                
            } else {
                JOptionPane.showMessageDialog(null, "El archivo de texto no existe");
            }
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Se produjo un error" + x);
        }
    }
    
      
}
