/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package excepciones;

/**
 *
 * @author isabella
 */
public class FormatoTextoMalo extends Exception {

    /**
     * Creates a new instance of <code>FormatoTextoMalo</code> without detail
     * message.
     */
    public FormatoTextoMalo() {
    }

    /**
     * Constructs an instance of <code>FormatoTextoMalo</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public FormatoTextoMalo(String msg) {
        super(msg);
    }
}
