/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.demo2;

import javax.microedition.lcdui.*;

/**
 *
 * @author julioa
 */
public class DemoTextBox extends TextBox implements CommandListener {

    Command volver = new Command("Volver", Command.BACK, 1);
    Command salir = new Command("Salir", Command.EXIT, 1);

    DemoMidlet myMidlet = null;

    public DemoTextBox(DemoMidlet myMidlet) {
        super("TextBox Demo", null, 20, TextField.ANY);

        this.addCommand(salir);
        this.addCommand(volver);

        this.myMidlet = myMidlet;

        this.setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
        if (c == volver) {
           //DemoMidlet.vuelve();

















            myMidlet.vuelve();
        } else if (c == salir) {
        } else {
        }
    }
}
