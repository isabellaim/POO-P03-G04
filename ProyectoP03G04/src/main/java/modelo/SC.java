/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author isabella
 */
public enum SC implements Serializable{
    ALIMENTACION, EDUCACION, SALUD, VESTIMENTA;
    public SC[] getValues() {
        return SC.values();
    }
}
