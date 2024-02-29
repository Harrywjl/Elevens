
/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

    /**
     * The main method in this class checks the Deck operations for consistency.
     *	@param args is not used.
     */
    public static void main(String[] args) {
        String[] ranks = new String[]{"A", "2", "3", "J"};
        String[] suits = new String[]{"diamonds", "clubs", "hearts", "spades"};
        int[] values = new int[]{1, 2, 3, 10};
        String[] ranks1 = new String[]{"4", "5", "6", "7", "Q"};
        int[] values1 = new int[]{4, 5, 6, 7, 10};
        String[] ranks2 = new String[]{"8", "9", "10", "K"};
        int[] values2 = new int[]{8, 9, 10, 10};
        Deck deck1 = new Deck(ranks, suits, values);
        Deck deck2 = new Deck(ranks1, suits, values1);
        Deck deck3 = new Deck(ranks2, suits, values2);
        System.out.println(deck1.size());
        System.out.println(deck1.deal());
        System.out.println(deck1.deal());
        System.out.println(deck1.deal());
        System.out.println(deck1.size());
        System.out.println(deck1.isEmpty());
        System.out.println(deck1);
        System.out.println(deck2.size());
        System.out.println(deck2.deal());
        System.out.println(deck2.deal());
        System.out.println(deck2.deal());
        System.out.println(deck2.size());
        System.out.println(deck2.isEmpty());
        System.out.println(deck2);
        System.out.println(deck3.size());
        System.out.println(deck3.deal());
        System.out.println(deck3.deal());
        System.out.println(deck3.deal());
        System.out.println(deck3.size());
        System.out.println(deck3.isEmpty());
        System.out.println(deck3);
    }
}

