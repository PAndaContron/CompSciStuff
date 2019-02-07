package json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonObject
{
	private Object value;
	
	public JsonObject()
	{
		value = null;
	}
	
	public JsonObject(String s)
	{
		value = s;
	}
	
	public JsonObject(int i)
	{
		value = i;
	}
	
	public JsonObject(byte b)
	{
		value = b;
	}
	
	public JsonObject(short s)
	{
		value = s;
	}
	
	public JsonObject(long l)
	{
		value = l;
	}
	
	public JsonObject(double d)
	{
		value = d;
	}
	
	public JsonObject(float f)
	{
		value = f;
	}
	
	public JsonObject(boolean b)
	{
		value = b;
	}
	
	public JsonObject(Map<String, JsonObject> map)
	{
		value = map;
	}

	public JsonObject(JsonObject[] arr)
	{
		value = arr;
	}
	
	public JsonObject(String[] arr)
	{
		JsonObject[] objArr = new JsonObject[arr.length];
		for(int i=0; i<arr.length; i++)
		{
			objArr[i] = new JsonObject(arr[i]);
		}
		value = objArr;
	}
	
	public JsonObject(int[] arr)
	{
		JsonObject[] objArr = new JsonObject[arr.length];
		for(int i=0; i<arr.length; i++)
		{
			objArr[i] = new JsonObject(arr[i]);
		}
		value = objArr;
	}

	public JsonObject(byte[] arr)
	{
		JsonObject[] objArr = new JsonObject[arr.length];
		for(int i=0; i<arr.length; i++)
		{
			objArr[i] = new JsonObject(arr[i]);
		}
		value = objArr;
	}

	public JsonObject(short[] arr)
	{
		JsonObject[] objArr = new JsonObject[arr.length];
		for(int i=0; i<arr.length; i++)
		{
			objArr[i] = new JsonObject(arr[i]);
		}
		value = objArr;
	}

	public JsonObject(long[] arr)
	{
		JsonObject[] objArr = new JsonObject[arr.length];
		for(int i=0; i<arr.length; i++)
		{
			objArr[i] = new JsonObject(arr[i]);
		}
		value = objArr;
	}

	public JsonObject(double[] arr)
	{
		JsonObject[] objArr = new JsonObject[arr.length];
		for(int i=0; i<arr.length; i++)
		{
			objArr[i] = new JsonObject(arr[i]);
		}
		value = objArr;
	}

	public JsonObject(float[] arr)
	{
		JsonObject[] objArr = new JsonObject[arr.length];
		for(int i=0; i<arr.length; i++)
		{
			objArr[i] = new JsonObject(arr[i]);
		}
		value = objArr;
	}

	public JsonObject(boolean[] arr)
	{
		JsonObject[] objArr = new JsonObject[arr.length];
		for(int i=0; i<arr.length; i++)
		{
			objArr[i] = new JsonObject(arr[i]);
		}
		value = objArr;
	}

	public JsonObject(Map<String, JsonObject>[] arr)
	{
		JsonObject[] objArr = new JsonObject[arr.length];
		for(int i=0; i<arr.length; i++)
		{
			objArr[i] = new JsonObject(arr[i]);
		}
		value = objArr;
	}

	public void setValue(String s)
	{
		value = s;
	}
	
	public void setValue(int i)
	{
		value = i;
	}
	
	public void setValue(byte b)
	{
		value = b;
	}
	
	public void setValue(short s)
	{
		value = s;
	}
	
	public void setValue(long l)
	{
		value = l;
	}
	
	public void setValue(double d)
	{
		value = d;
	}
	
	public void setValue(float f)
	{
		value = f;
	}
	
	public void setValue(boolean b)
	{
		value = b;
	}
	
	public void setValue(JsonObject[] arr)
	{
		value = arr;
	}
	
	public void setValue(Map<String, JsonObject> map)
	{
		value = map;
	}
	
	@SuppressWarnings("unchecked")
	public void setValue(String key, JsonObject value)
	{
		try
		{
			((Map<String, JsonObject>) value).put(key, value);
		}
		catch(NullPointerException | ClassCastException e)
		{
			
		}
	}
	
	public Class<? extends Object> getType()
	{
		if(value == null)
			return null;
		if(value instanceof String)
			return String.class;
		if(value instanceof Integer)
			return Integer.class;
		if(value instanceof Byte)
			return Byte.class;
		if(value instanceof Short)
			return Short.class;
		if(value instanceof Long)
			return Long.class;
		if(value instanceof Double)
			return Double.class;
		if(value instanceof Float)
			return Float.class;
		if(value instanceof Boolean)
			return Boolean.class;
		if(value instanceof JsonObject[])
			return JsonObject[].class;
		if(value instanceof Map)
			return Map.class;
		return null;
	}
	
	public String getString()
	{
		if(value != null && value instanceof String)
			return (String) value;
		return null;
	}
	
	public int getInt()
	{
		if(value != null && value instanceof Integer)
			return (Integer) value;
		return 0;
	}
	
	public byte getByte()
	{
		if(value != null && value instanceof Byte)
			return (Byte) value;
		return 0;
	}
	
	public short getShort()
	{
		if(value != null && value instanceof Short)
			return (Short) value;
		return 0;
	}
	
	public long getLong()
	{
		if(value != null && value instanceof Long)
			return (Long) value;
		return 0;
	}
	
	public double getDouble()
	{
		if(value != null && value instanceof Double)
			return (Double) value;
		return 0;
	}
	
	public float getFloat()
	{
		if(value != null && value instanceof Float)
			return (Float) value;
		return 0;
	}
	
	public boolean getBoolean()
	{
		if(value != null && value instanceof Boolean)
			return (Boolean) value;
		return false;
	}
	
	public JsonObject[] getArray()
	{
		if(value != null && value instanceof JsonObject[])
			return (JsonObject[]) value;
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, JsonObject> getMap()
	{
		try
		{
			return (Map<String, JsonObject>) value;
		}
		catch(NullPointerException | ClassCastException e)
		{
			
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public JsonObject getValue(String key)
	{
		try
		{
			return ((Map<String, JsonObject>) value).get(key);
		}
		catch(NullPointerException | ClassCastException e)
		{
			
		}
		return null;
	}
	
	public String toString()
	{
		if(value == null)
		{
			return "null";
		}
		if(value instanceof Long)
		{
			return value+"L";
		}
		if(value instanceof Short)
		{
			return value+"S";
		}
		if(value instanceof Byte)
		{
			return value+"T";
		}
		if(value instanceof Float)
		{
			return value+"F";
		}
		if(value instanceof Map)
		{
			@SuppressWarnings("unchecked")
			Map<String, JsonObject> map = (Map<String, JsonObject>) value;
			String out = "{";
			for(Entry<String, JsonObject> e : map.entrySet())
			{
				out += format(e.getKey(), e.getValue()) + ",";
			}
			out = out.substring(0, out.length()-1)+"}";
			return out;
		}
		if(value instanceof String)
		{
			return String.format("\"%s\"", ((String)value)
					.replace("\\", "\\\\")
					.replace("\t", "\\t")
					.replace("\b", "\\b")
					.replace("\f", "\\f")
					.replace("\r", "\\r")
					.replace("\n", "\\n")
					.replace("\"", "\\\""));
		}
		if(value instanceof JsonObject[])
		{
			return Arrays.toString((JsonObject[]) value);
		}
		return value.toString();
	}
	
	public static JsonObject parse(String json)
	{
		json = json.trim();
		if(json.startsWith("{"))
		{
			json = json.substring(1, json.length()-1).trim();
		
			Map<String, JsonObject> map = new HashMap<>();
			String[] tags = getTags(json);
//			String[] tags = json.split("(((\\{(.*?)\\})|(\\[(.*?)\\]))*\\s*,\\s*)|(((\\{(.*?)\\})|(\\[(.*?)\\]))+)");
			for(String tag : tags)
			{
				String trimTag = tag.trim();
				int colonIndex = trimTag.indexOf(":");
				String key = trimTag.substring(1, colonIndex-1).trim();
				String value = trimTag.substring(colonIndex+1, trimTag.length()).trim();
//				System.out.printf("Tag: %20s Key: %20s Value: %20s%n", trimTag, key, value);
				
				map.put(key, parse(value));
			}
			
			return new JsonObject(map);
		}
		if(json.startsWith("["))
		{
			json = json.substring(1, json.length()-1).trim();
			String[] elements = getTags(json);
			JsonObject[] array = new JsonObject[elements.length];
			for(int i=0; i<elements.length; i++)
			{
				array[i] = parse(elements[i]);
			}
			
			return new JsonObject(array);
		}
		if(json.startsWith("\""))
		{
			return new JsonObject(parseUnicodeEscapes(json.substring(1, json.length()-1)
					.replace("\\t", "\t")
					.replace("\\f", "\f")
					.replace("\\b", "\b")
					.replace("\\n", "\n")
					.replace("\\r", "\r")
					.replace("\\\"", "\"")
					.replace("\\\\", "\\")));
		}
		try
		{
			int radix = 10;
			if(json.startsWith("0b") || json.startsWith("0B"))
				radix = 2;
			else if(json.startsWith("0x") || json.startsWith("0X"))
				radix = 16;
			if(radix != 10)
				json = json.substring(2);
			if(json.endsWith("l") || json.endsWith("L"))
				return new JsonObject(Long.parseLong(json.substring(0, json.length()-1), radix));
			if(json.endsWith("s") || json.endsWith("S"))
				return new JsonObject(Short.parseShort(json.substring(0, json.length()-1), radix));
			if(json.endsWith("t") || json.endsWith("T"))
				return new JsonObject(Byte.parseByte(json.substring(0, json.length()-1), radix));
			if(json.endsWith("f") || json.endsWith("F"))
				return new JsonObject(Float.parseFloat(json.substring(0, json.length()-1)));
			try
			{
				return new JsonObject(Integer.parseInt(json, radix));
			}
			catch(Exception e)
			{
				
			}
			return new JsonObject(Double.parseDouble(json));
		}
		catch(Exception e)
		{
			
		}
		if(json.equals("true") || json.equals("false"))
		{
			return new JsonObject(Boolean.parseBoolean(json));
		}
		return new JsonObject();
	}
	
	private static String[] getTags(String json)
	{
		if(json.matches("\\s*"))
			return new String[0];
		
		int start = 0;
		List<String> tags = new ArrayList<>();
		Stack<Character> groups = new Stack<>();
		for(int i=0; i<json.length(); i++)
		{
			if("{[\"".contains(json.charAt(i)+""))
			{
				if(!groups.isEmpty() && groups.peek() == '"' && json.charAt(i)=='"'
						&& json.charAt(i-1) != '\\')
				{
					groups.pop();
				}
				else
				{
					groups.push(json.charAt(i));
				}
			}
			else if("}]".contains(json.charAt(i)+""))
			{
				groups.pop();
			}
			else if(groups.isEmpty() && json.charAt(i)==',')
			{
				tags.add(json.substring(start, i).trim());
				start = i+1;
			}
		}
		tags.add(json.substring(start, json.length()).trim());
		
		String[] tagArr = new String[tags.size()];
		for(int i=0; i<tags.size(); i++)
		{
			tagArr[i] = tags.get(i);
		}
		
		return tagArr;
	}

	private static String format(String key, JsonObject value)
	{
		return String.format("\"%s\":%s", key, value);
	}
	
	private static String parseUnicodeEscapes(String str)
	{
		Pattern regex = Pattern.compile("\\\\u[0-9A-Fa-f]{4}");
		Matcher regexMatcher = regex.matcher(str);
		
		while(regexMatcher.find())
		{
			str = regexMatcher.replaceFirst(
					""+(char) Integer.parseInt(regexMatcher.group(0).substring(2), 16));
			regexMatcher = regex.matcher(str);
		}
		
		return str;
	}
}
