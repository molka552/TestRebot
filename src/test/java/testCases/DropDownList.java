package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDownList {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/ressource/drivers/chromedriver");

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/select-menu/");
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement list = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("oldSelectMenu")));
		 
		//Instantiation de la classe select
		Select dropDwon = new Select(list);
		
		dropDwon.selectByValue("5");
		Thread.sleep(2000);
		
		dropDwon.selectByVisibleText("Green");
		Thread.sleep(2000);
		
		dropDwon.selectByIndex(0);
		
		WebElement multiSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cars")));
		
		Select carSelect = new Select(multiSelect);
		/*
		 * carSelect.selectByValue("Volvo"); carSelect.selectByValue("saab");
		 */
		/*
		 * int size = carSelect.getOptions().size(); System.out.print(size); for(int
		 * i=0; i<size;i++) { carSelect.selectByIndex(i); }
		 */
		//verifier si  la liste accept la selection multiple ou nn
		if(carSelect.isMultiple()) {
			carSelect.selectByValue("volvo");
			carSelect.selectByValue("saab");
			carSelect.selectByValue("opel");
			carSelect.selectByValue("audi");
		}else {
			carSelect.selectByValue("volvo");
		}
		//deselection
		carSelect.deselectByValue("volvo");
		
		
	}

}
