package Game;

import Game.Utils.IOUtil;
import Characters.Player;
import Entities.Enemy;
import Items.Armor;
import Items.Heal;
import Items.Weapon;
import Map.Map;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

import static Color.Colors.*;


public class Intro {

    public static Scanner sc = new Scanner(System.in);
    public static char playerChoose, playerRace;
    public static int playerKills = 0;
    public static int score = 0;
    public static int heals = 7;
    public static int armorsCollected = 0;
    public static int weaponsCollected = 0;
    public static int healsCollected = 0;
    public static boolean playerMove;
    public static boolean game = true;
    public static Player player;
    public static Enemy enemy;
    public static Heal heal;
    public static Weapon weapon;
    public static Armor armor;
    public static Random g = new Random();
    public static File file = new File("../DungeonGame/src/dungeonMap.txt");
    public static BufferedReader mapReader = null;
    public static String line;

    public static void intro() {


        while (game) {

            raceChoose();

            playerChoose = sc.next().charAt(0);

            while (playerChoose != 'k' && playerChoose != 'v' && playerChoose != 'r' && playerChoose != 'w') {
                IOUtil.printText("Try it again!");
                playerChoose = sc.next().charAt(0);
            }

            playerRace = playerChoose;

            for (int i = 0; i < 15; i++) {

                IOUtil.printText(ANSI_RED + "Ok, lets see your enemies!");

                System.out.println();

                Map spawn = new Map(i);

                try {
                    mapReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    int j = 0;
                    while ((line = mapReader.readLine()) != null) {
                        char[] chars = line.toCharArray();
                        for (int k = 0; k < 73; k++) {
                            spawn.setCoordinate(j, k, chars[k]);
                        }
                        j++;
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

                introText();


                spawn.playerGenerator(playerRace);
                player = spawn.getPlayer();

                spawn.enemyGenerator();
                enemy = spawn.getEnemy();

                spawn.healGenerator();
                heal = (Heal) spawn.getHeal();

                spawn.weaponGenerator();
                weapon = (Weapon) spawn.getWeapon();

                spawn.armorGenerator();
                armor = (Armor) spawn.getArmor();

                spawn.printMap();

                while (!playerMove) {

                    Fight.playerDirection();
                    Fight.playerDead();
                    Fight.playerWin();
                    spawn.printMap();

                }

            }
        }
    }

    public static void raceChoose() {

        IOUtil.printAsciiArt(ANSI_BLUE + "█░█░█ █▀▀ █░░ █▀▀ █▀█ █▀▄▀█ █▀▀\n" +
                "▀▄▀▄▀ ██▄ █▄▄ █▄▄ █▄█ █░▀░█ ██▄");
        System.out.println();

        IOUtil.printText(ANSI_BLUE + "| Welcome to my 2D Dungeon Game |");
        IOUtil.printText(ANSI_BLUE + "| You will meet a lot of monsters here, such as Skeletons, Zombies or even Spiders |");
        IOUtil.printText(ANSI_BLUE + "| On the ground you will be able to find spawned items - better armor, bandages or a better sword |");
        IOUtil.printText(ANSI_BLUE + "| And your mission is to survive, collect as many items as possible and most importantly kill all the monsters! |");
        IOUtil.printText(ANSI_BLUE + "| GL HF |");
        System.out.println();
        pressAnyKeyToContinue();
        IOUtil.printText(ANSI_BLUE + "Choose your race : ");
        System.out.println();
        IOUtil.printText(ANSI_BLUE + "| Robot - r ( HP - 200 | DMG - 50 ) | Difficulty - " + ANSI_GREEN + "Easy" + ANSI_BLUE + " |");
        System.out.println();
        IOUtil.printText(ANSI_BLUE + "| Knight - k ( HP - 120 | DMG - 18) | Difficulty - " + ANSI_CYAN + "Medium" + ANSI_BLUE + " |");
        System.out.println();
        IOUtil.printText(ANSI_BLUE + "| Wizard - w ( HP - 100 | DMG - 12) | Difficulty - " + ANSI_CYAN + "Medium" + ANSI_BLUE + " |");
        System.out.println();
        IOUtil.printText(ANSI_BLUE + "| Villager - v ( HP - 45 | DMG - 7 ) | Difficulty - " + ANSI_RED + "Hard" + ANSI_BLUE + " |");
        System.out.println();

    }

    public static void introText() {
        IOUtil.printText(ANSI_RED + "| Zombie - Z | Witch - W | Spider - I | Skeleton - S | Dragon - D |");
        System.out.println();
        pressAnyKeyToContinue();
        IOUtil.printText(ANSI_YELLOW + "Items : ");
        System.out.println();
        IOUtil.printText(ANSI_YELLOW + "| Armor - A | Weapon(sword) - G | Heal - H |");
        System.out.println();
        pressAnyKeyToContinue();
        IOUtil.printText(ANSI_PURPLE + "Abilites : ");
        System.out.println();
        IOUtil.printText(ANSI_PURPLE + "| Attack enemy - a | Block attack - d | Use heal - h |");
        System.out.println();
        pressAnyKeyToContinue();
        IOUtil.printText(ANSI_GREEN + "Moving : ");
        System.out.println();
        IOUtil.printText(ANSI_GREEN + "| North - n | East - e | South - s | West - w |");
        System.out.println();
        pressAnyKeyToJumpIntoGame();
        IOUtil.printText("Nice, lets go on the map!");
        System.out.println();
        System.out.println();
    }


    public static void pressAnyKeyToContinue() {
        IOUtil.printText("Press Enter key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {

        }
    }

    public static void pressAnyKeyToJumpIntoGame() {
        IOUtil.printText("When you are ready to jump into the game, press Enter...");
        try {
            System.in.read();
        } catch (Exception e) {

        }
    }


}


