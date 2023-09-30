package com.ActiTime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ActiTime.pom.LoginPage;

public class BaseClass {

	FileLibrary f = new FileLibrary();
	public static WebDriver driver;
	@BeforeSuite
	public void databaseConnection(){
		Reporter.log("DataBase Connected",true);
		
	}
	@BeforeClass
	public void LaunchBrowser() throws IOException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String Link = f.readDataFromPropertyFile("url");
		driver.get(Link);
		driver.get("https://demo.actitime.com/login.do");
		Reporter.log("Browser Launched Successfully",true);
	}
	@BeforeMethod
	public void loginToActiTime() throws IOException {
		LoginPage lp =new LoginPage(driver);
		String un = f.readDataFromPropertyFile("username");
		lp.getUntbx().sendKeys(un);
		String pw = f.readDataFromPropertyFile("password");
		lp.getPwtbx().sendKeys(pw);
		lp.getLgbtn().click();
		Reporter.log("logged in Successfully",true);
	}
	@AfterMethod
	public void logoutFromActitime() {
		driver.findElement(By.id("logoutLink")).click();
		Reporter.log("logged out Successfully",true);
		
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
		Reporter.log("Browser closed Successfully",true);
	}
	@AfterSuite
	public void closeddatabaseconnection() {
		Reporter.log("database disconnected",true);
		
	}
	

}
