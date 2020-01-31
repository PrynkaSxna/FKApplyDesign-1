package java_practice;

import java.util.*;

class Bicycle
{
	String size;
	String tape_color;

	String chain = "10-speed";
	String tire_size = "23";

	Bicycle(String size, String tape_color)
	{
		this.size = size;
		this.tape_color = tape_color;
	}
}

class Bicycle1
{
	String size;
	String tape_color;
	String chain;
	String tire_size;
	String style;

	Bicycle(String size, String tape_color, String style)
	{
		this.size = size;
		this.tape_color = tape_color;
		this.style = style;
	}

	public void spare()
	{
		if(style == "road")
		{
			chain = "10-speed";
			tire_size = "23";
		}
		else
		{
			chain = "10-speed";
			tire_size = "2.1";
		}
	}
} 

class Bicycle3
{
	//size and spare
}

class RoadBike extends Bicycle3
{
	//tape_color
}

class MountianBike extends Bicycle3
{
	//shock
}   

class Bicycle4
{
	//size, chain, tire_size
} 

class Bicycle5
{
	//size, chain, tire_size and default_chain(), default_tire_size()
} 

class MountainBike1 extends Bicycle5
{
	//default_tire_size()
} 

class RoadBike1 extends Bicycle5
{
	//default_tire_size()
}

clas Bicycle5
{
	//size, chain, tire_size and spare(), constructor with default value of chain
}

class MountainBike2 extends Bicycle5
{
	//constructor with default tire size
} 

class RoadBike1 extends Bicycle5
{
	//constructor with default tire size
}

class Bicycle6
{
	//size, chain, tire_size and initalize() and local_spare(), default_tire_size() and default_chain() 
}

class MountainBike3 extends Bicycle5
{
	//override initialize(), local_spare(), deafult_chain()
} 

class RoadBike3 extends Bicycle5
{
	//overrise initialize(), local_spare(), default_tire_size()
}