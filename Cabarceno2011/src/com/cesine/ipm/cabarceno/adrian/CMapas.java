/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.cabarceno.adrian;

/**
 *
 * @author Cactus
 */
//import com.eightmotions.map.MapDisplay;
//import com.eightmotions.util.UtilMidp;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.Sprite;
import java.io.*;
import java.lang.*;
import javax.microedition.location.*;
import java.lang.System.*;
import java.util.Vector;

public class CMapas {

    Coordinates miCoordenada, CoordAbajo, CoordArriba, derecha, izquierda, aux;//Cordenada actual, coordenadas referencia
    SirvePuntos Calculador;
    double YcoordenadaMax, YcoordenadaMin, YespacioCoordenadas;//coordenadas minimas Y, espacio entre estas
    double XcoordenadaMax, XcoordenadaMin, XespacioCoordenadas;//coordenadas minimas X, espacio entre estas
    int Xpantalla, Ypantalla;
    int XpixelActual, YpixelActual;//pixels centrales de la imagen
    int XdimensionMapa, YdimensionMapa;//tamaño en pixeles de la imagen a mostrar
    int Xcrop, Ycrop;//puntos donde se iniciara el recortado de la imagen
    int XmedidaCrop, YmedidaCrop;
    private Form mForm;//formulario para permitir prueba BORRAR AL INTEGRAR (canviando el tipo del metodo prueba)
    private Image ImagenIncial;
    double Zoom;//Zoom que afectara al area mostrada

    public CMapas(int ancho, int largo) {//pasame al constructor al crear el objeto las dimensiones
        Xpantalla = ancho;
        Ypantalla = largo;
        Calculador = new SirvePuntos();
        Zoom = 0.5;
        miCoordenada = new Coordinates(Coordinates.convert("-3:49:44.14"), Coordinates.convert("43:21:32.23"), 100);
        CoordAbajo = new Coordinates(Coordinates.convert("-3:51:51.45"), Coordinates.convert("43:20:03.95"), 34);
        CoordArriba = new Coordinates(Coordinates.convert("-3:48:24.18"), Coordinates.convert("43:22:31.05"), 34);
        derecha = new Coordinates(Coordinates.convert("-3:48:24.18"), Coordinates.convert("43:20:03.95"), 34);
        izquierda = new Coordinates(Coordinates.convert("-3:51:51.45"), Coordinates.convert("43:22:31.05"), 34);
        XdimensionMapa = 1132;
        YdimensionMapa = 644;
        XespacioCoordenadas = CoordAbajo.distance(derecha);
        YespacioCoordenadas = CoordArriba.distance(izquierda);
    }

//primera---
    //SUSTITUIR LOS DOBLES POR OBJETO COORDENADAS coordinates de mi clase localizacion
    public void setCoordenadas(Coordinates cord) {
        Zoom = 0.5;
        miCoordenada = cord;

        // this.almacenaCoordenadas();
        this.calculoProporciones();
        this.calculoZonaZoom();
    }

    private void almacenaCoordenadas() {
        Calculador.añadeRuta(XpixelActual, YpixelActual);
    }

