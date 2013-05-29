/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.tema3.contactos;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

/**
 * @author julioa
 */
public class ContactosMidlet extends MIDlet implements CommandListener {

    private List list = null;
    private Command exitCommand = null;
    private String[] optionList = {"Ver Lista", "Añadir Contacto"};

    public ContactosMidlet() {
    }

    public void startApp() {
        list = new List("Menu", List.IMPLICIT, optionList, null);
        exitCommand = new Command("Salir", Command.EXIT, 1);
        list.addCommand(exitCommand);
        list.setCommandListener((CommandListener) this);
        menu();
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if (c == List.SELECT_COMMAND) {
            int index = list.getSelectedIndex();
            if (index == 0) {
                ponLista();
            } else if (index == 1) {
                ContactForm form = new ContactForm(this, -1, ContactForm.MODE_NEW);
                Display.getDisplay(this).setCurrent(form);
            } else if (index == 2) {
            } else if (index == 3) {
            } else if (index == 4) {
            } else if (index == 5) {
            } else if (index == 6) {
            } else if (index == 7) {
            } else if (index == 8) {
            }
        }
        if (c == exitCommand) {
            salir();
        }
    }

    public void salir() {
        destroyApp(true);
        notifyDestroyed();
    }

    protected void menu() {
        Display.getDisplay(this).setCurrent(list);
    }

    protected void ponLista() {
        ContactList lista2 = new ContactList(this);
        Display.getDisplay(this).setCurrent(lista2);
    }
}
