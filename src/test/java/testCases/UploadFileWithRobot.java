package testCases;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFileWithRobot {
	// Declaration des variables
	public ChromeDriver driver;
	String path = "/home/molka/Pictures/2024-10-01_19-59.png";

	@BeforeAll

	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/ressource/drivers/chromedriver");
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		// yistana ell telechargement de la page ell kol bich yjiblek ell elmnt
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	public void uploadFile(String path) {
		StringSelection stringSelection = new StringSelection(path);
		// ctrl+c dans la press-papier
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);

		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		// ctrl+v
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		// bich ysayeb ell clique
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.keyPress(KeyEvent.VK_ENTER);

	}

	@Test
	public void robotTest() {
		WebElement addFileBtn = driver.findElement(By.className("btn btn-success fileinput-button"));
		addFileBtn.click();

		uploadFile(path);

	}

	@AfterAll

	public void closeDriver() {
		driver.quit();
	}

}
