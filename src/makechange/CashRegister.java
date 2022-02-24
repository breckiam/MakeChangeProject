package makechange;

import java.util.Scanner;

public class CashRegister {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		
		boolean keepGoing = true;

		
		while (keepGoing) {
			// initialize double inside of loop to 0 each time loop repeats
			double total = 0, paid = 0, changeDue = 0;

			System.out.println("----------------Main Menu-----------------");
			System.out.println("Please choose from the folllowing options:");
			System.out.println("1: Jims burger shop");
			System.out.println("2: Tonys Tacos");
			System.out.println("3: Manual Cash Register");
			System.out.println("4: Quit");

			String choice = kb.next();

			switch (choice) {
			case "1":
			case "jims":
			case "burger":
				total = jimsBurger(kb);
				if (total == 0) {
					System.out.println("Invalid choice, please try again");
				}
				break;
			case "2":
			case "tonys":
			case "tacos":
				total = tonysTacos(kb);
				if (total == 0) {
					System.out.println("Invalid choice, please try again");
				}
				break;
			case "3":
			case "manual":
				total = manualCash(kb);
				break;
			case "4":
			case "quit":
				System.out.println("Goodbye :)");
				keepGoing = false;
				break;
			default:
				System.out.println("Please enter a vaid choice");
				total = 0;
			}

			// keeps CashRegister from running from and prompting user to enter any more
			// info in
			// and restarts them back at the main menu.
			if (total != 0) {

				// promt for amount paid
				System.out.print("Enter total amount paid: ");
				paid = kb.nextDouble();

				// Amount owed back
				changeDue = paid - total;

				// Displays message if total payed is less than total cost, and runs
				// cahsRegister () otherwise
				if (changeDue < 0) {
					double paidTemp = 12;
					while (changeDue < 0 && paidTemp != 0) {
						System.out.println("Silly goose, you need more moolah :)$$$");
						// Change due is switched to a positive value for Sysout
						System.out.println("You are short: $" + Math.abs(changeDue));
						System.out.println("Enter extra payment or 0 to quit");
						paidTemp = kb.nextDouble();

						// Quit program on entry of 0
						if (paidTemp == 0) {
							System.out.println("Goodbye :)");
							keepGoing = false;
							break;
						}
						changeDue = (paid + paidTemp) - total;
					}
					// Runs method for calc after change due is no longer negative
					System.out.println("Change due: $" + Math.round(changeDue * 100.0) / 100.0);
					cashRegister(changeDue);
				} else {
					System.out.println("Change due: $" + Math.round(changeDue * 100.0) / 100.0);
					cashRegister(changeDue);
				}
			}

		}

		kb.close();
	}

	public static double howManyBills(double billValue, double bills, double changeBack) {
		// Checks if modulus returns same value to Change due.
		// If modulus = changeBack --> billValue > changeBack
		if (bills == changeBack) {
			return 0;
		} else {
			changeBack -= bills;
			changeBack = changeBack / billValue;
			return changeBack;
		}

	}

	public static int howManyCents(int coinValue, int coins, int changeBack) {
		// Checks if modulus returns same value to Change due.
		// If modulus = changeBack --> billValue > changeBack
		if (coins == changeBack) {
			return 0;
		} else {
			changeBack -= coins;
			changeBack = changeBack / coinValue;
			return changeBack;
		}
	}

	public static void cashRegister(double changeDue) {
		// Calc # twenties, then update ChangeDue
		double twenty = changeDue % 20;
		twenty = howManyBills(20, twenty, changeDue);
		// If twenties is 0 no sysout or chaneDue update 
		if (twenty != 0 ) {
		changeDue -= twenty * 20;
		System.out.println("Twenties: " + (int) twenty);
		}

		// Calc # tens, then update ChangeDue
		double ten = changeDue % 10;
		ten = howManyBills(10, ten, changeDue);
		// If ten is 0 no sysout or chaneDue update 
		if (ten != 0 ) {
		changeDue -= ten * 10;
		System.out.println("Tens: " + (int) ten);
		}
		
		// Calc # tens, then update ChangeDue
		double five = changeDue % 5;
		five = howManyBills(5, five, changeDue);
		// If five is 0 no sysout or chaneDue update 
		if (five != 0 ) {
		changeDue -= five * 5;
		System.out.println("Fives: " + (int) five);
		}
		
		// Calc # tens, then update ChangeDue
		double one = changeDue % 1;
		one = howManyBills(1, one, changeDue);
		// If one is 0 no sysout or chaneDue update 
		if (one != 0 ) {
		changeDue -= one * 1;
		System.out.println("Ones: " + (int) one);
		}
		
		/*
		 * Takes in left over of changeDue, and moves decimal over two places. (ex: 0.67
		 * to 67.0) Then casts to an int and assigns to new int var centsDue.
		 */

		int centsDue = (int) (Math.round(changeDue * 100));

		// ALL Cents values are *100 to match CentsDue (ex: 0.25 = 25)
		// Calc # dimes, then update ChangeDue
		int quarter = centsDue % 25;
		quarter = howManyCents(25, quarter, centsDue);
		// If quarter is 0 no sysout or chaneDue update
		if (quarter != 0) {
		centsDue -= quarter * 25;
		System.out.println("Quarters: " + quarter);
		}
		
		// Calc # dimes, then update ChangeDue
		int dime = centsDue % 10;
		dime = howManyCents(10, dime, centsDue);
		// If dime is 0 no sysout or chaneDue update
		if (dime != 0 ) {
		centsDue -= dime * 10;
		System.out.println("Dimes: " + dime);
		}
		
		// Calc # nickels, then update ChangeDue
		int nickel = centsDue % 5;
		nickel = howManyCents(5, nickel, centsDue);
		// If nickel is 0 no sysout or chaneDue update
		if (nickel != 0 ) {
		centsDue -= nickel * 5;
		System.out.println("Nickels: " + nickel);
		}
		
		// Calc # pennies
		int penny = centsDue % 1;
		penny = howManyCents(1, penny, centsDue);
		// If penny is 0 no sysout
		if (penny != 0 ) {
		System.out.println("Pennies: " + penny);
		}
		
		System.out.println();
	}

	public static double jimsBurger(Scanner kb) {

		System.out.println("-----------Menu------------");
		System.out.println("What would you like to eat?");
		System.out.println("Enter 1-4 to make a choice: ");
		System.out.println();
		System.out.println("1: Single burger meal $10.54");
		System.out.println("2: Double burger meal $13.45");
		System.out.println("3: Basket of fries    $3.29");
		System.out.println("4: Drink              $2.12");

		int choice = kb.nextInt();

		switch (choice) {
		case 1:
			return 10.54;
		case 2:
			return 13.45;
		case 3:
			return 3.29;
		case 4:
			return 2.12;
		default:
			return 0;

		}
	}

	public static double tonysTacos(Scanner kb) {

		System.out.println("-----------Menu------------");
		System.out.println("What would you like to eat?");
		System.out.println("Enter 1-4 to make a choice: ");
		System.out.println();
		System.out.println("1: el pastor     $7.65");
		System.out.println("2: Carne asada   $6.77");
		System.out.println("3: Quesadilla    $10.29");
		System.out.println("4: Drink         $2.12");

		int choice = kb.nextInt();

		switch (choice) {
		case 1:
			return 7.65;
		case 2:
			return 6.77;
		case 3:
			return 10.29;
		case 4:
			return 2.12;
		default:
			return 0;

		}
	}

	public static double manualCash(Scanner kb) {

		// Prompt user for cost
		System.out.print("Please enter the total cost: ");
		double total = kb.nextDouble();

		return total;
	}
	


}
