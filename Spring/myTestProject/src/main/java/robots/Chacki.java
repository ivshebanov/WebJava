package robots;

import interfase.Head;
import interfase.Leg;
import interfase.Robot;

/**
 * Created by iliashebanov on 14.04.17.
 */
public class Chacki implements Robot {
    private Head head;
    private Leg leg;

    public Chacki(Head head, Leg leg) {
        this.head = head;
        this.leg = leg;
    }

    public void dance() {
        System.out.println("Я люблю танцевать");
    }

    public void action() {
        head.calc();
        leg.go();
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Leg getLeg() {
        return leg;
    }

    public void setLeg(Leg leg) {
        this.leg = leg;
    }
}
