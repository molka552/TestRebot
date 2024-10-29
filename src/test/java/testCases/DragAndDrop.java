package testCases;

import java.awt.Desktop.Action;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDrop {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/test/ressource/drivers/chromedriver");

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/droppable/");

		WebDriverWait wait = new WebDriverWait(driver, 3);
		//Action drop
		WebElement dragMe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggable")));
		WebElement dropHere = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("droppable")));
		
		//Scoller le page pour eviter le prb des pub qui pose prb sur l'action
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", dropHere);
		
		//Action drop
		Actions action = new Actions(driver);
		action.dragAndDrop(dragMe, dropHere).perform();
		
		//Verfification du résultat
		String resultatAttendu="Dropped!";
		String resultatObtenu = dropHere.getText();
		Assertions.assertTrue(resultatObtenu.contains(resultatAttendu));
		System.out.println("Passed!");

	}

}
