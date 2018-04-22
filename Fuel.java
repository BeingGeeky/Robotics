import Behaviors.Var;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.NXTTouchSensor;
import lejos.hardware.sensor.NXTUltrasonicSensor;
import lejos.robotics.SampleProvider;

public class Fuel {

		public static void main(String[] args) {
//VAR
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
			public static boolean isOpen = true;
			
			
//WANDER CODE
			LCD.clear();
			private boolean suppressed;
			SampleProvider ur = Var.ultrasonicSensor.getDistanceMode();//Ultrasonic   
			SampleProvider ir = Var.irSensor.getSeekMode();//Infrared
		    private float[] urSample = new float[ur.sampleSize()];

		
				ur.fetchSample(urSample, 0);

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
		
		
//AVOID CODE
		//avoid objects that aren't the IR ball
		private boolean suppressed;
		SampleProvider ur = Var.ultrasonicSensor.getDistanceMode();//Ultrasonic 
		SampleProvider ir = Var.irSensor.getSeekMode();//Infrared
	    private float[] urSample = new float[ur.sampleSize()];
	    private float[] irSample = new float[ir.sampleSize()];

			ir.fetchSample(irSample, 0);
			ur.fetchSample(urSample, 0);
	
			while(!suppressed && urSample[0] < 0.35){    
		        ur.fetchSample(urSample, 0);
		        Var.motorB.setSpeed(200);
		        Var.motorC.setSpeed(200);
		        Var.motorB.forward();
		        Var.motorC.backward();
				Thread.yield();
				}
			}

//MOVE FORWARDS IR CODE
private boolean suppressed;
SampleProvider ur = Var.ultrasonicSensor.getDistanceMode();//Ultrasonic   
SampleProvider ir = Var.irSensor.getSeekMode();//Infrared
private float[] irSample = new float[ir.sampleSize()];
int degrees = 15;
int smallStep = 5;

	ir.fetchSample(irSample, 0);
	return irSample[1] < 100 && Var.isOpen/* &&/*irSample[1] > 30 && (irSample[0] == 0)*/;

	while(!suppressed && irSample[1] < 80 /*&& Var.isOpen*/){
		LCD.clear();
		LCD.drawString("IR: " + irSample[0], 1, 2);
			ir.fetchSample(irSample, 0);
	          
	          if(irSample[0] > 1 ){
	        	  Var.motorB.setSpeed(50);
		          Var.motorC.setSpeed(125);
	            Var.motorB.forward();
	            Var.motorC.forward();
	          }else if(irSample[0] < -1 ){
	        	  Var.motorB.setSpeed(125);
		          Var.motorC.setSpeed(50);
	            Var.motorB.forward();
	            Var.motorC.forward(); 
	          }else{
	            Var.motorB.setSpeed(200);
	            Var.motorC.setSpeed(200);
	          }
	 
			
//GRAB IR BALL
	    	SampleProvider ir = Var.irSensor.getSeekMode();//Infrared
	        int time1 = (int)System.currentTimeMillis();
	        private float[] irSample = new float[ir.sampleSize()];

	    		ir.fetchSample(irSample, 0);
	    		return isPressed() == true;
	    	}

	    		while(!suppressed){    
	    				while(Var.y<3){
	    				Var.motorD.rotate(-300);//neg = closed & pos = open
	    				Var.y++;
	    				}
	    			Var.motorD.stop();
	    			suppress();
	    		//	Var.isOpen = false;
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

	
	

}
