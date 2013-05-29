/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cesine.ipm.cabarceno.david;

//import com.cesine.ipm.cabarceno.CabarMidlet;
import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;

/**
 *
 * @author profesor
 */
public class Menu extends List  implements CommandListener{

    public Menu() {
        super("titulo1", Choice.IMPLICIT);
        this.append("Mensajes", null);
        this.append("Directorio", null);
        this.append("Juegos", null);
        setCommandListener(this);
       
    }

    public void commandAction(Command c, Displayable d) {
        Dispacher miDispacher=Dispacher.getSingletonObject();
       if(List.SELECT_COMMAND == c){
       
           int option = this.getSelectedIndex();

           if(option==0){

             miDispacher.accedePrincipal("Mensajes");
           }
           if(option==1){
            miDispacher.accedePrincipal("Juegos");
           }
           if(option==2){
            miDispacher.accedePrincipal("Directorio");
           }

       }
     
    }

}
