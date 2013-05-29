/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.demo.uisimple;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import javax.microedition.midlet.*;
import javax.microedition.rms.*;

/**
 * @author julioa
 */
public class RecordMidlet extends MIDlet {
    
    

    public void startApp() {
        try {
            RecordStore myStore = RecordStore.openRecordStore("myTest", true);
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            
            dos.writeUTF("hola");
            
            byte[] salida = baos.toByteArray();

            myStore.addRecord(salida, 0, salida.length);
            
            RecordEnumeration enumerator = myStore.enumerateRecords(null, null, true);
            while (enumerator.hasNextElement()) {
                System.out.println(enumerator.nextRecordId());
            }
            
            this.notifyDestroyed();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        
        
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
}
