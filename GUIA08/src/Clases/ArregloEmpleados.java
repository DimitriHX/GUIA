package Clases;
public class ArregloEmpleados {
    //Atributo de la clase ArregloEmpleados
      private Empleado vectorEmpleados[];
      private int indice;
      
      //Contructor
      public ArregloEmpleados(){
          vectorEmpleados = new Empleado[100];
          indice = 0;
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
}
