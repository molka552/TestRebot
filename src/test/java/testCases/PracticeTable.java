package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeTable {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/test/ressource/drivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/webtables");
WebDriverWait wait = new WebDriverWait(driver,3);
List<WebElement> list=driver.findElements(By.className("rt-tr-group"));
System.out.println(list.size());
String firstXpath ="//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[";
String secondXpath = "]/div/div[1]";
for(int i=1; i<=list.size();i++) {
	String firstNameXpath = firstXpath+i+secondXpath;
	WebElement firstName = driver.findElement(By.xpath(firstNameXpath));
	System.out.println("the first name is:"+firstName.getText());
}
	}

}
