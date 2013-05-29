/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.demo.uisimple;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

/**
 * @author julioa
 */
public class Midlet1 extends MIDlet implements CommandListener {

    Command salir = null;
    TextBox textbox = null;

    public Midlet1() {
        salir = new Command("Salir", Command.EXIT, 1);
    }

    public void startApp() {
        textbox = new TextBox("TextBox", "Hola Mundo", 32, TextField.ANY);

        textbox.addCommand(salir);
        
        textbox.setCommandListener(this);
                
        Display.getDisplay(this).setCurrent(textbox);

    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if (c == salir) {
            System.out.println("Salimos");
            
            Alert alert = new Alert("Salimos", "Nos vamos", null, AlertType.ALARM);
            
            alert.setTimeout(5*1000);
            
            Display.getDisplay(this).setCurrent(alert);
            
            this.notifyDestroyed();
        }
    }
}
