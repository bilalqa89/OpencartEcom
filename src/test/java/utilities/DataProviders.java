package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	//data Provider 1
	
	@DataProvider(name="Logindata")
	public String [][] getdata() throws IOException
	{
		String path=".\\TestData\\Opencartlogindata.xlsx";
		Excelutility xlutil = new Excelutility(path); //creating object for execel utility 
		int totalrows=  xlutil.getrowcount("Sheet1");
		int totalcols = xlutil.getcellcount("Sheet1",1);
		String logindata[][] = new String[totalrows][totalcols];//created to store the data from excel file 
		
		for(int i=1;i<=totalrows;i++) //read data for two dimensional array which can store 
		{
			for(int j=0;j<totalcols;j++)
		
			{
				logindata[i-1][j]=xlutil.getcelldata("Sheet1",i,j);
				
			}	
			
		}
		return logindata;
	}
	
	//data provider 2 
	//data provider 3 
	

}
