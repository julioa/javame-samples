/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cesine.ipm.david;


import javax.microedition.lcdui.Display;
import javax.microedition.location.LocationException;
import javax.microedition.midlet.*;

/**
 * @author dlescajadillo
 */
public class DavidMidlet extends MIDlet {
    public void startApp() {
        try {
            Corrdinador coord = new Corrdinador();
            Display.getDisplay(this).setCurrent(coord.getObjetoDisplayable());
        } catch (LocationException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }



    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
}
