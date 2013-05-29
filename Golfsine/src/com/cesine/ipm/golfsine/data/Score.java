/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.golfsine.data;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Vector;
import javax.microedition.location.Coordinates;

/**
 *
 * @author julioa
 */
public class Score {

    private int hole = -1;
    private int longs = -1;
    private int putts = -1;
    private int shorts = -1;
    private int penalties = -1;
    private int total = -1;
    private int player2 = -1;
    private int player3 = -1;
    private int player4 = -1;
    private long initTime = -1;
    private long endTime = -1;
    private Vector shots = new Vector();
    private int par = -1;

    public Vector getShots() {
        return shots;
    }

    public void setShots(Vector shots) {
        this.shots = shots;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public int getHole() {
        return hole;
    }

    public void setHole(int hole) {
        this.hole = hole;
    }

    public long getInitTime() {
        return initTime;
    }

    public void setInitTime(long initTime) {
        this.initTime = initTime;
    }

    public int getLongs() {
        return longs;
    }

    public void setLongs(int longs) {
        this.longs = longs;
        updateTotal();
    }

    public int getPlayer2() {
        return player2;
    }

    public void setPlayer2(int player2) {
        this.player2 = player2;
    }

    public int getPlayer3() {
        return player3;
    }

    public void setPlayer3(int player3) {
        this.player3 = player3;
    }

    public int getPlayer4() {
        return player4;
    }

    public void setPlayer4(int player4) {
        this.player4 = player4;
    }

    public int getPutts() {
        return putts;
    }

    public void setPutts(int putts) {
        this.putts = putts;
        updateTotal();
    }

    public int getShorts() {
        return shorts;
    }

    public void setShorts(int shorts) {
        this.shorts = shorts;
        updateTotal();
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPenalties() {
        return penalties;
    }

    public void setPenalties(int penalties) {
        this.penalties = penalties;
        updateTotal();
    }

    public int getPar() {
        return par;
    }

    public void setPar(int par) {
        this.par = par;
    }

    public void stroke(Coordinates currentPosition) {
        if (currentPosition != null) {
            getShots().addElement(currentPosition);
        }
        setLongs(getLongs() + 1);
    }

    public void init() {
        this.setInitTime(System.currentTimeMillis());
        setLongs(0);
        setShorts(0);
        setPutts(0);
        setPenalties(0);
        setTotal(0);
        setPlayer2(0);
        setPlayer3(0);
        setPlayer4(0);
    }

    public void end() {
        this.setEndTime(System.currentTimeMillis());
    }

    void updateTotal() {
        setTotal(
                ((getLongs() < 0) ? 0 : getLongs())
                + ((getShorts() < 0) ? 0 : getShorts())
                + ((getPutts() < 0) ? 0 : getPutts())
                + ((getPenalties()) < 0 ? 0 : getPenalties()));
    }

    public void setFromBytes(byte[] bytes) {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        DataInputStream inputStream = new DataInputStream(bais);
        setFromStream(inputStream);
    }


    public void setFromStream(DataInputStream inputStream) {
        try {

            hole=inputStream.readInt();
            longs=inputStream.readInt();
            putts=inputStream.readInt();
            shorts=inputStream.readInt();
            penalties=inputStream.readInt();
            total=inputStream.readInt();
            player2=inputStream.readInt();
            player3=inputStream.readInt();
            player4=inputStream.readInt();
            par=inputStream.readInt();

            initTime=inputStream.readLong();
            endTime=inputStream.readLong();


            int size = inputStream.readInt();
            for (int i = 0; i < size; i++) {
                double latitud = inputStream.readDouble();
                double longitud = inputStream.readDouble();
                Coordinates auxCoord = new Coordinates(latitud, longitud, 0f);
                shots.addElement(auxCoord);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public byte[] getBytes() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream outputStream = new DataOutputStream(baos);

        try {
            outputStream.writeInt(hole);
            outputStream.writeInt(longs);
            outputStream.writeInt(putts);
            outputStream.writeInt(shorts);
            outputStream.writeInt(penalties);
            outputStream.writeInt(total);
            outputStream.writeInt(player2);
            outputStream.writeInt(player3);
            outputStream.writeInt(player4);
            outputStream.writeInt(par);

            outputStream.writeLong(initTime);
            outputStream.writeLong(endTime);

            outputStream.writeInt(shots.size());
            for (int i = 0; i < shots.size(); i++) {
                Coordinates auxCoord = (Coordinates) shots.elementAt(i);
                outputStream.writeDouble(auxCoord.getLatitude());
                outputStream.writeDouble(auxCoord.getLongitude());
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
            ioe.printStackTrace();
        }
        byte[] bytes = baos.toByteArray();

        return bytes;
    }
}
