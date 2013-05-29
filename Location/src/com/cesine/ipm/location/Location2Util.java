/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.location;

import javax.microedition.location.Coordinates;
import javax.microedition.location.Criteria;
import javax.microedition.location.Location;
import javax.microedition.location.LocationException;
import javax.microedition.location.LocationProvider;

/**
 *
 * @author julioa
 */
public class Location2Util {

    public void ayuda() {
        try {
            // Create a Criteria object for defining desired selection criteria
            Criteria cr = new Criteria();
            // Specify horizontal accuracy of 500 meters, leave other parameters
            // at default values.
            cr.setHorizontalAccuracy(500);
            LocationProvider lp = LocationProvider.getInstance(cr);
            // get the location, one minute timeout
            Location l = lp.getLocation(60);
            Coordinates c = l.getQualifiedCoordinates();
            if (c != null) {
                // use coordinate information
                // ...
            }
        } catch (LocationException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
