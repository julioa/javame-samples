/**
 * fecha 19/04/10
 * @author Pablo Rodríguez Fernández
 * Midlet de prueba de configuracion. Necesita de la clase Config
 */
package com.cesine.ipm.golfsine.module.config;

import com.cesine.ipm.golfsine.GolfController;
import javax.microedition.lcdui.*;

public class ConfigForm2 extends Form implements CommandListener {

    private Command backCommand = null;
    private Command okCommand = null;
    private Command otroCommand = null;
    TextField nombre = null;
    TextField handicap = null;
    ChoiceGroup[] palos = new ChoiceGroup[14];
    Config conf = null;
    String[] nombresDePalos = {"Ninguno", "Putter", "Driver","Madera 3", "Madera 5", "Madera 7", "Hibrido 3", "Hibrido 4","Hibrido 5","Hierro 3", "Hierro 4", "Hierro 5", "Hierro 6", "Hierro 7", "Hierro 8", "Hierro 9", "PW", "GW", "SW", "LW"};

    public ConfigForm2() {
        super("Configuracion");
        conf = ConfigManager.getConfig();
        if (conf == null) {
            conf = new Config();
        }
        nombre = new TextField("Usuario", null, 12, TextField.ANY);
        nombre.setLayout(TextField.LAYOUT_SHRINK);
        handicap = new TextField("Handicap", null, 5, TextField.DECIMAL);
        for (int i = 0; i < palos.length; i++) {
            palos[i] = new ChoiceGroup("Palo " + (i + 1), ChoiceGroup.POPUP, nombresDePalos, null);
        }

        mostrar();
    }

    public void commandAction(Command c, Displayable d) {
        if (c == backCommand) {
            volver();
        } else if (c == okCommand) {
            //System.out.println("guardando");
            conf.setNombre(nombre.getString());
            String hand = handicap.getString();
            float f = Float.valueOf(hand).floatValue();
            conf.setHandicap(f);
            for (int i = 0; i < palos.length; i++) {
                conf.setPalos(palos[i].getString(palos[i].getSelectedIndex()), i);
            }

            ConfigManager.saveConfig(conf);

        } else if (c == otroCommand) {
            GolfController.getInstance().goConfig2();
        }

    }

    protected void mostrar() {
            nombre.setString(conf.getNombre());
            String aux = Float.toString(conf.getHandicap());
            handicap.setString(aux);

            this.append(nombre);
            this.append(handicap);
            for (int i = 0; i < palos.length; i++) {
            palos[i].setSelectedIndex(seleccionChoiceGroup(conf, i), true);
            this.append(palos[i]);
            }

            backCommand = new Command("Volver", Command.BACK, 1);
            okCommand = new Command("Guardar", Command.OK, 1);
            otroCommand = new Command("Otro", Command.OK, 2);
            this.addCommand(backCommand);
            this.addCommand(okCommand);
            this.addCommand(otroCommand);
            this.setCommandListener((CommandListener) this);
  

    }

    protected int seleccionChoiceGroup(Config conf, int n) {
        int indice = 0;
        for (int i=0; i < nombresDePalos.length; i++) {
            if (conf.getPalos(n).equals(nombresDePalos[i])) {
                indice = i;
                break;
            }
        }
        return indice;
    }

    void volver() {
        GolfController.getInstance().goMain(false);
    }
}
