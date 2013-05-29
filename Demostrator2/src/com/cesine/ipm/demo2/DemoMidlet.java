/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.demo2;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

/**
 * @author julioa
 */
public class DemoMidlet extends MIDlet implements CommandListener {

    String[] opciones = {"TextBox", "Alerta", "List", "Form"};
    List menu = null;
    DemoTextBox demoTextBox = null;


    public DemoMidlet() {
        menu = new List("Opciones", List.IMPLICIT, opciones, null);
        menu.setCommandListener(this);
    }

    public void startApp() {
      ponMenu();
    }



    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if (c == List.SELECT_COMMAND) {
            int option = menu.getSelectedIndex();

            if (option == 0) {

                demoTextBox = new DemoTextBox(this);
                muestralo(demoTextBox);


            } else if (option == 1) {
            } else {
            }

        }


    }

    public void muestralo(Displayable displayable) {

        if (displayable != null) {
            Display.getDisplay(this).setCurrent(displayable);
        } else {
            System.out.println("Me estan llamando con valor nulo");
        }
    }

    public void vuelve() {
     ponMenu();
    }

    public void ponMenu() {
        muestralo(menu);
    }
}
