package com.ActiTime.Testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ActiTime.GenericLibrary.BaseClass;
import com.ActiTime.GenericLibrary.FileLibrary;
import com.ActiTime.GenericLibrary.ListnerImplementation;
import com.ActiTime.pom.HomePage;
import com.ActiTime.pom.TaskPage;

import graphql.org.antlr.v4.runtime.tree.xpath.XPath;
@Listeners(ListnerImplementation.class)
public class CreateCustomer extends BaseClass {
	@Test
	public void CreateCustomer() throws EncryptedDocumentException, IOException{
		HomePage hp = new HomePage(driver);
		hp.getTasktab().click();
		TaskPage tp = new TaskPage(driver);
		tp.getAddnewcust().click();
		tp.getNewcust().click();
		FileLibrary f = new FileLibrary();
		String name = f.readDataFromExcel("Sheet1", 3, 1);
		tp.getCustname().sendKeys(name);
		String desp = f.readDataFromExcel("Sheet1", 1, 2);
		tp.getCustdesp().sendKeys(desp);
		tp.getCreatecust().click();
		
		String expectedresult = name ;
		String actualresult = driver.findElement(By.xpath("//div[.='"+name+"']")).getText();
		SoftAssert s = new SoftAssert();
		s.assertEquals(expectedresult, actualresult);
		s.assertAll();
		
	}
	

}
