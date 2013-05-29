/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cesine.ipm.golfsine.data;

import javax.microedition.location.Coordinates;

/**
 *
 * @author julioa
 */
public class Hole {

    private String name = null;
    private String imageName = null;
    private Coordinates point1 = null;
    private Coordinates point2 = null;
    private Coordinates point3 = null;
    private Coordinates point4 = null;
    private Coordinates pin = null;

    private int lengthYellow = -1;
    private int lengthRed = -1;
    private int lengthWhite = -1;
    private int par = -1;

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public int getLengthRed() {
        return lengthRed;
    }

    public void setLengthRed(int lengthRed) {
        this.lengthRed = lengthRed;
    }

    public int getLengthWhite() {
        return lengthWhite;
    }

    public void setLengthWhite(int lengthWhite) {
        this.lengthWhite = lengthWhite;
    }

    public int getLengthYellow() {
        return lengthYellow;
    }

    public void setLengthYellow(int lengthYellow) {
        this.lengthYellow = lengthYellow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPar() {
        return par;
    }

    public void setPar(int par) {
        this.par = par;
    }

    public Coordinates getPin() {
        return pin;
    }

    public void setPin(Coordinates pin) {
        this.pin = pin;
    }

    public Coordinates getPoint1() {
        return point1;
    }

    public void setPoint1(Coordinates point1) {
        this.point1 = point1;
    }

    public Coordinates getPoint2() {
        return point2;
    }

    public void setPoint2(Coordinates point2) {
        this.point2 = point2;
    }

    public Coordinates getPoint3() {
        return point3;
    }

    public void setPoint3(Coordinates point3) {
        this.point3 = point3;
    }

    public Coordinates getPoint4() {
        return point4;
    }

    public void setPoint4(Coordinates point4) {
        this.point4 = point4;
    }


}
