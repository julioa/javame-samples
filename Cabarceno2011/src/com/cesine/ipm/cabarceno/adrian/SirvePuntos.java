/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cesine.ipm.cabarceno.adrian;

/**
 *
 * @author Mariaje
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.Vector;
import javax.microedition.lcdui.Image;
import java.lang.System.*;
import javax.microedition.location.*;
/**
 *
 * @author Cactus
 */
public class SirvePuntos {

       Vector RutaX,RutaY;
       Vector VectorX,VectorY;
       Vector puntosInteres,interesDevolver;
       Interes salaExp,osos,jirafas,hienas,copius,hipos,asnos,cebras;
       Coordinates oso,jirafa,hiena,copiu,hipoPig,asno,cebra,sala;
       public SirvePuntos() {
           sala=new Coordinates(43.35654,-3.833361,34);
           oso=new Coordinates(43.356907,-3.838994,34);
           jirafa=new Coordinates(43.356493,-3.836827,34);
           hiena=new Coordinates(43.359169,-3.838264,34);
           copiu=new Coordinates(43.357874,-3.834123,34);
           hipoPig=new Coordinates(43.358623,-3.834863,34);
           asno=new Coordinates(43.357531,-3.834724,34);
           cebra=new Coordinates(43.3559,-3.83717,34);
           punto pSala=new punto(sala);
           punto pOso=new punto(oso);
           punto pJirafa=new punto(jirafa);
           punto pHiena=new punto(hiena);
           punto pCopiu=new punto(copiu);
           punto pHipo=new punto(hipoPig);
           punto pAsno=new punto(asno);
           punto pCebra=new punto(cebra);
           try{
              puntosInteres=new Vector();
              salaExp=new Interes(pSala.getX(),pSala.getY(),Image.createImage("imagenes/elefante.png"));//COMPROBAR LAS RUTAS
              hienas=new Interes(pHiena.getX(),pHiena.getY(),Image.createImage("imagenes/WC.gif"));
              copius=new Interes(pCopiu.getX(),pCopiu.getY(),Image.createImage("imagenes/coc.gif"));
              osos=new Interes(pOso.getX(),pOso.getY(),Image.createImage("imagenes/oso.gif"));
              hipos=new Interes(pHipo.getX(),pHipo.getY(),Image.createImage("imagenes/oso.gif"));
              asnos=new Interes(pAsno.getX(),pAsno.getY(),Image.createImage("imagenes/oso.gif"));
              cebras=new Interes(pCebra.getX(),pCebra.getY(),Image.createImage("imagenes/oso.gif"));
              jirafas=new Interes(pJirafa.getX(),pJirafa.getY(),Image.createImage("imagenes/oso.gif"));
              puntosInteres.addElement(salaExp);
              puntosInteres.addElement(hienas);
              puntosInteres.addElement(copius);
              puntosInteres.addElement(osos);
              puntosInteres.addElement(hipos);
              puntosInteres.addElement(asnos);
              puntosInteres.addElement(cebras);
              puntosInteres.addElement(jirafas);
           }catch(IOException e ){
           System.out.println("Comprueba la carga de imagenes");
           }
       }

        public int CalculaX(){
       int XpixelActual=1;
       return XpixelActual;
       }
       public int CalculaY(){
       int YpixelActual=1;
       return YpixelActual;
       }
       public Vector calculapuntos(int Xcrop,int XmedidaCrop,float Zoom,int Ycrop,int YmedidaCrop){
             interesDevolver=new Vector();
             Interes aux;
             for(int j=0;j<puntosInteres.size();j++){
             aux=(Interes)puntosInteres.elementAt(j);
             if(aux.getX()>=Xcrop && aux.getX()<=Xcrop){
               if(aux.getY()>=Ycrop && aux.getY()<=Ycrop){
                   aux.setposX((int)((aux.getX()-Xcrop)*Zoom));
                   aux.setposY((int)((aux.getY()-Ycrop)*Zoom));
                   interesDevolver.addElement(aux);
               }

             }
             }
          return interesDevolver;
       }
       public void añadeRuta(int x,int y){
            Integer aux;
            aux=new Integer(x);
            RutaX.addElement(aux);
            aux=new Integer(y);
            RutaY.addElement(aux);
       }
       public void calcula(Vector x, Vector y){
       RutaX=x;
       RutaY=y;
       }
       public void getRuta(int Xcrop,int XmedidaCrop,double Zoom,int Ycrop,int YmedidaCrop){
           VectorX=new Vector();
           VectorY=new Vector();
           Integer aux;
           Integer auy;
           int auxiliar;
           for(int j=0;j<RutaX.size();j++){
               aux=(Integer)RutaX.elementAt(j);
               auy=(Integer)RutaY.elementAt(j);
               if(aux.intValue()>=Xcrop && aux.intValue()<=(Xcrop+XmedidaCrop)){
                  if(auy.intValue()>=Ycrop && auy.intValue()<=(Ycrop+YmedidaCrop)){
                     auxiliar=aux.intValue();
                     auxiliar=auxiliar-Xcrop;
                     auxiliar=(int)(auxiliar*Zoom);
                     aux=new Integer(auxiliar);
                     VectorX.addElement(auy);
                     auxiliar=auy.intValue();
                     auxiliar=auxiliar-Ycrop;
                     auxiliar=(int)(auxiliar*Zoom);
                     aux=new Integer(auxiliar);
                     VectorY.addElement(auy);
                  }
               }
           }

       }
      public Vector getX(){
             return VectorX;
      }
      public Vector getY(){
             return VectorY;
      }

}
