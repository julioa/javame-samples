/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ejemplos.tema4;

import java.io.*;
import javax.microedition.midlet.*;
import javax.microedition.rms.*;

/**
 * @author julioa
 */
public class RMSMidlet extends MIDlet {

    public void startApp() {
        try {
            RecordStore myStore = RecordStore.openRecordStore("myEjemlo", true);
            
            byte[] data;
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            
            DataOutputStream dos = new DataOutputStream(baos);
            try {
                dos.writeUTF("Hola");
                dos.writeInt(21);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
            data = baos.toByteArray();
            
            
            myStore.addRecord(data, 0, data.length);
            
            int numRecords = myStore.getNumRecords();
            System.out.println("Registros:"+numRecords);
            
            RecordEnumeration recEnum = myStore.enumerateRecords(null, null, true);
            
            
            data = null;
            while(recEnum.hasNextElement()) {
                int recId = recEnum.nextRecordId();
                
                data = myStore.getRecord(recId);
                
                ByteArrayInputStream bais = new ByteArrayInputStream(data);
                DataInputStream dis = new DataInputStream(bais);
                try {
                    String value = dis.readUTF();
                    int value2 = dis.readInt();
                    System.out.println(recId + "->" + value + "," + value2);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                
                
            }
              
            
            
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        }
        
        this.notifyDestroyed();
        
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
}
