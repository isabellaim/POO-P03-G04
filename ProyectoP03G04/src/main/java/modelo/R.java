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
public enum R implements Serializable{
    
    TWITTER, FACEBOOK, INSTAGRAM, TIKTOK, PINTEREST, YOUTUBE, LINKEDIN;
    
    public R[] getValues() {
        return R.values();
    }
}
