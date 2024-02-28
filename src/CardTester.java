/**
 * This is a class that tests the Card class.
 */
public class CardTester {

    /**
     * The main method in this class checks the Card operations for consistency.
     *	@param args is not used.
     */
    public static void main(String[] args) {
        Card sixSpades = new Card("6", "spades", 6);
        Card tenDiamonds = new Card("10", "diamonds", 10);
        Card aClubs = new Card("A", "clubs", 1);
        System.out.println(sixSpades.suit());
        System.out.println(sixSpades.rank());
        System.out.println(sixSpades.pointValue());
        System.out.println(sixSpades.toString());
        System.out.println();
        System.out.println(tenDiamonds.suit());
        System.out.println(tenDiamonds.rank());
        System.out.println(tenDiamonds.pointValue());
        System.out.println(tenDiamonds.toString());
        System.out.println();
        System.out.println(aClubs.suit());
        System.out.println(aClubs.rank());
        System.out.println(aClubs.pointValue());
        System.out.println(aClubs.toString());


    }
}