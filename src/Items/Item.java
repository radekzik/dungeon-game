package Items;
import Map.Map;

public abstract class Item {
	public int x, y;
	public Map generator;
	
	public Item(int x, int y, Map floor) {
		this.x = x;
		this.y = y;
		this.generator = floor;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	


}
