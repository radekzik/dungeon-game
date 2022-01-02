package Entities;
import Map.Map;

public class Dragon extends Enemy {



	public Dragon(int x, int y, Map g) {
		super(x, y, 42, 18, 42,  g, "Dragon");
		g.setCoordinate(x, y, 'D');
	}

	public String getRace() {

		return "Dragon";

	}

}


