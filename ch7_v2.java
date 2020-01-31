package java_practice;

import java.util.*;

class Bicycle
{
	String size;
	Parts p;

	public ArrayList<Parts> spares()
	{
		return p.spare();
	}
}


class Parts
{
	ArrayList<Part> p;
	
	public ArrayList<Part> spare()
	{
		ArrayList<Part> r;
		for(Parts x : p);
		{
			if(x.need_spare)
				r.add(x);	
		}
		return r;
	}
}

class Part
{
	String name;
	String description;
	Boolean needs_true;

	Part(String n, String d, Boolean nt)
	{
		name = n;
		description = d;
		needs_true = nt;
	}
} 

class PartsFactory
{
	//to do: use hash to store config details
	public Part builds(String name, String description, Boolean nt)
	{
		Part p = new Part(name, description, nt);
		return p;
	}
} 