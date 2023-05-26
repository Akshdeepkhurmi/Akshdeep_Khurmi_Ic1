import java.util.Random;
import java.util.Scanner;

public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random random = new Random();

        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(random.nextInt(13) + 1);
            c.setSuit(Card.SUITS[random.nextInt(4)]);
            magicHand[i] = c;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Pick a card - Enter the value of your card (1-13): ");
        int value = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        System.out.print("Enter the suit of your card (Heart, Diamonds, Spades, Clubs): ");
        String suit = scanner.nextLine();

        Card userCard = new Card();
        userCard.setValue(value);
        userCard.setSuit(suit);

        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equalsIgnoreCase(userCard.getSuit())) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Congratulations! Your card is in the magic hand.");
        } else {
            System.out.println("Sorry! Your card is not in the magic hand.");
        }
    }
}
