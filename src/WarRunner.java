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
        List<Card> pCards = new ArrayList<Card>();
        List<Card> cCards = new ArrayList<Card>();
        while (beginningDeck.size() > 0) {
            pCards.add(beginningDeck.deal());
            cCards.add(beginningDeck.deal());
        }
        Deck playerDeck = new Deck();
        Deck compDeck = new Deck();
        playerDeck.addToDeck(pCards);
        compDeck.addToDeck(cCards);
        System.out.println("It's a war of cards!\nDeck sizes: " + playerDeck.size() + " (yours) vs. " + compDeck.size() + " (computer's)");
        while (!gameWon) {
            System.out.println("Press 'ENTER' to fight another battle or 'S' to shuffle your deck!");
            inp = scan.nextLine();
            if (inp.toUpperCase().equals("S")) {
                playerDeck.shuffle();
                System.out.println("Your deck has been shuffled\n");
            } else {
                List<Card> stake = new ArrayList<Card>();
                Card player = playerDeck.deal();
                stake.add(player);
                Card comp = compDeck.deal();
                stake.add(comp);
                System.out.println("You drew a " + player);
                System.out.println("The computer drew a " + comp);
                while (player.pointValue() == comp.pointValue() && !gameWon) {
                    System.out.println("It's a tie! Battle Again! \nYou and the computer each lay down 3 cards.");
                    if (compDeck.size() <= 4) {
                        gameWon = true;
                        System.out.println("The computer ran out of cards! You won the war!!");
                    } else if (playerDeck.size() <= 4) {
                        gameWon = true;
                        System.out.println("You ran out of cards! The computer won the war!!");
                    } else {
                        for (int i = 1; i <= 4; i++) {
                            player = playerDeck.deal();
                            comp = compDeck.deal();
                            stake.add(player);
                            stake.add(comp);
                        }
                        System.out.println("You drew a " + player);
                        System.out.println("The computer drew a " + comp);
                    }
                }
                if (player.pointValue() > comp.pointValue()) {
                    playerDeck.addToDeck(stake);
                    System.out.println("You won " + stake.size() + " cards! Deck sizes: " + playerDeck.size() + " (yours) vs. " + compDeck.size() + " (computer's)");
                } else if (player.pointValue() < comp.pointValue()) {
                    compDeck.addToDeck(stake);
                    System.out.println("The computer won " + stake.size() + " cards! Deck sizes: " + playerDeck.size() + " (yours) vs. " + compDeck.size() + " (computer's)");
                }
            }
            if (compDeck.isEmpty()) {
                gameWon = true;
                System.out.println("You won the war!!");
            }
            if (playerDeck.isEmpty()) {
                gameWon = true;
                System.out.println("The computer won the war!!");
            }
        }

    }
}