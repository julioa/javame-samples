/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.*;

/**
 * @author julioa
 */
public class GraphicMidlet extends MIDlet {

    public void startApp() {
        Displayable canvas = new GraphicCanvas();
        Display.getDisplay(this).setCurrent(canvas);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
}
