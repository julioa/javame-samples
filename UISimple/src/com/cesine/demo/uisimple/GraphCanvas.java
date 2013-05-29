/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.demo.uisimple;

import javax.microedition.lcdui.*;

/**
 *
 * @author julioa
 */
public class GraphCanvas extends Canvas implements CommandListener {

    int[] values = {2, 5, 4, 9, 5};

    protected void paint(Graphics g) {

        int width = this.getWidth();
        int heigth = this.getHeight();

        g.setColor(255, 255, 255);

        g.fillRect(0, 0, width, heigth);

        int maxValue = 0;
        int sumValue = 0;
        for (int i = 0; i < values.length; i++) {
            sumValue += values[i];
            maxValue = Math.max(maxValue, values[i]);
        }

        g.setColor(0, 0, 255);
        int barWidth=width/values.length;
        for (int i = 0; i < values.length; i++) {
            g.fillRect(i*barWidth,(int)((float)heigth*(1f-(float)values[i]/(float)maxValue)),barWidth,(int)((float)heigth*((float)values[i]/(float)maxValue)));
        }
    }

    public void commandAction(Command c, Displayable d) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
