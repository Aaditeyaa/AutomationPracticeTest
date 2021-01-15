package com.listener;

import com.practice.test;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.util.UUID;

public class AllureListener implements ITestListener {


    @Override
    public void onTestFailure(ITestResult result) {

      WebDriver driver = test.getDriverFromContext(result.getTestContext());
      try{
          Allure.addAttachment(UUID.randomUUID().toString(),
          new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
      }catch (Exception e){
          e.printStackTrace();
      }
    }
}
