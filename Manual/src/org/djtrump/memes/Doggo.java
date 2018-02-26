package org.djtrump.memes;
//***********************************************************************************
//  Rajat Patel
//  Dog
//  6/10/2017
//  Represents a good boy.
//***********************************************************************************

public class Doggo 
{
	private enum Emotion
	{
		Happy,
		Angered,
		Sad,
		Sleepy,
		Apathetic
	}
	
	private String name;
	private Emotion emotion = Emotion.Apathetic;
	
	public Doggo(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String speak()
	{
		return "Bork";
	}
	
	public boolean isGoodBoy()
	{
		return emotion != Emotion.Angered;
	}
	
	public void eat(Food food)
	{
		emotion = food.isYummy() ? Emotion.Happy : Emotion.Angered;
	}
	
	public Emotion emotion()
	{
		return emotion;
	}
	
	public void pet()
	{
		switch(emotion)
		{
			case Angered:
			case Sad:
				emotion = Emotion.Apathetic;
				return;
			case Apathetic:
				emotion = Emotion.Happy;
				return;
			case Sleepy:
			default:
				return;
		}
	}
}
