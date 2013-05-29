/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.golfsine.module;

import com.cesine.ipm.golfsine.data.Course;
import com.cesine.ipm.golfsine.data.Hole;
import java.util.Vector;
import javax.microedition.location.Coordinates;

/**
 *
 * @author julioa
 */
public class CourseManager {

    private static Vector courses = new Vector();

    static {

        Course auxCourse = null;
        Hole auxHole = null;

        auxCourse = new Course();
        auxCourse.setName("Test");
        auxCourse.setDirName("test1");
        auxHole = new Hole();
        auxHole.setImageName("hoyo1test.jpg");
        auxHole.setName("Hole 1");
        auxHole.setPoint1(new Coordinates(43.472752d, -3.792750d, 0.0f));
        auxHole.setPoint2(new Coordinates(43.472782d, -3.791459d, 0.0f));
        auxHole.setPoint3(new Coordinates(43.471153d, -3.792565d, 0.0f));
        auxHole.setPoint4(new Coordinates(43.471249d, -3.791305d, 0.0f));
        auxHole.setPin(new Coordinates(43.472621d, -3.792283d, 0.0f));
        auxHole.setPar(3);
        auxCourse.addHole(auxHole);

        auxHole = new Hole();
        auxHole.setImageName("hoyo1test.jpg");
        auxHole.setName("Hole 2");
        auxHole.setPoint1(new Coordinates(43.472752d, -3.792750d, 0.0f));
        auxHole.setPoint2(new Coordinates(43.472782d, -3.791459d, 0.0f));
        auxHole.setPoint3(new Coordinates(43.471153d, -3.792565d, 0.0f));
        auxHole.setPoint4(new Coordinates(43.471249d, -3.791305d, 0.0f));
        auxHole.setPin(new Coordinates(43.472621d, -3.792283d, 0.0f));
        auxHole.setPar(3);
        auxCourse.addHole(auxHole);

        courses.addElement(auxCourse);


//H1 TL,-3.791221899507959,43.48492703475424
//H1 BR,-3.787701853753733,43.48424950469971
//H1,-3.787961080122836,43.48452736681825
//H2 TL,-3.78797303309977,43.48470133286806
//H2 BR,-3.785711591238568,43.48422785888408
//H2,-3.786105045570247,43.48455983579503
//H3 TL,-3.785118350448387,43.4849407885474
//H3 BR,-3.781306484433518,43.48381972159039
//H3,-3.781893200966791,43.48471748679125
//H4 TL,-3.782356926344306,43.48565291805352
//H4 BR,-3.781334511074681,43.48466775393243
//H4,-3.781950808312902,43.48546689880767
//H5 TL,-3.78779174910622,43.4859532534635
//H5 BR,-3.781759663977354,43.4848059091919
//H5,-3.787116776562005,43.48505243429302
//H6 TL,-3.78736972357621,43.48580379648446
//H6 BR,-3.781857141338831,43.48466671861235
//H6,-3.782249474891155,43.48536966828455
//H7 TL,-3.786033850207066,43.48512931134503
//H7 BR,-3.781711345088123,43.48435170351264
//H7,-3.785611191499037,43.48462520526849
//H8 TL,-3.789482440828458,43.48520281861429
//H8 BR,-3.78566542218431,43.48446404185537
//H8,-3.789279323979649,43.48496447433411
//H9 TL,-3.789740482142403,43.48609169796061
//H9 BR,-3.788688516467432,43.48470062815485
//H9,-3.789318158753066,43.48589950699279

        double[][] coordMat = {
            {-3.791221899507959, 43.48492703475424},
            {-3.787701853753733, 43.48424950469971},
            {-3.787961080122836, 43.48452736681825},
            {-3.78797303309977, 43.48470133286806},
            {-3.785711591238568, 43.48422785888408},
            {-3.786105045570247, 43.48455983579503},
            {-3.785118350448387, 43.4849407885474},
            {-3.781306484433518, 43.48381972159039},
            {-3.781893200966791, 43.48471748679125},
            {-3.782356926344306, 43.48565291805352},
            {-3.781334511074681, 43.48466775393243},
            {-3.781950808312902, 43.48546689880767},
            {-3.78779174910622, 43.4859532534635},
            {-3.781759663977354, 43.4848059091919},
            {-3.787116776562005, 43.48505243429302},
            {-3.78736972357621, 43.48580379648446},
            {-3.781857141338831, 43.48466671861235},
            {-3.782249474891155, 43.48536966828455},
            {-3.786033850207066, 43.48512931134503},
            {-3.781711345088123, 43.48435170351264},
            {-3.785611191499037, 43.48462520526849},
            {-3.789482440828458, 43.48520281861429},
            {-3.78566542218431, 43.48446404185537},
            {-3.789279323979649, 43.48496447433411},
            {-3.789740482142403, 43.48609169796061},
            {-3.788688516467432, 43.48470062815485},
            {-3.789318158753066, 43.48589950699279}};

        int[] pares = {4, 3, 4, 3, 5, 4, 4, 4, 3};

        auxCourse = new Course();
        auxCourse.setName("Mataleñas 9");
        auxCourse.setDirName("matalenas");

        for (int i = 0; i < coordMat.length / 3; i++) {
            auxHole = new Hole();
            auxHole.setImageName("h" + (i + 1) + ".jpg");
            auxHole.setName("Hole " + (i + 1));
            auxHole.setPoint1(new Coordinates(coordMat[i * 3][1], coordMat[i * 3][0], 0.0f));
            auxHole.setPoint2(new Coordinates(coordMat[i * 3][1], coordMat[i * 3 + 1][0], 0.0f));
            auxHole.setPoint3(new Coordinates(coordMat[i * 3 + 1][1], coordMat[i * 3][0], 0.0f));
            auxHole.setPoint4(new Coordinates(coordMat[i * 3 + 1][1], coordMat[i * 3 + 1][0], 0.0f));
            auxHole.setPin(new Coordinates(coordMat[i * 3 + 2][1], coordMat[i * 3 + 2][0], 0.0f));
            auxHole.setPar(pares[i]);
            auxCourse.addHole(auxHole);
        }

        courses.addElement(auxCourse);

        auxCourse = new Course();
        auxCourse.setName("Mataleñas 18");
        auxCourse.setDirName("matalenas");

        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < coordMat.length / 3; i++) {
                auxHole = new Hole();
                auxHole.setImageName("h" + (i + 1) + ".jpg");
                auxHole.setName("Hole " + (i + 1));
                auxHole.setPoint1(new Coordinates(coordMat[i * 3][1], coordMat[i * 3][0], 0.0f));
                auxHole.setPoint2(new Coordinates(coordMat[i * 3][1], coordMat[i * 3 + 1][0], 0.0f));
                auxHole.setPoint3(new Coordinates(coordMat[i * 3 + 1][1], coordMat[i * 3][0], 0.0f));
                auxHole.setPoint4(new Coordinates(coordMat[i * 3 + 1][1], coordMat[i * 3 + 1][0], 0.0f));
                auxHole.setPin(new Coordinates(coordMat[i * 3 + 2][1], coordMat[i * 3 + 2][0], 0.0f));
                auxHole.setPar(pares[i]);
                auxCourse.addHole(auxHole);
            }
        }

        courses.addElement(auxCourse);

    }

    public static Vector getCourseList() {
        return courses;
    }

    public static Course getCourse(int pos) {
        return (Course) courses.elementAt(pos);
    }

    public static Course getCourse(String name) {
        if (name == null) {
            return null;
        }

        for (int i = 0; i < courses.size(); i++) {
            if (name.equals(((Course) courses.elementAt(i)).getName())) {
                return (Course) courses.elementAt(i);
            }
        }

        return null;

    }
}
