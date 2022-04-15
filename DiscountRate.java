package BeautySalon;

//----------------------------------------------------
//Assignment 1 Question 2
//Written by: Matthew Penny #219-5150
//For Application Development 2 (Mobile) - Winter 2022
//----------------------------------------------------

/* My program will create Customers of a beauty salon and generate a bill for their visit. Based on the loyalty
* program of the beauty salon, the customer will receive a discount of 10-20% for the services and a current flat
* rate of 10%, although this can change at a later date. Non member customers will not receive any discount. There
* toString methods to override the default method, and the classes are set up as per instructions given.
*/

public class DiscountRate {

	private static double serviceDiscountPremium = 0.2;
	private static double serviceDiscountGold = 0.15;
	private static double serviceDiscountSilver = 0.1;

	private static double productDiscountPremium = 0.2;
	private static double productDiscountGold = 0.15;
	private static double productDiscountSilver = 0.1;

	/*
	 * The methods below are set will take in a String and determine the level of
	 * membership in the loyalty program. I used .equalsIgnorCase() as my choice as
	 * many people neglect to add capitals when adding information. Essentially, if
	 * a customer has the relevant level, they receive the discount amount. Non
	 * members do not receive anything.
	 */

	private static double getServiceDiscountRate(String memberType) {

		if (memberType.equalsIgnoreCase("premium")) {
			return 0.2;
		} else if (memberType.equalsIgnoreCase("gold")) {
			return 0.15;
		} else if (memberType.equalsIgnoreCase("silver")) {
			return 0.1;
		} else {
			return 0;
		}
	}

	private static double getProductDiscountRate(String memberType) {

		if (memberType.equalsIgnoreCase("premium") || (memberType.equalsIgnoreCase("gold"))
				|| (memberType.equalsIgnoreCase("silver"))) {
			return 0.1;
		} else {
			return 0;
		}
	}
}
