package test;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
public class SearchFlipkart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  
	//		System.setProperty("webdriver.chrome.driver", "src/test/resources/libs/browserFiles/chromeDriver.exe");
			
			System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
		  driver.get("http://www.flipkart.com/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  //below step is to find directly username field in login page
		  driver.findElement(By.className("_2zrpKA")).sendKeys("USER_NAME@gmail.com");
		  /*Below step is to find password filed. But wait, here if you find 
		  element by class name you can see class name as “2zrpKA _3v41xv”. 
		  This wont work because there is a space between A and _. Selenium 
		  wont allow compound class name. So use xpath for the same as 
		  mentioned below */
		  driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("YOUR PASSWORD");
		  /* Now click on 'Sign In' button. But here also compound class name
		   present. You cannot use findByClassName method. But remember one 
		  thing. Maximum all sign in pages are written as forms by UI 
		  developers. If it is form then no need to find element separately 
		  for login button. You can take any element in that form and use 
		  .submit() to submit the form. so i have taken username element 
		  again and submit using that */
		  

		//*[contains(@type,'submit')]//  span[contains(text(), 'Login')]
		  driver.findElement(By.xpath("//*[contains(@type,'submit')]//span[contains(text(),'Login')]")).click();
		  driver.findElement(By.className("_2zrpKA")).sendKeys("1234567891");
		  
		  driver.findElement(By.xpath("//*[contains(@type,'submit')]//span[contains(text(),'CONTINUE')]")).click();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//button[contains(text(),'✕')]")).click();
		  
		  
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  //Close the browser
		  Actions act = new Actions(driver);
		  driver.findElement(By.xpath("//button[contains(text(),'Refresh')]")).click();
		  WebElement mainmenu= driver.findElement(By.xpath("//span[contains(text(),'Electronics')]"));
		  act.moveToElement(mainmenu).build().perform();//taking mouse
		  WebElement mobiles = driver.findElement(By.xpath("//span[contains(text(),'Mobiles')]"));
		  mobiles.click();//clicking on mobiles
		  
		  
		  ((WebElement) driver.findElements(By.xpath("//input[@name='q']"))).sendKeys("Mobiles");
		  ((WebElement) driver.findElements(By.xpath("//button[@class='vh79eN']"))).click();
		 
		  List<WebElement> brands = driver.findElements(By.xpath("//div[@id='list-tagcloud']/div[2]/a"));
		  System.out.println(brands.size());
		  for(int i=0;i<brands.size();i++){
		   System.out.println(brands.get(i).getText());//fetching all the brands
		   if(brands.get(i).getText().equals("Samsung"))//matching for samsung only
		   {
		    brands.get(i).click();//clicking pon samsung
		   }
		   brands = driver.findElements(By.xpath("//div[@id='list-tagcloud']/div[2]/a"));//for cache
		  }
		  WebElement searchbox = driver.findElement(By.xpath("//*[@id='searchbox']/li[2]/form/input[4]"));
		  searchbox.sendKeys("grand2");//in search box search for grand2
		  driver.findElement(By.xpath("//*[@id='searchbox']/li[2]/form/input[5]")).click();//clicking on search icon
		 
		  List<String> allLinks = new ArrayList<String>();
		  List<WebElement> data = driver.findElements(By.xpath("//div[@id='products']/div/div/div/div[2]/div[@class='pu-title fk-font-13']/a"));
		  System.out.println("total fonds are =="+data.size());//total searches coming on the page
		  for(int i=0;i<data.size();i++){
		   System.out.println(data.get(i).getText());//printing all samsung phones
		   if(data.get(i).getText().contains("Grand 2"))//search for grnad2 only
		   {
		    String link = data.get(i).getAttribute("href");//fetching all the links
		    allLinks.add(link);//adding them to list
		   
		  }
		   data = driver.findElements(By.xpath("//div[@id='products']/div/div/div/div[2]/div[@class='pu-title fk-font-13']/a"));// for cache
		}
		  System.out.println(allLinks.size());//total grand2 phones
		  for(int i=0;i<allLinks.size();i++){
		   System.out.println(allLinks.get(i));
		   driver.get(allLinks.get(i));
		   driver.findElement(By.xpath("//*[@id='mplistings']/div/div/div[1]/div[3]/a")).click();//click on view sellers
		   List<WebElement> retails = driver.findElements(By.xpath("//div[@class='cart-table']/div[starts-with(@class,'line seller-item')]/div[4]/a"));//fetching info
		   System.out.println(retails.size());
		   for(int j=0;j<retails.size();j++)
		   {
		   
		    System.out.println(retails.get(j).getText());//printing all the sellers info
		   
		   }
		  
		  }
		 
		  driver.close();
		}

	}


