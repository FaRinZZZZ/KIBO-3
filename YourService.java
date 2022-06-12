package jp.jaxa.iss.kibo.rpc.I3_Comeback;

import jp.jaxa.iss.kibo.rpc.api.KiboRpcService;

import gov.nasa.arc.astrobee.Result;
import gov.nasa.arc.astrobee.types.Point;
import gov.nasa.arc.astrobee.types.Quaternion;

import org.opencv.core.Mat;

/**
 * Class meant to handle commands from the Ground Data System and execute them in Astrobee
 */

public class YourService extends KiboRpcService {
    @Override
    protected void runPlan1(){
        // the mission starts
        api.startMission();

        // move to a point
        Point point1 = new Point(10.71f, -7.75f, 4.48f);
        Quaternion quaternion1 = new Quaternion(0f, 0.707f, 0f, 0.707f);
        api.moveTo(point1, quaternion1, false);

        // report point1 arrival
        api.reportPoint1Arrival();

        // get a camera image
//        Mat image = api.getMatNavCam();

        // irradiate the laser
        api.laserControl(true);

        // take target1 snapshots
        api.takeTarget1Snapshot();

        // turn the laser off
        api.laserControl(false);

        Point point2 = new Point(10.71f, -7.75f, 5.3f);
        Quaternion quaternion2 = new Quaternion(0f, 0, -0.707f, 0.707f);
        api.moveTo(point2, quaternion2, false);

        Point point3 = new Point(10.71f, -9.9f, 5.3f);
        Quaternion quaternion3 = new Quaternion(0f, 0, -0.707f, 0.707f);
        api.moveTo(point3, quaternion3, false);

        Point point4 = new Point(11.27f, -9.9f, 5.3f);
        Quaternion quaternion4 = new Quaternion(0f, 0, -0.707f, 0.707f);
        api.moveTo(point4, quaternion4, false);

//        api.laserControl(true);

        /* ******************************************** */
        /* write your own code and repair the air leak! */
        /* ******************************************** */

        // send mission completion
//        api.reportMissionCompletion();
    }

    @Override
    protected void runPlan2(){
        // write here your plan 2
    }

    @Override
    protected void runPlan3(){
        // write here your plan 3
    }

    // You can add your method
    private void moveToWrapper(double pos_x, double pos_y, double pos_z,
                               double qua_x, double qua_y, double qua_z,
                               double qua_w){

        final Point point = new Point(pos_x, pos_y, pos_z);
        final Quaternion quaternion = new Quaternion((float)qua_x, (float)qua_y,
                                                     (float)qua_z, (float)qua_w);

        api.moveTo(point, quaternion, true);
    }

    private void relativeMoveToWrapper(double pos_x, double pos_y, double pos_z,
                               double qua_x, double qua_y, double qua_z,
                               double qua_w) {

        final Point point = new Point(pos_x, pos_y, pos_z);
        final Quaternion quaternion = new Quaternion((float) qua_x, (float) qua_y,
                (float) qua_z, (float) qua_w);

        api.relativeMoveTo(point, quaternion, true);
    }

}

