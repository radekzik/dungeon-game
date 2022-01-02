package Game;

import Game.Utils.IOUtil;

import java.util.Random;
import java.util.Scanner;

import static Characters.Character.generator;
import static Game.Intro.*;
import static Characters.Player.coordinatesX;
import static Characters.Player.coordinatesY;
import static Color.Colors.ANSI_RED;
import static Color.Colors.ANSI_YELLOW;

public class Fight {

    public static Scanner sc = new Scanner(System.in);
    public static char playerChoose, otherAction;
    public static double randomDMG;
    public static Random g = new Random();

    public static void fight(){

    if (playerChoose == 'h' && heals >= 1 && generator.getCoordinate(coordinatesX, coordinatesY) != 'D' && generator.getCoordinate(coordinatesX, coordinatesY) != 'S' &&
            generator.getCoordinate(coordinatesX, coordinatesY) != 'I' && generator.getCoordinate(coordinatesX, coordinatesY) != 'W' &&
            generator.getCoordinate(coordinatesX, coordinatesY) != 'Z') {

        player.setHP(player.getHP() + 40);
        generator.setAction("U healed your self! | Your HP now - " + player.getHP());
        heals--;

        playerDead();
        enemyDead();
    } else if (generator.getCoordinate(coordinatesX, coordinatesY) == 'D' || generator.getCoordinate(coordinatesX, coordinatesY) == 'S' ||
            generator.getCoordinate(coordinatesX, coordinatesY) == 'I' || generator.getCoordinate(coordinatesX, coordinatesY) == 'W' ||
            generator.getCoordinate(coordinatesX, coordinatesY) == 'Z') {


        if (playerChoose == 'a') {

            playerDead();
            enemyDead();

            numberG();

            if (g.nextInt() <= 30) {

                player.setHP(player.getHP() - enemy.getDMG() * randomDMG);

                enemy.setHP(enemy.getHP() - player.getDMG() * randomDMG);

                generator.setAction("U are attacking enemy! | Enemy's HP now - " + enemy.getHP() + " HP");

            } else {

                enemy.setHP(enemy.getHP() - 1);
                generator.setAction("Enemy blocked your attack! | Enemy's HP now - " + enemy.getHP() + " HP");

            }

            playerDead();
            enemyDead();

        }

        if (playerChoose == 'd') {

            playerDead();
            enemyDead();

            player.setHP(player.getHP() - (enemy.getDMG() - 2));

            generator.setAction("U blocked enemy's attack! | " + generator.getCoordinate(coordinatesX, coordinatesY) + " attacking you | " + generator.getCoordinate(coordinatesX, coordinatesY) + "'s HP - " + enemy.getHP());

            playerDead();
            enemyDead();

        }

        if (playerChoose == 'h' && heals >= 1) {

            generator.setAction("U healed your self! | Your HP now - " + player.getHP());
            player.setHP(player.getHP() + 50);

            heals--;


            playerDead();
            enemyDead();
        }

    } else {

        generator.setAction(" --- ");
        otherAction = 'o';

    }
}
    public static void playerDirection() {

        String a = sc.next();
        char[] charArray = a.toCharArray();
        playerChoose = charArray[0];


        if (playerChoose == 'n' || playerChoose == 's' || playerChoose == 'e' || playerChoose == 'w'
                || playerChoose == 'a' || playerChoose == 'd' || playerChoose == 'h') {

            Fight.fight();

            if (playerChoose == 'n') {

                playerMove = player.move('1', otherAction);

            }

            if (playerChoose == 's') {

                playerMove = player.move('2', otherAction);

            }

            if (playerChoose == 'e') {
                playerMove = player.move('3', otherAction);

            }

            if (playerChoose == 'w') {
                playerMove = player.move('4', otherAction);

            }

        }

    }

    public static void numberG() {

        g.nextInt(41);

        if (g.nextInt() <= 20) {

            randomDMG = 0.5;

        }
        if (g.nextInt() >= 20 && g.nextInt() <= 40) {

            randomDMG = 1;

        }
    }
    public static void playerWin() {


        if (player.getHP() > 0 && playerKills == 18) {

            IOUtil.printText(ANSI_YELLOW + "You are the winner!");
            IOUtil.printText(ANSI_YELLOW + "Kills - " + playerKills);
            IOUtil.printText(ANSI_YELLOW + "Armors collected - " + armorsCollected);
            IOUtil.printText(ANSI_YELLOW + "Weapons collected - " + weaponsCollected);
            IOUtil.printText(ANSI_YELLOW + "Heals collected - " + healsCollected);
            IOUtil.printText(ANSI_YELLOW + "Score - " + score);
            IOUtil.printText(ANSI_YELLOW + "CG!");
            System.exit(0);

        }

    }

    public static void playerDead() {

        if (player.getHP() <= 0) {

            IOUtil.printText(ANSI_RED + "You are dead!");
            IOUtil.printText(ANSI_RED+"U were killed by "+generator.getCoordinate(coordinatesX, coordinatesY));
            IOUtil.printText(ANSI_RED + "Kills - " + playerKills);
            IOUtil.printText(ANSI_RED + "Armors collected - " + armorsCollected);
            IOUtil.printText(ANSI_RED + "Weapons collected - " + weaponsCollected);
            IOUtil.printText(ANSI_RED + "Heals collected - " + healsCollected);
            IOUtil.printText(ANSI_RED + "Score - " + score);
            IOUtil.printText(ANSI_RED + "GAME OVER!");
            System.exit(0);

        }

    }

    public static void enemyDead() {

        if (enemy.getHP() <= 0) {

            playerKills++;
            score = score + 100;
            generator.setAction("Enemy is dead! | U killed " + generator.getCoordinate(coordinatesX, coordinatesY) + "! | Your HP now - " + player.getHP());
            generator.setCoordinate(coordinatesX, coordinatesY, '.');
            enemy.setHP(enemy.getHP() + enemy.getMhp());

        }
    }
}

