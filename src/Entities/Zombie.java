package Entities;
import Map.Map;

public class Zombie extends Enemy {

	public Zombie(int x, int y, Map g) {
		super(x, y, 40, 18, 40,   g, "Zombie");
		g.setCoordinate(x, y, 'Z');
	}
	public String getRace() {

		return "Zombie";

	}

}
