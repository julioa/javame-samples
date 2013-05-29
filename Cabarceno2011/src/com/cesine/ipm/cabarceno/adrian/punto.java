/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.cabarceno.adrian;

/**
 *
 * @author Mariaje
 */
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.Sprite;
import java.io.*;
import java.lang.*;
import javax.microedition.location.*;
import java.lang.System.*;
import java.util.Vector;

public class punto {

    int x;
    int y;
    Coordinates miCoordenada, CoordAbajo, CoordArriba, derecha, izquierda, aux;
    int XdimensionMapa, YdimensionMapa;
    double YespacioCoordenadas, XespacioCoordenadas;//coordenadas minimas Y, espacio entre estas

    public punto(Coordinates miCoordenada) {
        CoordAbajo = new Coordinates(Coordinates.convert("-3:51:51.45"), Coordinates.convert("43:20:03.95"), 34);
        CoordArriba = new Coordinates(Coordinates.convert("-3:48:24.18"), Coordinates.convert("43:22:31.05"), 34);
        derecha = new Coordinates(Coordinates.convert("-3:48:24.18"), Coordinates.convert("43:20:03.95"), 34);
        izquierda = new Coordinates(Coordinates.convert("-3:51:51.45"), Coordinates.convert("43:22:31.05"), 34);
        XdimensionMapa = 1132;
        YdimensionMapa = 644;
        XespacioCoordenadas = CoordAbajo.distance(derecha);
        YespacioCoordenadas = CoordArriba.distance(izquierda);
          float distancia;
        aux = new Coordinates(CoordAbajo.getLatitude(), miCoordenada.getLongitude(), 1);
        distancia = aux.distance(miCoordenada);
        x = (int) ((distancia * XdimensionMapa) / XespacioCoordenadas) - 10;
        aux = new Coordinates(miCoordenada.getLatitude(), CoordArriba.getLongitude(), 1);
        distancia = aux.distance(miCoordenada);
        y = (int) ((distancia * YdimensionMapa) / YespacioCoordenadas) + 100;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
