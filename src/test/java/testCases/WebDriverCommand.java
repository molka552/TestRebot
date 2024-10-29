package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverCommand {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/test/ressource/drivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com");
		String titre = driver.getTitle();
		System.out.println("le titre de la page est:"+titre);
System.out.println(driver.getCurrentUrl());
System.out.println(driver.getPageSource());
//driver.navigate().back();
//driver.navigate().forward();
//driver.navigate().refresh();

driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

WebElement btnLogin =  driver.findElement(By.xpath("//button[@type='submit']"));
JavascriptExecutor js= (JavascriptExecutor)driver;
//dima argument de 0 
js.executeScript("arguments[0].click()", btnLogin);


	}

}
