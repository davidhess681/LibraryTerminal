import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

public class Prompt {
	static Scanner input = new Scanner(System.in);
	public static boolean YesOrNo()
    {
        while (true)
        {
            String response = input.nextLine();
            if (response == "y" || response == "yes")
            {
                return true;
            }
            else if (response== "n" || response == "no")
            {
                return false;
            }
            else
            {
                System.out.println("Invalid input, try with yes or no: ");
                continue;
                //loops to top
            }
        }
    }
	public static String TitleCaseString()
    {
        while (true)
        {
            String sentence = input.nextLine();
            if (sentence == null)
            {
            	System.out.println("Error, please enter a title: "); //if theres no input, returns nothing
                continue;
            }
            StringUtils.capitalize(sentence);
            return sentence;                     //joins all the words back into a sentence
        }
    }
	public static String ValidTitle() {
		System.out.println("\nPlease input keywords you wish to search for: ");
		while (true) {
			String title = input.nextLine();
			if (title.isEmpty() || title.length() > 35) {
				System.out.println("That is not correct input, try again: ");
				continue;
			}
			return title;
			
		}
	}
	private static int ValidNum(int minRange, int maxRange) {
		while(true) {
			try {
				int num = input.nextInt();
				if (num >= minRange && num <= maxRange) {
					return num;
				}
				else {
					System.out.println("Input out of range. Try again: ");
				}
			}
			catch (InputMismatchException e) {
				System.out.println("Invalid input, try again: ");
			}
		}
	}
	public static int MenuChoice() {
		System.out.println("\n1. List All Books\n2. Search\n3. Checkout Book\n4. Return Book\n5. Add Book\n6. Quit Program");
		System.out.println("\nPlease enter a menu number: ");
		return ValidNum(1, 6);
	}
	public static int SearchChoice(int searchLength) {
		System.out.println("\nSelect a book by number: ");
		return ValidNum(1, searchLength);
	}
	public static boolean ByTitleOrAuthor() {
		System.out.println("What would you like to search?\n\n1. By Title or 2. By Author\nPlease Enter Number:  ");
		return ValidNum(1, 2) == 1;
	}
}
