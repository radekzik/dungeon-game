package Characters;
import Map.Map;

public abstract class Character {

	protected int x, y;
	protected double hp, dmg, mhp;
	public static Map generator;


	public Character(int x, int y, double hp, double dmg, double mhp, Map generator) {
		this.x = x;
		this.y = y;
		this.hp = hp;
		this.dmg = dmg;
		this.mhp = mhp;
		this.generator = generator;

	}


	public double getHP() {
		return hp;
	}
	public double getDMG() {
		return dmg;
	}

	public Map getGenerator() {
		return generator;
	}

	public void setHP(double HP) {
		hp = HP;
	}
	public void setDMG(double DMG){
		dmg = DMG;
	}

	public double getMhp() {
		return mhp;
	}

	public void setMhp(int mhp) {
		this.mhp = mhp;
	}
}