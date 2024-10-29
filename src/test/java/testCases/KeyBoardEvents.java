package testCases;

import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KeyBoardEvents {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/test/ressource/drivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/text-box");
WebDriverWait wait = new WebDriverWait(driver,3);
WebElement fullName,email,currentAdress, permanentAdress;
fullName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userEmail")));
currentAdress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("currentAddress")));
permanentAdress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("permanentAddress")));
	
fullName.sendKeys("molka");
email.sendKeys("molka@gmail.com");
currentAdress.sendKeys("Tunis");

JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("window.scrollBy(0,600)","");
Actions action = new Actions(driver);

//copier coller

action.keyDown(currentAdress,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
action.keyDown(permanentAdress,Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();


	}

}
