/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author isabella
 */
public class Stand implements Serializable{
  private String codigoStand;
  private LocalDate fechaAsig;
  private Persona dueno;
  private boolean reservado;

  // Constructor de la clase Stand
  
  public Stand(String codigoStand){
    this.codigoStand = codigoStand;
    this.fechaAsig = null;
    this.dueno = null;
    this.reservado=false;
  }

  // Getters
  
  public String getCodigoStand(){
    return codigoStand;
  }

  public LocalDate getFechaAsig(){
    return fechaAsig;
  }

  public Persona getDueno(){
    return dueno;
  }

  public boolean getReservado(){
    return reservado;
  }

  // Setters
  
  public void setCodigoStand(String codigoStand){
    this.codigoStand = codigoStand;
  }

  public void setFechaAsig(LocalDate fechaAsig){
    this.fechaAsig = fechaAsig;
  }

  public void setDueno(Persona dueno){
    this.dueno = dueno;
    if(dueno instanceof Emprendedor){
      Emprendedor emp = (Emprendedor) dueno;
      emp.getStandsEmpre().add(this);
    }
  }

  public void setReservado(boolean reservado){
    this.reservado = reservado;
  }

  // Método toString() de Stand
  
    @Override
  public String toString() {
    if(dueno instanceof Emprendedor){
      Emprendedor emp = (Emprendedor) dueno;
      return "Codigo del stand: " + codigoStand + "\nFecha de asignación: " + fechaAsig + "\nInformación del emprendedor: " + emp;
    }

    else if(dueno instanceof Auspiciante) {
      Auspiciante aus = (Auspiciante) dueno;
      return "Codigo del stand: " + codigoStand + "\nFecha de asignación: " + fechaAsig + "\nInformación del emprendedor: " + aus;
    }
    return null;
  }

  // Método útil para mostrar qué Stand está reservado o no
  
  public String verStandReser() {
    if (reservado){
      return "[" + codigoStand + "*]";
    }
    return "[" + codigoStand + "]";
  }
}
