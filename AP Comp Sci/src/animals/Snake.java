package animals;

public class Snake extends Reptile
{
	public Snake(String name)
	{
		super(name);
	}

	public int numLegs()
	{
		return 0;
	}

	public String makeNoise()
	{
		return "hissssssss";
	}
}
