package animals;

import java.awt.Color;

public class Bear extends Mammal
{
	public Bear(String name)
	{
		super(name);
	}

	public Color furColor()
	{
		return Color.BLACK;
	}

	public String makeNoise()
	{
		return "Growl";
	}
}
