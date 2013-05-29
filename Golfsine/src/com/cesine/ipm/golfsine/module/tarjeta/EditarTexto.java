package com.cesine.ipm.golfsine.module.tarjeta;

import javax.microedition.lcdui.*;


/**
 *
 * Ignacio López Sierra, Javier García Rodriguez, Daniel Delgado Torre
 */
public class EditarTexto extends TextBox implements CommandListener {
    private static final Command CMD_OK = new Command ("OK", Command.OK, 1);
    private static final Command CMD_CANCEL = new Command ("Cancel", Command.CANCEL, 1);
    private TablaItem tabla1;
    private Display display;
    private int mode = TextField.ANY;

    public EditarTexto (String text, TablaItem tabla1, Display display, int mode) {
        super ("Editar Valor", text, 50, mode);
        this.mode = mode;
        this.tabla1 = tabla1;
        this.display = display;
        addCommand(CMD_OK);
        addCommand(CMD_CANCEL);
        setCommandListener (this);
    }

    public void commandAction (Command c, Displayable d) {
        if (c == CMD_OK) {
            tabla1.setText(getString ());
            display.setCurrentItem(tabla1);
        }
        else if (c == CMD_CANCEL) {
            display.setCurrentItem(tabla1);
        }
    }
}
