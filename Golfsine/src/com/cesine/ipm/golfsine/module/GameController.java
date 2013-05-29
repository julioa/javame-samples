/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.golfsine.module;

import com.cesine.ipm.golfsine.GolfController;
import com.cesine.ipm.golfsine.data.Course;
import com.cesine.ipm.golfsine.data.Game;
import com.cesine.ipm.golfsine.data.Hole;
import com.cesine.ipm.golfsine.form.map.PlayCanvas;
import java.util.Vector;
import javax.microedition.location.Coordinates;
import javax.microedition.location.Criteria;
import javax.microedition.location.Location;
import javax.microedition.location.LocationException;
import javax.microedition.location.LocationListener;
import javax.microedition.location.LocationProvider;
import javax.microedition.location.QualifiedCoordinates;

/**
 *
 * @author julioa
 */
public class GameController implements LocationListener {

    private Course course = null;
    private Vector listeners = new Vector();
    private Vector path = new Vector();
    private String gpsStat = "Gps ?";
    private QualifiedCoordinates currentPosition = null;
    private Coordinates lastShot = null;
    private float andado = 0;
    private int auxCont = 0;
    private LocationProvider lp = null;
    private Game game = null;
    private int accuracy = -1;
    private static int GPS_UPDATE = 15; // Informacion de gps cada x segundos
    private boolean readOnly = false;
    private PlayCanvas playCanvas = null;

    public GameController(Game game, boolean readOnly) {

        setReadOnly(readOnly);

        setGame(game);
        game.setReadOnly(isReadOnly());

        course = game.getCourse();
        game.init();

        playCanvas = new PlayCanvas(this, isReadOnly());
        if (isReadOnly() == false) {
            startGps();
        }

        // Ponemos ejemplos
//        QualifiedCoordinates aux = null;
//
//        aux = new QualifiedCoordinates(43.4716481228612, -3.79163122556919, 0.0f, 0.0f, 0.0f);
//        this.updateMetrics(aux);
//
//        aux = new QualifiedCoordinates(43.47178240740975, -3.791653771646382, 0.0f, 0.0f, 0.0f);
//        this.updateMetrics(aux);
//
//        aux = new QualifiedCoordinates(43.47178922508903, -3.791926880514553, 0.0f, 0.0f, 0.0f);
//        this.updateMetrics(aux);
//        updateGolpe();
//
//        aux = new QualifiedCoordinates(43.47187745985543, -3.791945797770921, 0.0f, 0.0f, 0.0f);
//        this.updateMetrics(aux);
//
//        aux = new QualifiedCoordinates(43.47183390611386, -3.792276011664986, 0.0f, 0.0f, 0.0f);
//        this.updateMetrics(aux);
//
//        aux = new QualifiedCoordinates(43.47206491238463, -3.792064015838676, 0.0f, 0.0f, 0.0f);
//        this.updateMetrics(aux);
//        updateGolpe();
//
//        aux = new QualifiedCoordinates(43.47222250047491, -3.792213482631338, 0.0f, 0.0f, 0.0f);
//        this.updateMetrics(aux);
//
//        aux = new QualifiedCoordinates(43.472322471349811, -3.792145106103292, 0.0f, 0.0f, 0.0f);
//        this.updateMetrics(aux);
//
//        aux = new QualifiedCoordinates(43.47236786537898, -3.792266751567865, 0.0f, 0.0f, 0.0f);
//        this.updateMetrics(aux);
//        updateGolpe();
//
//        aux = new QualifiedCoordinates(43.47244513860386, -3.792170727757866, 0.0f, 0.0f, 0.0f);
//        this.updateMetrics(aux);
    }

    public Course getCourse() {
        return course;
    }

    public Hole getHole() {
        return game.getCurrentHole();
    }

    public void addListener(IGameListener listener) {
        listeners.addElement(listener);
    }

    public void notifyListeners() {
        for (int i = 0; i < listeners.size(); i++) {
            ((IGameListener) listeners.elementAt(i)).gameNotification();
        }
    }

    public void startGps() {
        try {
            if (System.getProperty("microedition.location.version") != null) {

                Criteria cr = null; //new Criteria();
                //cr.setHorizontalAccuracy(10);
                //cr.setVerticalAccuracy(10);
                if (lp != null) {
                    lp.reset();
                }
                lp = LocationProvider.getInstance(cr);
                if (lp != null) {
                    lp.setLocationListener(this, GPS_UPDATE, -1, -1);
                    int state = lp.getState();
                    this.providerStateChanged(lp, state);
                    //gpsStat = "Gps OK";
                } else {
                    gpsStat = "Gps ERROR";
                }
            } else {
                gpsStat = "No Gps";
            }

        } catch (LocationException ex) {
            //TODO poner algo para que si no se
            // obtiene el provider lo vuelva a intentar.
            ex.printStackTrace();
            gpsStat = "Gps Loc.Excep.";
        } catch (Exception ex) {
            //TODO poner algo para que si no se
            // obtiene el provider lo vuelva a intentar.
            ex.printStackTrace();
            gpsStat = "Gps Except.";
        }
    }

