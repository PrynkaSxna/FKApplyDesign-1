package java_practice;

import java.util.*;

class Parts
{
	String spares;
	String chain;
	String tire_size;
	
	//overload to set default values
}

class Bicycle 
{
	String size;
	Parts p;
	
	Bicycle(String size, Parts p)
	{
		this.size = size;
		this.p = p;
	}
		
	public void spares()
	{
		return p.spares;
	}
}

class RoadBikeParts extends Parts
{
	//override default value of tire_size
	String local_spares;
}

class MountainBikeParts extends Parts
{
	//override default value of tire_size
	String local_spares;
}