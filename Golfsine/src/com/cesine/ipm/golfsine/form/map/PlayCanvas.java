/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.golfsine.form.map;

import com.cesine.ipm.golfsine.form.map.MapHandler;
import com.cesine.ipm.golfsine.GolfController;
import com.cesine.ipm.golfsine.module.GameController;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;

/**
 *
 * @author julioa
 */
public class PlayCanvas extends Canvas implements CommandListener {

    MapHandler map = null;
    Command exitCommand = null;
    Command golpeCommand = null;
    Command finhoyoCommand = null;
    Command zoominCommand = null;
    Command zoomoutCommand = null;
    Command nozoomCommand = null;
    Command volverCommand = null;
    Command rotateCommand = null;
    boolean isReadOnly = false;

    public PlayCanvas(GameController controller, boolean readOnly) {

        setReadOnly(readOnly);

        this.setCommandListener(this);
        map = new MapHandler(this, controller);

        // Pintamos menu
        exitCommand = new Command("Salir", Command.EXIT, 1);
        this.addCommand(exitCommand);

        volverCommand = new Command("Volver", Command.EXIT, 2);
        this.addCommand(volverCommand);

        finhoyoCommand = new Command("Hoyo", Command.EXIT, 3);
        this.addCommand(finhoyoCommand);

        if (isReadOnly() == false) {
        golpeCommand = new Command("Golpe", Command.OK, 1);
        this.addCommand(golpeCommand);
        }

        zoominCommand = new Command("Zoom+", Command.OK, 2);
        this.addCommand(zoominCommand);

        zoomoutCommand = new Command("Zoom-", Command.OK, 3);
        this.addCommand(zoomoutCommand);

        nozoomCommand = new Command("No Zoom", Command.OK, 4);
        this.addCommand(nozoomCommand);

        rotateCommand = new Command("Rotar", Command.OK, 5);
        this.addCommand(rotateCommand);
    }

    protected void paint(Graphics g) {

        // Pintamos mapa
        map.paint(g);

        // Actualizamos el menu
        // Por ahora no lo hacemos
    }

    public void commandAction(Command c, Displayable d) {
        if (c == exitCommand) {
            GolfController.getInstance().endGame();
        } else if (c == volverCommand) {
            GolfController.getInstance().goMain(false);
        } else if (c == rotateCommand) {
            map.rotate();
        } else if (c == zoominCommand) {
            map.zoomin();
        } else if (c == zoomoutCommand) {
            map.zoomout();
        } else if (c == nozoomCommand) {
            map.nozoom();
        } else if (c == finhoyoCommand) {
            GolfController.getInstance().getGame().viewCard();
        } else if (c == golpeCommand) {
            GolfController.getInstance().getGame().golpe();
        }
    }

    protected void keyRepeated(int key) {
        int action = getGameAction(key);
        map.keyPressed(action, true);
    }

    protected void keyPressed(int key) {
        int action = getGameAction(key);
        map.keyPressed(action, false);
    }

    public boolean isReadOnly() {
        return isReadOnly;
    }

    public void setReadOnly(boolean isReadOnly) {
        this.isReadOnly = isReadOnly;
    }


}
