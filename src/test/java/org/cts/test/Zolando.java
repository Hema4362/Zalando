package org.cts.test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Zolando extends ExcelRead{
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sai\\eclipse\\MavenProject\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.zalando.co.uk/");
		WebElement account = driver.findElement(By.xpath("//a[@style='position:relative']"));
		account.click();
		WebElement email = driver.findElement(By.xpath("//input[@id='login.email']"));
		email.sendKeys(getLoginDetails(0,0));
		WebElement pass = driver.findElement(By.xpath("//input[@id='login.password']"));
		pass.sendKeys(getLoginDetails(0,1));
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		Thread.sleep(3000);
		WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
		search.sendKeys("bags");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("(//div[text()='Valentino by Mario Valentino'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Add to bag']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='z-navicat-header_navToolItemLink']")).click();
		WebElement product = driver.findElement(By.xpath("//a[text()='Valentino by Mario Valentino']"));
		String p = product.getText();
		System.out.println(p);
		WebElement price = driver.findElement(By.xpath("(//span[text()='£189.98'])[3]"));
		String p1 = price.getText();
		ExcelWrite.printItemDetailsFromExcel(p, p1);
		
	}}


