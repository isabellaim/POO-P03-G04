/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author isabella
 */
public class RedSocial {
    private String cuenta;
  private R redSocial;

  // Constructor de clase RedSocial
  
  public RedSocial(String cuenta, R redSocial){
    this.cuenta = cuenta;
    this.redSocial = redSocial;
  }

  public R[] getValues() {
      return R.values();
  }
  
  // Metodo toString() de la clase RedSocial
  public String toString(){
    return "Cuenta: " + cuenta + " -- Red social: " + redSocial.toString();
  }
}
