package RegisterStepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RegisterSteps {

    WebDriver driver;

    @Given("^New user is already on Login Page$")
    public void new_user_is_already_on_Login_Page()  {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\ShkollaDigjitale\\Desktop\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8081/");

    }

    @When("^title for login page is Sign in$")
    public void title_for_login_page_is_Sign_in() throws InterruptedException {
        Thread.sleep(2000);
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals("Sign in", title);

    }

    @Then("^user clicks on create account button$")
    public void user_clicks_on_create_account_button() throws InterruptedException {
        Thread.sleep(2000);
        WebElement createAccountBtn =
                driver.findElement(By.className("txt1"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", createAccountBtn);

    }

    @Then("^user is on register page$")
    public void user_is_on_register_page() throws InterruptedException {
        Thread.sleep(2000);
        String title = driver.getTitle();
        System.out.println("Register page::"+ title);
        Assert.assertEquals("Sign up", title);

    }

    @Then("^user enters \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void new_user_enters_and_and(String email, String username, String password) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).click(); // Keep this click statement even if you are using click before clear.
        driver.findElement(By.name("email")).sendKeys(email);
        Thread.sleep(2000);
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).click(); // Keep this click statement even if you are using click before clear.
        driver.findElement(By.name("username")).sendKeys(username);
        Thread.sleep(2000);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).click(); // Keep this click statement even if you are using click before clear.
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @Then("^user clicks on register button$")
    public void user_clicks_on_register_button() throws InterruptedException {
        Thread.sleep(2000);
        WebElement registerAccountBtn =
                driver.findElement(By.className("login100-form-btn"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", registerAccountBtn);

    }

    @Then("^New user is on login page$")
    public void new_user_is_on_login_page() throws InterruptedException {
        Thread.sleep(2000);
        String title = driver.getTitle();
        System.out.println("Login page::"+ title);
        Assert.assertEquals("Sign in", title);

    }



}
