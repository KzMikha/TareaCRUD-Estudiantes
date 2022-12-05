package Main;

import Model.Estudiantes;
import TransitoDeDatos.AccederAlmacenamiento;

import Exception.ErrorEntradaNoValida;
import Exception.ErrorTipoDeDato;
import TransitoDeDatos.Consola;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
      public static ArrayList<Estudiantes> estudiantes;
      public static void main(String[]args){
          try {
              estudiantes = AccederAlmacenamiento.cargarDatos();
          }
            catch(FileNotFoundException ex){
                Consola.imprimirMensaje("No hay datos.");
                estudiantes = new ArrayList<>();
            }
            catch(IOException ex){
                estudiantes = new ArrayList<>();
                System.out.println("IOException");
                Consola.imprimirMensaje(ex.getMessage());
            }
            catch(ClassNotFoundException ex){
                estudiantes = new ArrayList<>();
                Consola.imprimirMensaje(ex.getMessage());
            }
          boolean funcionando = true;
            while (funcionando) {              
                Consola.mostrarOpciones();
                int opcion = Consola.ObtenerOpcion();
                if (opcion==1) {
                estudiantes.add(Consola.entrarEstudiante());    
                } 
                else if(opcion==2){
                Consola.mostrarEstudiante(estudiantes);    
                }
                else if(opcion==3){
                try {
                  int estudiantes = Consola.elegirEstudiante();
                  Consola.modificarEstudiante(estudiantes);
                }     
                catch(ErrorEntradaNoValida | ErrorTipoDeDato e){
                    Consola.imprimirMensaje(e.getMessage());
                 }
                }
                else if(opcion==4){
                 int cantEstudiantes;
                 try {
                   cantEstudiantes = Consola.elegirEstudiante();  
                   estudiantes.remove(cantEstudiantes);
                   Consola.BorrarEstudianteNotificacion();
                  }    
                 catch(ErrorEntradaNoValida | ErrorTipoDeDato e){
                    Consola.imprimirMensaje(e.getMessage());
                 }
                } 
                else if(opcion==5){
                 try {
                   AccederAlmacenamiento.guardarDatos(estudiantes);
                   Consola.guardarCambiosNotificacion();  
                   estudiantes.remove(estudiantes);
                 }    
                 catch(IOException ex){
                   Consola.imprimirMensaje(ex.getMessage());
                 }
                } 
                else if(opcion==6){
                   Consola.salirNotificacion();
                   System.exit(0);
                }
            }
        }
    }
