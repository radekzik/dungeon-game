package Map;

import Entities.Enemy;
import Characters.Player;
import Items.Armor;
import Items.Heal;
import Items.Item;
import Items.Weapon;

import static Game.Intro.*;
import static Color.Colors.ANSI_CYAN;

public class Map {

	int roomID;
	Player player;
	Enemy enemy;
	Heal heal;
	Weapon weapon;
	Armor armor;
	String action ="";
	String secAction = "";
	String thirdAction = "";

	char[][] map = new char[42][73];
	Generator[] rooms = new Generator[9];


	public Map(int roomID) {

		this.roomID = roomID;

		for(int i = 0; i < 9; i++) {
			rooms[i] = new Generator(i, this);
		}

	}
	public void printMap() {

		for(int i = 0; i < 42; i++) {
			for(int j = 0; j < 73; j++)
				System.out.print(map[i][j]);
			System.out.println();
		}

		System.out.println(ANSI_CYAN);
		System.out.println("| U | " + player.getRace()+" | HP - " + player.getHP()+" | DMG - " + player.getDMG()+" | Kills - "+ playerKills+  " | Score - "+score+" | Heals - "+heals+" | Attack enemy - a | Block attack - d | Use heal - h |");
		System.out.println("| "+action+" |");
		System.out.println(secAction);

	}

	public void playerGenerator(char race) {

		int p = 0;
		rooms[p].playerGenerator(race);

	}


	public void enemyGenerator() {

		int e = 0;
		rooms[e].enemyGenerator2();

	}

	public void healGenerator(){

		int h = 0;
		rooms[h].healGenerator2();

	}

	public void weaponGenerator(){

		int w = 0;
		rooms[w].weaponGenerator2();

	}

	public void armorGenerator(){

		int a = 0;
		rooms[a].armorGenerator2();

	}

	public char getCoordinate(int x, int y) {

		return map[x][y];

	}

	public void setCoordinate(int x, int y, char coordinate) {

		map[x][y] = coordinate;

	}

	public Player getPlayer() {

		return player;

	}

	public Enemy getEnemy() {

		return enemy;

	}

	public Item getHeal(){

		return heal;

	}
	public Item getWeapon(){

		return weapon;

	}
	public Item getArmor(){

		return armor;

	}

	public void setAction(String action) {

		this.action = action;

	}

	public void setSecAction(String secAction) {

		this.secAction = secAction;

	}
	public void setThirdAction(String thirdAction) {

		this.thirdAction = thirdAction;

	}


}