package java_practice;

import java.util.*;


//to do: use interface instead to simulate Ruby's module
class Schedulable extends Schedule
{
	//getter and setter for start_date and end_date
}

class Schedule
{
	public void scheduled(Schedulable s)
	{
		System.out.printf("Not scheduled between %s and %s\n"; s.start_date, s.end_date);
	}
}

class Bicycle 
{
	Schedule s;
	String size;
	String chain;
	String tire_size;
	int lead_days;
	
	public void scheduled()
	{
		//wrapper to call scheduled()
	}
}