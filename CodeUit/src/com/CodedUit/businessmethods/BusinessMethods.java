package com.CodedUit.businessmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BusinessMethods 
{
	public WebDriver driver=null;
	public String prPath=(System.getProperty("user.dir").replace("\\", "\\\\"));
	public String CodedUit_Launch(String url)
	{
		System.setProperty("webdriver.chrome.driver", prPath+"/"+"src/bin/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver, 360);
		WebElement signin=driver.findElement(By.xpath("//a[@ui-sref='app.login']"));
		if (signin.isDisplayed())
		{
			return "Pass";
		}
		else
		{
			return "Fail";
		}
	}
	
	public String CodedUit_Login(String un,String pwd) throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@ui-sref='app.login']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(10000);
		WebElement username=driver.findElement(By.xpath("//a[@ui-sref='app.settings']"));
		if (username.isDisplayed())
		{
			return "Pass";
		}
		else
		{
			return "Fail";
		}
	}
	
	public String CodedUit_Settings(String pwd)
	{
		driver.findElement(By.xpath("//a[@ui-sref='app.settings']")).click();
		driver.findElement(By.xpath("//textarea[@placeholder='Short bio about you']")).sendKeys("I am a trainer");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Keys.TAB);
		Actions act=new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Sleeper.sleepTightInSeconds(10);
		WebElement PrImg=driver.findElement(By.xpath("//img[@src='https://static.productionready.io/images/smiley-cyrus.jpg']"));
		if (PrImg.isDisplayed())
		{
			return "Pass";
		}
		else
		{
			return "Fail";
		}
	}
	public String CodedUit_Logout()
	{
		driver.findElement(By.xpath("//a[@ui-sref='app.settings']")).click();
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//button[contains(text(),'logout')]"))).build().perform();
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
//		Sleeper.sleepTightInSeconds(10);
		driver.findElement(By.xpath("//button[contains(text(),'logout')]")).click();
		WebElement signin=driver.findElement(By.xpath("//a[@ui-sref='app.login']"));
		if (signin.isDisplayed())
		{
			return "Pass";
		}
		else
		{
			return "Fail";
		}
	}
	public void CodedUi_Close()
	{
		driver.close();
	}
}
