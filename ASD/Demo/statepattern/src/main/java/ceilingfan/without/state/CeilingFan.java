package ceilingfan.without.state;

public class CeilingFan {
	int current_state = 0;

	public void pullgreen() {
		if (current_state == 0) {
			current_state = 1;
			System.out.println("low speed");
		} else if (current_state == 1) {
			current_state = 2;
			System.out.println("medium speed");
		} else if (current_state == 2) {
			current_state = 3;
			System.out.println("high speed");
		} else {
			current_state = 0;
			System.out.println("turning off");
		}
	}

	public void pullred() {
		if (current_state == 0) {
			current_state = 3;
			System.out.println("high speed");
		} else if (current_state == 1) {
			current_state = 0;
			System.out.println("turning off");
		} else if (current_state == 2) {
			current_state = 1;
			System.out.println("low speed");
		} else {
			current_state = 2;
			System.out.println("medium speed");
		}
	}

}
