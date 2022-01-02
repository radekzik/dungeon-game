package Entities;
import Characters.Character;
import Map.Map;

public class Enemy extends Character {

	public String race;

	public Enemy(int x, int y, double hp, double dmg, double mhp, Map generator, String Race) {
		super(x, y, hp, dmg, mhp, generator);
		this.race=Race;
	}
	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}
}

