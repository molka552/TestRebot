package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadFile {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/test/ressource/drivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/upload/");
WebDriverWait wait = new WebDriverWait(driver, 5);
WebElement btnUpload = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadfile_0")));
btnUpload.sendKeys("/home/molka/Pictures//2024-10-01_19-59.png");
WebElement accept = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("terms")));
accept.click();

WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitbutton")));
submit.click();
	}

}
