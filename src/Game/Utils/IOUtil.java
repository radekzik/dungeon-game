package Game.Utils;

public class IOUtil {

    public static void printText(String text) {
        try {
            for (String s : text.split(" ")) {
                for (char c : s.toCharArray()) {
                    Thread.sleep(40);
                    System.out.print(c);
                }
                System.out.print(" ");
                Thread.sleep(80);
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void printAsciiArt(String text) {
        try {
            for (String s : text.split(" ")) {
                for (char c : s.toCharArray()) {
                    Thread.sleep(7);
                    System.out.print(c);
                }
                System.out.print(" ");
                Thread.sleep(7);
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println(e);
        }
    }



}
