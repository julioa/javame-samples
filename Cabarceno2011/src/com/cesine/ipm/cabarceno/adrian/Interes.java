/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.cabarceno.adrian;

/**
 *
 * @author Cactus
 */
import javax.microedition.lcdui.*;

public class Interes {

    int x;
    int y;
    int posicionPintadoX, posicionPintadoY;
    Image Icono;

    public Interes(int X, int Y, Image Icon) {
        x = X;
        y = Y;
        Icono = Icon;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setposX(int x) {
        posicionPintadoX = x;
    }

    public void setposY(int y) {
        posicionPintadoY = y;
    }

    public int getposX() {//llamar para saber donde tienes que pintar el objeto en pantalla
        return posicionPintadoX;
    }

    public int getposY() {//llamar para saber donde tienes que pintar el objeto en pantalla
        return posicionPintadoY;
    }

    public Image getImage() {
        return Icono;
    }
}
