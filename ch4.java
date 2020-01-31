package java_practice;

import java.util.*; 

class preparer
{

} 

class Trip
{
	int bicycle;
	int car;
	
	public void prepare(preparer p)
	{
		if (p instanceof Mechanic)
		{
			Mechanic m = (Mechanic) p;
			bicycle = m.prepare_bicycle();
		}
		else if (p instanceof Driver)
		{
			Driver d = (Driver) p;
			car = d.prepare_car();
		}
	}
		
} 

class Mechanic extends preparer
{
	public int prepare_bicycle()
	{
		return 5;
	}	
}

class Driver extends preparer
{
	public int prepare_car()
	{
		return 3;
	}
}


//improved code

interface prep
{
	public int prepare_trip();
}

class Mechanic1 implements prep
{
	public int prepare_trip()
	{
		return 5;
	}
} 

class Driver1 implements prep
{
	public int prepare_trip()
	{
		return 3;
	}
}

class Trip1
{
	int bicycle;
	int car;
	
	public void prepare(prep p)
	{
		bicycle = p.prepare_trip();
		car = p.prepare_trip();
	}
		
}

class stable
{
	public void eg(prep p)
	{
		if (p instanceof Integer)
			System.out.println("Ok."); 
	}
} 