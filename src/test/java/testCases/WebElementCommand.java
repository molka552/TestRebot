package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementCommand {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/test/ressource/drivers/chromedriver");

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		WebDriverWait wait = new WebDriverWait(driver, 3);
		
		WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")));
WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")));
WebElement btnLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")));

userName.sendKeys("Admin");
password.sendKeys("admin123");

//verifier la taille de l'elemenetWeb avec la maquette
Dimension dimension;
dimension = userName.getSize();
System.out.print(dimension.height);
//Vérifier la position de l'élement
Point pnt = btnLogin.getLocation();
System.out.println("Position de bouton login : "+ pnt.x+"y :"+pnt.y);

//Verifier la couleur d'un elment
System.out.println(btnLogin.getCssValue("color"));

//Vérifier si l'elemnt est actif ou nn
boolean isTrue= btnLogin.isEnabled();
System.out.println(isTrue);

//Vérifier si l'element est affiche sur la page
boolean isTrue2 = password.isDisplayed();
System.out.println(isTrue2);


	}

}
