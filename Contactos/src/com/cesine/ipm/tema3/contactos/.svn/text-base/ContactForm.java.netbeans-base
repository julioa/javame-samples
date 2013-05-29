/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.tema3.contactos;

import javax.microedition.lcdui.*;

/**
 *
 * @author julioa
 */
public class ContactForm extends Form implements CommandListener {

    public static int MODE_VIEW = 1;
    public static int MODE_EDIT = 2;
    public static int MODE_NEW = 3;
    Command exit = new Command("Salir", Command.EXIT, 1);
    Command back = new Command("Atrás", Command.BACK, 2);
    Command edit = new Command("Editar", Command.OK, 3);
    Command delete = new Command("Borrar", Command.OK, 3);
    Command accept = new Command("Aceptar", Command.OK, 3);
    private ContactosMidlet midlet = null;
    private Contacto contacto = null;
    private int mode = -1;
    private int index = -1;

    private TextField nombre = null;
    private TextField apellido = null;
    private TextField email = null;
    private TextField movil = null;


    public ContactForm(ContactosMidlet midlet, int index, int mode) {
        super("Contacto");

        this.midlet = midlet;
        this.mode = mode;
        this.index = index;

        this.setCommandListener(this);

        if (this.mode != MODE_NEW) {
            contacto = ContactFactory.getInstance().getItem(index);
        } else {
            contacto = new Contacto();
        }

        refresh();
    }

    private void refresh() {

        int editFlag = 0;

        this.removeCommand(exit);
        this.removeCommand(back);
        this.removeCommand(edit);
        this.removeCommand(delete);
        this.removeCommand(accept);

        if (this.mode == MODE_VIEW) {
            this.addCommand(exit);
            this.addCommand(back);
            this.addCommand(edit);
            this.addCommand(delete);
        } else if (this.mode == MODE_EDIT) {
            this.addCommand(back);
            this.addCommand(accept);
        } else if (this.mode == MODE_NEW) {
            this.addCommand(back);
            this.addCommand(accept);
        }

        this.deleteAll();

        if (this.mode == MODE_VIEW) {
            editFlag = TextField.UNEDITABLE;
        }

        nombre = new TextField("Nombre", contacto.getNombre(), 128, TextField.ANY | editFlag);
        this.append(nombre);
        apellido = new TextField("Apellido", contacto.getApellido(), 128, TextField.ANY | editFlag);
        this.append(apellido);
        email = new TextField("E-Mail", contacto.getEmail(), 128, TextField.EMAILADDR | editFlag);
        this.append(email);
        movil = new TextField("Móvil", contacto.getMovil(), 128, TextField.PHONENUMBER | editFlag);
        this.append(movil);


    }

    public void commandAction(Command c, Displayable d) {
        if (c == exit) {
            midlet.salir();
        } else if (c == back) {
            if (this.mode == MODE_EDIT) {
                this.mode = MODE_VIEW;
                refresh();
            } else {
                midlet.menu();
            }
        } else if (c == delete) {
            ContactFactory.getInstance().delete(index);
            midlet.menu();
        } else if (c == accept) {
            updateContact();
            if (this.mode== MODE_EDIT) {
                ContactFactory.getInstance().update(contacto, index);
                this.mode = MODE_VIEW;
                refresh();
            } else if (this.mode == MODE_NEW) {
                ContactFactory.getInstance().append(contacto);
                midlet.menu();
            }
        } else if (c == edit) {
            this.mode = MODE_EDIT;
            refresh();
        }
    }

    private void updateContact() {
        contacto.setNombre(nombre.getString());
        contacto.setApellido(apellido.getString());
        contacto.setEmail(email.getString());
        contacto.setMovil(movil.getString());
    }
}
