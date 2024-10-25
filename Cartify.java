package assessment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Cartify {

	public static void main(String[]args) throws InterruptedException {
	//1. Launch the browser and Load Url as https://www.cartify.pk/ 

	ChromeOptions options= new ChromeOptions();
	options.addArguments("--disable-notifications");
	ChromeDriver driver= new ChromeDriver(options);
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	
	driver.get("https://www.cartify.pk/"); 
	

//2.Click on "Shop By Categories"
	driver.findElement(By.xpath("(//span[@class='site-nav__label'])[3]")).click();  

	
	//3.Click on "Cloth Rack" category 

	Thread.sleep(2000);
	driver.findElement(By.xpath("(//div[@class='collection-grid-item__title h3'])[3]")).click();
	
	//4.Click on the "Floor-Standing Cloth Rack With Wheels" item 
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@class='grid-view-item product-card']")).click(); 
	
	//5.Add the item to the cart

	driver.findElement(By.xpath("//button[@name='add']")).click(); 
	
	//Click on View to cart 
	
	driver.findElement(By.xpath("//a[@class='cart-popup__cta-link btn btn--secondary-accent']")).click(); 
	
	//7.Retrieve the subtotal price 
	String price= driver.findElement(By.xpath("//span[@class='cart-subtotal__price']")).getText();
	System.out.println(price);
	
	//8.Quit the driver 
	driver.quit();
}
}