package Map;
import Game.Utils.IOUtil;
import Characters.Knight;
import Characters.Villager;
import Characters.Robot;
import Characters.Wizard;
import Entities.*;
import Items.Armor;
import Items.Heal;
import Items.Weapon;

import static Color.Colors.*;

public class Generator {

	int roomPosition;
	Map generator;
	int width, height;
	boolean[][] pos;

	public Generator(int rID, Map generator) {

		this.roomPosition = rID;
		this.generator = generator;

		pos = new boolean[height][width];

		for(int i=0; i<height; i++) {

			for(int j=0; j<width; j++) {

				pos[i][j] = true;

			}
		}

	}

	public void playerGenerator(char race) {

		switch (race) {

			case 'v' -> {
				generator.player = new Villager(39 , 12, generator);

				IOUtil.printAsciiArt(ANSI_BLACK+"██████████████████████████ \n" +
						"█░░░▒▒▒░░░▒▒▒░░░▒▒▒░░░▒▒▒█\n" +
						"█░░░▒▒▒░░░▒▒▒░░░▒▒▒░░░▒▒▒█\n" +
						"█▒▒▒░░░▒▒▒░░░▒▒▒░░░▒▒▒░░░█\n" +
						"█▒▒▒░░░▒▒▒░░░▒▒▒░░░▒▒▒░░░█\n" +
						"█░░░▒▒▒▒▒▒▒▒▒░░░░░░░░░░▒▒█\n" +
						"█░██████████████████████▒█\n" +
						"█▒▒▒▒▒▒▒▒▒░░░▒▒▒▒▒▒▒░░░░░█\n" +
						"█▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒░░▒░░░▒█\n" +
						"█░░░░███░▒▒▒▒▒▒▒▒███▒▒▒▒▒█\n" +
						"█░░░▒▒▒░░░▒▒▒▒▒▒▒▒░░░▒▒▒▒█\n" +
						"█▒▒▒░░░▒▒▒▒▒▒▒▒░░▒▒░░░▒░▒█\n" +
						"█▒▒▒░░░▒▒▒▒▒▒▒░░░▒▒▒▒░░░▒█\n" +
						"█░░░▒▒▒████████████▒░░░▒▒█\n" +
						"█░░░▒▒▒████████████▒░░░▒▒█\n" +
						"█▒▒▒░░░████████████▒░░▒▒▒█\n" +
						"█▒▒▒░░░███░▒▒▒▒▒███▒░░░▒▒█\n" +
						"█░░░▒▒▒░░░▒▒▒░░░▒▒▒░░░▒▒▒█\n" +
						"█░░░▒▒▒░░░▒▒▒░░░▒▒▒░░░▒▒▒█\n" +
						"██████████████████████████");
				System.out.println(ANSI_CYAN);
			}

			case 'w' -> {
				generator.player = new Wizard(39, 12, generator);
				IOUtil.printAsciiArt(ANSI_BLUE+"              _,._      \n" +
						"  .||,       /_ _\\\\     \n" +
						" \\.`',/      |'L'| |    \n" +
						" = ,. =      | -,| L    \n" +
						" / || \\    ,-'\\\"/,'`.   \n" +
						"   ||     ,'   `,,. `.  \n" +
						"   ,|____,' , ,;' \\| |  \n" +
						"  (3|\\    _/|/'   _| |  \n" +
						"   ||/,-''  | >-'' _,\\\\ \n" +
						"   ||'      ==\\ ,-'  ,' \n" +
						"   ||       |  V \\ ,|   \n" +
						"   ||       |    |` |   \n" +
						"   ||       |    |   \\  \n" +
						"   ||       |    \\    \\ \n" +
						"   ||       |     |    \\\n" +
						"   ||       |      \\_,-'\n" +
						"   ||       |___,,--\")_\\\n" +
						"   ||         |_|   ccc/\n" +
						"   ||        ccc/       \n" +
						"   ||                   ");
				System.out.println(ANSI_CYAN);
			}

			case 'k' -> {
				generator.player = new Knight(39 , 12, generator);
				IOUtil.printAsciiArt(ANSI_BLUE+"|\\             //\n" +
						" \\\\           _!_\n" +
						"  \\\\         /___\\\n" +
						"   \\\\        [+++]\n" +
						"    \\\\    _ _\\^^^/_ _\n" +
						"     \\\\/ (    '-'  ( )\n" +
						"     /( \\/ | {&}   /\\ \\\n" +
						"       \\  / \\     / _> )\n" +
						"        \"`   >:::;-'`\"\"'-.\n" +
						"            /:::/         \\\n" +
						"           /  /||   {&}   |\n" +
						"          (  / (\\         /\n" +
						"          / /   \\'-.___.-'\n" +
						"        _/ /     \\ \\\n" +
						"       /___|    /___|");
				System.out.println(ANSI_CYAN);
			}

			case 'r' -> {
				generator.player = new Robot(39, 12, generator);
				IOUtil.printAsciiArt(ANSI_BLUE+"                  _____\n" +
						"                 |     |\n" +
						"                 | | | |\n" +
						"                 |_____|\n" +
						"           ____ ___|_|___ ____\n" +
						"          ()___)         ()___)\n" +
						"          // /|           |\\ \\\\\n" +
						"         // / |           | \\ \\\\\n" +
						"        (___) |___________| (___)\n" +
						"        (___)   (_______)   (___)\n" +
						"        (___)     (___)     (___)\n" +
						"        (___)      |_|      (___)\n" +
						"        (___)  ___/___\\___   | |\n" +
						"         | |  |           |  | |\n" +
						"         | |  |___________| /___\\\n" +
						"        /___\\  |||     ||| //   \\\\\n" +
						"       //   \\\\ |||     ||| \\\\   //\n" +
						"       \\\\   // |||     |||  \\\\ //\n" +
						"            \\\\ // ()__)   (__()\n" +
						"              ///       \\\\\\\n" +
						"             ///         \\\\\\\n" +
						"           _///___     ___\\\\\\_\n" +
						"          |_______|   |_______|");
				System.out.println(ANSI_CYAN);
			}


		}
	}


