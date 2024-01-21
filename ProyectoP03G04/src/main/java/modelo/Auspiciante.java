/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.*;
/**
 *
 * @author isabella
 */
public class Auspiciante extends Persona {
    private ArrayList<SC> sectores;

  // Constructor de la clase Auspiciante
  
  public Auspiciante(String cedula, String nombre, String nombrePersona, String telefono, String email, String direccion, String sitioWeb, ArrayList<RedSocial> redesSociales, ArrayList<SC> sectores){
    super(cedula, nombre, nombrePersona, telefono, email, direccion, sitioWeb, redesSociales);
    this.sectores = sectores;
  }
  
          
  public SC[] getValues() {
      return SC.values();
  }

  // Getters
  
  public ArrayList<SC> getSectores(){
    return sectores;
  }

  // Setters
  
  public void setSectores(ArrayList<SC> sectores){
    this.sectores = sectores;
  }

  // Método toString() de la clase Auspiciante
  
  public String toString(){
    String string1 = super.toString() + "\n8. Sectores cubiertos: \n-------------------";
    String string2 = "";
    for(SC sector: sectores){
      string2 = string2 + "\n>>> " + sector.toString();
    }
    return string1 + string2;
  }
}