    //CLASES QUE HA DE LLAMAR DAVID PUBLICAS llamar para devolver imagen
    public Image vista() {//CAMBIAR A Image vista()
        //this.setCoordenadas(2, 2,0.5); para probar
        double aux = miCoordenada.getLongitude();
        try {
            ImagenIncial = Image.createImage("imagenes/buena.jpg");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println(Xcrop);
        System.out.println(Ycrop);
        System.out.println(XmedidaCrop);
        System.out.println(YmedidaCrop);
        Image laimagen = Image.createImage(ImagenIncial, Xcrop, Ycrop, XmedidaCrop, YmedidaCrop, Sprite.TRANS_NONE);//XmedidaCrop, YmedidaCrop,Sprite.TRANS_NONE);//CROP
        Image ultima = this.ReescalaImagen(laimagen, Xpantalla, Ypantalla);//CAMBIAR POR TAMAÑO PANTALLA PASADO EN EL CONSTRUCTOR
          /*  ImageItem img = new ImageItem("",ultima,
        ImageItem.LAYOUT_EXPAND,"background",ImageItem.PLAIN);
        mForm = new Form("MIDlet Developer Guide: Display an image.");
        mForm.append(img);*/
        //CAMBIAR A return ultima
        return ultima;
    }
    ///LAS SIGUIENTES FUNCIONES SON PARA PINTAR LA RUTA (PASALAS EL VECTOR CON LAS COORDENADAS ALAMACENADAS)
    //LLAMALAS EN ORDEN PUES getPintarRutaX HACE EL PROCESO POR AMBAS (ACTUALIZADO VIERNES 12:30)(MEJORAR DESPUES DEL LUNES)

    public Vector getPintarRutaX(Vector Coordenadas) {//DEVUELVEN A DAVID EN QUE X DE LA NUEVA IMAGEN PINTAR LA RUTA
        float distancia;
        Vector x = new Vector();
        Vector y = new Vector();
        Integer pixel;
        Coordinates coordenada;
        for (int j = 0; j < Coordenadas.size(); j++) {
            coordenada = (Coordinates) Coordenadas.elementAt(j);
            aux = new Coordinates(CoordAbajo.getLatitude(), coordenada.getLongitude(), 1);
            distancia = aux.distance(coordenada);
            XpixelActual = (int) ((distancia * XdimensionMapa) / XespacioCoordenadas) - 10;
            pixel = new Integer(XpixelActual);
            x.addElement(pixel);
            aux = new Coordinates(coordenada.getLatitude(), CoordArriba.getLongitude(), 1);
            distancia = aux.distance(coordenada);
            YpixelActual = (int) ((distancia * YdimensionMapa) / YespacioCoordenadas) + 100;
            pixel = new Integer(YpixelActual);
            y.addElement(pixel);
        }
        Calculador.calcula(x, y);
        Calculador.getRuta(Xcrop, XmedidaCrop, Zoom, Ycrop, YmedidaCrop);
        Vector ruta = Calculador.getX();
        return ruta;
    }

    public Vector getPintarRutaY() {//DEVUELVEN A DAVID EN QUE Y DE LA NUEVA IMAGEN PINTAR LA RUTA
        Vector ruta = Calculador.getY();
        return ruta;
    }

    //OBJETOS DE INTERES SOLO UN ARRAY SOLO EL IMPORT
    public Vector getInteres() {//DEVUELVE A DAVID VECTOR DE OBJETOS(INTERES:Ver clase Interes) CON LA X/Y e IMAGEN DE CADA PUNTO E IMAGEN
        Vector interes = Calculador.calculapuntos(Xcrop, XmedidaCrop, (float)Zoom, Ycrop, YmedidaCrop);
        return interes;
    }

    private void calculoZonaZoom() {

        Xcrop = XpixelActual - (int) ((Xpantalla / 2) / Zoom);
        Ycrop = (YpixelActual - (int) ((Ypantalla / 2) / Zoom));
        XmedidaCrop = (int) (Xpantalla / Zoom);
        YmedidaCrop = (int) (Ypantalla / Zoom);
        this.seguridad();
    }

    private void seguridad() {
        if (Ycrop + YmedidaCrop > 644) {
            while (Ycrop + YmedidaCrop > 644) {
                Ycrop -= 1;
            }
        }
        if (Xcrop + XmedidaCrop > 1132) {
            while (Xcrop + XmedidaCrop > 1132) {
                Xcrop -= 1;
            }
        }

        if (Xcrop < 1) {
            Xcrop = 1;
        }
        if (Ycrop < 1) {
            Ycrop = 1;
        }
    }

    private void calculoProporciones() {
        float distancia;
        aux = new Coordinates(CoordAbajo.getLatitude(), miCoordenada.getLongitude(), 1);
        distancia = aux.distance(miCoordenada);
        XpixelActual = (int) ((distancia * XdimensionMapa) / XespacioCoordenadas) - 10;
        aux = new Coordinates(miCoordenada.getLatitude(), CoordArriba.getLongitude(), 1);
        distancia = aux.distance(miCoordenada);
        YpixelActual = (int) ((distancia * YdimensionMapa) / YespacioCoordenadas) + 100;
    }
    /*
    void calculoProporciones(){
    XpixelActual=XdimensionMapa-(int)(((XdimensionMapa/((CoordAbajo.getLatitude()-CoordArriba.getLatitude())*-1)))*((miCoordenada.getLatitude()-CoordArriba.getLatitude())*-1));
    YpixelActual=(int)(((YdimensionMapa/((CoordAbajo.getLongitude()-CoordArriba.getLongitude()))))*((miCoordenada.getLongitude()-CoordArriba.getLongitude())));
    CoordArriba.
    /*Xavance=CoordArriba.getLatitude()-miCoordenada.getLatitude();
    XpixelActual=(int)(XdimensionMapa-((XdimensionMapa/Xavance)*XespacioCoordenadas))*-1;
    Yavance=CoordArriba.getLongitude()-miCoordenada.getLongitude();
    YpixelActual=(int) ((int) YdimensionMapa - ((YdimensionMapa / Yavance) * YespacioCoordenadas))*-1;
    Xcrop=XpixelActual-(int)(85/Zoom);
    Ycrop=(YpixelActual-(int)(82/Zoom));
    }*/
    /* void calculoProporciones(){
    XpixelActual=XdimensionMapa-(int)((XdimensionMapa*miCoordenada.getLatitude())/CoordArriba.getLatitude());
    YpixelActual=YdimensionMapa-(int)((YdimensionMapa*miCoordenada.getLongitude())/CoordAbajo.getLongitude());
    System.out.println(XpixelActual);
    System.out.println(YpixelActual);
    }
    /* void calculoProporciones(){

    Xavance=(miCoordenada.getLatitude()-CoordArriba.getLatitude())*-1;
    Yavance=miCoordenada.getAltitude()-CoordAbajo.getAltitude();
    //Xavance=(CoordAbajo.getLatitude()-miCoordenada.getLatitude())*-1;
    //Yavance=CoordArriba.getAltitude()-miCoordenada.getLatitude();
    XpixelActual=XdimensionMapa-((int)(Xavance*Xproporcion));
    YpixelActual=YdimensionMapa-((int)(Yavance*Yproporcion));

    }*/

    private Image ReescalaImagen(Image imagenOriginal, int anchoNuevo, int altoNuevo) {

        int anchoOrigen = imagenOriginal.getWidth();

        int altoOrigen = imagenOriginal.getHeight();

        Image imagenFinal = Image.createImage(anchoNuevo, altoNuevo);

        Graphics g = imagenFinal.getGraphics();
        g.setColor(255, 0, 0);

        for (int y = 0; y < altoNuevo; y++) {

            for (int x = 0; x < anchoNuevo; x++) {

                g.setClip(x, y, 1, 1);

                int xAux = x * anchoOrigen / anchoNuevo;

                int yAux = y * altoOrigen / altoNuevo;

                g.drawImage(imagenOriginal, x - xAux, y - yAux, Graphics.LEFT | Graphics.TOP);
                g.setColor(255, 0, 0);
                g.drawLine(anchoNuevo / 2 - 5, altoNuevo / 2, anchoNuevo / 2 + 5, altoNuevo / 2);
                g.drawLine(anchoNuevo / 2, altoNuevo / 2 - 5, anchoNuevo / 2, altoNuevo / 2 + 5);
            }

        }

        return Image.createImage(imagenFinal);

    }

    protected void paint(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
