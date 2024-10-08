package com.actitime.generic;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.actitime.generic.BaseCLass;

public class ListenerImplementation extends BaseCLass implements ITestListener{

		@Override
		public void onTestStart(ITestResult result) {
		
		}

		@Override
		public void onTestSuccess(ITestResult result) {
			String res= result.getName();
			Reporter.log(res+"has got passed");
		}

		@Override
		public void onTestFailure(ITestResult result) {
			String res=result.getName();
			String timestamp=LocalDateTime.now().toString().replace(':', '-');
			 TakesScreenshot ts = (TakesScreenshot) driver;
			 File src=ts.getScreenshotAs(OutputType.FILE);
			 File dest=new File("./screenshots/"+res+timestamp+".png");
			 try {
				FileUtils.copyFile(src, dest);
			} catch (IOException e) {
			}
			 
		}

		@Override
		public void onTestSkipped(ITestResult result) {
			String res= result.getName();
			Reporter.log(res+"has got skipped");
		}

		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
			ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
		}

		@Override
		public void onTestFailedWithTimeout(ITestResult result) {
			// TODO Auto-generated method stub
			ITestListener.super.onTestFailedWithTimeout(result);
		}

		@Override
		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
			ITestListener.super.onStart(context);
		}

		@Override
		public void onFinish(ITestContext context) {
			// TODO Auto-generated method stub
			ITestListener.super.onFinish(context);
		}
		

	}

