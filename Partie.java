import java.io.*;

public class Partie 
{
	
	private int niveauCourant;
	private int niveauMaxAtteint;
	
	private final String fichierSVG = System.getProperty("user.home")+
					System.getProperty("file.separator")+"soko.svg";
	
	public Partie() 
	{
		try 
		{
			BufferedReader flot = new BufferedReader(new FileReader(fichierSVG));
			niveauMaxAtteint = flot.read();
			flot.close();
		}
		catch (Exception e) 
		{
			niveauMaxAtteint = 1;
		}
		niveauCourant = 1;
	}
	
	//------------------------------------------------------------------------------------------
	
	public int getNiveauCourant() 
	{
		return niveauCourant;
	}
	
	//------------------------------------------------------------------------------------------
	
	public int getNiveauMaxAtteint() 
	{
		return niveauMaxAtteint;
	}
	
	//------------------------------------------------------------------------------------------
	
	public void goToNextLevel() 
	{
		this.niveauCourant+= (niveauCourant != 10)?1:0;;
		this.niveauMaxAtteint = (niveauCourant > niveauMaxAtteint)? niveauCourant : niveauMaxAtteint;
		try 
		{
			FileWriter flot = new FileWriter(fichierSVG);
			flot.write(niveauMaxAtteint);
			flot.close();
		}
		catch (Exception e) {}
	}
	
	//------------------------------------------------------------------------------------------
	
	public void goToPreviousLevel() 
	{
		if (niveauCourant != 1) niveauCourant--;
	}
	
	//------------------------------------------------------------------------------------------
	
	public void goToLevel(int n) 
	{
		if (n >= 1) 
		{
			niveauCourant = (n > niveauMaxAtteint)?niveauMaxAtteint:n;
		}
	}
}