/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cesine.ipm.tema3.contactos;

import java.util.Vector;

/**
 *
 * @author julioa
 */
public class ContactFactory {

    private static ContactFactory instance = null;

    private Vector lista = new Vector();

    private String[][] inicio = {{"Julio", "Arrebola", "julioa@computer.org", "600000000"}};

    private ContactFactory() {
        for (int i=0; i<inicio.length; i++) {
        Contacto nuevo = new Contacto(inicio[i][0], inicio[i][1], inicio[i][2], inicio[i][3]);
        append(nuevo);
            
        }
    }

    public static ContactFactory getInstance() {
        if (instance == null) {
            instance = new ContactFactory();
        }

        return instance;
    }

    public Vector getList() {
        return lista;
    }

    public void append(Contacto contacto) {
        lista.addElement(contacto);
    }

    Contacto getItem(int index) {
        return (Contacto)lista.elementAt(index);
    }

    void delete(int index) {
        lista.removeElementAt(index);
    }

    void update(Contacto contacto, int index) {
        lista.setElementAt(contacto, index);
    }

}
