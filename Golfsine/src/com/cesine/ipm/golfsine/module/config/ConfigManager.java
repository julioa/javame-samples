/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.golfsine.module.config;

import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreFullException;
import javax.microedition.rms.RecordStoreNotFoundException;

/**
 *
 * @author julioa
 */
public class ConfigManager {

    private static Config config = null;

    public static void saveConfig(Config conf) {

        ConfigManager.config = conf;

        try {
            RecordStore recStore = RecordStore.openRecordStore("Config", false);
            recStore.setRecord(1, conf.getBytes(), 0, conf.getBytes().length);
            recStore.closeRecordStore();
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        }
    }

    public static Config getConfig() {

        if (ConfigManager.config == null) {
            Config conf = new Config();

            try {
                RecordStore recStore = RecordStore.openRecordStore("Config", true);
                if (recStore.getNumRecords() == 0) {
                    recStore.addRecord(conf.getBytes(), 0, conf.getBytes().length);
                }
                conf.setConfig(recStore.getRecord(1));
                recStore.closeRecordStore();
            } catch (RecordStoreException ex) {
                ex.printStackTrace();
            }

            ConfigManager.config = conf;

        }

        return ConfigManager.config;

    }
}
