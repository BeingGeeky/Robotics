package Behaviors;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.NXTTouchSensor;
import lejos.hardware.sensor.NXTUltrasonicSensor;
import lejos.robotics.SampleProvider;

public class Var {
	public static final float[] NULL = null;

	//public static EV3LargeRegulatedMotor motorA;
    public static EV3IRSensor irSensor = new EV3IRSensor(SensorPort.S1);

    public static NXTUltrasonicSensor ultrasonicSensor = new NXTUltrasonicSensor(SensorPort.S4);
    
    public static NXTTouchSensor touch = new NXTTouchSensor(SensorPort.S2);

    public static EV3LargeRegulatedMotor motorB = new EV3LargeRegulatedMotor(MotorPort.B); 
  
    public static EV3LargeRegulatedMotor motorC = new EV3LargeRegulatedMotor(MotorPort.C);
    
    public static EV3LargeRegulatedMotor motorD = new EV3LargeRegulatedMotor(MotorPort.D);
    
    public static float getURValue() {
        SampleProvider ur = Var.ultrasonicSensor.getDistanceMode();//Ultrasonic 
        //SampleProvider ir = Var.irSensor.getSeekMode();//Infrared
        float[] urSample = new float[ur.sampleSize()];
        ur.fetchSample(urSample, 0);
        return urSample[0];
    }  
    
	public static int y = 0;

}
