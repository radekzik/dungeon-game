package Characters;
import Map.Map;

public class Robot extends Player {

	public Robot(int x, int y, Map g) {

		super(x, y, 200, 50, 200,  g, "Robot" );

	}
	
	public String getRace() {

		return "Robot";

	}

}
