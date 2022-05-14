package model;

public class parolaHashing
{
	public String parola;
	public int indexString;
	public int indexParola;
	public int risultatoFinale;
	public int risultatoIntermedio;
	
	
	public parolaHashing(String ingressoString ,int indexMatrice ,int indexPersonale) 
	{
		// TODO Auto-generated constructor stub
		parola=ingressoString;
		indexString=indexMatrice;
		indexParola=indexPersonale;
	}
	
	public int sommaNormale() 
	{
		char[] charArray = parola.toCharArray();
        int sum = 0;
        for (int i = 0; i < charArray.length; i++)
        {
                int a = Integer.parseInt(String.valueOf(charArray[i]));
                sum = sum + a;
            
        }
        risultatoIntermedio=sum;
		return sum;
		
	}
	
	public int sommaquadatrica() 
	{
		char[] charArray = parola.toCharArray();
        int sum = 0;
        for (int i = 0; i < charArray.length; i++)
        {
                int a = Integer.parseInt(String.valueOf(charArray[i]));
                a=(int)Math.pow(a, 2);
                sum = sum + a;
            
        }
        risultatoIntermedio=sum;
		return sum;
		
	}
	public int xMod8() 
	{
		if (risultatoIntermedio!=0)
		{
			risultatoFinale = risultatoIntermedio % 8;
		}
		return risultatoFinale;
	}
	
	public int x5_2mod8() 
	{
		if (risultatoIntermedio!=0)
		{
			risultatoFinale = (5*risultatoIntermedio) % 8;
		}
		return risultatoFinale;
	}
	
	public int x_j2mod8() 
	{
		if (risultatoIntermedio!=0)
		{
			risultatoFinale = (risultatoIntermedio + (int)Math.pow(risultatoIntermedio, 2) % 8);
		}
		return risultatoFinale;
	}

}
