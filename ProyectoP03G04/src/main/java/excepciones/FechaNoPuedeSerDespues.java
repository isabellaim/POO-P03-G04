/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package excepciones;

/**
 *
 * @author isabella
 */
public class FechaNoPuedeSerDespues extends Exception {

    /**
     * Creates a new instance of <code>FechaNoPuedeSerDespues</code> without
     * detail message.
     */
    public FechaNoPuedeSerDespues() {
        super("La fecha de inicio no puede ser despues de la de fin");
    }

    /**
     * Constructs an instance of <code>FechaNoPuedeSerDespues</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public FechaNoPuedeSerDespues(String msg) {
        super(msg);
    }
}
