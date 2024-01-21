/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package excepciones;

/**
 *
 * @author isabella
 */
public class NoExisteFeria extends Exception {

    /**
     * Creates a new instance of <code>NoExisteFeria</code> without detail
     * message.
     */
    public NoExisteFeria() {
    }

    /**
     * Constructs an instance of <code>NoExisteFeria</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public NoExisteFeria(String msg) {
        super(msg);
    }
}
