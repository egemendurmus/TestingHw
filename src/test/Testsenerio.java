package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testsenerio {
	public static WebDriver driver = new FirefoxDriver();
	// webdriver for firefox

	static Logger logger = Logger.getLogger(Testsenerio.class);

	// logger libs for take log our automation
	// new driver for firefox

	public static void main(String[] args) {
		logger.info("STARTED TESTİNG");

		// BasicConfigurator.configure();

		PropertyConfigurator.configure("Log4j.properties");

		logger.info("open firefox browser");

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		// as used thread

		// in my testing I have 6 step now lets go to step by step

		// * in my senerio first step login with facebook *//

		driver.get("https://www.n11.com/social/facebookRouter?source=WEB_REGULAR_FB&scope=email,user_birthday");
		// after open firefox redirect my website facebook authorize
		logger.info("STARTED facebook login");

		// facebook login
		driver.findElement(By.xpath("//*[@id='email']")).click();
		// finds on site elements for email and click for write my username

		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(
				"rosahappy_34@outlook.com");
		// after finds send my user name

		driver.findElement(By.xpath("//*[@id='pass']")).click();
		// finds on site elements for password
		driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("mutlu2014");
		// after finds send my password
		driver.findElement(By.xpath("//*[@id='u_0_2']")).click();
		// click ok button and redirect to n11.com mainapge

		// * second , third ,fourth step after login automitically redirect
		// n11.com and finds in
		// menu /KİTAP,MÜZİK,FİLM,OYUN / KİTAP / YAZARLAR *//

		// in here navigate to mainpage-books-authors
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		logger.info("Facebook logged is success open n11.com");

		// Waiting is having the automated task execution elapse a certain
		// amount of time before continuing with the next step.
		driver.findElement(
				By.xpath("//*[@id='contentMain']/div/nav/ul/li[8]/a")).click();
		// in left side has menu and find KİTAP,MÜZİK,FİLM,OYUN and click

		logger.info("in left side has menu and find KİTAP,MÜZİK,FİLM,OYUN and click");

		driver.findElement(
				By.xpath("//*[@id='contentCategory']/div/div[2]/div[1]/ul/li[1]/a"))
				.click();
		logger.info("find KİTAP and click");

		// again find KİTAP and click

		driver.findElement(
				By.xpath("//*[@id='contentListing']/div/div/div[2]/section[3]/a"))
				.click();

		logger.info("find Yazarlar and click");

		// find Yazarlar and click

		// driver.findElements(By.xpath("//div[@id='ires']//li")).size(); this
		// command used for div size

		/*
		 * fifth step ı choose from alphabet M and Z and then for example ı
		 * selected 'M' ,then go to the author page their name start wit'M'
		 * count authors if <= 80 no problem >= its paging
		 * 
		 * 6th step if author more than 80 we controls first page last name not
		 * equal to second page first name
		 */

		driver.get("http://www.n11.com/yazarlar/M");
		// go to the authors names page start with 'M'

		logger.info("go to the authors names page start with 'M'");

		SenerioMethods.divControls();
		// calling method
		logger.info("calling method");

		driver.get("http://www.n11.com/yazarlar/M?pg=2");
		// direct 2nd page startwith 'M'
		logger.info("direct 2nd page startwith 'M'");

		List<WebElement> DIV2 = Testsenerio.driver.findElements(By
				.xpath("//*[@id='authorsList']/div[1]/ul/li"));

		logger.info("listing second page");

		String FIRSTELEMENT = (DIV2.get(DIV2.size() - DIV2.size()).getText());
		// 2nd page 1st element

		logger.info("second page start with = " + FIRSTELEMENT);

	if(FIRSTELEMENT==SenerioMethods.LASTELEMENT){
		logger.error("web site has error about paging");

	}else{
		logger.info("web site hasn't got  error about paging");

	}
		
		
		
		
		
		try {

			Thread.sleep(10000);

			driver.get("http://www.n11.com/yazarlar/Z");

			logger.info("Start testing for 'Z'");

			driver.navigate().refresh();
			logger.info("navigate and refresh");

			SenerioMethods.divControls();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}