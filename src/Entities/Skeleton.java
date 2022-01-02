package Entities;
import Map.Map;

public class Skeleton extends Enemy {

	public Skeleton(int x, int y, Map g) {
		super(x, y, 40, 17, 40,  g, "Skeleton");
		g.setCoordinate(x, y, 'S');
	}
	public String getRace() {

		return "Skeleton";

	}

}