    public void locationUpdated(LocationProvider lp, Location lctn) {
        if (isReadOnly() == false) {
            if (lctn.isValid()) {
                QualifiedCoordinates coord = lctn.getQualifiedCoordinates();
                if (coord.getLatitude() != 0.0d && coord.getLongitude() != 0.0d) {
                    updateMetrics(coord);
                    System.out.println("GPS:" + coord.convert(coord.getLatitude(), Coordinates.DD_MM_SS) + "/" + coord.convert(coord.getLongitude(), Coordinates.DD_MM_SS));
                    //notifyListeners();
                }
            }
            int state = lp.getState();
            this.providerStateChanged(lp, state);
        }
    }

    private void updateMetrics(QualifiedCoordinates coord) {
        if (coord == null) {
            return;
        }

        if (currentPosition != null) {
            float auxDistance = currentPosition.distance(coord);
            andado += auxDistance;
        }
        path.addElement(coord);
        currentPosition = coord;

        accuracy = (int) ((coord.getHorizontalAccuracy() + coord.getVerticalAccuracy()) / 2);
    }

    private void updateGolpe() {

        if (isReadOnly() == false) {

            if (currentPosition != null) {
                setLastShot(currentPosition);
            }

            game.stroke(currentPosition);
        }
        notifyListeners();
    }

    public void providerStateChanged(LocationProvider lp, int newState) {

        auxCont++;

        if (newState == LocationProvider.AVAILABLE) {
            gpsStat = "Gps OK";
        } else if (newState == LocationProvider.OUT_OF_SERVICE) {
            gpsStat = "Gps Out";
        } else if (newState == LocationProvider.TEMPORARILY_UNAVAILABLE) {
            gpsStat = "Gps Temp.Out";
        } else {
            gpsStat = "Gps " + newState;
        }

        gpsStat = gpsStat + "-" + auxCont;

        System.out.println("GPS-STAT:" + gpsStat);
        notifyListeners();
    }

    public String getGpsStat() {
        return gpsStat;
    }

    public void setGpsStat(String gpsStat) {
        this.gpsStat = gpsStat;
    }

    public Coordinates getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(QualifiedCoordinates currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void viewCard() {
        GolfController.getInstance().viewCard(null, isReadOnly());
        notifyListeners();
    }

    public void nexHole() {
        path = new Vector();

        if (isReadOnly() == false) {
            game.endHole();
            game.nextHole();
            game.initHole();
            GolfController.getInstance().keepPlaying();
        } else {
            game.nextHole();
            GolfController.getInstance().keepPlaying();
        }

    }

    public void endGame() {
        if (isReadOnly() == false ) {
        GolfController.getInstance().endGame();
        } else {
            GolfController.getInstance().goMain(false);
        }
    }

    public void finishGame() {
        if (lp != null) {
            lp.reset();
        }

        game.endHole();
    }

    public void golpe() {
        updateGolpe();
    }

    public float getAndado() {
        return andado;
    }

    public void setAndado(float andado) {
        this.andado = andado;
    }

    public Vector getPath() {
        return path;
    }

    public void setPath(Vector path) {
        this.path = path;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Coordinates getLastShot() {
        return lastShot;
    }

    public void setLastShot(Coordinates lastShot) {
        this.lastShot = lastShot;
    }

    public Vector getGolpes() {
        return game.getCurrentScore().getShots();
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public String getTimeTotal() {
        long aux = getGame().getEndTime();
        long init = getGame().getInitTime();
        int horas = (int) ((aux - init) / (1000f * 3600f));
        int min = (int) (((aux - init - (horas * 1000f * 3600f))) / ((1000f * 60f)));
        return horas + ":" + min;
    }

    public String getTimeHole() {
        long aux = System.currentTimeMillis();
        long init = getGame().getCurrentScore().getInitTime();
        int horas = (int) ((aux - init) / (1000f * 3600f));
        int min = (int) (((aux - init - (horas * 1000f * 3600f))) / ((1000f * 60f)));
        return horas + ":" + min;
    }

    public float getDistance2Pin() {
        if (getCurrentPosition() != null) {
            return getHole().getPin().distance(getCurrentPosition());
        } else {
            return -1f;
        }
    }

    public float getDistanceShot() {
        if (getLastShot() != null && getCurrentPosition() != null) {
            return getLastShot().distance(getCurrentPosition());
        } else {
            return -1f;
        }
    }

    public PlayCanvas getPlayCanvas() {
        return playCanvas;
    }

    public void setPlayCanvas(PlayCanvas playCanvas) {
        this.playCanvas = playCanvas;
    }
}
