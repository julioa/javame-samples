/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.golfsine.form;

import com.sun.lwuit.Form;
import com.sun.lwuit.Image;
import com.sun.lwuit.animations.CommonTransitions;
import com.sun.lwuit.plaf.Style;
import java.io.IOException;

/**
 *
 * @author julioa
 */
public class Splash extends Form {

    public Splash() {
        Image bgImage = null;
        try {
            bgImage = Image.createImage("/res/img/cesine.png");
            Style style = this.getStyle();
            style.setBgImage(bgImage);
            style.setBackgroundAlignment(Style.BACKGROUND_IMAGE_ALIGN_CENTER);
            //style.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_HORIZONTAL);
            this.setTransitionInAnimator(CommonTransitions.createFade(10000));
            this.setTransitionOutAnimator(CommonTransitions.createFade(10000));

            this.setScrollable(false);
            this.refreshTheme();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
