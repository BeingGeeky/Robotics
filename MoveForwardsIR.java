package Behaviors;

  import lejos.hardware.lcd.LCD;
import lejos.robotics.SampleProvider;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

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
		ir.fetchSample(irSample, 0);
		//ir.fetchSample(irSample,  1);
		return irSample[1] < 100 && irSample[1] > 30 && (irSample[0] == 0);
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		suppressed = false;
		while(!suppressed && irSample[1] < 50){
			LCD.clear();
			LCD.drawString("IR: " + irSample[0], 1, 2);
				ir.fetchSample(irSample, 0);
		          Var.motorB.setSpeed(100);
		          Var.motorC.setSpeed(100);
		          if(irSample[0] > 1 ){
		            Var.motorB.backward();
		            Var.motorC.forward();
		          }else if(irSample[0] < -1 ){
		            Var.motorB.forward();
		            Var.motorC.backward(); 
		          }else{
		            Var.motorB.setSpeed(300);
		            Var.motorC.setSpeed(300);
		          }
		          
		          Var.motorB.forward();
		          Var.motorC.forward();
		          
		          
		        }
		}
	
	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		suppressed = true;
	}

}

