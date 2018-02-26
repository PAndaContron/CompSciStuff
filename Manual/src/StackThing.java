//***********************************************************************************
//  Rajat Patel
//  StackThing
//  1/16/2017
//***********************************************************************************
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackThing 
{
	public static void main(String[] args)
	{
		System.out.println(missingGrouping(" 53 + 56 )"));
		System.out.println(missingGrouping("{ 5 - ( 3 + 5 }"));
		System.out.println(missingGrouping("{ 5 - 3 + 5 ) }"));
	}
	
	public static char missingGrouping(String expression)
	{
		char[] open = {'(', '[', '{'};
		char[] close = {')', ']', '}'};
		char[] all = {'(', ')', '[', ']', '{', '}'};
		
		Stack<String> stack = new Stack<String>();
		
		StringTokenizer tokenizer = new StringTokenizer(expression);
		
		while(tokenizer.hasMoreTokens())
		{
			stack.push(tokenizer.nextToken());
			
			if(Arrays.binarySearch(all, stack.peek().charAt(0)) <= -1)
			{
				stack.pop();
				continue;
			}
			
			int index = Arrays.binarySearch(close, stack.peek().charAt(0));
			if(index > -1)
			{
				stack.pop();
				if(stack.isEmpty())
					return open[index];
				char previous = stack.pop().charAt(0);
				if(previous==open[index])
					continue;
				int prevIndex = Arrays.binarySearch(open, previous);
				if(prevIndex > -1)
					return close[prevIndex];
				return open[index];
			}
		}
		
		
		
		return (char) 0;
	}
}
