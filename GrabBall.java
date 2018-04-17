package Behaviors;

import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.robotics.SampleProvider;
import lejos.robotics.subsumption.Behavior;
import lejos.hardware.sensor.NXTTouchSensor;


public class GrabBall implements Behavior{
	private boolean suppressed;
	SampleProvider ir = Var.irSensor.getSeekMode();//Infrared
    int time1 = (int)System.currentTimeMillis();
    private float[] irSample = new float[ir.sampleSize()];

	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub		
		ir.fetchSample(irSample, 0);
		return isPressed() == true;
	}

	@Override
	public void action() {
		suppressed = false;
		while(!suppressed){    
	        LCD.clear();
	//		LCD.drawString("Grabbing ball", 2, 1); 	
	//		LCD.drawString("T: " + isPressed(), 1, 2);
			while (isPressed()==true){
				while(Var.y<3){
				Var.motorD.rotate(-300);//neg = closed & pos = open
				Var.y++;}
			}
			Var.motorD.stop();
			Thread.yield();
		}
	}
		
	public boolean isPressed() {
			SampleProvider touch = Var.touch.getTouchMode();//Ultrasonic   
		    float[] tSample = new float[touch.sampleSize()];
			touch.fetchSample(tSample, 0);
		    if (tSample[0] == 0)
		      return false;
		    return true;
		  }		

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		suppressed = true;
	}

}
