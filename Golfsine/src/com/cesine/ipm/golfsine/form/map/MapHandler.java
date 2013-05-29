/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.golfsine.form.map;

import com.cesine.ipm.golfsine.GolfController;
import com.cesine.ipm.golfsine.data.Hole;
import com.cesine.ipm.golfsine.module.GameController;
import com.cesine.ipm.golfsine.module.IGameListener;
import java.io.IOException;
import java.util.Vector;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.location.Coordinates;

/**
 *
 * @author julioa
 */
public class MapHandler implements IGameListener {

    Canvas canvas = null;
    int width = 0;
    int height = 0;
    int imgHeight = 0;
    int imgWidth = 0;
    int zoom = 1;
    int radio = 6;
    Hole currHole = null;
    int xOffset = 0;
    int yOffset = 0;
    boolean updateImage = false;
    Image finalImage = null;
    int step = 1;
    int rotation = 0;
    Coordinates corner1 = null;
    Coordinates corner2 = null;
    Coordinates corner3 = null;
    Coordinates corner4 = null;
    GameController controller = null;

    public MapHandler(Canvas canvas, GameController controller) {
        this.canvas = canvas;
        this.controller = controller;
        controller.addListener(this);
        updateImage = true;
    }

    public void paint(Graphics g) {

        width = g.getClipWidth();
        height = g.getClipHeight();
        System.out.println("Pantall:" + width + "/" + height);
        // Limpiamos la pantalla
        g.setColor(0x888888);
        g.fillRect(0, 0, width, height);

        if (GolfController.getInstance().getGame() == null) {
            return;
        }

        Hole newHole = GolfController.getInstance().getGame().getHole();

        if (currHole == null || currHole != newHole) {
            currHole = newHole;
            resetZoom();
            updateImage = true;
        }

        // Pintamos el mapa
        if (updateImage == true) {
            String imgName = currHole.getImageName();
            String dirName = GolfController.getInstance().getGame().getCourse().getDirName();

            String imgFile = "/res/campos/" + dirName + "/" + imgName;

            System.out.println("Buscando Imagen:" + imgFile);

            if (rotation == 90) {
                corner1 = currHole.getPoint2();
                corner2 = currHole.getPoint4();
                corner3 = currHole.getPoint1();
                corner4 = currHole.getPoint3();
            } else if (rotation == 180) {
                corner1 = currHole.getPoint4();
                corner2 = currHole.getPoint3();
                corner3 = currHole.getPoint2();
                corner4 = currHole.getPoint1();
            } else if (rotation == 270) {
                corner1 = currHole.getPoint3();
                corner2 = currHole.getPoint1();
                corner3 = currHole.getPoint4();
                corner4 = currHole.getPoint2();
            } else {
                corner1 = currHole.getPoint1();
                corner2 = currHole.getPoint2();
                corner3 = currHole.getPoint3();
                corner4 = currHole.getPoint4();
            }

            Image image1 = null;
            try {
                image1 = Image.createImage(imgFile);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            Image image = null;
            try {
                image = ImageUtil.rotateImage(image1, rotation);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println("Zoom;" + zoom);

            finalImage = ImageUtil.resizeImageJul(image, width * zoom, height * zoom);

            imgHeight = finalImage.getHeight();
            imgWidth = finalImage.getWidth();

            updateImage = false;
        }

        g.drawImage(finalImage, (width / 2) + xOffset, (height / 2) + yOffset, Graphics.HCENTER | Graphics.VCENTER);

        // Pintamos la bandera

        Point bandera = this.Coordinates2Point(currHole.getPin());

        g.setColor(0xffff00);
        g.fillArc((bandera.x - radio / 2) + xOffset, (bandera.y - radio / 2) + yOffset, radio, radio, 0, 360);

//        //pintamos esquinas
//        Point auxCorner = null;
//        auxCorner = this.Coordinates2Point(corner1);
//        g.setColor(0xff0000);
//        g.fillArc((auxCorner.x - radio / 2) + xOffset, (auxCorner.y - radio / 2) + yOffset, radio, radio, 0, 360);
//        auxCorner = this.Coordinates2Point(corner2);
//        g.setColor(0x00ff00);
//        g.fillArc((auxCorner.x - radio / 2) + xOffset, (auxCorner.y - radio / 2) + yOffset, radio, radio, 0, 360);
//        auxCorner = this.Coordinates2Point(corner3);
//        g.setColor(0x0000ff);
//        g.fillArc((auxCorner.x - radio / 2) + xOffset, (auxCorner.y - radio / 2) + yOffset, radio, radio, 0, 360);
//        auxCorner = this.Coordinates2Point(corner4);
//        g.setColor(0xffffff);
//        g.fillArc((auxCorner.x - radio / 2) + xOffset, (auxCorner.y - radio / 2) + yOffset, radio, radio, 0, 360);
//        auxCorner = this.Coordinates2Point(new Coordinates(
//                (currHole.getPoint1().getLatitude() + currHole.getPoint3().getLatitude()) / 2d,
//                (currHole.getPoint1().getLongitude() + currHole.getPoint2().getLongitude()) / 2d,
//                0.0f));
//        g.setColor(0xff00ff);
//        g.fillArc((auxCorner.x - radio / 2) + xOffset, (auxCorner.y - radio / 2) + yOffset, radio, radio, 0, 360);
//


        //System.out.println("Bandera en :" + bandera.x + "/" + bandera.y);

        Vector path = null;
        Point lastPoint = null;
        // Pintamos los golpes
        g.setColor(0x0000ff);
        path = GolfController.getInstance().getGame().getGolpes();
        lastPoint = null;
        for (int i = 0; i < path.size(); i++) {
            if (path.elementAt(i) != null) {
                Point currPoint = this.Coordinates2Point((Coordinates) path.elementAt(i));
                if (lastPoint == null) {
                    lastPoint = currPoint;
                }

                g.drawLine((lastPoint.x) + xOffset, (lastPoint.y) + yOffset, (currPoint.x) + xOffset, (currPoint.y) + yOffset);

                lastPoint = currPoint;
            }
        }

        // Pintamos lo andado
        g.setColor(0x00ff00);
        path = GolfController.getInstance().getGame().getPath();
        lastPoint = null;
        for (int i = 0; i < path.size(); i++) {
            Point currPoint = this.Coordinates2Point((Coordinates) path.elementAt(i));
            if (lastPoint == null) {
                lastPoint = currPoint;
            }

            g.drawLine((lastPoint.x) + xOffset, (lastPoint.y) + yOffset, (currPoint.x) + xOffset, (currPoint.y) + yOffset);

            lastPoint = currPoint;
        }

        // Pintamos la posicion actual

        Coordinates position = GolfController.getInstance().getGame().getCurrentPosition();
        if (position != null) {
            Point aqui = this.Coordinates2Point(position);

            g.setColor(0x00ffff);
            g.fillArc((aqui.x - radio / 2) + xOffset, (aqui.y - radio / 2) + yOffset, radio, radio, 0, 360);

            //System.out.println("Aqui en :" + aqui.x + "/" + aqui.y);

        }


        // Pintamos la leyenda
        g.setColor(0xffffff);

        Font font = Font.getFont(Font.FACE_SYSTEM,
                Font.STYLE_PLAIN, Font.SIZE_SMALL);
        int fh = font.getHeight();
        g.setFont(font);

        Vector lines = new Vector();

        int pad = 2;
        int lineHeight = fh + pad;
        int leyendaWidth = 0;

        String aux = null;
        int auxWidth = 0;

        // Campo
        aux = GolfController.getInstance().getGame().getCourse().getName();
        g.drawString(aux, pad, pad, Graphics.TOP | Graphics.LEFT);
        // Hoyo
        aux = GolfController.getInstance().getGame().getHole().getName();
        g.drawString(aux, pad, fh + pad + pad, Graphics.TOP | Graphics.LEFT);
        // Par
        aux = "Par: " + GolfController.getInstance().getGame().getHole().getPar();
        g.drawString(aux, pad, 2 * (fh + pad) + pad, Graphics.TOP | Graphics.LEFT);

        // Estado gps
        aux = GolfController.getInstance().getGame().getGpsStat();
        lines.addElement(aux);
        auxWidth = font.stringWidth(aux);
        leyendaWidth = Math.max(leyendaWidth, auxWidth);

        // Golpes
        aux = "Golpes: " + GolfController.getInstance().getGame().getGame().getCurrentScore().getTotal();
        lines.addElement(aux);
        auxWidth = font.stringWidth(aux);
        leyendaWidth = Math.max(leyendaWidth, auxWidth);

        // Tiempo
        aux = "T.ToTal: " + GolfController.getInstance().getGame().getTimeTotal();
        lines.addElement(aux);
        auxWidth = font.stringWidth(aux);
        leyendaWidth = Math.max(leyendaWidth, auxWidth);

        // Tiempo
        aux = "T.Hoyo: " + GolfController.getInstance().getGame().getTimeHole();
        lines.addElement(aux);
        auxWidth = font.stringWidth(aux);
        leyendaWidth = Math.max(leyendaWidth, auxWidth);

        // Distancia
        aux = "D.Pin: " + (int) GolfController.getInstance().getGame().getDistance2Pin() + "m";
        lines.addElement(aux);
        auxWidth = font.stringWidth(aux);
        leyendaWidth = Math.max(leyendaWidth, auxWidth);

        // Distancia
        aux = "D.Golpe: " + (int) GolfController.getInstance().getGame().getDistanceShot() + "m";
        lines.addElement(aux);
        auxWidth = font.stringWidth(aux);
        leyendaWidth = Math.max(leyendaWidth, auxWidth);

        // Distancia
        aux = "D.Total: " + (int) GolfController.getInstance().getGame().getAndado() + "m";
        lines.addElement(aux);
        auxWidth = font.stringWidth(aux);
        leyendaWidth = Math.max(leyendaWidth, auxWidth);

        // Precision
        aux = "Prec.: " + GolfController.getInstance().getGame().getAccuracy() + "m";
        lines.addElement(aux);
        auxWidth = font.stringWidth(aux);
        leyendaWidth = Math.max(leyendaWidth, auxWidth);

        leyendaWidth = leyendaWidth + 2 * pad;
        int leyendaHeight = fh * lines.size() + pad * 2;

        int leyendaX = width - leyendaWidth;
        int leyendaY = height - leyendaHeight;
        g.drawRoundRect(leyendaX, leyendaY, leyendaWidth, leyendaHeight, radio, radio);
        for (int i = 0; i < lines.size(); i++) {
            int offset = pad + i * fh;
            g.drawString((String) lines.elementAt(i), leyendaX + pad, leyendaY + offset, Graphics.TOP | Graphics.LEFT);
        }
    }

    public void repaint() {
        canvas.repaint();
    }

    public void gameNotification() {
        repaint();
    }

    void zoomin() {
        updateImage = true;
        zoom = zoom * 2;
        xOffset = xOffset * 2;
        yOffset = yOffset * 2;
        repaint();
    }

    void zoomout() {
        if (zoom > 1) {
            updateImage = true;
            zoom = zoom / 2;
            xOffset = xOffset / 2;
            yOffset = yOffset / 2;
            repaint();
        }
    }

    void nozoom() {

        updateImage = true;

        resetZoom();

        repaint();

    }

    void resetZoom() {
        xOffset = 0;
        yOffset = 0;
        rotation = 0;

        zoom = 1;
    }

    private Point Coordinates2Point(Coordinates coord) {
        if (currHole == null) {
            return null;
        }

        if (coord == null) {
            return null;
        }

        Point result = new Point();

        Coordinates center = new Coordinates(
                (currHole.getPoint1().getLatitude() + currHole.getPoint3().getLatitude()) / 2d,
                (currHole.getPoint1().getLongitude() + currHole.getPoint2().getLongitude()) / 2d,
                0.0f);

        float distanceHeight = corner1.distance(corner3);

        float azimuthDeg = corner3.azimuthTo(corner1);
        float azimuthPoint = center.azimuthTo(coord);
        float azimuthTotal = (90-azimuthPoint-azimuthDeg);

        //double azimuthRad = Math.PI * (azimuthDeg / 180f);
        double azimuthRad = Math.PI * (azimuthTotal / 180f);

        System.out.println("Azimuth:" + azimuthDeg + ":" + azimuthPoint + "=" + azimuthTotal + "("+azimuthRad+")");

        float ratio = distanceHeight / imgHeight;

//        Coordinates center = new Coordinates(
//                (corner1.getLatitude() + corner3.getLatitude()) / 2d,
//                (corner1.getLongitude() + corner2.getLongitude()) / 2d,
//                0.0f);

        float distance = center.distance(coord);

//        float distanceY = center.distance(new Coordinates(coord.getLatitude(), center.getLongitude(), 0.0f));
//        float distanceX = center.distance(new Coordinates(center.getLatitude(), coord.getLongitude(), 0.0f));
//
//        float realDistanceY = distanceY * (float) Math.cos(azimuthRad) + distanceX * (float) Math.sin(azimuthRad);
//        if (coord.getLatitude() > center.getLatitude()) {
//            realDistanceY = -1 * realDistanceY;
//        }
//
//
//        float realDistanceX = distanceX * (float) Math.cos(azimuthRad) - distanceY * (float) Math.sin(azimuthRad);
//        if (coord.getLongitude() < center.getLongitude()) {
//            realDistanceX = -1 * realDistanceX;
//        }

        float realDistanceY = distance * (float) Math.sin(azimuthRad);
        float realDistanceX = distance * (float) Math.cos(azimuthRad);


        result.setX(((width / 2 + ((int) (realDistanceX / ratio)))));
        result.setY(((height / 2 - ((int) (realDistanceY / ratio)))));

        return result;
    }

    public void keyPressed(int action, boolean repeated) {

        if (repeated == true) {
            step += 3;
        } else {
            step = 2;
        }

        switch (action) {
            case Canvas.DOWN:
                yOffset -= step;
                repaint();
                break;
            case Canvas.RIGHT:
                xOffset -= step;
                repaint();
                break;
            case Canvas.LEFT:
                xOffset += step;
                repaint();
                break;
            case Canvas.UP:
                yOffset += step;
                repaint();
                break;
            case Canvas.FIRE:
                nozoom();
                break;
        }
    }

    void rotate() {
        rotation = (rotation + 90) % 360;
        updateImage = true;
        repaint();
    }
}
