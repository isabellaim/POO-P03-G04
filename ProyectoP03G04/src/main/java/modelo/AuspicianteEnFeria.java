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
public class AuspicianteEnFeria {
    private Auspiciante aus;
  private String descripcion;
  private boolean incluyeStand;

  // Contructor de la clase AuspicianteEnFeria
  public AuspicianteEnFeria(Auspiciante aus, String descripcion, boolean incluyeStand){
    this.aus = aus;
    this.descripcion = descripcion;
    this.incluyeStand = incluyeStand;
  }

  // Getters
  
  public Auspiciante getAus(){
    return aus;
  }
  public String getDescripcion(){
    return descripcion;
  }
  public boolean getIncluyeStand(){
    return incluyeStand;
  }

  // Setters
  
  public void setAus(Auspiciante aus){
    this.aus = aus;
  }
  public void setDescripcion(String descripcion){
    this.descripcion = descripcion;
  }
  public void setIncluyeStand(boolean incluyeStand){
    this.incluyeStand = incluyeStand;
  }
  public String toString(){
    return aus.getNombre();
  }
}
