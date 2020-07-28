package AppointmentStepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookAppointmentStepDefinitions {

    WebDriver driver;


    @Given("^patient is already on Login Page$")
    public void patient_is_already_on_Login_Page()  {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ShkollaDigjitale\\Desktop\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8081/");

    }

    @When("^login page title is Sign in$")
    public void login_page_title_is_Sign_in() throws InterruptedException {
        Thread.sleep(2000);
        String title = driver.getTitle();
        Assert.assertEquals("Sign in", title);

    }

    @Then("^patient enters \"([^\"]*)\" and \"([^\"]*)\"$")
    public void patient_enters_and(String username, String password) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.name("username")).sendKeys(username);
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys(password);

    }

    @Then("^patient clicks on login button$")
    public void patient_clicks_on_login_button() throws InterruptedException {
        Thread.sleep(2000);
        WebElement loginBtn =
                driver.findElement(By.className("login100-form-btn"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", loginBtn);

    }

    @Then("^patient is on dashboard$")
    public void patient_is_on_dashboard() throws InterruptedException {
        Thread.sleep(2000);
        String title = driver.getTitle();
        Assert.assertEquals("Health Care", title);

    }

    @Then("^patient clicks on book appointment$")
    public void patient_clicks_on_book_appointment() throws InterruptedException {
        Thread.sleep(2000);
        WebElement bookAppointmentBtn =
                driver.findElement(By.id("bookAppointment"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", bookAppointmentBtn);

    }

    @Then("^patient is on Repart list page$")
    public void patient_is_on_Repart_list_page() throws InterruptedException {
        Thread.sleep(2000);
        String title = driver.getTitle();
        Assert.assertEquals("Reparts", title);

    }

    @Then("^patient clicks on cardiology repart$")
    public void patient_clicks_on_cardiology_repart() throws InterruptedException {
        Thread.sleep(2000);
        WebElement cardiologyRepartBtn =
                driver.findElement(By.className("specialization-links"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", cardiologyRepartBtn);

    }

    @Then("^patient is on cardiologist list page$")
    public void patient_is_on_cardiologist_list_page() throws InterruptedException {
        Thread.sleep(2000);
        String title = driver.getTitle();
        Assert.assertEquals("Cardiologists", title);

    }

    @Then("^patient clicks book appointment$")
    public void patient_clicks_book_appointment() throws InterruptedException {
        Thread.sleep(2000);
        WebElement cardiologyBookAppointmenttBtn =
                driver.findElement(By.className("cardiologist-book-appointment"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", cardiologyBookAppointmenttBtn);

    }

    @Then("^patient is on book appointment page$")
    public void patient_is_on_book_appointment_page() throws InterruptedException {
        Thread.sleep(2000);
        String title = driver.getTitle();
        Assert.assertEquals("Book Appointment", title);

    }

    @Then("^patient enters \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void patient_enters_and_and(String date, String time, String description) throws InterruptedException {

//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("document.getElementById('date').value='07/30/2020'");
        Thread.sleep(2000);
        driver.findElement(By.id("date")).sendKeys(date);
        Thread.sleep(2000);
        driver.findElement(By.id("time")).sendKeys(time);
        Thread.sleep(2000);
        driver.findElement(By.id("description")).sendKeys(description);

    }

    @Then("^patient clicks save appointment$")
    public void patient_clicks_save_appointment() throws InterruptedException {
        Thread.sleep(2000);
        WebElement saveAppointmenttBtn =
                driver.findElement(By.id("saveAppointment"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", saveAppointmenttBtn);

    }

    @Then("^patient should see his appointments$")
    public void patient_should_see_his_appointments() throws InterruptedException {
        Thread.sleep(2000);
        String title = driver.getTitle();
        Assert.assertEquals("Patient Appointments", title);

    }

}
