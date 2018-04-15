package Behaviors;

import lejos.robotics.SampleProvider;
import lejos.robotics.subsumption.Behavior;

public class TurnTowardIR implements Behavior{
	private boolean suppressed;
	SampleProvider ur = Var.ultrasonicSensor.getDistanceMode();//Ultrasonic   
SampleProvider ir = Var.irSensor.getSeekMode();//Infrared
 	private float[] irSample = new float[ir.sampleSize()];
  	int degrees = 15;
  	int smallStep = 5;
    
	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return irSample[1] < 100 && irSample[1] > 30 && (irSample[0] != 0);
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		suppressed = false;
		while(!suppressed && irSample[1] < 100 && irSample[1] > 30 && (irSample[0] != 0)){
	        ir.fetchSample(irSample, 0);
			while(irSample[0] < 1 && irSample[0] > -1){
				if(irSample[0] < 0){
					rotateLeft(smallStep);
				}else if(irSample[0] > 1){
					rotateRight(smallStep);
				}
			}
			
			Thread.yield();
		}
	}
	
	public void rotateLeft(int degrees){
		Var.motorC.rotate(degrees);
		Var.motorB.rotate(-degrees);
	}
	
	public void rotateRight(int degrees){
		Var.motorC.rotate(-degrees);
		Var.motorB.rotate(degrees);
	}
	
	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		suppressed = true;
	}

}

