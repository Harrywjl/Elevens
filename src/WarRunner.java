import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class WarRunner{

    /**
     * The ranks of the cards for this game to be sent to the deck.
     */
    private static final String[] RANKS =
            {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    /**
     * The suits of the cards for this game to be sent to the deck.
     */
    private static final String[] SUITS =
            {"♠", "♥", "♦", "♣"};

    /**
     * The values of the cards for this game to be sent to the deck.
     */
    private static final int[] POINT_VALUES =
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};


    public static void main(String[] args)
    {
        //beginningDeck is the Deck we start with.  When we deal, it gets split into two
        //Decks for each player
        Deck beginningDeck = new Deck(RANKS,SUITS,POINT_VALUES);
        beginningDeck.shuffle();
        //System.out.println(beginningDeck);
        boolean gameWon = false;
        Scanner scan = new Scanner(System.in);
        String inp = "";
        int pCards = beginningDeck.size() / 2;
        int cCards = beginningDeck.size() / 2;
        System.out.println("It's a war of cards!\nDeck sizes: " + pCards + " (yours) vs. " + cCards + " (computer's)");
        while (!gameWon) {
            System.out.println("Press 'ENTER' to fight another battle or 'S' to shuffle your deck!");
            inp = scan.nextLine();
            if (inp.equals("S")) {
                beginningDeck.shuffle();
                System.out.println("Your deck has been shuffled\n");
            } else {
                int stake = 0;
                Card player = beginningDeck.deal();
                pCards--;
                stake++;
                Card computer = beginningDeck.deal();
                cCards--;
                stake++;
                System.out.println("You drew a " + player);
                System.out.println("The computer drew a " + computer);
                while (player.pointValue() == computer.pointValue()) {
                    System.out.println("It's a tie! Battle Again! \nYou and the computer each lay down 3 cards.");
                    for (int i = 1; i <= 4; i++) {
                        player = beginningDeck.deal();
                        computer = beginningDeck.deal();
                    }
                    System.out.println("You drew a " + player);
                    System.out.println("The computer drew a " + computer);
                }
                if (player.pointValue() > computer.pointValue()) {
                    pCards += stake;
                    System.out.println("You won " + stake + " cards! Deck sizes: " + pCards + " (yours) vs. " + cCards + " (computer's)");
                } else if (player.pointValue() < computer.pointValue()) {
                    cCards += stake;
                    System.out.println("The computer won " + stake + " cards! Deck sizes: " + pCards + " (yours) vs. " + cCards + " (computer's)");
                }
            }
            if (cCards <= 0) {
                System.out.println("You won the war!!");
            }
            if (pCards <= 0) {
                System.out.println("The computer won the war!!");
            }
        }

    }
}