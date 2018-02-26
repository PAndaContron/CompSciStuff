//***********************************************************************************
//  Rajat Patel
//  Dog Test
//  6/14/2017
//  Shows various dogs
//***********************************************************************************

public class DogTest 
{

	public static void main(String[] args) 
	{
		Yorkshire yorkie = new Yorkshire("Doggo");
		System.out.println(yorkie.getName()+" says "+yorkie.speak());
		Labrador lab = new Labrador("Doggo the Second","black");
		System.out.println(lab.getName()+" says "+lab.speak());
	}

}
