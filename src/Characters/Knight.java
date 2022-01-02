package Characters;
import Map.Map;

public class Knight extends Player {

	public Knight(int x, int y, Map g) {
		super(x, y, 120, 18, 120,  g, "Knight" );
	}
	
	public String getRace() {

		return "Knight";

	}

}
