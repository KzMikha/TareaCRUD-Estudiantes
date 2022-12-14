
package Model;

/**
 *
 * @author Erick
 */

import java.io.Serializable;


public class Estudiantes implements Serializable {
    private String Nombre;
    private String Apellidos;
    private String CarnetIdentidad;
    private int Edad;
    
public Estudiantes(String Nombre, String Apellidos, String CarnetIdentidad,
        int Edad) {
    this.Nombre = Nombre;
    this.Apellidos = Apellidos;
    this.CarnetIdentidad = CarnetIdentidad;
    this.Edad = Edad;
    }
    @Override 
public String toString() {
    return "{" + "Nombre: " + Nombre + ", Apellidos: " 
          + Apellidos +",Edad: " + Edad + ", CI: " + CarnetIdentidad + "}"; 
        }
  public String getNombre(){
    return Nombre;
  }
  public void setNombre(String Nombre){
    this.Nombre = Nombre;
  }
  public String getApellidos(){
    return Apellidos;
  }
  public void setApellidos(String Apellidos){
    this.Apellidos = Apellidos;
  }
  public String getCarnetIdentidad(){
    return CarnetIdentidad;
  }
  public void setCarnetIdentidad(String CarnetIdentidad){
    this.CarnetIdentidad = CarnetIdentidad;
  }
    public int getEdad(){
    return Edad;
  }
  public void setEdad(int Edad){
    this.Edad = Edad;
  }
}
