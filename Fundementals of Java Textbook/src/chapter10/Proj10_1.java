package chapter10;

import java.awt.Color;
import java.util.Arrays;

public class Proj10_1 
{

	public static void main(String[] args) 
	{
		Bear panda = new Panda();
		System.out.println(Arrays.toString(panda.getFurColors()));
		System.out.println(panda.getHabitat());
		System.out.println(Arrays.toString(panda.getDiet()));
		System.out.println(panda.canEat("Bamboo"));
		System.out.println(panda.canEat("Rodents"));
		System.out.println(panda.canEat("Fish"));
		System.out.println(panda.canEat("Seals"));
		System.out.println(panda.canEat("Berries"));
		System.out.println(panda.climbTree());
		System.out.println(panda.swim());
		System.out.println(panda.hibernate());
		
		System.out.println();

		Bear blackBear = new BlackBear();
		System.out.println(Arrays.toString(blackBear.getFurColors()));
		System.out.println(blackBear.getHabitat());
		System.out.println(Arrays.toString(blackBear.getDiet()));
		System.out.println(blackBear.canEat("Bamboo"));
		System.out.println(blackBear.canEat("Rodents"));
		System.out.println(blackBear.canEat("Fish"));
		System.out.println(blackBear.canEat("Seals"));
		System.out.println(blackBear.canEat("Berries"));
		System.out.println(blackBear.climbTree());
		System.out.println(blackBear.swim());
		System.out.println(blackBear.hibernate());
		
		System.out.println();

		Bear polarBear = new PolarBear();
		System.out.println(Arrays.toString(polarBear.getFurColors()));
		System.out.println(polarBear.getHabitat());
		System.out.println(Arrays.toString(polarBear.getDiet()));
		System.out.println(polarBear.canEat("Bamboo"));
		System.out.println(polarBear.canEat("Rodents"));
		System.out.println(polarBear.canEat("Fish"));
		System.out.println(polarBear.canEat("Seals"));
		System.out.println(polarBear.canEat("Berries"));
		System.out.println(polarBear.climbTree());
		System.out.println(polarBear.swim());
		System.out.println(polarBear.hibernate());
	}
	
	private abstract static class Bear
	{
		protected Color[] furColors;
		protected String habitat;
		protected String[] diet;
		
		public Color[] getFurColors()
		{
			return Arrays.copyOf(furColors, furColors.length);
		}
		
		public String getHabitat()
		{
			return habitat;
		}
		
		public String[] getDiet()
		{
			return Arrays.copyOf(diet, diet.length);
		}
		
		public boolean canEat(String food)
		{
			return Arrays.binarySearch(diet, food) >= 0;
		}
		
		abstract public String climbTree();
		abstract public String swim();
		abstract public String hibernate();
	}
	
	private abstract static class Ailuropoda extends Bear
	{
		public Ailuropoda()
		{
			habitat = "Mountians";
		}
	}
	
	private static class Panda extends Ailuropoda
	{
		public Panda()
		{
			super();
			furColors = new Color[] {Color.BLACK, Color.WHITE};
			diet = new String[] {"Bamboo", "Fish", "Rodents"};
		}
		
		@Override
		public String climbTree()
		{
			return "Climbed up tree and took a nap.";
		}
		
		@Override
		public String swim()
		{
			return "Took a swim and caught some fish.";
		}
		
		@Override
		public String hibernate()
		{
			return "Can't get enough food to hibernate!";
		}
	}
	
	private abstract static class Ursus extends Bear
	{
		public Ursus()
		{
			diet = new String[] {"Fish"};
		}
	}
	
	private static class BlackBear extends Ursus
	{
		public BlackBear()
		{
			super();
			diet = new String[] {"Berries", "Fish"};
			furColors = new Color[] {Color.BLACK};
			habitat = "Forest";
		}
		
		@Override
		public String climbTree()
		{
			return "Climbed a tree and took a nap.";
		}
		
		@Override
		public String swim()
		{
			return "Took a swim and caught some fish.";
		}
		
		@Override
		public String hibernate()
		{
			return "Time to take a nice long nap...";
		}
	}
	
	private static class PolarBear extends Ursus
	{
		public PolarBear()
		{
			diet = new String[] {"Fish", "Seals"};
			furColors = new Color[] {Color.WHITE};
			habitat = "Arctic";
		}
		
		@Override
		public String climbTree()
		{
			return "Can't find any trees!";
		}
		
		@Override
		public String swim()
		{
			return "Took a swim and caught a seal.";
		}
		
		@Override
		public String hibernate()
		{
			return "Too cold to hibernate!";
		}
	}

}
