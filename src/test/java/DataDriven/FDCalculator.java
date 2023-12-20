package DataDriven;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class FDCalculator {
	public static void main(String[] args) throws IOException {
		WebDriver driver=new EdgeDriver(); 
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		WebElement IniDeposit=driver.findElement(By.id("mat-input-0"));
		WebElement Length=driver.findElement(By.id("mat-input-1"));
		WebElement IntRate=driver.findElement(By.id("mat-input-2"));
		WebElement CalButton=driver.findElement(By.xpath("//*[@id=\"CIT-chart-submit\"]/div"));
		System.out.println("All elements are inspected");
		String path="C:\\Users\\Sony\\eclipse-workspace\\Techflow1\\TestData\\caldata.xlsx";
		int rows=XLUtils.getRowCount(path,"Sheet1");
		System.out.println("Row count:"+rows);
		for(int i=1;i<8;i++) {
			//reading excel
			String INDEP=XLUtils.getcelldata(path, "Sheet1", i, 0);
			String INRATE=XLUtils.getcelldata(path, "Sheet1", i, 1);
			String Month=XLUtils.getcelldata(path, "Sheet1", i, 2);
			String EXPTOTAL=XLUtils.getcelldata(path, "Sheet1", i, 4);
			IniDeposit.clear();
			Length.clear();
			IntRate.clear();
			IniDeposit.sendKeys(INDEP);
			Length.sendKeys(Month);
			IntRate.sendKeys(INRATE);
			CalButton.click();
			
			String ActualAmount=driver.findElement(By.xpath("//*[@id=\"displayTotalValue\"]")).getText();
			System.out.println(ActualAmount);
			if(EXPTOTAL.equals(ActualAmount))
			{
				XLUtils.Setcelldata(path, "Sheet1", i,6,"Passed");
				XLUtils.fillGreenColor(path, "Sheet1", i,6);
				
			}
			else {
				XLUtils.Setcelldata(path, "Sheet1", i,6,"Failed");
				XLUtils.fillRedColour(path, "Sheet1", i,6);
			}
			
			
		}
		
		

		}

	}
