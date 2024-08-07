package com.actitime.generic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.acti_time.generice.FileLib;
import com.acti_time.pom.LoginPage;

public class BaseCLass {
	public static WebDriver driver;
	@BeforeTest
	public void openBrowser() {
	Reporter.log("openBrowser",true);	
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://localhost/login.do");
	}
	@BeforeMethod
public void Login() throws IOException {
		Reporter.log("login",true);	
		FileLib f=new FileLib();
		String url = f.getPropertyData("url");
		String un = f.getPropertyData("username");
		String pw = f.getPropertyData("password");
		driver.get(url);	
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		}	

	@AfterMethod
public void Logout() {
	Reporter.log("login",true);	
	driver.findElement(By.id("logoutLink")).click();
	
}
	@AfterTest
public void closeBrowser() {
	Reporter.log("closeBrowser",true);	
	driver.quit();
}

}


