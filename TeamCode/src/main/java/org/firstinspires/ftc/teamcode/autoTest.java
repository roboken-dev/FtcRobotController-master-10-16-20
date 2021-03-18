package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="auto")

public class autoTest extends LinearOpMode{
    private DcMotor frontLeft;
    private DcMotor rearLeft;
    private DcMotor rearRight;
    private DcMotor frontRight;

    private CRServo servo;
    @Override


    public void runOpMode()
    {
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        rearLeft = hardwareMap.dcMotor.get("rearLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        rearRight = hardwareMap.dcMotor.get("rearRight");

        servo = hardwareMap.crservo.get("servo");


        frontRight.setDirection(DcMotor.Direction.REVERSE);
        rearRight.setDirection(DcMotor.Direction.REVERSE);

        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //motorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //motorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


waitForStart();
driveForward(0.5,1000);
turnLeftTime(0.5,1000);







    }

    public void driveForward(double speed,long time){
        frontLeft.setPower(speed);
        frontRight.setPower(speed);
        rearLeft.setPower(speed);
        rearRight.setPower(speed);
        sleep(time);
        stopDriving();


    }


    public void stopDriving(){
        frontLeft.setPower(0);
        frontRight.setPower(0);
        rearLeft.setPower(0);
        rearRight.setPower(0);
    }


    public void turnLeftTime(double speed,long time){
        frontLeft.setPower(-speed);
        frontRight.setPower(speed);
        rearLeft.setPower(-speed);
        rearRight.setPower(speed);
        sleep(time);
        stopDriving();


    }
}



