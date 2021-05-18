package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;


public class donkeybot {

    public DcMotor frontLeft;
    public DcMotor rearLeft;
    public DcMotor rearRight;
    public DcMotor frontRight;

    BNO055IMU imu;
    Orientation angles;

    private CRServo servo;


    HardwareMap hwMap = null;

    public donkeybot (){}


    public void init(HardwareMap ahwMap, LinearOpMode opmode){

        hwMap=ahwMap;

        frontLeft = hwMap.dcMotor.get("frontLeft");
        rearLeft = hwMap.dcMotor.get("rearLeft");
        frontRight = hwMap.dcMotor.get("frontRight");
        rearRight = hwMap.dcMotor.get("rearRight");

        servo = hwMap.crservo.get("servo");


        frontRight.setDirection(DcMotor.Direction.REVERSE);
        rearRight.setDirection(DcMotor.Direction.REVERSE);

        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
        imu = hwMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);




    }


    public void driveForward(double speed,long time) throws InterruptedException {
        frontLeft.setPower(speed);
        frontRight.setPower(speed);
        rearLeft.setPower(speed);
        rearRight.setPower(speed);
        Thread.sleep(time);
        stopDriving();


    }


    public void stopDriving(){
        frontLeft.setPower(0);
        frontRight.setPower(0);
        rearLeft.setPower(0);
        rearRight.setPower(0);
    }


    public void turnLeftTime(double speed,long time) throws InterruptedException {
        frontLeft.setPower(-speed);
        frontRight.setPower(speed);
        rearLeft.setPower(-speed);
        rearRight.setPower(speed);
        Thread.sleep(time);
        stopDriving();


    }



    public void turnLeftAngle(double speed,int angleReading, LinearOpMode opmode) throws InterruptedException {

        angles=imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
        Thread.sleep(500);
        frontLeft.setPower(-speed);
        frontRight.setPower(speed);
        rearLeft.setPower(-speed);
        rearRight.setPower(speed);
        while (angles.firstAngle < angleReading && !opmode.isStopRequested()){
            angles=imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
            opmode.telemetry.addData("Heading",angles.firstAngle);
            opmode.telemetry.update();
        }
        stopDriving();
    }



}
