public class MagicSquare
{
	
	public static void main( String [] args )
	{
		int [][] square4by4 = {{16,3,2,13},{5,10,11,8},{9,6,7,12},{4,15,14,1}};
		int [][] square3by3 = { {1, 6, 4}, {8, 2, 9}, {5, 7, 3} };
		MagicSquare case1 = new MagicSquare(square3by3);
		MagicSquare case2 = new MagicSquare(square4by4);
		String table1 = case1.toString();
		String table2 = case2.toString();
		// Display the table
		System.out.println(table1);
		System.out.println(table2);
		if (case1.isAmagicSq())
			System.out.println( "square3by3 is a magic square");
		else
			System.out.println( "square3by3 is not a magic square");
		// Repeat for the 4x4 square here.
		if (case2.isAmagicSq())
			System.out.println( "square4by4 is a magic square");
		else
			System.out.println( "square4by4 is not a magic square");
	}

	//1. Write a constructor to create a deep copy of the 2-D array formal parameter. There should be a private instance field for
	//holding the deep copy of the input array.
	private int [][] table;
	
	public MagicSquare(int [][] t)
	{
		table=new int[t.length][t.length];
		for(int i=0; i<table.length; i++)
		{
			for(int ii=0; ii<table[i].length; ii++)
			{
				table[i][ii]=t[i][ii];
			}
		}
	}
	
	//2. Write the toString method to return a String with a table containing the magic square.
	public String toString()
	{
		String a="";
		for(int r=0; r<table.length; r++)
		{
			for(int c=0; c<table[r].length; c++)
			{
				a+=table[r][c]+"  ";
			}
			a+="\n";
		}
		System.out.println();
		return a;
	}
	
	//3. Determine if the 2-Dimensional array is or is not a magic square using an instance method.
	public boolean isAmagicSq()
	{
		int mdiag=0;
		for(int m=0; m<table.length; m++)
			mdiag+=table[m][m];
		
		int diag=0;
		int a=table.length-1;
		for(int d=0; d<table.length; d++)
		{
			diag+=table[d][a];
			a--;
		}
		if(mdiag!=diag)
			return false;
		
		int row=0;
		for(int r=0; r<table.length; r++)
		{
			row=0;
			for(int c=0; c<table[r].length; c++)
			{
				row+=table[r][c];
			}
			if(mdiag!=row)
				return false;
		}
		
		int col=0;
		for(int ir=0; ir<table.length; ir++)
		{
			col=0;
			for(int ic=0; ic<table[ir].length; ic++)
			{
				col+=table[ic][ir];
			}
			if(mdiag!=col)
				return false;
		}
			return true;
	}
}
