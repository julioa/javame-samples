/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.golfsine.form;

import com.cesine.ipm.golfsine.GolfController;
import com.cesine.ipm.golfsine.module.config.Config;
import com.cesine.ipm.golfsine.module.config.ConfigManager;
import com.sun.lwuit.ComboBox;
import com.sun.lwuit.Command;
import com.sun.lwuit.Container;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.TabbedPane;
import com.sun.lwuit.TextField;
import com.sun.lwuit.animations.CommonTransitions;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.GridLayout;

/**
 *
 * @author julioa
 */
public class ConfigForm extends Form implements ActionListener {

    Command exitCommand = null;
    Command okCommand = null;
    Config config = null;
    ComboBox[] palos = new ComboBox[14];
    TextField fieldNombre = new TextField();
    TextField fieldHandicap = new TextField();
    String[] nombres =  {"Ninguno", "Putter", "Driver","Madera 3", "Madera 5", "Madera 7", "Hibrido 3", "Hibrido 4","Hibrido 5","Hierro 3", "Hierro 4", "Hierro 5", "Hierro 6", "Hierro 7", "Hierro 8", "Hierro 9", "PW", "GW", "SW", "LW"};

    public ConfigForm() {

        config = ConfigManager.getConfig();

        TabbedPane tabbedPane = new TabbedPane(TabbedPane.TOP);

        Container container1 = new Container();
        container1.setLayout(new GridLayout(3, 2));

        container1.addComponent(new Label("Nombre"));
        fieldNombre.setText(config.getNombre());
        container1.addComponent(fieldNombre);

        container1.addComponent(new Label("Handicap"));
        fieldHandicap.setText(Float.toString(config.getHandicap()));
        container1.addComponent(fieldHandicap);


        Container container2 = new Container();
        container2.setLayout(new GridLayout(14, 2));

        for (int i = 0; i < palos.length; i++) {
            container2.addComponent(new Label("Palo " + (i + 1)));
            palos[i] = new ComboBox(nombres);
            palos[i].setSelectedItem(config.getPalos(i));
            container2.addComponent(palos[i]);
        }


        tabbedPane.addTab("Global", container1);
        tabbedPane.addTab("Palos", container2);
        this.addComponent(tabbedPane);

        this.setTransitionOutAnimator(CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, true, 1000));
        this.refreshTheme();
        exitCommand = new Command("Volver");
        this.addCommand(exitCommand);
        okCommand = new Command("OK");
        this.addCommand(okCommand);

        this.addCommandListener(this);
    }

    public void actionPerformed(ActionEvent evt) {
        Command command = evt.getCommand();

        if (command == exitCommand) {
            // Confirmamos y salimos
            GolfController.getInstance().goMain(false);
        } else if (command == okCommand) {
            // Confirmamos y Guardamos datos
            config.setNombre(fieldNombre.getText());
            String hand = fieldHandicap.getText();
            float f = Float.valueOf(hand).floatValue();
            config.setHandicap(f);
            for (int i = 0; i < palos.length; i++) {
                config.setPalos((String)palos[i].getSelectedItem(), i);
            }

            ConfigManager.saveConfig(config);

            GolfController.getInstance().goMain(false);
        }
    }
}
