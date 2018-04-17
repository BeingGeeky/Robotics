package Behaviors;

import lejos.hardware.lcd.LCD;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import Behaviors.Wander;
//import Behaviors.TurnTowardIR;
import Behaviors.MoveForwardsIR;
import Behaviors.Avoid;
import Behaviors.GrabBall;

public class SubSum {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LCD.clear();

		Behavior b0 = new Wander(); //move around
 	//	Behavior b1 = new TurnTowardIR(); //lines up with IR
 		Behavior b2 = new Avoid(); //avoid obstacles
 		Behavior b3 = new MoveForwardsIR(); //approaches IR
 		Behavior b4 = new GrabBall(); //grab ball

		Behavior[]behArr = {b0, b2, b3, b4};
		
		Arbitrator arby = new Arbitrator(behArr);
		arby.go();
	}
}

