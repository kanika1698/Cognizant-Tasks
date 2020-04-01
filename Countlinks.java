package com.selenium.webelement;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ContactForm {

	@Test
	public void FillForm() throws Exception{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Asus\\Desktop\\chromedriver.exe");
    	System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");    	
    	WebDriver driver=new ChromeDriver();
    	driver.manage().window().maximize();    	
    	driver.get("https://www.mycontactform.com/samples.php");
    	
    	List<WebElement> list=driver.findElements(By.xpath("//ul[@class='samples']/li/a"));
    	System.out.println("Total no. of links:-"+list.size());
    	String[] links=new String[list.size()];
    	for(int i=0;i<list.size();++i) links[i]=list.get(i).getAttribute("href");
	    for( int j=0;j<links.length;++j){
	    	driver.navigate().to(links[j]);
	    	takeScreenshot(driver,"D:\\Screenshots\\Link "+(j+1)+".jpg");
	    }
	}	
	public static void takeScreenshot(WebDriver webdriver,String path) throws Exception{
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        File screenshot=scrShot.getScreenshotAs(OutputType.FILE);
        File dest=new File(path);
        Files.copy(screenshot.toPath(), dest.toPath());
    }
}
