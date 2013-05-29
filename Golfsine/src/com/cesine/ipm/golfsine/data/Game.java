/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.golfsine.data;

import com.cesine.ipm.golfsine.module.CourseManager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Vector;
import javax.microedition.location.Coordinates;

/**
 *
 * @author julioa
 */
public class Game {

    private String name = null;
    private String courseName = null;
    private String player2 = null;
    private String player3 = null;
    private String player4 = null;
    private Course course = null;
    private int initHole = 0;
    private long initTime = -1;
    private long endTime = -1;
    private Vector scores = new Vector();
    private int currentHoleNum = 0;
    private int recordId = -1; // Marca el recordId si ha sido sacado de rms
    private boolean readOnly = false;

    public String getCourseName() {
        return courseName;
    }

    public Score getCurrentScore() {
        return (Score) scores.elementAt(getCurrentHoleNum());
    }

    public void init() {
        setInitTime(System.currentTimeMillis());
        initHole();
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
        setCourse(CourseManager.getCourse(courseName));
        int nHoles = getCourse().getHoles().size();
        for (int i = 0; i < nHoles; i++) {
            Score auxScore = new Score();
            auxScore.setPar(getCourse().getHole(i).getPar());
            scores.addElement(auxScore);
        }
        setCurrentHoleNum(getInitHole());
    }

    public Score getScore(int pos) {
        return (Score) getScores().elementAt(pos);
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public long getEndTime() {
        if (endTime < 0) {
            return System.currentTimeMillis();
        } else {
            return endTime;
        }
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public Hole getCurrentHole() {
        return getCourse().getHole(getCurrentHoleNum());
    }

    public long getInitTime() {
        return initTime;
    }

    public void setInitTime(long initTime) {
        this.initTime = initTime;
    }

    public String getName() {
        if (name == null) {
            Calendar cal = Calendar.getInstance();
            name = courseName + "-" + cal.get(Calendar.YEAR) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.DAY_OF_MONTH) + " " + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE);
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vector getScores() {
        return scores;
    }

    public void setScores(Vector scores) {
        this.scores = scores;
    }

    public String getPlayer2() {
        return (player2 == null ? "" : player2);
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getPlayer3() {
        return (player3 == null ? "" : player3);
    }

    public void setPlayer3(String player3) {
        this.player3 = player3;
    }

    public String getPlayer4() {
        return (player4 == null ? "" : player4);
    }

    public void setPlayer4(String player4) {
        this.player4 = player4;
    }

    public int getInitHole() {
        return initHole;
    }

    public void setInitHole(int initHole) {
        this.initHole = initHole;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getCurrentHoleNum() {
        return currentHoleNum;
    }

    public void setCurrentHoleNum(int currentHole) {
        if (currentHole == -1) {
            this.currentHoleNum = 0;
        }
        if (getCourse() != null) {
            this.currentHoleNum = currentHole % getCourse().getHoles().size();
        } else {
            this.currentHoleNum = currentHole;
        }

        System.out.println("currHole:" + currentHole + "->" + currentHoleNum);
    }

    public void stroke(Coordinates currentPosition) {
                if (isReadOnly() == false) {
        getCurrentScore().stroke(currentPosition);
                }
    }

    public void endGame() {
        if (isReadOnly() == false) {
            getCurrentScore().end();
            setEndTime(System.currentTimeMillis());
        }
    }

    public void endHole() {
                if (isReadOnly() == false) {
        getCurrentScore().end();
                }
    }

    public void nextHole() {
        setCurrentHoleNum(getCurrentHoleNum() + 1);
    }

    public void initHole() {
                if (isReadOnly() == false) {
        getCurrentScore().init();
                }
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public void setFromBytes(byte[] bytes) {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        DataInputStream inputStream = new DataInputStream(bais);
        try {

            setName(inputStream.readUTF());
            courseName = (inputStream.readUTF());
            setCourse(CourseManager.getCourse(courseName));
            setPlayer2(inputStream.readUTF());
            setPlayer3(inputStream.readUTF());
            setPlayer4(inputStream.readUTF());

            setInitHole(inputStream.readInt());
            setCurrentHoleNum(inputStream.readInt());
            setCurrentHoleNum(getInitHole());

            setInitTime(inputStream.readLong());
            setEndTime(inputStream.readLong());

            int size = inputStream.readInt();
            for (int i = 0; i < size; i++) {
                Score aux = new Score();
                aux.setFromStream(inputStream);
                scores.addElement(aux);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public byte[] getBytes() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream outputStream = new DataOutputStream(baos);

        try {
            outputStream.writeUTF(getName());
            outputStream.writeUTF(getCourseName());
            outputStream.writeUTF(getPlayer2());
            outputStream.writeUTF(getPlayer3());
            outputStream.writeUTF(getPlayer4());

            outputStream.writeInt(getInitHole());
            outputStream.writeInt(getCurrentHoleNum());

            outputStream.writeLong(getInitTime());
            outputStream.writeLong(getEndTime());

            outputStream.writeInt(scores.size());
            for (int i = 0; i < scores.size(); i++) {
                byte[] aux = ((Score) scores.elementAt(i)).getBytes();
                outputStream.write(aux);
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
            ioe.printStackTrace();
        }
        byte[] bytes = baos.toByteArray();

        return bytes;
    }
}
