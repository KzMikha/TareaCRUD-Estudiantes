package TransitoDeDatos;

import Exception.ErrorEntradaNoValida;
import Exception.ErrorTipoDeDato;
import java.util.Scanner;
import Model.Estudiantes;
import Main.Main;
import static Main.Main.estudiantes;
import java.util.ArrayList;


public class Consola {
  public static void mostrarOpciones(){
      System.out.println("Opciones:");
      System.out.println("1: Agregar estudiante");
      System.out.println("2: Mostrar lista de estudiantes");
      System.out.println("3: Modificar estudiante");
      System.out.println("4: Borrar estudiante");
      System.out.println("5: Guardar");
      System.out.println("6: Salir");
  }
  public static int ObtenerOpcion() throws ErrorTipoDeDato{
      Scanner read = new Scanner(System.in);
      int opcionEscogida = read.nextInt();
      return opcionEscogida;
  }  
 public static Estudiantes entrarEstudiante(){
      Scanner read = new Scanner(System.in);
      System.out.println("Agregando Estudiante");     
      System.out.println("Diga el nombre");
      String nombre = read.nextLine();
      System.out.println("Diga los apellidos");
      String apellidos = read.nextLine();
      System.out.println("Diga el carnet de Identidad");
      int carnetIdentidad = read.nextInt();
      
      Estudiantes nuevo = new Estudiantes(nombre, apellidos, carnetIdentidad);
      return nuevo;
    }
public static void mostrarEstudiante(ArrayList estudiantes){
      System.out.println("");
      for (int i = 0; i < estudiantes.size(); i++) {
        System.out.println("Estudiante#"+(i+1)+"");
        System.out.println(estudiantes.get(i).toString());
      }
      System.out.println(""); 
}
public static void modificarEstudiante(int numeroEstudiante) throws
        ErrorEntradaNoValida, ErrorTipoDeDato{
    Scanner read = new Scanner(System.in);
    Estudiantes estudiante = estudiantes.get(numeroEstudiante);
    System.out.println("Diga el dato que desee modificar:");
    System.out.println("Nombre");
    System.out.println("Apellidos");
    System.out.println("Carnet de Identidad");
    System.out.println("Todo");
    int opcion = read.nextInt();
    if (opcion==1){
        String nombre = read.nextLine();
        estudiante.setNombre(nombre);
    }
    else if (opcion==2){
        String apellidos = read.nextLine();
        estudiante.setApellidos(apellidos);
    }
    else if (opcion==3){
        long carnetIdentidad = read.nextInt();
        estudiante.setCarnetIdentidad(carnetIdentidad);
    }
    else {
        estudiante = Consola.entrarEstudiante();
    }
}
public static void BorrarEstudianteNotificacion(){
    System.out.println("El estudiante fue borrado");
}
public static void guardarCambiosNotificacion(){
    System.out.println("Los datos fueron guardados");
}
public static void salirNotificacion(){
    System.out.println("Adios");
}
public static int elegirEstudiante() throws ErrorEntradaNoValida, 
        ErrorTipoDeDato{
    System.out.println("Diga el numero del estudiante");
    Scanner read = new Scanner(System.in);
    int pos = read.nextInt();
    if(pos<1 || pos>Main.estudiantes.size()){
     throw new ErrorEntradaNoValida();
    }
    pos -- ;
    return pos;
}
public static void imprimirMensaje(String msg){
    System.out.println("\n"+msg);
}
}
