/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.golfsine.form;

import com.cesine.ipm.golfsine.GolfController;
import com.cesine.ipm.golfsine.data.Game;
import com.sun.lwuit.Button;
import com.sun.lwuit.Command;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.animations.CommonTransitions;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.GridLayout;

/**
 *
 * @author julioa
 */
public class SaveForm extends Form implements ActionListener {

    private Game game = null;
    Command exitCommand = null;
    Command okCommand = null;

    public SaveForm() {
        this.setTransitionOutAnimator(CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, true, 1000));
        setLayout(new GridLayout(4, 1));
        this.addComponent(new Label("¿Guardar Recorrido?"));

        Button b1 = new Button("Sí");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                GolfController.getInstance().saveGame(GolfController.SAVE_YES);
            }
        });
        b1.setTextPosition(Button.BOTTOM);
        b1.setAlignment(Button.CENTER);
        this.addComponent(b1);

        Button b2 = new Button("No");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                GolfController.getInstance().saveGame(GolfController.SAVE_NO);
            }
        });
        b2.setTextPosition(Button.BOTTOM);
        b2.setAlignment(Button.CENTER);
        this.addComponent(b2);

        Button b3 = new Button("Volver");
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                GolfController.getInstance().saveGame(GolfController.SAVE_CANCEL);
            }
        });
        b3.setTextPosition(Button.BOTTOM);
        b3.setAlignment(Button.CENTER);
        this.addComponent(b3);

        this.addCommandListener(this);
    }

    public void actionPerformed(ActionEvent evt) {
    }
}
