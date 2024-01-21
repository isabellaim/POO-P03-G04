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
public class OrganizacionStands {
    private int cantStands;
  private Stand[] standsPorSeccion;
  private int numSeccion;

  // Constructor de la clase OrganizacionStands
  
  public OrganizacionStands(int cantStands, int numSeccion){
    this.cantStands = cantStands;
    this.standsPorSeccion = new Stand[cantStands];
    this.numSeccion = numSeccion;
    
    for (int i = 0; i < standsPorSeccion.length; i++){
      String codigoStand = null;
      if(numSeccion==1){
        codigoStand = "A" + (i+1);
        standsPorSeccion[i]= new Stand(codigoStand);
      }
      else if(numSeccion==2){
        codigoStand = "B" + (i+1);
        standsPorSeccion[i]= new Stand(codigoStand);
      }
      else if(numSeccion==3){
        codigoStand = "C" + (i+1);
        standsPorSeccion[i]= new Stand(codigoStand);
      }
      else if(numSeccion==4){
        codigoStand = "D" + (i+1);
        standsPorSeccion[i]= new Stand(codigoStand);
      }
    }
  }

  // Getters
  
  public int getCantStands(){
    return cantStands;
  }
  
  public Stand[] getStandsPorSeccion(){
    return standsPorSeccion;
  }
  
  public int getNumSeccion(){
    return numSeccion;
  }

  //Setters
  
  public void setCantStands(int cantStands){
    this.cantStands = cantStands;
  }
  public void setStandsPorSeccion(Stand[] standsPorSeccion){
    this.standsPorSeccion = standsPorSeccion;
}
}
