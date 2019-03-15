package quaziismydad_lab6;

import java.util.Scanner;

public class quaziismydad_lab6_q3 {

	// Copying me gets us both zero. Just use this as inspiration.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Declare required variables.
		String deck[] = new String[52];
		String suits[] = { "H", "C", "D", "S" };
		String currentCard = "", lastCard = "";
		int userInput = 0, totalCorrect = 0;
		int currentVal = 0, lastVal = 0;

		// Enable the Scanner.
		Scanner inputScanner = new Scanner(System.in);

		// Print the header.
		printHeader(6, 3, "quaziismydad", "", "Simple card game using arrays");

		// Loop the program.
		while (true) {
			// Reset user score.
			totalCorrect = 0;
			// Populate the deck.
			populateDeck(deck, suits);
			// Draw the first card
			lastCard = drawCard(deck);
			System.out.println("\nYour first card is: " + showCard(lastCard));
			// Loop to accomplish the rest of the program.
			for (int i = 0; i < 51; i++) {
				// Draw a new card.
				currentCard = drawCard(deck);
				// Convert the numbers to integers to ease comparison.
				lastVal = (int) (lastCard.charAt(0));
				if (lastCard.charAt(1) != 'H' && lastCard.charAt(1) != 'C' && lastCard.charAt(1) != 'D'
						&& lastCard.charAt(1) != 'S') {
					lastVal = lastVal * 10 + ((int) (lastCard.charAt(1)));
				}
				currentVal = (int) (currentCard.charAt(0));
				if (currentCard.charAt(1) != 'H' && currentCard.charAt(1) != 'C' && currentCard.charAt(1) != 'D'
						&& currentCard.charAt(1) != 'S') {
					currentVal = currentVal * 10 + ((int) (currentCard.charAt(1)));
				}
				// Ask the user and get their input.
				System.out.println("Is " + showCard(currentCard) + " higher or lower then " + showCard(lastCard) + "?");
				// Loop to get a valid input.
				do {
					System.out.println("Enter 0 for lower, 1 for higher, and 9 to exit.");
					// The actual card values are pretty messed up but they still serve their
					// purpose. Un-comment the below code to burn your eyes.
					// System.out.println(currentVal);
					// System.out.println(lastVal);
					userInput = inputScanner.nextInt();
				} while (userInput != 0 && userInput != 1 && userInput != 9);

				// Do the checking to see if the user is right.
				switch (userInput) {
				case 0:
					if (currentVal < lastVal) {
						System.out.println("Correct!");
						totalCorrect++;
					} else if (currentVal == lastVal) {
						System.out.println("The cards are of equal value.");
					} else {
						System.out.println("Incorrect.");
					}
					break;
				case 1:
					if (currentVal > lastVal) {
						System.out.println("Correct!");
						totalCorrect++;
					} else if (currentVal == lastVal) {
						System.out.println("The cards are of equal value.");
					} else {
						System.out.println("Incorrect.");
					}
					break;
				case 9:
					System.out.println("The user guessed " + totalCorrect + " card(s) correctly.");
					System.exit(0);
				}
				lastCard = currentCard;
			}
			// When the cards run out: tell the user, give them their score, and reset the
			// deck.
			System.out.println("There are no cards left in the deck.");
			System.out.println("The user guessed " + totalCorrect + " card(s) correctly.");
			System.out.println("Would you like to continue?: (Press 9 to exit)");
			// If 9 is input, exit the program.
			if (inputScanner.nextInt() == 9) {
				System.exit(0);
			}
			// If not, reset the deck.
			System.out.println("Resetting the deck...");
		}

