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
public class EmprendedorEnFeria implements Serializable{
  private Emprendedor emprendedor;
  private Stand standAsignado;
  private String seccion;

  // Contructor de la clase AuspicianteEnFeria
  public EmprendedorEnFeria(Emprendedor emp, Stand sA, String seccion){
    this.emprendedor = emp;
    this.standAsignado = sA;
    this.seccion = seccion;
  }

  // Getters
  
  public Emprendedor getEmprendedor(){
    return emprendedor;
  }
  public Stand getStandAsignado(){
    return standAsignado;
  }
  public String getSeccion(){
    return seccion;
  }

  // Setters
  
  public void setAus(Emprendedor emp){
    this.emprendedor = emp;
  }
  public void setStandAsignado(Stand stand){
    this.standAsignado = stand;
  }
  
  public String toString(){
    return emprendedor.getNombre();
  }
}
