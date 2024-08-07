package com.actitime.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseCLass;
import com.actitime.generic.FileLib;

@Listeners(com.actitime.generic.ListenerImplementation.class)
public class CustomerModule  extends BaseCLass {
		@Test
		public void testCreatecustomer() throws EncryptedDocumentException, IOException {
			Reporter.log("Createcustomer",true);
			FileLib f=new FileLib();
			String cn = f.getExcelData("CreateCustomer", 1, 3);
			driver.findElement(By.xpath("//div[text()='TASKS']")).click();
			driver.findElement(By.xpath("//div[text()='Add New']")).click();
			driver.findElement(By.xpath("//div[text()='+ New Customer'")).click();
			driver.findElement(By.id("customerLightBox_nameField")).sendKeys("HDFC");
			driver.findElement(By.id("customerLightBox_descriptionField")).sendKeys("BankingDomin");
			driver.findElement(By.xpath("//button[@class='x-btn-text']")).click();
			driver.findElement(By.xpath("//a[text()='Our Company']")).click();
			driver.findElement(By.xpath("//span[text()='Create Customer']")).click();
			String actualCust = driver.findElement(By.xpath("//div[@class='navigationLinks']/../div[2]")).getText();
			Assert.assertEquals(actualCust,cn );
		}
	}

