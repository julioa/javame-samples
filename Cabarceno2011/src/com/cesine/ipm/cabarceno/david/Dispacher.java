/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.cabarceno.david;

import com.cesine.ipm.cabarceno.david.Menu;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

/**
 *
 * @author profesor
 */
public class Dispacher {
    private  int pls=0;
    private MIDlet miMidlet;
    private static Dispacher miDispacher;
    private Display display = null;

    public void setMidlet(MIDlet miMidletRecivido) {
        miMidlet = miMidletRecivido;
        display = Display.getDisplay(miMidlet);
    }

    public static Dispacher getSingletonObject() {
        if (miDispacher == null) {
            miDispacher = new Dispacher();
        }
        return miDispacher;
    }

    public void drawMenuPrincipal() {
        Menu principal = new Menu();
        Display pantalla = Display.getDisplay(miMidlet);
        pantalla.setCurrent(principal);
    }

    public void accedePrincipal(String option) {

        if (option.equalsIgnoreCase("Mensajes")) {
            pls=1;
            Mensajes mimns = new Mensajes("entro", "que tal", 255, 0);
            Display pantalla = Display.getDisplay(miMidlet);
            pantalla.setCurrent(mimns);
        } else
        if (option.equalsIgnoreCase("Juegos")) {
            pls=1;
            Juegos mimns = new Juegos("entro juegos", "que tal", 255, 0);
            Display pantalla = Display.getDisplay(miMidlet);
            pantalla.setCurrent(mimns);
        } else
        if (option.equalsIgnoreCase("Directorio")) {
            pls=1;
            Directorio mimns = new Directorio("entro directorio", "que tal", 255, 0);
            Display pantalla = Display.getDisplay(miMidlet);
            pantalla.setCurrent(mimns);
        }

    }

    void back() {
        if(pls!=0){
            drawMenuPrincipal();
        }
    }
}
