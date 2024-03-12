import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
public class ElevensBoardTester {
    public static void main(String[] args) {
        ElevensBoard game = new ElevensBoard();
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Elevens!");
        System.out.println();
        while (!game.gameIsWon()) {
            System.out.println(game.toString());
            if (game.anotherPlayIsPossible()) {
                ArrayList<Integer> selectedCards = new ArrayList<Integer>();
                int in = -2;
                System.out.println("Pick either a pair that have a combined value of 11 OR\n3 cards consisting of a jack, a queen, and a king in some order\n(Type the indices of the cards and type -1 when you're finished)");
                while (in != -1) {
                    in = scan.nextInt();
                    List<Integer> valid = game.cardIndexes();
                    if (valid.indexOf(in) >= 0) {
                        selectedCards.add(in);
                    }
                }
                while (!game.isLegal(selectedCards)) {
                    System.out.println("Invalid play. Please try again");
                    selectedCards = new ArrayList<Integer>();
                    in = -2;
                    System.out.println("Pick either a pair that have a combined value of 11 \nOR\n3 cards consisting of a jack, a queen, and a king in some order\n(Type the indices of the cards and type -1 when you're finished)");
                    while (in != -1) {
                        in = scan.nextInt();
                        List<Integer> valid = game.cardIndexes();
                        if (valid.indexOf(in) >= 0) {
                            selectedCards.add(in);
                        }
                    }
                }
                game.replaceSelectedCards(selectedCards);
                System.out.println("Undealt cards: " + game.deckSize());

            } else {
                System.out.println("No plays are possible. You lost! :(\nReplacing cards on the board...");
                game.newGame();
            }
        }
        if (game.gameIsWon()) {
            System.out.println("You won!!! :)");
        }

    }
}
