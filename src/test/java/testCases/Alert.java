package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alert {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/ressource/drivers/chromedriver");

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts/");

		WebDriverWait wait = new WebDriverWait(driver, 3);
		
		WebElement clickMe = wait.until(ExpectedConditions.elementToBeClickable(By.id("alertButton")));
	
		clickMe.click();
		
		String textAlert = driver.switchTo().alert().getText();
		System.out.println(textAlert);
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
	}

}
