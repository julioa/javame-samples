/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.golfsine.form;

import com.cesine.ipm.golfsine.GolfController;
import com.sun.lwuit.Command;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.animations.CommonTransitions;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.GridLayout;

/**
 *
 * @author julioa
 */
public class CreditsForm extends Form implements ActionListener {

    Command exitCommand = null;
    String[] labels = {
        "Aplicación desarrollada para la asignatura ",
        "'Informática para Móviles' de Tercero de ",
        "Ingeniería Informática de Cesine ",
        "(Curso 2009/2010)",
        "Los logotipos y marcas que aparecen en el ",
        "programa son propiedad de sus legítimos ",
        "dueños, no existiendo ninguna vinculación ",
        "entre dichas marcas y los responsbles del programa",
        "Si entiende que hay alguna vulneración de ",
        "algún derecho póngase en contacto con el equipo",
        "--------------",
        "Equipo de Trabajo",
        "Profesor: ",
        " Julio Arrebola ",
        " (jarrebola@viachannel.com)",
        "Alumnos:",
        "Almon Bugallo, Marcos",
        "Barquín Gandarillas, Cynthia",
        "Bosch Domenech, Miguel",
        "Cantero Gutiérrez, Alvaro",
        "Compostizo Olarte, Angel",
        "Cortés Villar, Miguel",
        "De la Cuesta Campillo, Oscar",
        "Del Hierro Real, Carlos",
        "Delgado Torre, Daniel",
        "Fernández Gutiérrez, Sergio",
        "García Rodríguez, Javier",
        "Giménez Pérez, Juan José",
        "Guerra del Olmo, Guillermo",
        "Ibáñez Ibáñez, Adrián",
        "López Sierra, Ignacio",
        "Mantecón San Miguel, Miguel",
        "Pérez Cuesta, María Teresa",
        "Pérez Sánchez, Ignacio",
        "Rasines Díez, Pablo",
        "Rodríguez Fernández, Pablo",
        "Scrimieri González, Alberto",
        "Trueba Cantero, Mario",
        "--------------",
        "Con la colaboración de ",
        "Viachannel Sistemas ",
        "(info@viachannel.com)"
    };

    public CreditsForm() {

        this.setLayout(new GridLayout(labels.length, 1));


        this.setTransitionOutAnimator(CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, true, 1000));
        this.refreshTheme();

        for (int i = 0; i < labels.length; i++) {
            Label textArea = new Label();
            textArea.setText(labels[i]);
            this.addComponent(textArea);
        }

        exitCommand = new Command("Volver");
        this.addCommand(exitCommand);

        this.addCommandListener(this);
    }

    public void actionPerformed(ActionEvent evt) {
        Command command = evt.getCommand();

        if (command == exitCommand) {
            // Confirmamos y salimos
            GolfController.getInstance().goMain(false);
        } else {
            System.out.println(evt.getCommand());
        }
    }
}
