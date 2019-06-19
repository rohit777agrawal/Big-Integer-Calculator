
import java.util.Scanner;

/**
 * @author Larry
 *
 */
public class BigIntMathTesterOne
{
	private static Scanner keyboard = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
/** 
 * Sample valid input and resulting output
 * 	"44444444445555555555666666666677777777770000000000" 
 * stores ["4","4","4","4","4","4","4","4","4","4","5","5","5","5","5","5","5","5","5","5","6","6","6","6","6","6","6'<'6","6","6","7","7","7","7","7","7","7","7","7","7","0","0","0","0","0","0","0","0","0","0"] in ArrayList and sets the value to positive
 *returns string "44444444445555555555666666666677777777770000000000"
 * "100000" stores ["1","0","0","0","0","0"] in ArrayList and sets the value to positive
 *returns string "100000"
 *"+0" stores ["0"] in ArrayList and sets the value to positive
 *returns string "0"
 *"-0" stores ["0"] in ArrayList and sets the value to positive
 *returns string "0"
 *"-0023401" stores ["2","3","4","0","1"] in ArrayList and sets the value to negative
 *returns string "-23401"
 *-00100000 stores ["1","0","0","0","0","0"] in ArrayList and sets the value to negative
 *returns string "-100000"
 *Sample errors
 *"5stt7" stores empty ArrayList, sets value to positive and returns string "empty" 
 *"+" stores empty ArrayList, sets value to positive and returns "empty"
 *"-" stores empty ArrayList, sets value to positive and returns "empty"
 *"   500" stores empty ArrayList, sets value to positive and returns "empty"
 * 
 */
		BigInt bigNumberOne = null;
		String yesNo = "no";
		String menuChoice = "q";
		BigInt bigNumberTwo = null;
		BigInt bigNumberAnswer = null;

		System.out.println("This program will perform basic math on large integer numbers");
		do
		{
			bigNumberOne = inputBigInteger();
			bigNumberTwo = inputBigInteger();
			System.out.println("You input the following integer numbers:\n" + 
					bigNumberOne + "\n" + 
					bigNumberTwo);
			System.out.println("You may perform one of the following opperations:");
			System.out.println("1. Add");
			System.out.println("2. Subtract the first number from the second number");
			System.out.println("3. Subtract the second number from the first number");
			System.out.println("4. Multiplication");
			System.out.println("5. Ignore numbers and start over");
			do
			{
				System.out.println("Please enter a menu choice number.");
				menuChoice = keyboard.nextLine();
			}while(!menuChoice.matches("([1-4])"));
			switch(menuChoice)
			{
			case "1":
				System.out.println("Adding " + bigNumberOne + " to " + bigNumberTwo);
				bigNumberAnswer = bigNumberOne.add(bigNumberTwo);
				break;
			case "2":
				System.out.println("Subtracting " + bigNumberOne + " from " + bigNumberTwo);
				bigNumberAnswer = bigNumberOne.subtract(bigNumberTwo);
				break;
			case "3":
				System.out.println("Subtracting " + bigNumberTwo + " from " + bigNumberOne);
				bigNumberAnswer = bigNumberOne.subtract(bigNumberTwo);
				break;
			case "4":
				System.out.println("Multiplying " + bigNumberOne + " by " + bigNumberTwo);
				bigNumberAnswer = bigNumberTwo.multiply(bigNumberOne);
				break;
			default:
				break;
			}
			System.out.println("Produces: " + bigNumberAnswer);
			System.out.println("Would you like to enter new numbers?");
			do
			{
				System.out.println("Please enter yes or no");
				yesNo = keyboard.nextLine();
				
			}while(!yesNo.equalsIgnoreCase("yes") && !yesNo.equalsIgnoreCase("no"));
		}while(yesNo.equalsIgnoreCase("yes"));

	}

	private static BigInt inputBigInteger()
	{
		BigInt newBigInt = null;
		String userIntInput = null;
		do 
		{
			try 
			{
				System.out.println("Please enter an integer of any size.");
				userIntInput = keyboard.nextLine();
				newBigInt = new BigInt(userIntInput);
			}
			catch(Exception myException)
			{
				System.out.println(myException.getMessage());
				newBigInt = null;
			}
		}while(newBigInt == null);
		return newBigInt;
	}
	

}

