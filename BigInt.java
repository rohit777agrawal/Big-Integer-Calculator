import java.util.ArrayList;
/** 
 * 
 * @author rohitagrawal
 *
 */

public class BigInt {
	
	/**
	 * START
	 * ARRAYLIST<STRING> input
	 * BOOLEAN flag
	 * STRING number
	 */

	private ArrayList<String> input = new ArrayList<>();
	private boolean flag = true;
	private String number;
	
	/**
	 * CONSTRUCTOR BigInt
	 * PRE-CONDITION ->> There should be all the instance variable.
	 * POST-CONDITION ->> All the instance variable will be initialize
	 */
	public BigInt()
	{
		this.flag = true;
		this.number = "";
		this.input.clear();
	}
	
	/**
	 * CONSTRUCTOR BigInt
	 * @param number
	 * @throws BigIntException
	 * START
	 * IF string is only + or - 
	 *   throw exception
	 * ELSE IF contains blankspaces
	 *   throw exception
	 * else
	 *   initialize this.number
	 *   call method setSignAndRemoveItIfItIsThere();
	 *   edit this.number by method removeZeros(this.number) and remove zeros
	 *   call method addToArray()
	 */
	public BigInt(String number) throws BigIntException
	{
		
			if (number.equals("+") || number.equals("-")) 
			{
				throw new BigIntException("could not be '+' or '-' only!");
			}
			else if (number.contains(" "))
			{
				throw new BigIntException("No blankspaces allowed!");
			}
			else
			{
				this.number = number;
				setSignAndRemoveItIfItIsThere();
				this.number = removeZeros(this.number);
				addToArray();
			}
		
		
	}
	
	/**
	 * METHOD toString
	 * @return BigInt in words
	 */
	public String toString() {
		return "BigInt [input=" + input + ", flag=" + flag + ", number=" + number + "]";
	}
	
	/**
	 * METHOD setSignAndRemoveItIfItIsThere()
	 * PRE-CONDITION --> this.number should have input
	 * POST-CONDITION --> if there is '+' or '-' in front then remove it and set the flag to true(+) or false (-)
	 * START
	 * IF this.number first character is '+' 
	 *    set flag to true and remove '+'
	 * IF this.number first character is '-'
	 *    set flag to false and remove '-'
	 */
	private void setSignAndRemoveItIfItIsThere ()
	{
		if (this.number.charAt(0) == '+')
		{
			flag = true;
			this.number = this.number.replace("+", "");
		}
		if (this.number.charAt(0) == '-')
		{
			flag = false;
			this.number = this.number.replace("-", "");
		}
	}
	
	/**
	 * METHOD removeZeros
	 * @param number
	 * @return number
	 * PRE-CONDITION --> this.number should have value
	 * POST-CONDITION --> If any zeros in front, then it is remove and return number. 
	 * START
	 * BOOLEAN found
	 * INT length set to number's length
	 * FOR 
	 * 		INT i, i<length && found, i++
	 * 		IF number starts with zero
	 * 			replace 0 with blank
	 * 		ELSE 
	 * 			set found to false
	 */
	private String removeZeros(String number)
	{
		boolean found = true;
		int length = number.length();
		for (int i =0; i< length && found; i++)
		{
			if (number.startsWith("0"))
			{
				number = number.replaceFirst("0", "");
			}
			else
			{
				found = false;
			}
		}
		return number;
	}
	
	/**
	 * METHOD addToArray
	 * @throws BigIntException
	 * PRE-CONDITION --> this.number should have value 
	 * 				 there should be an array to input data
	 * POST-CONDITION --> all the number should be added to array
	 * START 
	 * FOR 
	 * 		int i, i<length of number, i increase by 1
	 * 		IF  character is digit at that position 
	 * 			add to array
	 * 		ELSE
	 * 			throw exception
	 * REPEAT until finished. 
	 */
	private void addToArray() throws BigIntException
	{
		for (int i = 0; i< this.number.length(); i++)
		{
			if (Character.isDigit(this.number.charAt(i)))
			{
				String add = this.number.substring(i, (i+1));
				input.add(add);
			}
			else
			{
				throw new BigIntException("Invalid Character!");
			}	
		
		}
	}
	
	/**
	 * METHOD addToArray 
	 * PRE-CONDITION --> there should be number to add to array
	 * POST-CONDITION --> the number is added to array and array is returned.
	 * @param number
	 * @return Array 
	 * START
	 * ARRAYLIST<STRING> myArray
	 * FOR
	 * 		INT i, i<number's length, i++
	 * 			STRING add 
	 * 			add to myArray
	 * REPEAT
	 */
	private ArrayList<String> addToArray(String number)
	{
		ArrayList<String> myArray = new ArrayList<>();
		
		for (int i =0; i<number.length(); i++)
		{
			String add = number.substring(i, (i+1));
			myArray.add(add);
		}
		return myArray;
	}
	
