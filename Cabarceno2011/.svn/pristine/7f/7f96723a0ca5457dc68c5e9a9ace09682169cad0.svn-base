/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.david;

import java.util.NoSuchElementException;
import java.util.Vector;
import javax.microedition.lcdui.Display;
import javax.microedition.location.Coordinates;
import javax.microedition.location.Criteria;
import javax.microedition.location.Location;
import javax.microedition.location.LocationException;
import javax.microedition.location.LocationListener;
import javax.microedition.location.LocationProvider;

/**
 *
 * @author dlescajadillo
 */
class Localizacion implements LocationListener {
    private Corrdinador cord;
    private Vector tracking;
    private Float distanciaRefresco;

    public Localizacion(float movementDistance) throws LocationException, InterruptedException {
        try {

            tracking = new Vector();
            distanciaRefresco = new Float(10);
            Criteria cr = new Criteria();

            cr.setHorizontalAccuracy(500);

            LocationProvider lp = LocationProvider.getInstance(cr);


            Location l = lp.getLocation(60);

            Coordinates c = l.getQualifiedCoordinates();
            tracking.addElement(c);
            if (c != null) {
           //esta linea falla
               lp.setLocationListener(this, 60, 60, 120);

            }
        } catch (LocationException e) {
        }
    }

    public void locationUpdated(LocationProvider lp, Location lctn) {
        //filtrar cada diez metros

        if (lctn.getQualifiedCoordinates().distance((Coordinates) tracking.lastElement()) > distanciaRefresco.floatValue()) {
            tracking.addElement(lctn.getQualifiedCoordinates());
           
                //cord = new Corrdinador();
                //llamar al organizador para pintar en el canvas no se como hacerlo
           

        }
    }

    public Vector getTracking() {
        return tracking;
    }

    public Coordinates getLastPosition() {
        try {
            return (Coordinates)tracking.lastElement();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void providerStateChanged(LocationProvider lp, int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
