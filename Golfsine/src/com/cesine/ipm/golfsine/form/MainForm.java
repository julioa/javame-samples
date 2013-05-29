/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.golfsine.form;

import com.cesine.ipm.golfsine.GolfController;
import com.sun.lwuit.Button;
import com.sun.lwuit.Command;
import com.sun.lwuit.Display;
import com.sun.lwuit.Form;
import com.sun.lwuit.Image;
import com.sun.lwuit.animations.CommonTransitions;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.GridLayout;
import java.io.IOException;

/**
 *
 * @author julioa
 */
public class MainForm extends Form implements ActionListener {

    public MainForm() {
        setLayout(new GridLayout(3, 2));

        Image imgButton1 = null;
        try {
            imgButton1 = Image.createImage("/res/img/green.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Button b1 = new Button("Configuración", imgButton1);
        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                GolfController.getInstance().goConfig();
            }
        });
        b1.setTextPosition(Button.BOTTOM);
        b1.setAlignment(Button.CENTER);
        this.addComponent(b1);

        Image imgButton2 = null;
        try {
            imgButton2 = Image.createImage("/res/img/golfball.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Button b2 = new Button("Histórico", imgButton2);
        b2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                GolfController.getInstance().goHistory();
            }
        });
        b2.setAlignment(Button.CENTER);
        b2.setTextPosition(Button.BOTTOM);
        this.addComponent(b2);


        Image imgButton3 = null;
        try {
            imgButton3 = Image.createImage("/res/img/hoyo.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Button b3 = new Button("Jugar", imgButton3);
        b3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                GolfController.getInstance().goGame();
            }
        });
        b3.setAlignment(Button.CENTER);
        b3.setTextPosition(Button.BOTTOM);
        this.addComponent(b3);


        Image imgButton4 = null;
        try {
            imgButton4 = Image.createImage("/res/img/rfeg.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Button b4 = new Button("Reglas", imgButton4);
        b4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                GolfController.getInstance().goReglas();
            }
        });
        b4.setTextPosition(Button.BOTTOM);
        b4.setAlignment(Button.CENTER);
        this.addComponent(b4);

        Image imgButton5 = null;
        try {
            imgButton5 = Image.createImage("/res/img/logo-cesine.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Button b5 = new Button("Créditos", imgButton5);
        b5.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                GolfController.getInstance().goCredits();
            }
        });
        b5.setAlignment(Button.CENTER);
        b5.setTextPosition(Button.BOTTOM);
        this.addComponent(b5);

        Image imgButton6 = null;
        try {
            imgButton6 = Image.createImage("/res/img/system-log-out.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Button b6 = new Button("Salir", imgButton6);
        b6.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                GolfController.getInstance().exit();
            }
        });
        b6.setAlignment(Button.CENTER);
        b6.setTextPosition(Button.BOTTOM);
        this.addComponent(b6);


        this.setTransitionOutAnimator(CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, true, 1000));
        this.refreshTheme();

        //Command exitCommand = new Command("Salir");
        //this.addCommand(exitCommand);
        //this.addCommandListener(this);

    }

    public void actionPerformed(ActionEvent evt) {
        GolfController.getInstance().exit();
    }
}
