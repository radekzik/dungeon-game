package Characters;


import Map.Map;

import java.util.Random;

import static Game.Intro.*;

public class Player extends Character {

	public char lastPosition;
	public String race;
	public static int coordinatesX = 0;
	public static int coordinatesY = 0;
	Random randomG = new Random();
	public static int randomGenerator;

	public Player(int x, int y, double hp, double dmg, double mhp, Map generator, String Race) {
		super(x, y, hp, dmg,mhp, generator);
		this.lastPosition = '.';
		this.race = Race;
		generator.setCoordinate(x, y, 'U');
		
	}


	public boolean move(char dir, char action) {
		coordinatesX = x;
		coordinatesY = y;

		String direction= "";

		switch (dir) {
			case '1' -> {
				coordinatesX -= 1;
				direction = "North";
			}
			case '2' -> {
				coordinatesX += 1;
				direction = "South";
			}

			case '3' -> {
				coordinatesY += 1;
				direction = "East";
			}
			case '4' -> {
				coordinatesY -= 1;
				direction = "West";
			}

		}


	    if(action == 'o') {


			if(generator.getCoordinate(coordinatesX, coordinatesY) == '.') {

	          generator.setCoordinate(x, y, lastPosition);

	          lastPosition = generator.getCoordinate(coordinatesX, coordinatesY);

	          x = coordinatesX;
	          y = coordinatesY;
	          generator.setCoordinate(x, y, 'U');
	          generator.setAction("U are going on " + direction);
	        }

	        else if(generator.getCoordinate(coordinatesX, coordinatesY) == '-'|| generator.getCoordinate(coordinatesX, coordinatesY) == ' ' ||
					generator.getCoordinate(coordinatesX, coordinatesY) == '|') {
				generator.setAction("There is a wall!");
	        }

	        else if(generator.getCoordinate(coordinatesX, coordinatesY) == 'H') {

				randomGenerator = randomG.nextInt(50)+ 1;
				healsCollected++;

				player.setHP(player.getHP() + randomGenerator);
				generator.setAction("U picked up heal! | + "+randomGenerator+ " HP");
				score = score + 25;

					generator.setCoordinate(x,y, lastPosition);
	                lastPosition = '.';
	                x = coordinatesX;
	                y = coordinatesY;
					generator.setCoordinate(x,y, 'U');

	            }

			else if(generator.getCoordinate(coordinatesX, coordinatesY) == 'G'){

				player.setDMG(player.getDMG() + 5);
				generator.setAction("U found better sword! | + 5 DMG ");
				weaponsCollected++;
				score = score + 50;
				generator.setCoordinate(x,y, lastPosition);
				lastPosition = '.';
				x = coordinatesX;
				y = coordinatesY;
				generator.setCoordinate(x,y, 'U');

			}

			else if(generator.getCoordinate(coordinatesX, coordinatesY) == 'A'){

				enemy.setDMG(enemy.getDMG() - 4);
				generator.setAction("U found better armor! | - 4 enemy DMG");
				armorsCollected++;
				score = score + 50;
				generator.setCoordinate(x,y, lastPosition);
				lastPosition = '.';
				x = coordinatesX;
				y = coordinatesY;
				generator.setCoordinate(x,y, 'U');
			}

	  }
	      return false;

	}

	public String getRace() {
		return race;
	}


}
