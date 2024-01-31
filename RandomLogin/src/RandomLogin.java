import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RandomLogin {

	WebDriver driver = new ChromeDriver();
String[] UserNames = {"standard_user", "locked_out_user", "problem_user", "performance_glitch_user", "error_user",
		"visual_user"} ;

Random rand = new Random();

  @BeforeTest 
  public void mySetup() {
	  
  }
  
  @Test()
  
  
  public void LoginUsingDifferentUserNames() throws InterruptedException {
	  
	  System.out.println(rand.nextInt(UserNames.length));
	  
	  
 driver.get("https://www.saucedemo.com/");
  WebElement UserNameInputField = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
  WebElement PasswordInputField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
  WebElement LoginButtonInputField = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
  
     String theUser = UserNames[rand.nextInt(UserNames.length)];
     
     String CommonPassword = "secret_sauce";
     
     UserNameInputField.sendKeys(theUser);
     PasswordInputField.sendKeys(CommonPassword);
     LoginButtonInputField.click();
     
     
     driver.manage().window().maximize();
     
     List<WebElement> AddTocartButtons = driver.findElements(By.className("btn"));
     
     for (int i = 0; i < AddTocartButtons.size() ; i++) {
    	 AddTocartButtons.get(i).click();
     }
	  
	  int expecteditemAsNumber = AddTocartButtons.size();
	//  String expectedItemAsText = Integer.toString(expecteditemAsNumber);
	  
	//  String actualitem = driver.findElement(By.xpath("//[@id=/"shopping_cart_container\"]/a/span")).getText();
	  
	  String actualitem = null;
	int actualitemAsNumber = Integer.parseInt(actualitem);

		assertEquals(actualitemAsNumber, expecteditemAsNumber);

	}

	  
	  
}  
	  
	  
	  
	  
	  
	  
	  
	  
	  
  
  