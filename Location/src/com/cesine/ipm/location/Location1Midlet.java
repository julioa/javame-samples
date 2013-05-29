package com.cesine.ipm.location;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * MIDlet en donde se muestra la siguiente información:
 *      a) Estado actual del proveedor de localización (Disponible, fuera de servicio, etc).
 *      b) Distancia recorrida (en metros) desde que se inicio la aplicación.
 *      c) La velocidad (en metros/segundo) a la que nos desplazamos.
 *      d) Nombre de la calle actual en la que nos encontramos.
 *      e) Longitud y latitud en la que nos encontramos.
 * @author Carlos García. Autentia
 */
public class Location1Midlet extends MIDlet {

    private Form main;

    public void startApp() {
        if (main == null){
            // ¿Está el API de localización disponible?
            if (System.getProperty("microedition.location.version") != null) {
                main = new Location1Form(this);
            } else {
                main = new Form("Location API");
                main.append("El API de localización no está disponible");
            }
        }

        Display.getDisplay(this).setCurrent(main);
    }

    public void pauseApp() {
        // Nada que hacer
    }

    public void destroyApp(boolean unconditional) {
        this.notifyDestroyed();
    }
}
    
