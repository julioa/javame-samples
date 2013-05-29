/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cesine.ipm.cabarceno.david;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.TextBox;

/**
 *
 * @author profesor
 */
public class Mensajes extends TextBox implements CommandListener{
Command exitCommand=null;
    public Mensajes(String title, String text, int maxSize, int constraints) {
        super(title, text, maxSize, constraints);

         exitCommand=new Command("atras", 1, 1);
        this.addCommand(exitCommand);
    }

    public void commandAction(Command c, Displayable d) {
        Dispacher miDispacher=Dispacher.getSingletonObject();
         if(this.exitCommand == c) {
         miDispacher.back();
      }
    }


 



}
