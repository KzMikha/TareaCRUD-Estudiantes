package Model;

/**
 *
 * @author Erick
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;


public class Gestion{
    	static String direc = "C:\\dataStudents.bin";
    //GuardarDatos de Estudiantes
    public static void GuardarDatos(Vector<Estudiantes> datos) throws FileNotFoundException,IOException{
        File file = new File(direc);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        DataOutputStream outStream = new DataOutputStream(fileOutputStream);
        
        outStream.writeInt(datos.size());
        
        for(int i =0;i<datos.size();i++){
            outStream.writeUTF(datos.get(i).getNombre());
            outStream.writeUTF(datos.get(i).getApellidos());
            outStream.writeUTF(datos.get(i).getCarnetIdentidad());
            outStream.writeInt(datos.get(i).getEdad());
        }
        outStream.flush();
        outStream.close();
    }
  
    public static Vector<Estudiantes> CargarDatos() throws FileNotFoundException,IOException,ClassNotFoundException{
        File file = new File(direc);
        Vector<Estudiantes> client=new Vector<Estudiantes>();
        
        FileInputStream fileInputStream = new FileInputStream(file);
        DataInputStream InStream = new DataInputStream(fileInputStream);
        
        int capacidad = InStream.readInt();
        
        for(int i =0;i<capacidad;i++){
            String Nombre = InStream.readUTF();
            String Apellidos = InStream.readUTF();
            String CI = InStream.readUTF();
            int Edad = InStream.readInt();
            Estudiantes info =new Estudiantes(Nombre, Apellidos, CI, Edad);
             client.add(info);
        }
        InStream.close();
        return client;
        
    }
    public static Vector<Estudiantes> Register_Client(Estudiantes info, Vector<Estudiantes> client) throws Exception{
        for(int i =0;i<client.size();i++){
            if(client.get(i).getCarnetIdentidad().equals(info.getCarnetIdentidad())){
                throw new Exception("Ya se encuentra el nombre del estudiante");
            }
        }
        client.add(info);
        GuardarDatos(client);
        return client;
    }
    public static Vector<Estudiantes> Delete_Client(String CI,Vector<Estudiantes> users){
        for(int i =0;i<users.size();i++){
            if(users.get(i).getCarnetIdentidad().equals(CI)){
                users.remove(i);
                return users;
            }
        }
        return users;
    }
    public static void leer(Vector<Estudiantes>users) {
    	for(int i =0;i<users.size();i++) {
    		System.out.println(i+"-"+users.get(i).getNombre()+" "+users.get(i).getApellidos());
    	}
    }
    
}