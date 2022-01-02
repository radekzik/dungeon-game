package Entities;
import Map.Map;

public class Spider extends Enemy {

	public Spider(int x, int y, Map g) {
		super(x, y, 38, 16, 38,   g, "Spider");
		g.setCoordinate(x, y, 'I');
	}
	public String getRace() {

		return "Spider";

	}
	
}
