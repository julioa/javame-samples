/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.golfsine.form;

import com.cesine.ipm.golfsine.GolfController;
import com.cesine.ipm.golfsine.data.Game;
import com.sun.lwuit.Command;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.List;
import com.sun.lwuit.animations.CommonTransitions;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.events.SelectionListener;
import java.util.Vector;

/**
 *
 * @author julioa
 */
public class HistoryForm extends Form implements ActionListener, SelectionListener {

    Command exitCommand = null;
    Command okCommand = null;
    Command selectCommand = null;
    Command deleteCommand = null;
    List lista = null;
    Vector histList = null;

    //String[] nombres = { "Partida 1", "Partida 2", "Partida 3", "Partida 4", "Partida 5", "Partida 6", "Partida 7" };
    public HistoryForm() {

        updateList();

        this.setTransitionOutAnimator(CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, true, 1000));
        this.refreshTheme();
        exitCommand = new Command("Volver");
        this.addCommand(exitCommand);

        this.addCommandListener(this);
    }

    private void updateList() {
        if (lista != null) {
            this.removeComponent(lista);
            if (okCommand != null) {
                this.removeCommand(okCommand);
            }
        }

        lista = new List();

        histList = GolfController.getInstance().getHistoryList();
        for (int i = 0; i < histList.size(); i++) {
            Game game = (Game) histList.elementAt(i);
            lista.addItem(game.getName());
        }

        lista.addSelectionListener(this);
        lista.addActionListener(this);
        selectCommand = new Command("Seleccionar");

        this.addComponent(lista);

        if (lista.size() > 0) {
            okCommand = new Command("OK");
            this.addCommand(okCommand);
            deleteCommand = new Command("Borrar");
            this.addCommand(deleteCommand);
        } else {
            this.addComponent(new Label("No hay recorridos"));
        }


    }

    public void actionPerformed(ActionEvent evt) {
        Command command = evt.getCommand();

        if (evt.getSource() == lista) {
            GolfController.getInstance().viewGame((Game) histList.elementAt(lista.getSelectedIndex()));
        } else if (command == exitCommand) {
            // Confirmamos y salimos
            GolfController.getInstance().goMain(false);
        } else if (command == okCommand) {
            // Confirmamos y Guardamos datos
            GolfController.getInstance().viewGame((Game) histList.elementAt(lista.getSelectedIndex()));
        } else if (command == deleteCommand) {
            int pos = lista.getSelectedIndex();
            Game game = (Game) histList.elementAt(pos);
            GolfController.getInstance().removeGame(game);
            updateList();
        } else {
            System.out.println(evt.getCommand());
        }
    }

    public void selectionChanged(int oldSelected, int newSelected) {
    }
}
