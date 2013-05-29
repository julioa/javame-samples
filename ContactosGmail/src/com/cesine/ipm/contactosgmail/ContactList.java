/*
 */

package com.cesine.ipm.contactosgmail;

import java.util.Vector;
import javax.microedition.lcdui.*;

/**
 *
 * Pantalla con la lista de contactos para seleccionar
 *
 * @author julioa
 */
public class ContactList extends List implements CommandListener {

    Command exit = new Command("Salir", Command.EXIT, 1);
    Command back = new Command("Atrás", Command.BACK, 2);
    Command select = new Command("Seleccionar", Command.OK, 1);

    private ContactosMidlet midlet = null;

    /**
     *
     * Crea la pantalla con la lista de contactos actualizada y
     * queda lista para ser mostrada
     *
     * @param midlet
     */
    public ContactList(ContactosMidlet midlet) {
        super("Lista de Contactos", List.IMPLICIT);

        this.midlet = midlet;

        this.addCommand(exit);
        this.addCommand(back);
        this.addCommand(select);

        this.setCommandListener(this);

        Vector contactos = ContactFactory.getInstance().getList();

        for (int i=0; i < contactos.size(); i++) {
            Contacto contacto = (Contacto)contactos.elementAt(i);
            this.append(contacto.getApellido()+", "+contacto.getNombre(), null);
        }

    }

    /**
     *
     * Procesamiento de comandos
     *
     * @param c
     * @param d
     */
    public void commandAction(Command c, Displayable d) {
        if (c == select) {
            ContactForm form = new ContactForm(midlet, this.getSelectedIndex(), ContactForm.MODE_VIEW);
            Display.getDisplay(midlet).setCurrent(form);
        } else if (c == back) {
            midlet.menu();
        } else if (c == exit) {
            midlet.salir();
        }
    }
}
