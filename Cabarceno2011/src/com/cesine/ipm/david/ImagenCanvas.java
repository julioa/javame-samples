/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.david;

import com.cesine.ipm.cabarceno.adrian.CMapas;
import com.cesine.ipm.cabarceno.adrian.Interes;
import java.io.IOException;
import java.util.Vector;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.location.Coordinates;
import javax.microedition.location.LocationException;

/**
 *
 * @author dlescajadillo
 */
public class ImagenCanvas extends Canvas implements CommandListener {

    CMapas mapas = null;
    Interes miInteres;
    int zoom;
    Image image = null;
    Localizacion miLoc = null;

    protected void paint(Graphics g) {
        aPintar(g);

    }

    protected void refresh() {

        repaint();
        // debo llamr al paint();

    }

    protected void aPintar(Graphics g) {
        try {

            //obtengo la imagen y la pinto al igual que los puntos de interes
            miLoc = new Localizacion((float) 11.0);
        } catch (LocationException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        mapas = new CMapas(getWidth(), getHeight());
        mapas.setCoordenadas(miLoc.getLastPosition());
        image = mapas.vista();
        //me falla lo de Adrian para pintar!!!!
        g.drawImage(image, (image.getWidth() / 2), (image.getHeight() / 2), Graphics.HCENTER | Graphics.VCENTER);
        Vector m = mapas.getInteres();
        for (int v = 0; v < m.size(); v++) {
            miInteres = (Interes) m.elementAt(v);
            g.drawImage(miInteres.getImage(), (miInteres.getposX()), (miInteres.getposY()), Graphics.HCENTER | Graphics.VCENTER);
        }


    }

    public void commandAction(Command c, Displayable d) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
