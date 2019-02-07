package json;

public class Test 
{

	public static void main(String[] args) 
	{
		System.out.println(JsonObject.parse("{\"value\": \"\\n\\\\r\\t\\u0041\\u0050\", \"value2\": {\"subvalue\": [38.2f, 2.5, 8.3, 2l, 3t, 5s, 0x41t, 0b001100s, 5]}}"));
	}

}
