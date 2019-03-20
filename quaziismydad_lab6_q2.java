package 1327372_lab6;
import java.util.Scanner;
public class 1327372_lab6_q2 {

	// Copying me gets us both zero. Just use this as inspiration.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Declare required variables.
		int numRolls = 0;
		int numEach[] = new int[6];
		double standardDev = 0.0, total = 0;
		
		//Initialize this to be 0.
		for (int k = 0; k < 6; k++) {
			numEach[k] = 0;
		}
		
		//Enable the scanner.
		Scanner inputScanner = new Scanner(System.in);
		
		//Ask the user how many rolls.
		System.out.println("Please enter desired number of rolls:");
		numRolls = inputScanner.nextInt();
		
		//Create the array.
		int results[] = new int[numRolls];
		
		//For loop to roll the dice an amount of times.
		for (int i = 0; i < numRolls; i++) {
			results[i] = rollDice();
			//Calculate the number of each result.
			if (results[i] == 1) {
				numEach[0]++;
			}
			else if (results[i] == 2) {
				numEach[1]++;
			}
			else if (results[i] == 3) {
				numEach[2]++;
			}
			else if (results[i] == 4) {
				numEach[3]++;
			}
			else if (results[i] == 5) {
				numEach[4]++;
			}
			else if (results[i] == 6) {
				numEach[5]++;
			}
			//Add current number to the total.
			total += results[i];
		}
		//Calculate the standard deviations.
		for(int j = 0; j < numRolls; j++) {
			standardDev = (results[j] - (total - numRolls))/numRolls;
			standardDev = Math.sqrt(Math.abs(standardDev));
		}
		
		//Output all the results.
		System.out.println("\nHere are the statistics:");
		System.out.println("1's: " + numEach[0]);
		System.out.println("2's: " + numEach[1]);
		System.out.println("3's: " + numEach[2]);
		System.out.println("4's: " + numEach[3]);
		System.out.println("5's: " + numEach[4]);
		System.out.println("6's: " + numEach[5]);
		System.out.println("Mean: " + (total/numRolls));
		System.out.println("Standard Deviations: " + standardDev);
		
	}

	// Create a method to generate a random number 1 to 6.
	public static int rollDice() {
		// Declare required variables.
		int randomInt = 0;
		// Generate the random int.
		randomInt = (int) ((Math.random() * 6) + 1);
		// Return it.
		return randomInt;
	}
}
