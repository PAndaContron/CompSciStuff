package animals;

import java.awt.Color;

public class Dog extends Mammal
{
	public Dog(String name)
	{
		super(name);
	}

	public Color furColor()
	{
		return Color.WHITE;
	}

	public String makeNoise()
	{
		return "bork";
	}
}
