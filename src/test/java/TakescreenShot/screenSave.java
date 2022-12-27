package TakescreenShot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class screenSave {
   public 	static WebDriver driver;
   
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS );
	}
	
	@Test
	public void testCase1() throws IOException, InterruptedException {
		
		driver.findElement(By.xpath("//a[text()='About']")).click();
		takescreenshot();
		driver.navigate().back();
		driver.findElement(By.xpath("//a[text()='Store']")).click();
		takescreenshot();
		driver.navigate().back();
		
	}
	
	
	
	
	
	
	public static void takescreenshot() throws IOException
	{
		Date c = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHHmmssZ");
		String sdate =formatter.format(c);
		TakesScreenshot shot= (TakesScreenshot) driver;
		File source = shot.getScreenshotAs(OutputType.FILE);
		File dst=new File("C:\\ScreenShot\\src\\test\\resources\\screenshot"+sdate+".png");
		FileUtils.copyFile(source, dst);
		
	}

	
}
