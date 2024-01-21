/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package excepciones;

/**
 *
 * @author isabella
 */
public class FechaVacia extends Exception {

    /**
     * Creates a new instance of <code>FechaVacia</code> without detail message.
     */
    public FechaVacia() {
        super("No se escogió una fecha");
    }

    /**
     * Constructs an instance of <code>FechaVacia</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public FechaVacia(String msg) {
        super(msg);
    }
}
