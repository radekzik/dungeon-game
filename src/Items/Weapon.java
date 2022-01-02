package Items;

import Map.Map;

public class Weapon extends Item {

    public Weapon(int x, int y, Map generator) {
        super(x, y, generator);
        generator.setCoordinate(x, y, 'G');
    }

}