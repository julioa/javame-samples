/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ejemplo;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

/**
 * @author julioa
 */
public class MidletSimple extends MIDlet implements CommandListener {
    
    TextBox textbox = null;
    boolean firstRun = true;
    Command salir = null;
    
    public MidletSimple () {
        salir = new Command("Salid", Command.EXIT, 1);
    }

    public void startApp() {
        if (firstRun == true) {
            textbox = new TextBox("Ejemplo","Hola Mundo", 32, TextField.ANY);
            
            textbox.addCommand(salir);
            
            textbox.setCommandListener(this);
            
            Display.getDisplay(this).setCurrent(textbox);
        }
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
       if (c == salir) {
           this.notifyDestroyed();
       }
    }
}
