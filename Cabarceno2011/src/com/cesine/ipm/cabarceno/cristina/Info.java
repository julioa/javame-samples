package com.cesine.ipm.cabarceno.cristina;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.TextBox;

public class Info extends TextBox implements CommandListener{
Command exitCommand=null;
    public Info(String title, String text, int maxSize, int constraints) {
        super(title, text, maxSize, constraints);
         exitCommand=new Command("Atrás", 1, 1);
        this.addCommand(exitCommand);
    }
    public void commandAction(Command c, Displayable d) {
        Dispacher miDispacher=Dispacher.getSingletonObject();
         if(this.exitCommand == c) {
         miDispacher.back();
      }
    }
}
