package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.hardware.Limelight;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.GyroSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LimelightSubsystem;

public class ContinuousAutonomous extends Command {
    DriveTrainSubsystem driveTrainSubsystem;
    IntakeSubsystem intakeSubsystem;
    //LimelightSubsystem limelightSubsystem;
    GyroSubsystem gyroSubsystem;
    Timer timer;
    double targetX, targetY, targetZ;
    private int stage;
    //for stages:
    //0 - go forward
    //1 - turn the first time
    //2 - align with speaker
    //3 - turn the second time
    //4 - back up from/go forward to speaker
    //5 - shoot!!!
    //6 - idk we done now
    private double startAngle;
    private double turningMarginOfError = 1.0;
    //these next two are random numbers I made up we need to find those out but that we can do during calibration time :D
    //how far to go forward from the starting position
    private double stage0Constant = -3;
    //distance from the amp that should line us up with the speaker
    private double distanceFromAmp = 5;
    //distance from speaker to be at in order to shoot
    private double distanceFromSpeaker = 5;
    //margin of error for robot position for those two distances above
    private double distanceMarginOfError = 0.5;
    private double[] pos;
    private double[] targetPose;
    //****** SET THIS BEFORE EACH MATCH ******** 
    //if false that means we're blue by the way
    private boolean weAreRed = false;
    private boolean doSimpleAutonomous = true;
    private double timeStartedShooting;
    public ContinuousAutonomous(DriveTrainSubsystem dTrainSubsystem, Timer m_timer,  GyroSubsystem gyroSubsystem, IntakeSubsystem intakeSubsystem) {
        driveTrainSubsystem = dTrainSubsystem;
        this.intakeSubsystem = intakeSubsystem;
        //this.limelightSubsystem = limelightSubsystem;
        this.gyroSubsystem = gyroSubsystem;
        timer = m_timer;
        addRequirements(driveTrainSubsystem);
    } 

    @Override
    public void initialize() {
        System.out.println("Starting continuous auto");
        stage = 0;
        timer.reset();
        timer.start();
        gyroSubsystem.calibrateGyro();
    }

