/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cesine.ipm.tema3.guitests;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

/**
 * @author julioa
 */
public class SampleCanvasMidlet extends MIDlet  implements CommandListener {



    public void startApp() {
       Status.listener = this;
       SampleCanvas canvas = new SampleCanvas();
       Display.getDisplay(this).setCurrent(canvas);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

   public void commandAction(Command command, Displayable displayable) {
        // write pre-action user code here
            if (command.getCommandType() == Command.EXIT) {
                // write pre-action user code here
                this.notifyDestroyed();
                // write post-action user code here
            }

        // write post-action user code here
    }
}
