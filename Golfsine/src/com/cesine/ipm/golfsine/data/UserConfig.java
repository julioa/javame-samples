/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cesine.ipm.golfsine.data;

/**
 *
 * @author julioa
 */
public class UserConfig {

    private String name = null;
    private float handicap = 36f;

    private String[] palos = new String[14];

    public float getHandicap() {
        return handicap;
    }

    public void setHandicap(float handicap) {
        this.handicap = handicap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPalos() {
        return palos;
    }

    public void setPalos(String[] palos) {
        this.palos = palos;
    }
}
