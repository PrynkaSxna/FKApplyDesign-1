package java_practice;

import java.util.*; 

class Gear
{
	int chainring;
	int cog;
	ObscuringReferences obj;

	/**
	int rim;
	int tire;
	**/

	Gear(int chainring, int cog)
	{
		setChainring(chainring);
		setCog(cog);
	}
	
	public float ratio()
	{
		return (float) getChainring() / getCog();
	}

	private int getChainring()
	{
		return chainring;
	}

	
	private int getCog()
	{
		return cog;
	}

	private void setChainring(int chainring)
	{
		this.chainring = chainring;
	}

	private void setCog(int cog)
	{
		this.cog = cog;
	}

	/** removed since each classes should exhibit cohesiveness
	public float gear_inches()
	{
		return ratio() * (rim + tire * 2);
	}
	**/
}

class ObscuringReferences
{
	int[][] data;
	
	class Wheel
	{
	    int tire;
	    int rim;
	}
		
	ObscuringReferences(int[][] data)
	{
		setData(data);
	}

	private int[][] getData()
	{
		return data;
	}

	private void setData(int[][] data)
	{
		this.data = data;
	}

        private Wheel[] wheelify()
    	{
        	int[][] dw = getData();
        	Wheel[] w = new Wheel[dw.length];
        	for(int a=0; a<dw.length; a++)
        	{
            		w[a].tire = dw[a][0];
            		w[a].rim = dw[a][1];
        	}
        	return w;
    	}

	public int[] diameter()
	{
		Wheel[] w = wheelify();
		int[] r = new int[w.length];
		for(int a=0; a<w.length; a++)
		    r[a] = w[a].tire + w[a].rim;
		 return r;
	}
} 

class ObscuringReferences2
{
	int[][] data;
	
	class Wheel
	{
	    int tire;
	    int rim;
	    
	    public int diameter()
	    {
	        return tire + rim;
	    }
	}
		
	ObscuringReferences(int[][] data)
	{
		setData(data);
	}

	private int[][] getData()
	{
		return data;
	}

	private void setData(int[][] data)
	{
		this.data = data;
	}

    private Wheel[] wheelify()
    {
        int[][] dw = getData();
        Wheel[] w = new Wheel[dw.length];
        for(int a=0; a<dw.length; a++)
        {
            w[a].tire = dw[a][0];
            w[a].rim = dw[a][1];
        }
        return w;
    }

	public int[] diameter()
	{
		Wheel[] w = wheelify();
		int[] r = new int[w.length];
		for(int a=0; a<w.length; a++)
		    r[a] = w[a].diameter();
		 return r;
	}
}