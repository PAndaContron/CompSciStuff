package chapter10;

public class Proj10_2 
{

	public static void main(String[] args) 
	{
		Vehicle train = new Train(5);
		System.out.println(train.refuel("Coal"));
		System.out.println(train.refuel("Gas"));
		System.out.println(train.refuel("Gasoline"));
		System.out.println(train.add(200));
		System.out.println(train.move("Road"));
		System.out.println(train.move("Rails"));
		System.out.println(train.remove(50));
		System.out.println(train.remove(50));
		
		System.out.println();

		Vehicle car = new Car();
		System.out.println(car.refuel("Coal"));
		System.out.println(car.refuel("Gas"));
		System.out.println(car.refuel("Gasoline"));
		System.out.println(car.add(200));
		System.out.println(car.move("Road"));
		System.out.println(car.move("Rails"));
		System.out.println(car.remove(50));
		System.out.println(car.remove(50));
		
		System.out.println();

		Vehicle bus = new Bus();
		System.out.println(bus.refuel("Coal"));
		System.out.println(bus.refuel("Gas"));
		System.out.println(bus.refuel("Gasoline"));
		System.out.println(bus.add(200));
		System.out.println(bus.move("Road"));
		System.out.println(bus.move("Rails"));
		System.out.println(bus.remove(50));
		System.out.println(bus.remove(50));
	}
	
	private abstract static class Vehicle
	{
		protected int capacity;
		private int passengers = 0;
		
		public String add(int num)
		{
			passengers += num;
			if(passengers > capacity)
			{
				int added = num - (passengers-capacity);
				passengers = capacity;
				return "Only "+added+" passengers were able to be added!";
			}
			
			return num+" passengers added successfully!";
		}
		
		public String remove(int num)
		{
			passengers = Math.max(0, passengers-num);
			if(passengers == 0)
				return "Vehicle emptied!";
			return num+" passengers unloaded.";
		}
		
		abstract public String refuel(String fuel);
		abstract public String move(String pathType);
	}
	
	private static class Train extends Vehicle
	{
		public Train(int cars)
		{
			capacity = 20*cars;
		}
		
		@Override
		public String refuel(String fuel)
		{
			if(fuel.equals("Coal"))
				return "Refueled successfully!";
			return "Incorrect fuel type!";
		}
		
		@Override
		public String move(String pathType)
		{
			if(pathType.equals("Rails"))
				return "Moving along smoothly!";
			return "Wrong path type!";
		}
	}
	
	private abstract static class Automobile extends Vehicle
	{	
		@Override
		public String refuel(String fuel)
		{
			if(fuel.equals("Gas") || fuel.equals("Gasoline"))
				return "Refueled successfully!";
			return "Incorrect fuel type!";
		}
		
		@Override
		public String move(String pathType)
		{
			if(pathType.equals("Road"))
				return "Moving along smoothly!";
			return "Wrong path type!";
		}
	}
	
	private static class Car extends Automobile
	{
		public Car()
		{
			capacity = 5;
		}
	}
	
	private static class Bus extends Automobile
	{
		public Bus()
		{
			capacity = 30;
		}
	}
}
