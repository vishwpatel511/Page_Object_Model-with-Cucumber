package com.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {
	
	public static Properties prop;
	public static FileInputStream inputStream;
	public static WebDriver driver;
	
	
	public TestBase() {
		

		try {
			prop =new Properties();
			inputStream = new FileInputStream("src/main/java/com/qa/env_vars/prop.properties");
			prop.load(inputStream);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// This method initialize the browser, page
	public static void initialization() {
		
	
		if(prop.getProperty("browser").equals("firefox")) {
			
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\vishw\\Desktop\\Study Material\\SeleniumJar\\geckodriver.exe");
			driver = new FirefoxDriver();
			
			
		}
		else if(prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\vishw\\Desktop\\Study Material\\SeleniumJar\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if(prop.getProperty("browser").equals("ie")) {
			
			System.setProperty("webdriver.ie.driver", "C:\\Users\\vishw\\Desktop\\Study Material\\SeleniumJar\\IEdriver.exe");
			driver = new InternetExplorerDriver();
		}
	
		
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		
	}
	
	public static void Exit() throws InterruptedException {
	
		Thread.sleep(3000);
		driver.quit();
	}

}
