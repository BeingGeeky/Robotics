package Behaviors;

import lejos.hardware.lcd.LCD;
import lejos.robotics.SampleProvider;
import lejos.robotics.subsumption.Behavior;

public class Avoid implements Behavior{
	//avoid objects that aren't the IR ball
	private boolean suppressed;
	SampleProvider ur = Var.ultrasonicSensor.getDistanceMode();//Ultrasonic 
	SampleProvider ir = Var.irSensor.getSeekMode();//Infrared
    private float[] urSample = new float[ur.sampleSize()];
    private float[] irSample = new float[ir.sampleSize()];

	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		ir.fetchSample(irSample, 0);
		ur.fetchSample(urSample, 0);
		return (urSample[0] < .35);
	}

	@Override
	public void action() {
		suppressed = false;

		while(!suppressed && urSample[0] < 0.35){    
	        ur.fetchSample(urSample, 0);
	        Var.motorB.setSpeed(200);
	        Var.motorC.setSpeed(200);
	        Var.motorB.forward();
	        Var.motorC.backward();
			Thread.yield();
			}
		}
		
	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		suppressed = true;
	}

}
