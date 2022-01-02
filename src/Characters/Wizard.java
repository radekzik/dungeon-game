package Characters;
import Map.Map;

public class Wizard extends Player {

	public Wizard(int x, int y, Map g) {

		super(x, y, 100, 12, 100, g, "Wizzard");

	}
	
	public String getRace() {

		return "Wizzard";

	}

}