	public void enemyGenerator2() {

		generator.enemy = new Dragon(27,65, generator);
		generator.enemy = new Dragon(12 , 54, generator);
		generator.enemy = new Dragon(21 , 56, generator);
		generator.enemy = new Dragon(39 , 24, generator);

		generator.enemy = new Skeleton(10 , 16, generator);
		generator.enemy = new Skeleton(30 , 28, generator);
		generator.enemy = new Skeleton(39 , 56, generator);
		generator.enemy = new Skeleton(35 , 2, generator);

		generator.enemy = new Witch(8 , 55, generator);
		generator.enemy = new Witch(25 , 25, generator);
		generator.enemy = new Witch(32 , 12, generator);

		generator.enemy = new Spider(25 , 2, generator);
		generator.enemy = new Spider(19 , 26, generator);
		generator.enemy = new Spider(14 , 30, generator);

		generator.enemy = new Zombie(15 , 2, generator);
		generator.enemy = new Zombie(37 , 39, generator);
		generator.enemy = new Zombie(20 , 39, generator);
		generator.enemy = new Zombie(17 , 10, generator);

	}

	public void healGenerator2() {

		generator.heal = new Heal(26, 39, generator);
		generator.heal = new Heal(17, 50, generator);
		generator.heal = new Heal(8,11, generator);
		generator.heal = new Heal(33,50, generator);

	}

	public void weaponGenerator2(){

		generator.weapon = new Weapon(8, 13, generator);
		generator.weapon = new Weapon( 28, 7, generator);
		generator.weapon = new Weapon( 18, 70, generator);

	}

	public void armorGenerator2(){

		generator.armor = new Armor(10, 40,generator);
		generator.armor = new Armor(19, 6, generator);
		generator.armor = new Armor(34, 70, generator);

	}

}