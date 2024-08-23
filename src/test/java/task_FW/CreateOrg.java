package task_FW;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.fileUtility.ExcelUtility;
import com.fileUtility.FileUtility;

public class CreateOrg {

	public static void main(String[] args) throws Throwable {

		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();

		
		String URL = fLib.getData("url");
		String BROWSER = fLib.getData("browser");
		String UN = fLib.getData("username");
		String PWD = fLib.getData("password");

		String orgName = eLib.getDataFromExcel("org", 1, 2);

		WebDriver driver = null;

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();

		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).submit();

		driver.findElement(By.linkText("Organizations")).click();

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		driver.findElement(By.name("accountname")).sendKeys(orgName);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	}
}