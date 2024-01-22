/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.io.Serializable;
import java.util.*;
/**
 *
 * @author isabella
 */
public class Emprendedor extends Persona implements Serializable{
  private String descripcion;
  private ArrayList<Stand> standsEmpre;

  // Constructor de clase Emprendedor
  
  public Emprendedor(String cedula, String nombre, String nombrePersona, String telefono, String email, String direccion, String sitioWeb, ArrayList<RedSocial> redesSociales, String descrip){
    
    super(cedula, nombre, nombrePersona, telefono, email, direccion, sitioWeb, redesSociales);
    this.descripcion = descrip;
    this.standsEmpre = new ArrayList<>();
  }

  // Getters
  
  public String getDescripcion(){
    return descripcion;
  }

  public ArrayList<Stand> getStandsEmpre(){
    return standsEmpre;
  }

  // Setters
  
  public void setDescripcion(String descripcion){
    this.descripcion = descripcion;
    }

  // Método toString() de la clase Emprendedor

  public String toString(){
    return super.toString() + "\n8. Descripción: " + descripcion;
  }
  
  
  // Método útil para ver información de Emprendedor en Feria
  public String verEmpreFer(){
    String string1 = "Emprendimiento: " + this.getNombre() + ", Descripción: " + this.descripcion + ", Sección: "; 
    
    if (standsEmpre.size() == 1){
      if(standsEmpre.get(0).getCodigoStand().indexOf("A")==0){
        return string1 + "#1";
      }
      else if(standsEmpre.get(0).getCodigoStand().indexOf("B")==0){
        return string1 + "#2";
      }

      else if(standsEmpre.get(0).getCodigoStand().indexOf("C")==0){
        return string1 + "#3";
      }

      else if(standsEmpre.get(0).getCodigoStand().indexOf("D")==0){
        return string1 + "#4";
      }
      
    }

    else if (standsEmpre.size() == 2){
      if(standsEmpre.get(0).getCodigoStand().indexOf("A")==0){
        string1 = string1 + "#1";
      }
      else if(standsEmpre.get(0).getCodigoStand().indexOf("B")==0){
        string1 = string1 + "#2";
      }

      else if(standsEmpre.get(0).getCodigoStand().indexOf("C")==0){
        string1 = string1 + "#3";
      }

      else if(standsEmpre.get(0).getCodigoStand().indexOf("D")==0){
        string1 = string1 + "#4";
      }

    if(standsEmpre.get(1).getCodigoStand().indexOf("A")==0){
        string1 = string1 + " y #1";
      }
      else if(standsEmpre.get(1).getCodigoStand().indexOf("B")==0){
        string1 = string1 + " y #2";
      }

      else if(standsEmpre.get(1).getCodigoStand().indexOf("C")==0){
        string1 = string1 + " y #3";
      }

      else if(standsEmpre.get(1).getCodigoStand().indexOf("D")==0){
        string1 = string1 + " y #4";
      }

    return string1;
    }
    return null;
  }
}
