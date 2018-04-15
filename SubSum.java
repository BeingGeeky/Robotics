package Behaviors;

import lejos.hardware.lcd.LCD;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
/*import Behaviors.Wander;
import Behaviors.ExploreIR;
import Behaviors.TowardsIR;*/
import Behaviors.Avoid;
import Behaviors.GrabBall;

public class SubSum {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LCD.clear();

		Behavior b0 = new Wander(); //move around
 	/*	Behavior b1 = new TowardsIR(); //move towards IR
 		Behavior b2 = new ExploreIR(); //detect IR*/
 		Behavior b3 = new Avoid(); //avoid obstacles
 		Behavior b4 = new GrabBall(); //grab ball

		Behavior[]behArr = {b4};
		
		Arbitrator arby = new Arbitrator(behArr);
		arby.go();
	}
}

