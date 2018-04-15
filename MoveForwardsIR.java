package Behaviors;

  import lejos.robotics.SampleProvider;
import lejos.robotics.subsumption.Behavior;

public class MoveForwardsIR implements Behavior{
	private boolean suppressed;
	SampleProvider ur = Var.ultrasonicSensor.getDistanceMode();//Ultrasonic   
	SampleProvider ir = Var.irSensor.getSeekMode();//Infrared
    private float[] irSample = new float[ir.sampleSize()];
    int degrees = 15;
    int smallStep = 5;
    
	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return irSample[1] < 100 && irSample[1] > 30 && (irSample[0] == 0);
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		suppressed = false;
		while(!suppressed && irSample[1] < 100 && irSample[1] > 30 && (irSample[0] == 0)){
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

