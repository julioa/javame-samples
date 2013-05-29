/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cesine.ipm.cabarceno.fbedia;

import javax.microedition.lcdui.*;

/**
 *
 * @author profesor
 */
public class Menu extends List implements CommandListener{
    String[] miMenu = {"Opcion1", "Opcion2", "Opcion2"};

    public Menu() {
        super("Titulo",Choice.IMPLICIT);
        for (int i=0; i< miMenu.length; i++) {
            this.append(miMenu[i], null);
        }
    setCommandListener(this);
    }

   

    public void commandAction(Command c, Displayable d) {
        int opcion = getSelectedIndex();
//        if (opcion == 0) {
//            miDispacher.accedeMenu("opcion1");
//        }
//        if (opcion == 1) {
//            miDispacher.accedeMenu("opcion1");
//        }
//        if (opcion == 2) {
//            miDispacher.accedeMenu("opcion2");
//        }
    }
    
    
    
    
    

}
