package Items;
import Map.Map;

public class Heal extends Item {

	public Heal(int x, int y, Map generator) {

		super(x, y, generator);

		generator.setCoordinate(x, y, 'H');
	}

}
