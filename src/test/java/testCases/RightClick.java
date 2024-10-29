package testCases;

import java.awt.Desktop.Action;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.graph.ElementOrder;

public class RightClick {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/test/ressource/drivers/chromedriver");

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/buttons");

		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement rightClick;
		rightClick = wait.until(ExpectedConditions.elementToBeClickable(By.id("rightClickBtn")));
		Actions action = new Actions(driver);
		action.contextClick(rightClick).perform();
		String msgattendu = "You have done a right click";
		//WebElement elementObtenu;
		String msgObtenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rightClickMessage"))).getText()	;
		//String msgObtenu= elementObtenu.getText();
		Assertions.assertEquals(msgattendu, msgObtenu);
		System.out.print("passed");
		driver.quit();
		
	}


}
