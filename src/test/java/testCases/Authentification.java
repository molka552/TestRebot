package testCases;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Authentification {

	public static void main(String[] args) throws InterruptedException {
//chemin de chrome driver
		System.setProperty("webdriver.chrome.driver","src/test/ressource/drivers/chromedriver");
	//instantiation de la classe chromedriver:ouvrir le navigateur chrome
	ChromeDriver driver= new ChromeDriver();
	//ouvrire l'url de l'application
	driver.get("https://opensource-demo.orangehrmlive.com");
	//maximisier la fenetre
	driver.manage().window().maximize();
	//Ajouter un temps d'attente force
	//Thread.sleep(3000);
	//ajouter une methode implicite wait
	//driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	//saisir login sans explicit wait
	//driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("Admin");
	//Saisir password
	//driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("admin123");
	//saisir login avec explicit wait
	WebDriverWait wait= new WebDriverWait(driver, 3); 
	WebElement userName;
	userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")));
	userName.sendKeys("Admin");
	
	WebElement passWord = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
	passWord.sendKeys("admin123");
	//cliquer sur le button
	driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	//fermer  la fenetre
	//driver.quit();
	//verifier la redirection vers la page dashbord
	String resultatAttendu = "Dashboard";
	WebElement elementObtenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module")));
	
	String resultatObtenu= elementObtenu.getText();
	System.out.println("Text obtenu"+resultatObtenu);
	Assertions.assertEquals(resultatAttendu, resultatObtenu);
	//ki yabda 7ajet fixe mattbadelch
	Assertions.assertTrue(resultatObtenu.contains(resultatAttendu));
	System.out.println("passed");
	}

}