	/**
	 * METHOD add
	 * @param bigNumberTwo
	 * @return bigNumberAnswer
	 * PRE-CONDITION ->> there should be two values that needs to be added
	 * POST-CONDITION ->> the numbers gets added and returns bigInt
	 * START
	 * BIGINT bigNumberAnswer calling constructor
	 * INT max --> find the maximum length of two strings
	 * IF  this.number < max
	 * 		INT c = max subtract length 
	 * 		FOR
	 * 			INT i, i<c, i increment
	 * 			this.number adds 0 in front.
	 * 		REPEAT
	 * IF bigNumberTwo < max
	 * 		INT c = max subtract length 
	 * 		FOR
	 * 			INT i, i<c, i increment
	 * 			bigNumberTwo adds 0 in front.
	 * 		REPEAT
	 * IF both numbers are positive or both negative
	 * 		bigNumberAnswer.number is produce by calling method addition 
	 * 		the String is added to array
	 * 		IF anyone's flag is true
	 * 			then set bigNumberAnswer flag to true
	 * 		ELSE 
	 * 			set bigNumberAnswer flag to false
	 * ELSE 
	 * 		BOOLEAN found
	 * 		FOR
	 * 			INT i, i<max && found; i++
	 * 				IF this.number character at i > bigNumberTwo.number at i
	 * 					Found is false
	 * 		REPEAT
	 * 		IF found is true
	 * 			Call method subtraction 
	 * 			Add to array 
	 * 			IF bigNumberTwo is false
	 * 				set answer flag to false
	 * 		ELSE 
	 * 			Call method subtraction 
	 * 			Add to array 
	 * 			IF bigNumberTwo is false
	 * 				set answer flag to false
	 *RETURN 	
	 */
	public BigInt add (BigInt bigNumberTwo)
	{
		BigInt bigNumberAnswer = new BigInt();
		
		int max = (this.number.length() < bigNumberTwo.number.length() ? bigNumberTwo.number.length(): this.number.length() );
		if (this.number.length() < max)
		{
			int c = max - this.number.length(); 
			for (int i = 0; i< c; i++)
			{
				this.number = "0" + this.number;
			}
		}
		if (bigNumberTwo.number.length() < max)
		{
			int c = max - bigNumberTwo.number.length();
			for (int i = 0; i< c; i++)
			{
				bigNumberTwo.number = "0" + bigNumberTwo.number;
			}
		}

		if ((this.flag == true && bigNumberTwo.flag == true) || (this.flag == false && bigNumberTwo.flag == false))
		{
			
			bigNumberAnswer.number = addition(bigNumberTwo.number, max);
			bigNumberAnswer.input = addToArray(bigNumberAnswer.number);
			if (this.flag == true)
			{
				bigNumberAnswer.flag = true;
				bigNumberAnswer.number = "+" + bigNumberAnswer.number;
			}
			else
			{
				bigNumberAnswer.flag = false;
				bigNumberAnswer.number = "-" + bigNumberAnswer.number;
			}
		}
		else
		{
			boolean found = true;
			for (int i =0; i<max && found == true; i++)
			{
				if (this.number.charAt(i) > bigNumberTwo.number.charAt(i))
				{
					found = false;
				}
			}
			if (found == true)
			{
				bigNumberAnswer.number = subtraction(bigNumberTwo.number,this.number, max);
				bigNumberAnswer.input = addToArray(bigNumberAnswer.number);
				if(bigNumberTwo.flag == false)
				{
					bigNumberAnswer.number = "-" + bigNumberAnswer.number;
					bigNumberAnswer.flag = false;
				}
			}
			else
			{
				bigNumberAnswer.number = subtraction(this.number,bigNumberTwo.number, max);
				bigNumberAnswer.input = addToArray(bigNumberAnswer.number);
				if(this.flag == false)
				{
					bigNumberAnswer.number = "-" + bigNumberAnswer.number;
					bigNumberAnswer.flag = false;
				}
			}	
		}
		return bigNumberAnswer;
	}
	
