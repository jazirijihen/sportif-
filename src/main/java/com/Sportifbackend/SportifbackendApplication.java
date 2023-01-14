package com.Sportifbackend;


import java.io.File;


import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Sportifbackend.repo.ProductRepository;

import com.Sportifbackend.model.Product;
@SpringBootApplication
public class SportifbackendApplication {
	@Autowired
	private static ProductRepository productrepo;
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(SportifbackendApplication.class, args);
		System.out.println("Hello My Spring Boot Project");
		//List<Product> products = productrepo.findAll();
        //System.out.print("Getting data from DB:"+products);
		System.setProperty("webdriver.chrome.driver","C:\\selenium jar and drivers\\chromeDriver\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:4200/login");
		WebElement username=driver.findElement(By.id("username"));
		username.sendKeys("admin");
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("admin");
        driver.findElement(By.xpath("/html/body/app-root/div/body/app-login/div/form/input[3]")).click();       
        Thread.sleep(5000);
        WebElement searchBox=driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/form/input"));
        searchBox.sendKeys("ball");
        searchBox.sendKeys(Keys.ENTER);
		driver.get("http://localhost:4200//add-product");
		WebElement selDate =driver.findElement(By.xpath("//*[@id=\"addedOn\"]"));
        selDate.sendKeys("01/01/2022");
        //driver findElement(By.xpath("//*[@id=\"addedOn\"]")).click(); 
     



	}
	


}
