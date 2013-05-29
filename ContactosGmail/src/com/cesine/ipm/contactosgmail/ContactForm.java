/*
 */
package com.cesine.ipm.contactosgmail;

import javax.microedition.lcdui.*;

/**
 *
 * Este form es utilizado por la aplicacion allí donde se precise una ficha
 * con los detalles de un contacto
 *
 * @author julioa
 */
public class ContactForm extends Form implements CommandListener {

    /**
     * Formulario en modo solo lectura
     */
    public static int MODE_VIEW = 1;
    /**
     * Formulario en modo edicion
     */
    public static int MODE_EDIT = 2;
    /**
     * Formulario en modo creacion
     */
    public static int MODE_NEW = 3;
    // Comandos para todos los modos
    Command exit = new Command("Salir", Command.EXIT, 1);
    Command back = new Command("Atrás", Command.BACK, 2);
    Command edit = new Command("Editar", Command.OK, 3);
    Command delete = new Command("Borrar", Command.OK, 3);
    Command accept = new Command("Aceptar", Command.OK, 3);
    private ContactosMidlet midlet = null;
    private Contacto contacto = null;
    private int mode = -1;
    private int index = -1;
    // Campos del formulario
    private TextField nombre = null;
    private TextField apellido = null;
    private TextField email = null;
    private TextField movil = null;

    /**
     *
     * Crea el formulario a partir del contacto con indice index de la 
     * lista de contacto en el modo de edicion determinado por mode
     *
     * @param midlet
     * @param index
     * @param mode
     */
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

    /*
     * Refresca el formulario para mostrar los valores actuales y el modo
     * de edicion seleccionado.
     */
    private void refresh() {

        int editFlag = 0;

        // Primero nos aseguramos de quitar lo que pueda
        // existir previamente
        this.removeCommand(exit);
        this.removeCommand(back);
        this.removeCommand(edit);
        this.removeCommand(delete);
        this.removeCommand(accept);

        this.deleteAll();

        // Ponemos comandos en funcion del modo
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


        // Añadimos los campos
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

    /**
     *
     * Procesamiento de comandos
     *
     * @param c
     * @param d
     */
    public void commandAction(Command c, Displayable d) {
        // En funcion del modo procesamos el comando y volvemos a
        // refrescar el formulario.
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
            if (this.mode == MODE_EDIT) {
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

    /*
     * Utilidad para actualizar el contacto con los valores del formulario.
     */
    private void updateContact() {
        contacto.setNombre(nombre.getString());
        contacto.setApellido(apellido.getString());
        contacto.setEmail(email.getString());
        contacto.setMovil(movil.getString());
    }
}
