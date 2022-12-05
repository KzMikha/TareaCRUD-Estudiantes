
package Model;

import java.io.Serializable;


public class Estudiantes implements Serializable {
    private String Nombre;
    private String Apellidos;
    private long CarnetIdentidad;

public Estudiantes(String Nombre, String Apellidos, long CarnetIdentidad) {
    this.Nombre = Nombre;
    this.Apellidos = Apellidos;
    this.CarnetIdentidad = CarnetIdentidad;
    }
    @Override 
public String toString() {
    return "{" + "Nombre_" + Nombre + ", Apellidos_" 
          + Apellidos + ", CI_" + CarnetIdentidad + "}"; 
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
  public long getCarnetIdentidad(){
    return CarnetIdentidad;
  }
  public void setCarnetIdentidad(long CarnetIdentidad){
    this.CarnetIdentidad = CarnetIdentidad;
  }
}
