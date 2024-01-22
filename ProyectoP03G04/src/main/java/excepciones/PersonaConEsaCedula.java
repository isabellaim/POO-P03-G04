/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package excepciones;

/**
 *
 * @author isabella
 */
public class PersonaConEsaCedula extends Exception {

    /**
     * Creates a new instance of <code>PersonaConEsaCedula</code> without detail
     * message.
     */
    public PersonaConEsaCedula() {
    }

    /**
     * Constructs an instance of <code>PersonaConEsaCedula</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PersonaConEsaCedula(String msg) {
        super(msg);
    }
}
