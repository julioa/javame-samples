
package com.cesine.ipm.cabarceno.cristina;

import com.cesine.ipm.cabarceno.cristina.Menu;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class Dispacher {
    private  int pls=0;
    private MIDlet miMidlet;
    private static Dispacher miDispacher;
    private Display display = null;

    public void setMidlet(MIDlet miMidletRecibido) {
        miMidlet = miMidletRecibido;
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

        System.out.println("accedePrincipal");

        if (option.equalsIgnoreCase("Información General")) {
            pls=1;
            Info mimns = new Info("Información", "Cabarceno", 255, 0);
            Display pantalla = Display.getDisplay(miMidlet);
            pantalla.setCurrent(mimns);
        } else
        if (option.equalsIgnoreCase("Visita")) {
            pls=1;
            Visita mimns = new Visita("Su visita", "que tal", 255, 0);
            Display pantalla = Display.getDisplay(miMidlet);
            pantalla.setCurrent(mimns);
        } else
        if (option.equalsIgnoreCase("Créditos")) {
            pls=1;
            Creditos mimns = new Creditos("Créditos", "Participantes...", 255, 0);
            Display pantalla = Display.getDisplay(miMidlet);
            pantalla.setCurrent(mimns);
        }
        if (option.equalsIgnoreCase("Salir")) {
            pls=1;
            Salir mimns = new Salir("Adios", "Vuelva pronto", 255, 0);
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
