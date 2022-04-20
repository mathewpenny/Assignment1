package PasswordGenerator;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordGenerator2 {

	public String generateLine(String book[][][]) {
		Random random = new Random();

		// First step is choosing page number, paragraph number and line number by using
		// Random class and nextInt() method
		String chosenLine = "";

		// do / while loop runs once and checks against the amount of paragraphs and
		// lines. If they go out of bounds, the randomizer for each runs again.
		do {

			// using this variable to set the range of pages, starting from 0 and excluding
			// length
			int pageLength = book.length;
			int randomPageNumber = random.nextInt(pageLength); // generate a page number

			int paragraphAmount = book[randomPageNumber].length; // generate a paragraph number up to number of
																	// paragraphs on random page
			int randomParagraphNumber = random.nextInt(paragraphAmount);

			int lineAmount = book[randomPageNumber][randomParagraphNumber].length;
			int randomLineNumber = random.nextInt(lineAmount);

			// once these three are generated, we can look at the line that is chosen
			chosenLine = book[randomPageNumber][randomParagraphNumber][randomLineNumber];

		} while (chosenLine == null);
		return chosenLine;
	}

	// a method to return true if the word is only a single character, false if more
	// than one character
	public static boolean checkWordLength(String word) {
		if (word.length() != 1) {
			return true;
		} else {
			return false;
		}
	}

	// A method that takes in the String array of the three chosen words and
	// compares them to each other.
	// If there is no match, it returns true, else returns false
	public static boolean differentWords(String array[]) {
		String word = array[0], word2 = array[1], word3 = array[2];
		boolean good = true;

		if (word.equals(word2) || word.equals(word3) || word2.equals(word3)) {
			good = false;
		} else {
			good = true;
		}
		return good;
	}

	// A method that checks for length of password between 8 and 16 characters.
	// Returns true if yes,
	// false if no.
	public static boolean lengthOfPassword(String password) {
		int passwordLength = password.length();

		if (passwordLength >= 8 && passwordLength <= 16) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * A method that checks for at least one capital letter. I used flag and break,
	 * the flag increments with each capital and if there is more than one there is
	 * no point in continuing so we break the loop. I used the ASCII values to check
	 * for the capitals. I checked in several places to ensure that charAt() is a
	 * String method.
	 */
	public static boolean hasCapitalLetter(String password) {
		int flag = 0;

		for (int i = 0; i < password.length(); i++) {
			if ((password.charAt(i) >= 65) && (password.charAt(i) <= 90))
				flag++;
		}
		if (flag == 1) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * A method that checks for at least one lower case letters. I used flag and
	 * break, the flag increments with at each lower case letter, if there is more
	 * than one there is no point in continuing so we break the loop. I used the
	 * ASCII values to check for the letter. Again, checked in many places to ensure
	 * that charAt() is a String method.
	 */
	public static boolean hasLowercaseLetters(String password) {
		int flag = 0;

		for (int i = 0; i < password.length(); i++) {
			if ((password.charAt(i) >= 97) && (password.charAt(i) <= 122))
				flag++;
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * A method that checks for at least one lower case letters. I used flag and
	 * break, the flag increments with at each lower case letter, if there is more
	 * than one there is no point in continuing so we break the loop. I used the
	 * ASCII values to check for the special characters. I checked for all just to
	 * be sure that nothing was missed. Again, checked in many places to ensure that
	 * charAt() is a String method.
	 */
	public static boolean hasSpecialCharacter(String password) {
		int flag = 0;

		for (int i = 0; i < password.length(); i++) {
			if ((password.charAt(i) >= 33) && (password.charAt(i) <= 47)
					|| ((password.charAt(i) >= 58) && (password.charAt(i) <= 64))) {
				flag++;
			}
		}
		if (flag == 1) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		/*
		 * Starting with a password object, we randomly choose a page, paragraph and
		 * line. Once chosen, the line goes through the methods to ensure that it meets
		 * all specifications. Each time a method returns false, a specific counter
		 * increments. Once we get a password that matches all specifications, it will
		 * be printed and this will continue until either 10,000 passwords or a password
		 * is generated with 0 lower case letters. Either way, the program will say
		 * goodbye!
		 */
		// http://www.gutenberg.org/cache/epub/19033/pg19033.txt
		final String[][][] book = { { { "ALICE was beginning to get very tired of sitting by her sister on the\n",
				"bank, and of having nothing to do. Once or twice she had peeped into the\n",
				"book her sister was reading, but it had no pictures or conversations in\n",
				"it, \"and what is the use of a book,\" thought Alice, \"without pictures or\n", "conversations?\"\n" },
				{ "So she was considering in her OWN mind (as well as she could, for the\n",
						"day made her feel very sleepy and stupid), whether the pleasure of\n",
						"making a daisy-chain would be worth the trouble of getting up and\n",
						"picking the daisies, when suddenly a White Rabbit with pink eyes ran\n", "close by her.\n" },
				{ "There was nothing so very remarkable in that, nor did Alice think it so\n",
						"very much out of the way to hear the Rabbit say to itself, \"Oh dear! Oh\n",
						"dear! I shall be too late!\" But when the Rabbit actually took a watch\n",
						"out of its waistcoat-pocket and looked at it and then hurried on, Alice\n",
						"started to her feet, for it flashed across her mind that she had never\n",
						"before seen a rabbit with either a waistcoat-pocket, or a watch to take\n",
						"out of it, and, burning with curiosity, she ran across the field after\n",
						"it and was just in time to see it pop down a large rabbit-hole, under\n",
						"the hedge. In another moment, down went Alice after it!" } },
				{ { "\"WHAT a curious feeling!\" said Alice. \"I must be shutting up like a\n", "telescope!\"\n" },
						{ "And so it was indeed! She was now only ten inches high, and her face\n",
								"brightened up at the thought that she was now the right size for going\n",
								"through the little door into that lovely garden.\n" },
						{ "After awhile, finding that nothing more happened, she decided on going\n",
								"into the garden at once; but, alas for poor Alice! When she got to the\n",
								"door, she found she had forgotten the little golden key, and when she\n",
								"went back to the table for it, she found she could not possibly reach\n",
								"it: she could see it quite plainly through the glass and she tried her\n",
								"best to climb up one of the legs of the table, but it was too slippery,\n",
								"and when she had tired herself out with trying, the poor little thing\n",
								"sat down and cried.\n" },
						{ "\"Come, there's no use in crying like that!\" said Alice to herself rather\n",
								"sharply. \"I advise you to leave off this minute!\" She generally gave\n",
								"herself very good advice (though she very seldom followed it), and\n",
								"sometimes she scolded herself so severely as to bring tears into her\n", "eyes.\n" },
						{ "Soon her eye fell on a little glass box that was lying under the table:\n",
								"she opened it and found in it a very small cake, on which the words \"EAT\n",
								"ME\" were beautifully marked in currants. \"Well, I'll eat it,\" said\n",
								"Alice, \"and if it makes me grow larger, I CAN reach the key; and if it\n",
								"makes me grow smaller, I can creep under the door: so either way I'll\n",
								"get into the garden, and I don't care which happens!\"\n" },
						{ "She ate a little bit and said anxiously to herself, \"Which way? Which\n",
								"way?\" holding her hand on the top of her head to feel which way she was\n",
								"growing; and she was quite surprised to find that she remained the same\n",
								"size. So she set to work and very soon finished off the cake." } },
				{ { "The King and Queen of Hearts were seated on their throne when they\n",
						"arrived, with a great crowd assembled about them--all sorts of little\n",
						"birds and beasts, as well as the whole pack of cards: the Knave was\n",
						"standing before them, in chains, with a soldier on each side to guard\n",
						"him; and near the King was the White Rabbit, with a trumpet in one hand\n",
						"and a scroll of parchment in the other. In the very middle of the court\n",
						"was a table, with a large DISH of tarts upon it. \"I wish they'd get the\n",
						"trial done,\" Alice thought, \"and hand 'round the refreshments!\"\n" },
						{ "The judge, by the way, was the King and he wore his crown over his great\n",
								"wig. \"That's the jury-box,\" thought Alice; \"and those twelve creatures\n",
								"(some were animals and some were birds) I suppose they are the jurors.\"\n" },
						{ "Just then the White Rabbit cried out \"Silence in the court!\"\n" },
						{ "\"HERALD! read the accusation!\" said the King." } } };
		Random random = new Random();
		int passwordCount = 0;
		
		PasswordGenerator2 password = new PasswordGenerator2();
		
		
		int singleCharCount = 0, newLineCount = 0, equalsCount = 0, lengthCount = 0, capitalLetterCount = 0,
				lowerLetterCount = 0, specialCharacterCount = 0, randomWordInt = 0;
		
		String chosenLine = "";

		while (passwordCount < 10) {

			// Generate the chosen line using the generateLine method then split into array
			// of words
			chosenLine = password.generateLine(book);
			String wordArray[] = chosenLine.split(" ");
			randomWordInt = 0;
			String word = "", threeWords = "", newLine = "\n";
			// an array to hold the words separately for checking if they are the same
			String substringArray[] = new String[3];

			// for loop from 0 to  to take in the three words required for the password.
			for (int i = 0; i < 3;) {

				randomWordInt = random.nextInt(wordArray.length);
				word = wordArray[randomWordInt]; // randomly choose a word

				if (checkWordLength(word) == true && word.contains(newLine) == false) {
					threeWords += word;
					substringArray[i] = word;
					i++;
					continue;
				} else if (checkWordLength(word) == false) {
					singleCharCount++;
					continue;
				} else if (word.contains(newLine) == true) {
					newLineCount++;
					continue;
				}
			}

			// once all three words are together, start checking specifications.
			// 1) if any words are the same, increment count and generate a new line else
			// move on
			if (differentWords(substringArray) == false) {
				equalsCount++;
				chosenLine = password.generateLine(book);
			}

			// 2) if the length of the password is not between 8 and 16, increment count and
			// generate
			// a new line else move on
			else if (lengthOfPassword(threeWords) == false) {
				lengthCount++;
				chosenLine = password.generateLine(book);
			}

			// 3) if there is more than one or if there is no capital letters, increment
			// count and
			// generate new line else move on
			else if (hasCapitalLetter(threeWords) == false) {
				capitalLetterCount++;
				chosenLine = password.generateLine(book);
			}

			// 4) if there is no lower case letters, increment
			// count and
			// generate new line else move on
			else if (hasLowercaseLetters(threeWords) == false) {
				lowerLetterCount++;
				chosenLine = password.generateLine(book);
			}

			// 5) if there is more than one or if there is no special characters, increment
			// count and
			// generate new line else move on
			else if (hasSpecialCharacter(threeWords) == false) {
				specialCharacterCount++;
				chosenLine = password.generateLine(book);
			}

			// 6) Now the password has met all specifications so we can print the password
			// along
			// with all of the counts. Then rest all counts to 0, except for password count and start with
			// a new chosenLine
			else {
				System.out.println(threeWords + "\n" + " ");
				System.out.print(singleCharCount + " " + newLineCount + " " + equalsCount + " " + lengthCount + " "
						+ capitalLetterCount + " " + lowerLetterCount + " " + specialCharacterCount + "\n");
				
				passwordCount++;
				
			}
			
		}

	}

}
