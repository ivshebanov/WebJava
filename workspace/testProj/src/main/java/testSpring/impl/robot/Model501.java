package testSpring.impl.robot;

import testSpring.interfaces.Hand;
import testSpring.interfaces.Head;
import testSpring.interfaces.Leg;
import testSpring.interfaces.Robot;

public class Model501 implements Robot {

	private Hand hand;
	private Head head;
	private Leg leg;

	public Model501(Hand hand, Head head, Leg leg) {
		super();
		this.hand = hand;
		this.head = head;
		this.leg = leg;
	}

	public void dance() {
		// TODO Auto-generated method stub
		System.out.print("Я умею танцевать!");
	}

	public void action() {
		// TODO Auto-generated method stub
		hand.catchSomething();
		head.calc();
		leg.go();
	}

	public Hand getHand() {
		return hand;
	}

	public Head getHead() {
		return head;
	}

	public Leg getLeg() {
		return leg;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public void setHead(Head head) {
		this.head = head;
	}

	public void setLeg(Leg leg) {
		this.leg = leg;
	}

}
