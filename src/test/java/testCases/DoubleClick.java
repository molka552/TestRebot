package testCases;

import java.awt.Desktop.Action;

import javax.lang.model.element.Element;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DoubleClick {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/test/ressource/drivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/buttons");
//Instantiantion de la class Webdriverwait: utiliser l'explicite wait
		WebDriverWait wait = new WebDriverWait(driver, 3);
//Declarer l'element bouton double click

		WebElement btnDoubleClick;
		btnDoubleClick = wait.until(ExpectedConditions.elementToBeClickable(By.id("doubleClickBtn")));
//Instantiation de la class Actions
		Actions action = new Actions(driver);
		action.doubleClick(btnDoubleClick).perform();

		// verification msg obtenu
		String resltAttendu = "You have done a double click";

		WebElement elementObtenu;
		elementObtenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickMessage")));
		String resltObtenu = elementObtenu.getText();

		Assertions.assertEquals(resltObtenu, resltAttendu);
	}

}
