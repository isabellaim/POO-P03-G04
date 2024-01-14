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
public class Persona {
    private String cedula;
  private String nombre;
  private String nombrePersona;
  private String telefono;
  private String email;
  private String direccion;
  private String sitioWeb;
  private ArrayList<RedSocial> redesSociales;

  // Constructor de la clase Persona
  
  public Persona(String cedula, String nombre, String nombrePersona, String telefono, String email, String direccion, String sitioWeb, ArrayList<RedSocial> redesSociales){
    this.cedula = cedula;
    this.nombre = nombre;
    this.nombrePersona = nombrePersona;
    this.telefono = telefono;
    this.email = email;
    this.direccion = direccion;
    this.sitioWeb = sitioWeb;
    this.redesSociales = redesSociales;
  }

  // Getters
  
  public String getCedula(){
    return cedula;
  }

  public String getNombre(){
    return nombre;
  }

  public String getNombrePersona(){
    return nombrePersona;
  }

  public String getTelefono(){
    return telefono;
  }

  public String getEmail(){
    return email;
  }

  public String getDireccion(){
    return direccion;
  }

  public String getSitioWeb(){
    return sitioWeb;
  }

  public ArrayList<RedSocial> getRedesSociales(){
    return redesSociales;
  }

  // Setters
  
  public void setCedula(String cedula){
    this.cedula = cedula;
  }

  public void setNombre(String nombre){
    this.nombre = nombre;
  }

  public void setNombrePersona(String nombrePersona){
    this.nombrePersona = nombrePersona;
  }

  public void setTelefono(String telefono){
    this.telefono = telefono;
  }

  public void setEmail(String email){
    this.email = email;
  }

  public void setDireccion(String direccion){
    this.direccion = direccion;
  }

  public void setSitioWeb(String sitioWeb){
    this.sitioWeb = sitioWeb;
  }

  public void setRedesSociales(ArrayList<RedSocial> redesSociales){
    this.redesSociales = redesSociales;
  }

  // Método toString() de la clase Persona

  public String toString(){
    String string1 = "\n1. Nombre: " + nombre + "\n2. Nombre de la persona responsable: " + nombrePersona + "\n3. Teléfono: " + telefono + "\n4. Email: " + email + "\n5. Dirección: " + direccion + "\n6. Sitio web: " + sitioWeb + "\n7. Redes Sociales: \n---------------";
    String string2 = "";
    for(RedSocial redSocial: redesSociales){
      string2 = "\n" + string2 + ">>> " + redSocial;
    }
    return string1 + string2;
  }

  // Método para ver información general de Persona
  public String verPersona(){
    return "Cédula: " + cedula + "\n   Nombre: " + nombre + "\n   Teléfono: " + telefono + "\n   Email: " + email + "\n";
  }
}
