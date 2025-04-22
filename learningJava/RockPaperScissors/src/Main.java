import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String player;
        String playAgain;
        String[] rps = {"r", "p", "s"};
        String computerGuess = rps[new Random().nextInt(rps.length)];

        while(true) {
            while (true) {
                System.out.println("please choose r ,p or s");
                player = scanner.nextLine().toLowerCase();
                if (player.equals("r") || player.equals("p") || player.equals("s"))
                    break;
                else
                    System.out.println("PLEASE ENTER A VALID CHAR");
            }

                System.out.println("computer guess is:" + computerGuess);
                if (player.equals(computerGuess))
                    System.out.println("Draw!");
                else if (player.equals("r")) {
                    if (computerGuess.equals("p"))
                        System.out.println("LOSER!");
                    else if (computerGuess.equals("s"))
                        System.out.println("WINNER!");
                } else if (player.equals("p")) {
                    if (computerGuess.equals("r"))
                        System.out.println("Winner!");
                    else if (computerGuess.equals("s"))
                        System.out.println("LOSER!");
                } else if (player.equals("s")) {
                    if (computerGuess.equals("r"))
                        System.out.println("LOSER!");
                    else if (computerGuess.equals("p"))
                        System.out.println("WINNER!");
                }

        System.out.println("Do you want to play again? y?n");
        playAgain = scanner.nextLine().toLowerCase();
        if (!playAgain.equals("y"))
            break;
        }
    }

}