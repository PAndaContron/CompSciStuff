package vbInterface;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import json.JsonObject;

public class Main
{

	public static void main(String[] args)
	{
		if(args[0].equals("-convert"))
		{
			switch(args[1])
			{
				case "int":
				case "integer":
					System.out.print(ReflectionManager.serialize(Integer.parseInt(args[2])));
					return;
				case "byte":
					System.out.print(ReflectionManager.serialize(Byte.parseByte(args[2])));
					return;
				case "short":
					System.out.print(ReflectionManager.serialize(Short.parseShort(args[2])));
					return;
				case "long":
					System.out.print(ReflectionManager.serialize(Long.parseLong(args[2])));
					return;
				case "char":
				case "character":
					System.out.print(ReflectionManager.serialize(args[2].charAt(0)));
					return;
				case "float":
					System.out.print(ReflectionManager.serialize(Float.parseFloat(args[2])));
					return;
				case "double":
					System.out.print(ReflectionManager.serialize(Double.parseDouble(args[2])));
					return;
				case "boolean":
					System.out.print(ReflectionManager.serialize(Boolean.parseBoolean(args[2])));
					return;
				case "string":
					System.out.print(ReflectionManager.serialize(args[2]));
					return;
				default:
					return;
			}
		}
		
		if(args[0].equals("-deserialize"))
		{
			System.out.print(ReflectionManager.deserialize(args[1]));
			return;
		}
		
		JsonObject caller = null, method = null;
		
		if(args[0].equals("-construct"))
		{
			Map<String, JsonObject> initMap = new HashMap<>();
			initMap.put("class", new JsonObject(args[1]));
			initMap.put("object", new JsonObject((String) null));
			caller = new JsonObject(initMap);
			method = new JsonObject("<init>");
		}
		else
		{
			String callerJson = args[0].equals("null") ? null : args[0];
			String methodStr = args[1];
			caller = JsonObject.parse(callerJson);
			method = new JsonObject(methodStr);
		}
		
		String[] paramsJson = {};
		if(args.length > 2)
			paramsJson = Arrays.copyOfRange(args, 2, args.length);
		
		JsonObject[] params = new JsonObject[paramsJson.length];
		for(int i=0; i<paramsJson.length; i++)
		{
			params[i] = JsonObject.parse(paramsJson[i]);
		}
		
		Map<String, JsonObject> requestMap = new HashMap<>();
		requestMap.put("caller", caller);
		requestMap.put("method", method);
		requestMap.put("parameters", new JsonObject(params));
		
		try
		{
			String response = ReflectionManager.invoke(new JsonObject(requestMap).toString());
			System.out.print(response);
		}
		catch (Throwable e)
		{
			e.printStackTrace();
		}
	}

}
