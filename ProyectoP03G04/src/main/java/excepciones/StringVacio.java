/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package excepciones;

/**
 *
 * @author isabella
 */
public class StringVacio extends Exception {

    /**
     * Creates a new instance of <code>StringVacio</code> without detail
     * message.
     */
    public StringVacio() {
        super("El string está vacío");
    }

    /**
     * Constructs an instance of <code>StringVacio</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public StringVacio(String msg) {
        super(msg);
    }
}
