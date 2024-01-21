/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package excepciones;

/**
 *
 * @author isabella
 */
public class MaximoStands extends Exception {

    /**
     * Creates a new instance of <code>MaximoStands</code> without detail
     * message.
     */
    public MaximoStands() {
    }

    /**
     * Constructs an instance of <code>MaximoStands</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public MaximoStands(String msg) {
        super(msg);
    }
}
