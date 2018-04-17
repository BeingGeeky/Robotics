package Behaviors;

import lejos.hardware.lcd.LCD;
import lejos.robotics.SampleProvider;
import lejos.robotics.subsumption.Behavior;

public class Wander implements Behavior{
	//move forward 
	private boolean suppressed;
	SampleProvider ur = Var.ultrasonicSensor.getDistanceMode();//Ultrasonic   
	SampleProvider ir = Var.irSensor.getSeekMode();//Infrared
    private float[] urSample = new float[ur.sampleSize()];

	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		ur.fetchSample(urSample, 0);
		return true;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		suppressed = false;

		while(!suppressed){
	        ur.fetchSample(urSample, 0);
	        LCD.clear();
			LCD.drawString("Moving forward", 2, 1); 
			LCD.drawString("UR: " + urSample[0], 1, 2);
			Var.motorB.setSpeed(200);
			Var.motorC.setSpeed(200);
			Var.motorB.forward();
			Var.motorC.forward();
			Thread.yield();
		}
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		suppressed = true;
	}

}
