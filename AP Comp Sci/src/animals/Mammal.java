package animals;

import java.awt.Color;

public abstract class Mammal extends Animal
{
	public Mammal(String name)
	{
		super(name);
	}
	
	abstract public Color furColor();
}
