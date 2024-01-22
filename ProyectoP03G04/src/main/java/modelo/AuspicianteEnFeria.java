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
public class AuspicianteEnFeria implements Serializable {
  private Auspiciante aus;
  private String descripcion;
  private boolean incluyeStand;
  private ArrayList<Stand> standsAsignados;

  // Contructor de la clase AuspicianteEnFeria
  public AuspicianteEnFeria(Auspiciante aus, String descripcion, boolean incluyeStand){
    this.aus = aus;
    this.descripcion = descripcion;
    this.incluyeStand = incluyeStand;
    if(incluyeStand){
        standsAsignados = new ArrayList<>();
    }
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
  public ArrayList<Stand> getStandsAsignados(){
    return standsAsignados;
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
  public void setStandsAsignados(ArrayList<Stand> stands){
    this.standsAsignados = stands;
  }
  public String toString(){
    return aus.getNombre();
  }
}
