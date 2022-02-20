package makechange;

import java.util.Scanner;

public class CashRegister {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);

		// Prompt user for cost
		System.out.print("Please enter the total cost: ");
		double total = kb.nextDouble();

		// Prompt user for amount paid
		System.out.print("Please enter amount paid: ");
		double paid = kb.nextDouble();

		// Amount owed back
		double changeDue = paid - total;

		// Displays message if total payed is less than total cost, and runs
		// cahsRegister () otherwise
		if (changeDue < 0) {
			System.out.println("Silly goose, you need more moolah :)$$$");
			// Change due is switched to a positive value for Sysout
			System.out.println("You are short: $" + Math.abs(changeDue));
		} else {
			System.out.println("Change due: $" + Math.round(changeDue * 100.0) / 100.0);
			cashRegister(changeDue);
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
		changeDue -= twenty * 20;

		// Calc # tens, then update ChangeDue
		double ten = changeDue % 10;
		ten = howManyBills(10, ten, changeDue);
		changeDue -= ten * 10;

		// Calc # tens, then update ChangeDue
		double five = changeDue % 5;
		five = howManyBills(5, five, changeDue);
		changeDue -= five * 5;

		// Calc # tens, then update ChangeDue
		double one = changeDue % 1;
		one = howManyBills(1, one, changeDue);
		changeDue -= one * 1;

		/*
		 * Takes in left over of changeDue, and moves decimal over two places. (ex: 0.67
		 * to 67.0) Then casts to an int and assigns to new int var centsDue.
		 */

		int centsDue = (int) (Math.round(changeDue * 100));

		// ALL Cents values are *100 to match CentsDue (ex: 0.25 = 25)
		// Calc # dimes, then update ChangeDue
		int quarter = centsDue % 25;
		quarter = howManyCents(25, quarter, centsDue);
		centsDue -= quarter * 25;

		// Calc # dimes, then update ChangeDue
		int dime = centsDue % 10;
		dime = howManyCents(10, dime, centsDue);
		centsDue -= dime * 10;

		// Calc # nickels, then update ChangeDue
		int nickel = centsDue % 5;
		nickel = howManyCents(5, nickel, centsDue);
		centsDue -= nickel * 5;

		// Calc # pennies
		int penny = centsDue % 1;
		penny = howManyCents(1, penny, centsDue);

		// Sysout results, bills are cast to int for visual purpose.
		System.out.println("Twenties: " + (int) twenty);
		System.out.println("Tens: " + (int) ten);
		System.out.println("Fives: " + (int) five);
		System.out.println("Ones: " + (int) one);
		System.out.println("Quarters: " + quarter);
		System.out.println("Dimes: " + dime);
		System.out.println("Nickels: " + nickel);
		System.out.println("Pennies: " + penny);
	}

}
