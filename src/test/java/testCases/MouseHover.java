package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseHover {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/test/ressource/drivers/chromedriver");

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/menu/");
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement list = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav\"]/li[2]/a")));
		//Scoller le page pour eviter le prb des pub qui pose prb sur l'action
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView();", list);
				//Action
				Actions action = new Actions(driver);
				action.moveToElement(list).perform();

	}

}
