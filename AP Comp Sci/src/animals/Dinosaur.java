package animals;

public class Dinosaur extends Reptile
{
	public Dinosaur(String name)
	{
		super(name);
	}

	public int numLegs() {
		return 2;
	}

	public String makeNoise() {
		return "Roar";
	}
}
