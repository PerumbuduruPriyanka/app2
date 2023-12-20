package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	WebDriver driver;
	@Given("Opne Chorme Browser")
	public void opne_chorme_browser() {
	    driver=new EdgeDriver();
	}

	@Given("Open URL {string}")
	public void open_url(String string) {
		driver.get("https://demo.guru99.com/V4/");
	    
	}

	@When("Login ID Login Password")
	public void login_id_login_password() {
		driver.findElement(By.name("uid")).sendKeys("mngr512103");
		driver.findElement(By.name("password")).sendKeys("ahUdAsA");
	    
	}

	@When("Click on Submit")
	public void click_on_submit() {
		driver.findElement(By.name("btnLogin")).click();
	   
	}

	@Then("Redirect to Bankpage")
		public void redirect_to_bankpage() {
			WebElement Image= driver.findElement(By.xpath("/html/body/table/tbody/tr/td/center/img[1]"));
			if(Image.isDisplayed())
			{
			System.out.println("Login Success");
			}
			else
			{
			System.out.println("Login Failed");
			}
	    
	}

	@Then("Click on New Customer")
	public void click_on_new_customer() {
		driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a")).click();
	}

	@Then("fill details and submit")
	public void fill_details_and_submit() {
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input")).sendKeys("raju");
	    driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]")).click();
	    driver.findElement(By.name("dob")).sendKeys("15-11-1997");
	    driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/textarea")).sendKeys("dilsukhnagar");
	    driver.findElement(By.name("city")).sendKeys("hyderabad");
	    driver.findElement(By.name("state")).sendKeys("telangana");
	    driver.findElement(By.name("pinno")).sendKeys("5000060");
	    driver.findElement(By.name("telephoneno")).sendKeys("12345678910");
	    driver.findElement(By.name("emailid")).sendKeys("ravi@gmail.com");
	    driver.findElement(By.name("password")).sendKeys("priya@12");
	    driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[14]/td[2]/input[1]")).click();
	}




}
