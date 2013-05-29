/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.golfsine.form;

import com.cesine.ipm.golfsine.GolfController;
import com.cesine.ipm.golfsine.data.Game;
import com.cesine.ipm.golfsine.module.GameController;
import com.cesine.ipm.golfsine.module.tarjeta.GameTableModel;
import com.cesine.ipm.golfsine.module.tarjeta.TablaItem;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;

/**
 *
 * @author julioa
 */
public class CardForm2 extends Form implements CommandListener {

//    String[][] data = {{"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "Total"}, {"Par", "4", "3", "4", "3", "5", "4", "4", "4", "3", "34"},
//        {"Yo", "4", "3", "4", "3", "5", "4", "4", "4", "3", "34"},
//        {"AJ", "4", "3", "4", "3", "5", "4", "4", "4", "3", "34"},
//        {"MN", "4", "3", "4", "3", "5", "4", "4", "4", "3", "34"}};
//    ArrayTableModel model = new ArrayTableModel(data);
    GameTableModel model1 = null;
    GameTableModel model2 = null;
    GameController gameController = null;
    Game game = null;
    private static final Command CMD_BACK = new Command("Volver", Command.EXIT, 1);
    private static final Command CMD_NEXT = new Command("Siguiente", Command.EXIT, 1);
    private static final Command CMD_END = new Command("Fin", Command.EXIT, 1);
    private static final Command CMD_IDA = new Command("Ida", Command.OK, 1);
    private static final Command CMD_VUELTA = new Command("Vuelta", Command.OK, 1);
    TablaItem tablaIda = null;
    TablaItem tablaVuelta = null;
    boolean readOnly;

    public CardForm2(Display display, boolean readOnly) {
        super("Tarjeta");

        setReadOnly(readOnly);

        addCommand(CMD_BACK);
        addCommand(CMD_NEXT);
        addCommand(CMD_END);
        setCommandListener(this);

        gameController = GolfController.getInstance().getGame();
        if (gameController == null) {
            return;
        }

        game = gameController.getGame();
        if (game == null) {
            return;
        }


        model1 = new GameTableModel(game, 0, 9, isReadOnly());
        tablaIda = new TablaItem("Ida", display, model1);
        if (game.getScores().size() > 9) {
            model2 = new GameTableModel(game, 9, 18, isReadOnly());
            tablaVuelta = new TablaItem("Vuelta", display, model2);
        }

        append(tablaIda);


        if (model2 != null) {
            addCommand(CMD_IDA);
            addCommand(CMD_VUELTA);
        }
    }

    public void commandAction(Command c, Displayable d) {

        if (game == null) {
            GolfController.getInstance().goMain(true);
        }

        if (c == CMD_BACK) {
            GolfController.getInstance().keepPlaying();
        } else if (c == CMD_NEXT) {
            gameController.nexHole();
        } else if (c == CMD_END) {
            gameController.endGame();
        } else if (c == CMD_IDA) {
            deleteAll();
            append(tablaIda);
        } else if (c == CMD_VUELTA) {
            deleteAll();
            append(tablaVuelta);
        }
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }
}
