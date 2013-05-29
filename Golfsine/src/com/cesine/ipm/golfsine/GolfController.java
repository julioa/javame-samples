/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.golfsine;

import com.cesine.ipm.golfsine.module.GameController;
import com.cesine.ipm.golfsine.data.Game;
import com.cesine.ipm.golfsine.form.CardForm;
import com.cesine.ipm.golfsine.form.CardForm2;
import com.cesine.ipm.golfsine.form.ConfigForm;
import com.cesine.ipm.golfsine.form.CreditsForm;
import com.cesine.ipm.golfsine.form.GameForm;
import com.cesine.ipm.golfsine.form.HistoryForm;
import com.cesine.ipm.golfsine.form.MainForm;
import com.cesine.ipm.golfsine.form.SaveForm;
import com.cesine.ipm.golfsine.form.map.PlayCanvas;
import com.cesine.ipm.golfsine.module.HistoryManager;
import com.cesine.ipm.golfsine.module.Reglas;
import com.cesine.ipm.golfsine.module.config.ConfigForm2;
import com.sun.lwuit.Dialog;
import java.util.Vector;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;

/**
 *
 * @author julioa
 */
public class GolfController {

    private static GolfController instance = null;
    private GolfMidlet midlet = null;
    private GameController gameController = null;

    private GolfController() {
    }

    static public GolfController getInstance() {
        if (instance == null) {
            instance = new GolfController();
        }

        return instance;
    }

    public GameController getGame() {
        return gameController;
    }

    public void exit() {
        if (midlet != null) {
            Dialog.show("Adios", "La aplicación se va a cerrar", Dialog.TYPE_INFO, null, "Salir", null, 10000);
            midlet.notifyDestroyed();
        }
    }

    public GolfMidlet getMidlet() {
        return midlet;
    }

    public void setMidlet(GolfMidlet midlet) {
        this.midlet = midlet;
    }

    public void goConfig() {
        ConfigForm2 form = new ConfigForm2();
        Display.getDisplay(midlet).setCurrent(form);
    }

    public void goConfig2() {
        ConfigForm form = new ConfigForm();
        form.show();
    }

    public void goHistory() {
        HistoryForm form = new HistoryForm();
        form.show();
    }

    public void goGame() {
        if (gameController != null) {
            keepPlaying();
            return;
        }
        GameForm form = new GameForm();
        form.show();
    }

    public void goPlay(Game game) {
        if (gameController == null) {
            gameController = new GameController(game, false);
        }

        Display.getDisplay(midlet).setCurrent(gameController.getPlayCanvas());
    }

    public void keepPlaying() {
        if (gameController == null) {
            this.goMain(true);
            return;
        }

        Display.getDisplay(midlet).setCurrent(gameController.getPlayCanvas());
    }

    public void goMain(boolean forward) {
        MainForm f = new MainForm();

        if (forward) {
            f.show();
        } else {
            f.showBack();
        }
    }

    public Vector getHistoryList() {
        return HistoryManager.getInstance().getHistoryList();
    }

    public void removeGame(Game game) {
        HistoryManager.getInstance().removeGame(game);
        goHistory();
    }

    public void viewGame(Game game) {

        gameController = new GameController(game, true);
        keepPlaying();

        //GameForm form = new GameForm();
        //form.setGame(game);
        //form.show();
    }

    public void endGame() {

        SaveForm form = new SaveForm();
        form.show();
//
//        gameController = null;
//        playCanvas = null;
//        goMain(false);
    }

    public static int SAVE_YES = 1;
    public static int SAVE_NO = 2;
    public static int SAVE_CANCEL = 3;
    public void saveGame(int mode) {
        if (mode == SAVE_YES) {
            if (getGame() != null) {
               gameController.finishGame();
               HistoryManager.getInstance().saveGame(getGame().getGame());
            }
            gameController = null;
            goMain(false);
        } else if (mode == SAVE_NO) {
            gameController.finishGame();
            gameController = null;
            goMain(false);
        } else if (mode == SAVE_CANCEL) {
            keepPlaying();
        }
    }

    public void viewCard(Game game, boolean readOnly) {
        CardForm2 form = new CardForm2(Display.getDisplay(midlet), readOnly);
        Display.getDisplay(midlet).setCurrent(form);
    }

    public void viewCard2(Game game) {
        CardForm form = new CardForm();
        form.setGame(game);
        form.show();
    }

    public void goReglas() {
        Reglas rules = new Reglas();
        Displayable menu = rules.getMenu();
        Display.getDisplay(midlet).setCurrent(menu);
    }

    public Display getDisplay() {
        return Display.getDisplay(midlet);
    }

    public void goCredits() {
        CreditsForm form = new CreditsForm();
        form.show();
    }
}
