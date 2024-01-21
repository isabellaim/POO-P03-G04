/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package excepciones;

/**
 *
 * @author isabella
 */
public class NoExistePersona extends Exception {

    /**
     * Creates a new instance of <code>NoExistePersona</code> without detail
     * message.
     */
    public NoExistePersona() {
    }

    /**
     * Constructs an instance of <code>NoExistePersona</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public NoExistePersona(String msg) {
        super(msg);
    }
}
