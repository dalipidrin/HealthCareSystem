package LoginStepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginSteps {

    WebDriver driver;

    @Given("^user is already on Login Page$")
	 public void user_already_on_login_page(){
	 System.setProperty("webdriver.chrome.driver","C:\\Users\\ShkollaDigjitale\\Desktop\\chromeDriver\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.get("http://localhost:8081/");
	 }


	 @When("^title of login page is Sign in$")
	 public void title_of_login_page_is_Sign_in() throws InterruptedException {
    	Thread.sleep(2000);
	 	String title = driver.getTitle();
	 	System.out.println(title);
	 	Assert.assertEquals("Sign in", title);
	 }



	 @Then("^user enters \"(.*)\" and \"(.*)\"$")
	 public void user_enters_username_and_password(String username, String password) throws InterruptedException {
    	Thread.sleep(2000);
	    driver.findElement(By.name("username")).sendKeys(username);
	    Thread.sleep(2000);
	    driver.findElement(By.name("password")).sendKeys(password);
	 }

	 @Then("^user clicks on login button$")
	 public void user_clicks_on_login_button() throws InterruptedException {
		 Thread.sleep(2000);
		 WebElement loginBtn =
	 	 driver.findElement(By.className("login100-form-btn"));
	 	 JavascriptExecutor js = (JavascriptExecutor)driver;
	 	 js.executeScript("arguments[0].click();", loginBtn);
	 }


	 @Then("^user is on dashboard$")
	 public void user_is_on_home_page() throws InterruptedException {
		 Thread.sleep(2000);
	 	 String title = driver.getTitle();
	 	 System.out.println("Dasbhoard::"+ title);
	 	 Assert.assertEquals("Health Care", title);
	 }

//	 @Then("^user moves to new contact page$")
//	 public void user_moves_to_new_contact_page() {
//		driver.switchTo().frame("mainpanel");
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"))).build().perform();
//		driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();
//
//		}
//
//
//	 @Then("^user enters contact details \"(.*)\" and \"(.*)\" and \"(.*)\"$")
//	 public void user_enters_contacts_details(String firstname, String lastname, String position){
//		 driver.findElement(By.id("first_name")).sendKeys(firstname);
//		 driver.findElement(By.id("surname")).sendKeys(lastname);
//		 driver.findElement(By.id("company_position")).sendKeys(position);
//		 driver.findElement(By.xpath("//input[@type='submit' and @value='Save']")).click();
//	 }
//
//
//	 @Then("^Close the browser$")
//	 public void close_the_browser(){
//		 driver.quit();
//	 }
}
