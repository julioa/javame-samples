
package com.cesine.ipm.cabarceno.cristina;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.*;

public class MidletCristina extends MIDlet {
    public void startApp() {
        Menu mimenu=new Menu();
        Dispacher.getSingletonObject().setMidlet(this);
        Display.getDisplay(this).setCurrent(mimenu);
      
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
}