		// System.out.println("");
		// for (int i = 0; i < 52; i++) {
		// System.out.print(deck[i] + " ");
		// }
	}

	// Method to generate the header.
	public static void printHeader(int labNum, int questionNum, String fName, String lName, String mission) {
		// Find the longest string.
		int numAst = 0;
		if ((fName.length() + lName.length() + 1) > mission.length()) {
			numAst = (fName.length() + lName.length() + 1);
		} else {
			numAst = mission.length();
		}

		// Make the header.
		for (int i = 1; i <= numAst; i++) {
			System.out.print("*");
		}
		System.out.println("\n" + mission);
		for (int j = 1; j <= numAst; j++) {
			System.out.print("*");
		}
		System.out.println("\nLab " + labNum);
		System.out.println("Question " + questionNum);
		System.out.println("Name: " + fName + " " + lName);
		for (int k = 1; k <= numAst; k++) {
			System.out.print("*");
		}
	}

	// Method to populate the deck.
	public static void populateDeck(String[] deck, String[] suits) {
		// Initialize hearts.
		for (int j = 0; j < 13; j++) {
			deck[j] = ((j + 1) + suits[0]);
		}
		// Initialize clubs.
		for (int k = 13; k < 26; k++) {
			deck[k] = ((k - 12) + suits[1]);
		}
		// Initialize diamonds.
		for (int l = 26; l < 39; l++) {
			deck[l] = ((l - 25) + suits[2]);
		}
		// Initialize clubs.
		for (int m = 39; m < 52; m++) {
			deck[m] = ((m - 38) + suits[3]);
		}
		// Index through all the cards and send them through the show value method.
		// for (int p = 0; p < 52; p++) {
		// deck[p] = showCard(deck[p]);
		// }
	}

	// Method to correct the value of the cards.
	public static String showCard(String cardValue) {
		// Check if the card number is a one and the second number is a letter.
		if (cardValue.charAt(0) == '1' && (cardValue.charAt(1) == 'H' || cardValue.charAt(1) == 'C'
				|| cardValue.charAt(1) == 'D' || cardValue.charAt(1) == 'S')) {
			// Check which suit the card is.
			if (cardValue.charAt(1) == 'H') {
				cardValue = "AH";
			} else if (cardValue.charAt(1) == 'C') {
				cardValue = "AC";
			} else if (cardValue.charAt(1) == 'D') {
				cardValue = "AD";
			} else if (cardValue.charAt(1) == 'S') {
				cardValue = "AS";
			}
		} else if (cardValue.charAt(1) == '1') { // Check if the second number is a one for Jack.
			// Check which suit the card is.
			if (cardValue.charAt(2) == 'H') {
				cardValue = "JH";
			} else if (cardValue.charAt(2) == 'C') {
				cardValue = "JC";
			} else if (cardValue.charAt(2) == 'D') {
				cardValue = "JD";
			} else if (cardValue.charAt(2) == 'S') {
				cardValue = "JS";
			}
		} else if (cardValue.charAt(1) == '2') { // Check if the second number is a 2 for Q.
			// Check which suit the card is.
			if (cardValue.charAt(2) == 'H') {
				cardValue = "QH";
			} else if (cardValue.charAt(2) == 'C') {
				cardValue = "QC";
			} else if (cardValue.charAt(2) == 'D') {
				cardValue = "QD";
			} else if (cardValue.charAt(2) == 'S') {
				cardValue = "QS";
			}
		} else if (cardValue.charAt(1) == '3') { // Check if the second number is a 3 for K.
			// Check which suit the card is.
			if (cardValue.charAt(2) == 'H') {
				cardValue = "KH";
			} else if (cardValue.charAt(2) == 'C') {
				cardValue = "KC";
			} else if (cardValue.charAt(2) == 'D') {
				cardValue = "KD";
			} else if (cardValue.charAt(2) == 'S') {
				cardValue = "KS";
			}
		}
		return cardValue;
	}

	// Method to draw a card.
	public static String drawCard(String[] deck) {
		// Declare required variables.
		boolean validCard = false;
		int cardAddress = 0;
		String returnCard = "";

		// Loop to get a valid card.
		while (!validCard) {
			// Generate a random number for the card address.
			cardAddress = (int) (Math.random() * 52);
			// Check if the card has already been drawn.
			if (deck[cardAddress] != "**") {
				// Exit the loop.
				validCard = true;
				// Set return card equal to ** so it can't be used again.
				returnCard = deck[cardAddress];
				deck[cardAddress] = "**";
			}
		}
		return returnCard;
	}
}
