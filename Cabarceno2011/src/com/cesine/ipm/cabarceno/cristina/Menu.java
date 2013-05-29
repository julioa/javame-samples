package com.cesine.ipm.cabarceno.cristina;

import com.cesine.ipm.cabarceno.cristina.MidletCristina;
import java.io.IOException;
import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.StringItem;

public class Menu extends Form implements CommandListener {

    private Command SEL_COMM = null;
    ChoiceGroup opciones = null;

    public Menu() {
        super("Menu Principal");
        try {
            SEL_COMM = new Command("seleccion", Command.ITEM, 1);
            Image logo;
            logo = Image.createImage("/com/cesine/ipm/cabarceno/cristina/image/cabarcenologo.JPG");
            append(new ImageItem("Cabarceno", logo, Item.LAYOUT_DEFAULT, "Logo de Cabarceno"));

            opciones = new ChoiceGroup("Menu", ChoiceGroup.EXCLUSIVE);
            opciones.append("Información General", null);
            opciones.append("Visita", null);
            opciones.append("Créditos", null);
            opciones.append("Salir", null);
            this.addCommand(SEL_COMM);
            append(opciones);

            setCommandListener(this);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void commandAction(Command c, Displayable d) {
        System.out.println("commandAction");

        Dispacher miDispacher = Dispacher.getSingletonObject();

        if (this.SEL_COMM == c) {

            int option = opciones.getSelectedIndex();

            if (option == 0) {
                miDispacher.accedePrincipal("Información General");
            }
            if (option == 1) {
                miDispacher.accedePrincipal("Visita");
            }
            if (option == 2) {
                miDispacher.accedePrincipal("Créditos");
            }
            if (option == 3) {
                miDispacher.accedePrincipal("Salir");
            }
        }
    }
}
