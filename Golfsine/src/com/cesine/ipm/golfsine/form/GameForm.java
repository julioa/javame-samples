/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.golfsine.form;

import com.cesine.ipm.golfsine.GolfController;
import com.cesine.ipm.golfsine.data.Course;
import com.cesine.ipm.golfsine.data.Game;
import com.cesine.ipm.golfsine.module.CourseManager;
import com.sun.lwuit.ComboBox;
import com.sun.lwuit.Command;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.TextField;
import com.sun.lwuit.animations.CommonTransitions;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.GridLayout;
import java.util.Vector;

/**
 *
 * @author julioa
 */
public class GameForm extends Form implements ActionListener {

    private Game game = null;
    Command exitCommand = null;
    Command okCommand = null;
    TextField fieldJugador2 = null;
    TextField fieldJugador3 = null;
    TextField fieldJugador4 = null;
    ComboBox camposBox = null;
    ComboBox hoyo = null;

    public GameForm() {

        this.setLayout(new GridLayout(3, 2));


        this.setTransitionOutAnimator(CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, true, 1000));
        this.refreshTheme();
        exitCommand = new Command("Volver");
        this.addCommand(exitCommand);

        this.addCommandListener(this);

        updateGame();


    }

    private void updateGame() {
        if (game == null) {
            game = new Game();
        }

        this.addComponent(new Label("Campo"));
        camposBox = new ComboBox();
        Vector camposList = CourseManager.getCourseList();
        for (int i = 0; i < camposList.size(); i++) {
            camposBox.addItem(((Course) camposList.elementAt(i)).getName());
        }
        this.addComponent(camposBox);

        this.addComponent(new Label("Hoyo"));
        hoyo = new ComboBox();
        for (int i = 1; i <= 18; i++) {
            hoyo.addItem(Integer.toString(i));
        }
        this.addComponent(hoyo);

        this.addComponent(new Label("Jugador 2"));
        fieldJugador2 = new TextField();
        //fieldJugadores.setText(Integer.toString(game.getPlayers()));
        fieldJugador2.setEditable(true);
        this.addComponent(fieldJugador2);

        this.addComponent(new Label("Jugador 3"));
        fieldJugador3 = new TextField();
        //fieldJugadores.setText(Integer.toString(game.getPlayers()));
        fieldJugador3.setEditable(true);
        this.addComponent(fieldJugador3);

        this.addComponent(new Label("Jugador 4"));
        fieldJugador4 = new TextField();
        //fieldJugadores.setText(Integer.toString(game.getPlayers()));
        fieldJugador4.setEditable(true);
        this.addComponent(fieldJugador4);

        okCommand = new Command("Jugar");
        this.addCommand(okCommand);
    }

    public void actionPerformed(ActionEvent evt) {
        Command command = evt.getCommand();

        if (command == exitCommand) {
            // Confirmamos y salimos
            GolfController.getInstance().goMain(false);
        } else if (command == okCommand) {
            // Confirmamos y Guardamos datos
            game.setInitHole(Integer.parseInt(hoyo.getSelectedItem().toString())-1);
            game.setCourseName(camposBox.getSelectedItem().toString());
            game.setPlayer2(fieldJugador2.getText());
            game.setPlayer3(fieldJugador3.getText());
            game.setPlayer4(fieldJugador4.getText());
            GolfController.getInstance().goPlay(game);
        } else {
            System.out.println(evt.getCommand());
        }
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
        updateGame();
    }
}
