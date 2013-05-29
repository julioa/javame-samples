/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.golfsine.module;

import com.cesine.ipm.golfsine.data.Game;
import java.util.Vector;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;

/**
 *
 * @author julioa
 */
public class HistoryManager {

    private static HistoryManager instance = null;
    private static String RECORDSTORE = "Rounds";

    private HistoryManager() {
    }

    static public HistoryManager getInstance() {
        if (instance == null) {
            instance = new HistoryManager();
        }

        return instance;
    }

//    public Vector getHistoryList() {
//        Vector result = new Vector();
//
//        Game aux = null;
//
//        aux=new Game();
//        aux.setName("Partida 1/1/2010");
//        aux.setCourseName("Test 1");
//        result.addElement(aux);
//
//        aux=new Game();
//        aux.setName("Partida 2/2/2010");
//        aux.setCourseName("Test 1");
//        result.addElement(aux);
//
//        aux=new Game();
//        aux.setName("Partida 3/3/2010");
//        aux.setCourseName("Test 1");
//        result.addElement(aux);
//
//        return result;
//    }
    public void saveGame(Game game) {
        try {
            RecordStore recStore = RecordStore.openRecordStore(RECORDSTORE, true);
            byte[] bytes = game.getBytes();
            recStore.addRecord(bytes, 0, bytes.length);
            recStore.closeRecordStore();
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        }
    }

    public Vector getHistoryList() {
        Vector result = new Vector();

        Game aux = null;

        try {
            RecordStore recStore = RecordStore.openRecordStore(RECORDSTORE, true);
            RecordEnumeration enumeration = recStore.enumerateRecords(null, null, true);
            while (enumeration.hasNextElement()) {
                int recId = enumeration.nextRecordId();
                byte[] bytes = recStore.getRecord(recId);
                Game game = new Game();
                game.setFromBytes(bytes);
                game.setRecordId(recId);
                result.addElement(game);
            }
            recStore.closeRecordStore();
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    public void removeGame(Game game) {
        if (game==null || game.getRecordId() < 0) {
            return;
        }

        try {
            RecordStore recStore = RecordStore.openRecordStore(RECORDSTORE, true);
            recStore.deleteRecord(game.getRecordId());
            recStore.closeRecordStore();
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        }
    }
}
