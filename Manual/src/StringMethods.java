//***********************************************************************************
//  Rajat Patel
//  String Methods
//  10/25/2016
//  Uses all string methods on page 78 of the textbook.
//***********************************************************************************

public class StringMethods 
{

	public static void main(String[] args) 
	{
		String sentence = "Don't dig straight down.";
		System.out.println("Original sentence: "+sentence);
		System.out.println("The third character in that sentence is \""+sentence.charAt(2)+"\".");
		System.out.println("How does the sentence compare alphabetically to \"Don't look straight down.\"? "+sentence.compareTo("Don't look straight down."));
		System.out.println("Now let's add another part at the end of the sentence: "+sentence.concat(".. Unless you know what you're doing."));
		System.out.println("Is our string the same as \"DON'T DIG STRAIGHT DOWN.\"? "+sentence.equals("DON'T DIG STRAIGHT DOWN."));
		System.out.println("What if we ignore case? "+sentence.equalsIgnoreCase("DON'T DIG STRAIGHT DOWN."));
		System.out.println("At what index is the word \"dig\" at? "+sentence.indexOf("dig"));
		System.out.println("How long is the sentence? "+sentence.length());
		System.out.println("What would we get if we replaced all of the i\'s with e\'s? "+sentence.replace('i','e'));
		System.out.println("Now let's cut out a part from the end of the string: "+sentence.substring(0,9));
		System.out.println("And from the beginning: "+sentence.substring(6));
		System.out.println("And finally, let's see what our sentence looks like in all lowercase: "+sentence.toLowerCase());
		System.out.println("... and in all caps: "+sentence.toUpperCase());
	}

}
