package java_practice;

import java.util.*;

interface wh
{
	public float diameter();
} 

class Gear
{
	//to do: write getter and setter
	int chainring;
	int cog;
	int rim;
	int tire;

	Gear(int chairing, int cog, int rim, int tire)
	{
		this.chainring = chainring;
		this.cog = cog;
		this.rim = rim;
		this.tire = tire;
	}

	public float ratio()
	{
		return (float) chainring / cog;
	}

	public float gear_inches()
	{
		Wheel w = new Wheel(rim, tire);
		return ratio() * w.diameter();
	}
}

class Wheel implements wh
{
	//to do: write getter and setter
	int rim;
	int tire;

	Wheel(int rim, int tire)
	{
		this.rim = rim;
		this.tire = tire;
	}
	
	public float diameter()
	{
		return rim + (tire*2);
	}
}

//dependency injection
class Gear1
{
	//to do: write getter and setter
	int chainring;
	int cog;
	int rim;
	int tire;
	wh w;

	Gear(int chairing, int cog, int rim, int tire, wh w)
	{
		this.chainring = chainring;
		this.cog = cog;
		this.rim = rim;
		this.tire = tire;
		this.w = w;
	}

	public float ratio()
	{
		return (float) chainring / cog;
	}

	public float gear_inches()
	{
		return ratio() * w.diameter();
	}
}

class Gear2
{
	//to do: write getter and setter
	int chainring;
	int cog;
	int rim;
	int tire;
	Wheel w;

	Gear(int chairing, int cog, int rim, int tire)
	{
		this.chainring = chainring;
		this.cog = cog;
		this.rim = rim;
		this.tire = tire;
		w = new Wheel(rim, tire); //alternatively use separate method for this
	}

	public float ratio()
	{
		return (float) chainring / cog;
	}

	private int getDiameter()
	{
		return w.diameter();
	}

	public float gear_inches()
	{
		return ratio() * getDiameter();
	}
}