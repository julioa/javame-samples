/*
 */
package com.cesine.ipm.contactospers;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.Vector;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreFullException;
import javax.microedition.rms.RecordStoreNotFoundException;
import javax.microedition.rms.RecordStoreNotOpenException;

/**
 * Clase responsable de gestionar la lista de contactos.
 * Todos los accesos tanto de lectura como de escritura a los
 * contactos se realizarán a través de ella.
 *
 * @author julioa
 */
public class ContactFactory {

    // Se implementa como un singleton
    private static ContactFactory instance = null;
    private static final String STORE_NAME = "ContactPers"; // Nombre del recordStore
    private Vector lista = new Vector(); // Vector que guarda la lista de contactos
    // Array para facilitar la inserción inicial de datos
    private String[][] inicio = {{"Julio", "Arrebola", "julioa@computer.org", "609448859"}};

    private ContactFactory() {
        // En el constructor vemos si existe el recordstore y si no es asi lo creamos
        // y le añadimos algunos contactos de ejemplo.

        boolean rellena = false;

        try {
            // Tambien lo podríamos haber implementado con
            // RecordStore.listRecordStores() y buscar el nombre del nuestro
            RecordStore rs = RecordStore.openRecordStore(STORE_NAME, false);
            rs.closeRecordStore();
        } catch (RecordStoreFullException ex) {
            ex.printStackTrace();
        } catch (RecordStoreNotFoundException ex) {
            //ex.printStackTrace();
            rellena = true;
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        }

        if (rellena == true) {
            for (int i = 0; i < inicio.length; i++) {
                Contacto nuevo = new Contacto(inicio[i][0], inicio[i][1], inicio[i][2], inicio[i][3]);
                append(nuevo);
            }
        } else {
            // Lee toda la lista
            try {
                RecordStore recStore = getStore();
                RecordEnumeration re = recStore.enumerateRecords(null, null, true);
                int numRecords = recStore.getNumRecords();
                while (re.hasNextElement()) {
                    byte[] bytes = re.nextRecord();
                    Contacto contacto = new Contacto(bytes);
                    lista.addElement(contacto);
                }
            } catch (RecordStoreException rse) {
                System.out.println(rse);
                rse.printStackTrace();
            }
        }
    }

    /**
     *
     * Con este método y el atributo estático instance implementamos
     * el singleton
     *
     * @return instancia unica
     */
    public static ContactFactory getInstance() {
        if (instance == null) {
            instance = new ContactFactory();
        }

        return instance;
    }

    /**
     * Cierra la lista de contactos
     */
    public void close() {
        // En esta implementacion no es necesario hacer nada
    }

    private RecordStore getStore() {
        // Centralizamos en este metodo el acceso al recordstore.
        // Si decidiesemos cambiar la implementacion y dejarlo abierto
        // durante la ejecucion del programa solo habria que cambiar aqui
        RecordStore rs = null;
        try {
            rs = RecordStore.openRecordStore(STORE_NAME, true);
        } catch (RecordStoreFullException ex) {
            ex.printStackTrace();
        } catch (RecordStoreNotFoundException ex) {
            ex.printStackTrace();
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        }
        return rs;
    }

    private void disposeStore(RecordStore store) {
        // Cierra el recordstore en caso de que queramos hacerlo
        // por cada acceso (ver getStore)
        if (store == null) {
            return;
        } else {
            try {
                store.closeRecordStore();
            } catch (RecordStoreNotOpenException ex) {
                ex.printStackTrace();
            } catch (RecordStoreException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     *
     * @return lista de contactos
     */
    public Vector getList() {
        return lista;
    }

    /**
     *
     * Añada un contacto a la lista y lo guarda en persistencia
     *
     * @param contacto
     */
    public void append(Contacto contacto) {
        lista.addElement(contacto);

        byte[] bytes = contacto.getBytes();

        RecordStore recStore = getStore();
        try {
            int recId = recStore.addRecord(bytes, 0, bytes.length);
            contacto.setId(recId);
        } catch (RecordStoreException rse) {
            System.out.println(rse);
            rse.printStackTrace();
        }

        this.disposeStore(recStore);

    }

    /**
     * Devulve el contacto con indice index de la lista
     * @param index
     * @return contacto en el indice index
     */
    public Contacto getItem(int index) {
        return (Contacto) lista.elementAt(index);
    }

    /**
     * Borra un contacto de la lista y de la persistencia
     * @param index
     */
    public void delete(int index) {
        RecordStore recStore = getStore();
        try {
            Contacto contacto = (Contacto) lista.elementAt(index);
            recStore.deleteRecord(contacto.getId());
        } catch (RecordStoreException rse) {
            System.out.println(rse);
            rse.printStackTrace();
        }
        lista.removeElementAt(index);
    }

    /**
     * Actualiza en la lista y persistencia en contacto indicado
     *
     * @param contacto
     * @param index
     */
    public void update(Contacto contacto, int index) {
        RecordStore recStore = getStore();
        try {
            byte[] bytes = contacto.getBytes();
            recStore.setRecord(index, bytes, 0, bytes.length);
        } catch (RecordStoreException rse) {
            System.out.println(rse);
            rse.printStackTrace();
        }

        lista.setElementAt(contacto, index);
    }
}
