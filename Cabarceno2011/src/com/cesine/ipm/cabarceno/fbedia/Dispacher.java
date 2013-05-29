/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cesine.ipm.cabarceno.fbedia;

/**
 *
 * @author profesor
 */


class Dispacher{

    private static Dispacher instance;

    private Dispacher() { }

    static Dispacher getInstance (){
        if (instance==null) {
            instance=new Dispacher();
        }
        return instance;
    }
}
