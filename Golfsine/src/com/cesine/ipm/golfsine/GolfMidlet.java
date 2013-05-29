/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.golfsine;

import com.cesine.ipm.golfsine.form.MainForm;
import com.cesine.ipm.golfsine.form.Splash;
import javax.microedition.midlet.*;

import com.sun.lwuit.*;
import com.sun.lwuit.animations.CommonTransitions;
import com.sun.lwuit.events.*;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.plaf.UIManager;
import com.sun.lwuit.util.Resources;

/**
 * @author julioa
 */
public class GolfMidlet extends MIDlet implements ActionListener {

    public void startApp() {

        GolfController.getInstance().setMidlet(this);

        Display.init(this);
// Setting the application theme is discussed
// later in the theme chapter and the resources chapter
        try {
            Resources r = Resources.open("/res/LWUITtheme.res");
            UIManager.getInstance().setThemeProps(r.getTheme(
                    r.getThemeResourceNames()[0]));
        } catch (java.io.IOException e) {
        }

        Splash sp = new Splash();

        sp.show();


        GolfController.getInstance().goMain(true);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void actionPerformed(ActionEvent evt) {
    }
}
