package Characters;
import Map.Map;

public class Villager extends Player {

	public Villager(int x, int y, Map g) {
		super(x, y, 45, 7, 45,  g, "Villager");
	}
	
	public String getRace() {

		return "Villager";

	}

}
