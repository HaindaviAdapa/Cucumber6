package GlueCode;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition
{
WebDriver driver;

@Given("User opens chrome browser")
public void user_opens_chrome_browser() {
    
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	driver =new ChromeDriver();    // driver=111222
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
	driver.manage().window().maximize() ;	

	
}
@Then("User opens application URL{string}")
public void user_opens_application_url_https_opensource_demo_orangehrmlive_com_web_index_php_auth_login(String TestURL) {
    
	driver.get(TestURL);


}
@Given("User enters Username as {string} and Password as {string}")
public void user_enters_username_as_and_password_as(String UserName1, String PassWord1) {
    

	driver.findElement(By.xpath("//input[@name='username']")).sendKeys(UserName1);
	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(PassWord1);
	driver.findElement(By.xpath("//button[@type='submit']")).click();


}
@When("User creats Nationality record")
public void user_creats_nationality_record(io.cucumber.datatable.DataTable dataTable) {
    
    List<Map<String ,String>>Nationalitydata=dataTable.asMaps(String.class,String.class);
    
    System.out.println("Number of rows:"+Nationalitydata.size());
    
    for(int i=0;i<Nationalitydata.size();i++) {
    	
    System.out.println(Nationalitydata.get(i).get("NationalityText"));
    	
    String NationalityText=Nationalitydata.get(i).get("NationalityText");
    	
    System.out.println("_________________________");
    
    driver.findElement(By.xpath("//span[text()='Admin']")).click(); //Admin
    driver.findElement(By.xpath("//a[text()='Nationalities']")).click();//Nationalities
	driver.findElement(By.xpath("(//button[@type='button'])[2]")).click(); //Addbuttonn
	driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(NationalityText);
	driver.findElement(By.xpath("//button[@type='submit']")).click();

    	
  }
    



}
@Then("User logout")
public void user_logout() {
    
	driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
	driver.findElement(By.xpath("//a[text()='Logout']")).click();  



}
@Then("User close browser")
public void user_close_browser() {


   driver.close();

}
}
