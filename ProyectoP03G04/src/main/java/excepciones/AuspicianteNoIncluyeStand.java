/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package excepciones;

/**
 *
 * @author isabella
 */
public class AuspicianteNoIncluyeStand extends Exception{

    /**
     * Creates a new instance of <code>AuspicianteNoIncluyeStand</code> without
     * detail message.
     */
    public AuspicianteNoIncluyeStand() {
    }

    /**
     * Constructs an instance of <code>AuspicianteNoIncluyeStand</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public AuspicianteNoIncluyeStand(String msg) {
        super(msg);
    }
}
