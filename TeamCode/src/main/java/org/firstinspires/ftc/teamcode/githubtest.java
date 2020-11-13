package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
@Autonomous(name="test")
@Disabled

public class githubtest extends LinearOpMode{
    private DcMotor motorLeft;
    private DcMotor motorRight;
    @Override


    public void runOpMode()
    {
        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorRight = hardwareMap.dcMotor.get("motorRight");

        motorLeft.setDirection(DcMotor.Direction.REVERSE);

        motorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        double DRIVE_POWER = 0.5;


        waitForStart();



        DriveForwardByTime(DRIVE_POWER,1000);

        TurnRightByTime(DRIVE_POWER,1000);

        DriveForwardByTime(DRIVE_POWER,750);

        TurnLeftByTime(DRIVE_POWER,1000);

        DriveForwardByTime(DRIVE_POWER,1000);


    }


    public void DriveForwardByTime(double power, long time)
    {
        motorLeft.setPower(power);
        motorRight.setPower(power);
        sleep(time);

        motorLeft.setPower(0);
        motorRight.setPower(0);
        sleep(250);
    }


    public void TurnRightByTime(double power, long time)
    {
        motorLeft.setPower(power);
        motorRight.setPower(-power);
        sleep(time);

        motorLeft.setPower(0);
        motorRight.setPower(0);
        sleep(250);
    }


    public void TurnLeftByTime(double power, long time)
    {
        motorLeft.setPower(-power);
        motorRight.setPower(power);
        sleep(time);

        motorLeft.setPower(0);
        motorRight.setPower(0);
        sleep(250);
    }



}