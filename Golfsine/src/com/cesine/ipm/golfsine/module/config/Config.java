/*
 * Estructura de Datos de la Configuracion
 * de la aplicación.
 */
package com.cesine.ipm.golfsine.module.config;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Config {

    private String nombre = null;
    private float handicap = 36f;
    private String[] palos = new String[14];

    public void setConfig(byte[] bytes) {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        DataInputStream inputStream = new DataInputStream(bais);
        try {
            String aux = null;
            float auxhand = 0f;

            aux = inputStream.readUTF();
            setNombre(aux);

            auxhand = inputStream.readFloat();
            setHandicap(auxhand);

            for (int i = 0; i < 14; i++) {
                aux = inputStream.readUTF();
                setPalos(aux, i);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Config() {
        nombre = "";
        handicap = 0f;
        for (int i = 0; i < palos.length; i++) {
            palos[i] = "Ninguno";
        }
    }

    public Config(String nom, float hand) {
        nombre = nom;
        handicap = hand;
        for (int i = 0; i < 14; i++) {
            palos[i] = "Ninguno";
        }
    }

    public float getHandicap() {
        return handicap;
    }

    public void setHandicap(float handicap) {
        this.handicap = handicap;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String[] getPalos() {
        return palos;
    }

    public String getPalos(int i) {
        return palos[i];
    }

    public void setPalos(String[] palos) {
        this.palos = palos;
    }

    public void setPalos(String pal, int n) {
        this.palos[n] = pal;
    }

    public byte[] getBytes() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream outputStream = new DataOutputStream(baos);
        int i = 0;
        try {
            outputStream.writeUTF(getNombre());
            outputStream.writeFloat(getHandicap());
            for (i = 0; i < palos.length; i++) {
                outputStream.writeUTF(getPalos(i));
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
            ioe.printStackTrace();
        }
        byte[] bytes = baos.toByteArray();
        return bytes;
    }
}