	/**
	 * METHOD subtract
	 * @param bigNumberTwo
	 * @return bigNumberAnswer
	 * PRE-CONDITION ->> there should be two values that needs to be subtracted
	 * POST-CONDITION ->> the numbers gets subtracted and returns bigInt
	 * START
	 * BigInt Constructor
	 * INT max ->> find the maximum length of two strings
	 * IF 
	 */
	public BigInt subtract (BigInt bigNumberTwo)
	{
		BigInt bigNumberAnswer = new BigInt();
		
		int max = (this.number.length() < bigNumberTwo.number.length() ? bigNumberTwo.number.length(): this.number.length() );
		if (this.number.length() < max)
		{
			int c = max - this.number.length(); 
			for (int i = 0; i< c; i++)
			{
				this.number = "0" + this.number;
			}
		}
		if (bigNumberTwo.number.length() < max)
		{
			int c = max - bigNumberTwo.number.length();
			for (int i = 0; i< c; i++)
			{
				bigNumberTwo.number = "0" + bigNumberTwo.number;
			}
		}
		
		boolean found = true;
		for (int i =0; i<max && found == true; i++)
		{
			if (this.number.charAt(i) > bigNumberTwo.number.charAt(i))
			{
				found = false;
			}
		}
		
		if ((this.flag == true && bigNumberTwo.flag == false) || (this.flag == false && bigNumberTwo.flag == true))
		{
			
			bigNumberAnswer.number = addition(bigNumberTwo.number, max);
			bigNumberAnswer.input = addToArray(bigNumberAnswer.number);
			
			if (found == true)
			{
				bigNumberAnswer.flag = bigNumberTwo.flag;
				if (bigNumberTwo.flag == true)
				{
					bigNumberAnswer.number = "+" + bigNumberAnswer.number;
				}
				else
					bigNumberAnswer.number = "-" + bigNumberAnswer.number;
				
			}
			else
			{
				bigNumberAnswer.flag = this.flag;
				if (this.flag == true)
				{
					bigNumberAnswer.number = "+" + bigNumberAnswer.number;
				}
				else
					bigNumberAnswer.number = "-" + bigNumberAnswer.number;
			}
		}
		else
		{
			if (found == true)
			{
				bigNumberAnswer.number = subtraction(bigNumberTwo.number,this.number, max);
			}
			else
			{
				bigNumberAnswer.number = subtraction(this.number,bigNumberTwo.number, max);
			}
			bigNumberAnswer.input = addToArray(bigNumberAnswer.number);
			if (this.flag == true)
			{
				bigNumberAnswer.number = "+" + bigNumberAnswer.number;
			}
			else
				bigNumberAnswer.number = "-" + bigNumberAnswer.number;
			
		}
		
		return bigNumberAnswer;
	}
	
	
	public BigInt multiply(BigInt bigNumberTwo)
	{
		BigInt bigNumberAnswer = new BigInt();
		
		bigNumberAnswer.number = multiplication(bigNumberTwo.number, this.number);
		bigNumberAnswer.input = addToArray(bigNumberAnswer.number);
		return bigNumberAnswer;
	}
	
	
	
	
	
	
	private String addition (String bigNumberTwo,int max)
	{
		String bigNumberAnswer = "";
		int carry =0;
		for (int i =0; i<max; i++)
		{
			int one = this.number.charAt(this.number.length()-1-i)-48;
			int two = bigNumberTwo.charAt(bigNumberTwo.length()-1-i)-48;
			int total = (one+two+carry)%10;
			bigNumberAnswer = (total + bigNumberAnswer);
			if ((one + two + carry) >=10)
			{
				carry =1;
			}
			else
			{
				carry =0;
			}
		}
		if (carry ==1)
		{
			bigNumberAnswer = "1" + bigNumberAnswer;
		}
		return bigNumberAnswer;
	}
	
	
	
	
	
	
	
	
	
	
	private String subtraction (String bigNumberOne, String bigNumberTwo,int max)
	{
		String bigNumberAnswer = "";
		
		int carry =0;
		for (int i =0; i<max; i++)
		{
			int one = bigNumberOne.charAt(bigNumberOne.length()-1-i)-48;
			int two = bigNumberTwo.charAt(bigNumberTwo.length()-1-i)-48;
			int total;
			one = one-carry;
			if(two > one)
			{
				one = one+10;
				carry =1;
				total = (one -two);
			}
			else
			{
				total = (one-two);
				carry =0;
			}
			bigNumberAnswer = (total + bigNumberAnswer);
		}
		bigNumberAnswer = removeZeros(bigNumberAnswer);
		return bigNumberAnswer;
	}
	
	
	
	public String multiplication(String num1, String num2) {
	    String n1 = new StringBuilder(num1).reverse().toString();
	    String n2 = new StringBuilder(num2).reverse().toString();
	 
	    int[] d = new int[num1.length()+num2.length()];
	 
	    //multiply each digit and sum at the corresponding positions
	    for(int i=0; i<n1.length(); i++){
	        for(int j=0; j<n2.length(); j++){
	            d[i+j] += (n1.charAt(i)-'0') * (n2.charAt(j)-'0');
	        }
	    }
	 
	    StringBuilder sb = new StringBuilder();
	 
	    //calculate each digit
	    for(int i=0; i<d.length; i++){
	        int mod = d[i]%10;
	        int carry = d[i]/10;
	        if(i+1<d.length){
	            d[i+1] += carry;
	        }
	        sb.insert(0, mod);
	    }
	 
	    //remove front 0's
	    while(sb.charAt(0) == '0' && sb.length()> 1){
	        sb.deleteCharAt(0);
	    }
	 
	    return sb.toString();
	}
}
