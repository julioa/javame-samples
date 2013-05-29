/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cesine.ipm.golfsine.data;

import java.util.Vector;

/**
 *
 * @author julioa
 */
public class Course {
    private String name = null;
    private String dirName = null;
    private Vector holes = new Vector();

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    public Vector getHoles() {
        return holes;
    }

    public void setHoles(Vector holes) {
        this.holes = holes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addHole(Hole hole) {
        holes.addElement(hole);
    }

    public Hole getHole(int i) {
        return (Hole)holes.elementAt(i);
    }
    

}
