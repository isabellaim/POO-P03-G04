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
public class OrganizacionStands implements Serializable{
    private int cantStands;
  private ArrayList<Stand> standsPorSeccion;
  private int numSeccion;

  // Constructor de la clase OrganizacionStands
  
  public OrganizacionStands(int cantStands, int numSeccion){
    this.cantStands = cantStands;
    this.standsPorSeccion = new ArrayList<>();
    this.numSeccion = numSeccion;
    
    for (int i = 0; i < cantStands; i++){
      String codigoStand = null;
      if(numSeccion==1){
        codigoStand = "A" + (i+1);
        standsPorSeccion.add(new Stand(codigoStand));
      }
      else if(numSeccion==2){
        codigoStand = "B" + (i+1);
        standsPorSeccion.add(new Stand(codigoStand));
      }
      else if(numSeccion==3){
        codigoStand = "C" + (i+1);
        standsPorSeccion.add(new Stand(codigoStand));
      }
      else if(numSeccion==4){
        codigoStand = "D" + (i+1);
        standsPorSeccion.add(new Stand(codigoStand));
      }
    }
  }

  // Getters
  
  public int getCantStands(){
    return cantStands;
  }
  
  public ArrayList<Stand> getStandsPorSeccion(){
    return standsPorSeccion;
  }
  
  public int getNumSeccion(){
    return numSeccion;
  }

  //Setters
  
  public void setCantStands(int cantStands, Feria feria){
    this.cantStands = cantStands;
    
    for(Stand stand: standsPorSeccion){
        stand.setReservado(false);
        Persona dueno = stand.getDueno();
        stand.setDueno(null);
        stand.setFechaAsig(null);
        if(dueno instanceof Emprendedor){
            Emprendedor emp = (Emprendedor) dueno;
            for(EmprendedorEnFeria empf: feria.getEmprendedores()){
                if(empf.getEmprendedor().equals(emp)){
                    feria.getEmprendedores().remove(empf);
                }
            }
        }
        if(dueno instanceof Auspiciante){
            Auspiciante aus = (Auspiciante) dueno;
            for(AuspicianteEnFeria ausf: feria.getAuspiciantes()){
                if(ausf.getAus().equals(aus)){
                    feria.getAuspiciantes().remove(ausf);
                }
            }
        }
    }
    standsPorSeccion.clear();
    standsPorSeccion = new ArrayList<>();
    for (int i = 0; i < cantStands; i++){
        String codigoStand = null;
        if(numSeccion==1){
          codigoStand = "A" + (i+1);
          standsPorSeccion.add(new Stand(codigoStand));
        }
        else if(numSeccion==2){
          codigoStand = "B" + (i+1);
          standsPorSeccion.add(new Stand(codigoStand));
        }
        else if(numSeccion==3){
          codigoStand = "C" + (i+1);
          standsPorSeccion.add(new Stand(codigoStand));
        }
        else if(numSeccion==4){
          codigoStand = "D" + (i+1);
          standsPorSeccion.add(new Stand(codigoStand));
        }
    }

  }
  public void setStandsPorSeccion(ArrayList<Stand> standsPorSeccion){
    this.standsPorSeccion = standsPorSeccion;
}
}
