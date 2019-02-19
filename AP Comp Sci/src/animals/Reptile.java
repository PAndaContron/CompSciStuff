package animals;

public abstract class Reptile extends Animal
{
	public Reptile(String name)
	{
		super(name);
	}
	
	abstract public int numLegs();
}