    @Override
    public void execute() {
        if (doSimpleAutonomous){
           // comment first if statement out if robot is not set up in front of speaker thing
            if (timer.get() < 1){
                intakeSubsystem.beltShooterMotor.set(0.5);
                intakeSubsystem.wheelShooterMotor.set(1.0);
                intakeSubsystem.secondWheelShooterMotor.set(1.0);
            }
            if (timer.get() < 3.75 && timer.get() > 1.1){
                driveTrainSubsystem.differentialDrive.arcadeDrive(-0.675, 0.0);
            }

        } else {
            pos = gyroSubsystem.getPos(timer.get());
            switch (stage){
                case 0: 
                    if (pos[1] > stage0Constant){
                        //go forward until you're at the appropriate place
                        System.out.println("x (right): " + pos[0] + ", y (front): " + pos[1] + ", z (up): " + pos[2]);
                        driveTrainSubsystem.differentialDrive.arcadeDrive(-0.5, 0.0);
                    } else {
                        driveTrainSubsystem.differentialDrive.arcadeDrive(0.0, 0.0);
                        startAngle = gyroSubsystem.get_angle();
                        stage = 1;
                    }
                    break;
                case 1:
                    //face toward amp
                    if (weAreRed){
                        //turn right
                        if (gyroSubsystem.get_angle() - startAngle >= -90 + turningMarginOfError){
                            driveTrainSubsystem.differentialDrive.arcadeDrive(0.0, -0.5);
                        } else if (gyroSubsystem.get_angle() - startAngle <= -90 - turningMarginOfError){
                            driveTrainSubsystem.differentialDrive.arcadeDrive(0.0, 0.5);
                        } else {
                            driveTrainSubsystem.differentialDrive.arcadeDrive(0.0, 0.0);
                            stage = 2;
                        }
                    } else {
                        //turn left
                        if (gyroSubsystem.get_angle() - startAngle >= 90 + turningMarginOfError){
                            driveTrainSubsystem.differentialDrive.arcadeDrive(0.0, -0.5);
                        } else if (gyroSubsystem.get_angle() - startAngle <= 90 - turningMarginOfError){
                            driveTrainSubsystem.differentialDrive.arcadeDrive(0.0, 0.5);
                        } else {
                            driveTrainSubsystem.differentialDrive.arcadeDrive(0.0, 0.0);
                            stage = 2;
                        }
                    }
                    break;
                case 2:
                    //back up or go forward to the appropriate distance from amp
                    //righty's on the front
                    //targetPose = limelightSubsystem.righty.readTargetPos();
                    /*if (targetPose[3] <= distanceFromAmp - distanceMarginOfError){
                        driveTrainSubsystem.differentialDrive.arcadeDrive(0.5, 0.0);
                    } else if (targetPose[3] <= distanceFromAmp + distanceMarginOfError){
                        driveTrainSubsystem.differentialDrive.arcadeDrive(-0.5, 0.0);
                    } else {
                        driveTrainSubsystem.differentialDrive.arcadeDrive(0.0, 0.0);
                        startAngle = gyroSubsystem.get_angle();
                        stage = 3;
                    }
                    break;
                case 3:
                    //face toward speaker
                    if (weAreRed){
                        //turn left
                        if (gyroSubsystem.get_angle() - startAngle >= 90 + turningMarginOfError){
                            driveTrainSubsystem.differentialDrive.arcadeDrive(0.0, -0.5);
                        } else if (gyroSubsystem.get_angle() - startAngle <= 90 - turningMarginOfError){
                            driveTrainSubsystem.differentialDrive.arcadeDrive(0.0, 0.5);
                        } else {
                            driveTrainSubsystem.differentialDrive.arcadeDrive(0.0, 0.0);
                            stage = 4;
                        }
                    } else {
                        //turn right
                        if (gyroSubsystem.get_angle() - startAngle >= -90 + turningMarginOfError){
                            driveTrainSubsystem.differentialDrive.arcadeDrive(0.0, -0.5);
                        } else if (gyroSubsystem.get_angle() - startAngle <= -90 - turningMarginOfError){
                            driveTrainSubsystem.differentialDrive.arcadeDrive(0.0, 0.5);
                        } else {
                            driveTrainSubsystem.differentialDrive.arcadeDrive(0.0, 0.0);
                            stage = 4;
                        }
                    }
                    break;
                case 4:
                    //back up/go forward to appropriate distance from speaker to shoot
                    //lefty is the one on the back of the robot
                    targetPose = limelightSubsystem.lefty.readTargetPos();
                    if (targetPose[3] <= distanceFromSpeaker - distanceMarginOfError){
                        driveTrainSubsystem.differentialDrive.arcadeDrive(0.5, 0.0);
                    } else if (targetPose[3] <= distanceFromSpeaker + distanceMarginOfError){
                        driveTrainSubsystem.differentialDrive.arcadeDrive(-0.5, 0.0);
                    } else {
                        driveTrainSubsystem.differentialDrive.arcadeDrive(0.0, 0.0);
                        timeStartedShooting = timer.get();
                        stage = 5;
                    }
                    break;
                case 5:
                    if (timer.get() - timeStartedShooting < 3){
                        intakeSubsystem.beltShooterMotor.set(-0.5);
                        intakeSubsystem.wheelShooterMotor.set(1.0);
                        intakeSubsystem.secondWheelShooterMotor.set(1.0);
                    } else {
                        intakeSubsystem.beltShooterMotor.set(0);
                        intakeSubsystem.wheelShooterMotor.set(0);
                        intakeSubsystem.secondWheelShooterMotor.set(0);
                        stage = 6;
                    }
                    break;*/
                default:
                    System.out.println("uh-oh");
                    stage = 6;
                   break;
            }
        }
    }

    @Override
    public void end(boolean interrupted) {
    }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (((timer.get() >= 14) || (stage >= 6) && !doSimpleAutonomous) || (timer.get() >= 4.65 && doSimpleAutonomous));
  }
}
