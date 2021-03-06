package animals;

public class AnimalDriver
{

	public static void main(String[] args)
	{
		Animal bear = new Bear("Beer");
		Animal dog = new Dog("Dug");
		Animal snake = new Snake("Snak");
		Animal dino = new Dinosaur("Din");
		
		System.out.println("Names:");
		System.out.printf("Bear:  %s%n", bear.getName());
		System.out.printf("Dog:   %s%n", dog.getName());
		System.out.printf("Snake: %s%n", snake.getName());
		System.out.printf("Dino:  %s%n", dino.getName());
		System.out.println();
		
		bear.setName("Yogi");
		dog.setName("Spot");
		snake.setName("Jim");
		dino.setName("Steg");
		
		System.out.println("New names:");
		System.out.printf("Bear:  %s%n", bear.getName());
		System.out.printf("Dog:   %s%n", dog.getName());
		System.out.printf("Snake: %s%n", snake.getName());
		System.out.printf("Dino:  %s%n", dino.getName());
		System.out.println();
		
		System.out.println("makeNoise method:");
		System.out.printf("Bear:  %s%n", bear.makeNoise());
		System.out.printf("Dog:   %s%n", dog.makeNoise());
		System.out.printf("Snake: %s%n", snake.makeNoise());
		System.out.printf("Dino:  %s%n", dino.makeNoise());
		System.out.println();
		
		System.out.println("furColor method (Mammals):");
		System.out.printf("Bear: %s%n", ((Mammal) bear).furColor());
		System.out.printf("Dog:  %s%n", ((Mammal) dog).furColor());
		System.out.println();
		
		System.out.println("numLegs method (Reptiles):");
		System.out.printf("Snake: %s%n", ((Reptile) snake).numLegs());
		System.out.printf("Dino:  %s%n", ((Reptile) dino).numLegs());
	}

}
