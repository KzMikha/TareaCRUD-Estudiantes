package TransitoDeDatos;
  import Model.Estudiantes;
  import java.io.*;
  import java.util.ArrayList;

public class AccederAlmacenamiento {
    static String ruta = "dataBase.data";
      
     public static ArrayList<Estudiantes> cargarDatos() throws
       FileNotFoundException, IOException,
       ClassNotFoundException {
         File baseDatos = new File(ruta);
         FileInputStream entradaDatos = new FileInputStream(baseDatos);
         ObjectInputStream entradaObjetos = new ObjectInputStream(entradaDatos);
        ArrayList<Estudiantes> estudiantes = new ArrayList<>();
          int CantEstudiantes = entradaObjetos.readInt();
            for (int i = 0; i < CantEstudiantes; i++) {
              Estudiantes nuevo = (Estudiantes)entradaObjetos.readObject();
              estudiantes.add(nuevo);
            }
          return estudiantes;  
    }      
    public static void guardarDatos (ArrayList<Estudiantes>estudiantes) throws
       FileNotFoundException, IOException{
         File baseDatos = new File(ruta);
         FileOutputStream salidaDatos = new FileOutputStream(baseDatos);
         ObjectOutputStream salidaObjetos = new ObjectOutputStream(salidaDatos);
           int Cant = estudiantes.size();
           salidaObjetos.writeInt(Cant);
            for (int i = 0; i < Cant; i++) {
              salidaObjetos.writeObject(estudiantes.get(i));
            }
          salidaObjetos.flush();  
          salidaObjetos.close();
        }     
    }
