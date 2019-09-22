package Main;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

class Main {

	public WebDriver driver = new FirefoxDriver();;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Program Files\\eclipse\\java-2019-09\\eclipse\\geckodriver-v0.25.0-win64-20190920T141612Z-001\\geckodriver\\geckodriver.exe");

		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/*
		 * String expectedTitle = "My Store"; String actualTitle = driver.getTitle(); if
		 * (expectedTitle.equals(actualTitle)) { System.out.
		 * println("Verification Successful - The correct title is displayed on the web page."
		 * ); } else { System.out.
		 * println("Verification Failed - An incorrect title is displayed on the web page."
		 * ); }
		 */
	}

	@BeforeEach
	void setUp() throws Exception {
		driver.get("http://automationpractice.com");
	}

	@Test
	void test() {
		//registration();
		login();
		addToCard();
		paymentGateway();
		fail("Not yet implemented");
	}

	void registration() {
		try {
			System.out.println("Regestration page started!");
			driver.findElement(By.className("login")).click();
			
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

			System.out.println("Login page retervied!");
			driver.findElement(By.className("account_input")).sendKeys("deepa7.thapa887@live.com");
			driver.findElement(By.id("SubmitCreate")).click();

			String expectedTitle = "My Store";
			String actualTitle = driver.getTitle();
			if (expectedTitle.equals(actualTitle)) {
				System.out.println("Verification Successful - The correct title is displayed on the web page.");
			} else {
				System.out.println("Verification Failed - An incorrect title is displayed on the web page.");
			}
			driver.findElement(By.id("uniform-id_gender2")).click();
			driver.findElement(By.id("customer_firstname")).sendKeys("Deepa");
			driver.findElement(By.id("customer_lastname")).sendKeys("Thapa");
			driver.findElement(By.id("passwd")).sendKeys("Deepa@143");
			WebElement element = driver.findElement(By.id("days"));
			Select dd = new Select(element);
			dd.selectByValue("31");

			WebElement element1 = driver.findElement(By.id("months"));
			Select mm = new Select(element1);
			mm.selectByValue("3");

			WebElement element2 = driver.findElement(By.id("years"));
			Select yy = new Select(element2);
			yy.selectByValue("1995");

			driver.findElement(By.id("newsletter")).click();
			driver.findElement(By.id("firstname")).sendKeys("Deepa");
			driver.findElement(By.id("lastname")).sendKeys("Thapa");
			driver.findElement(By.id("company")).sendKeys("Seva development");
			driver.findElement(By.id("address1")).sendKeys("Imadol,Lalithpur,Kathmandu.");
			driver.findElement(By.id("address2")).sendKeys("Imadol,Lalithpur,Kathmandu.");
			driver.findElement(By.id("city")).sendKeys("kathmandu");

			WebElement element3 = driver.findElement(By.id("id_state"));
			Select state = new Select(element3);
			state.selectByValue("34");

			driver.findElement(By.id("postcode")).sendKeys("00000");
			WebElement element4 = driver.findElement(By.id("id_country"));
			Select country = new Select(element4);
			country.selectByValue("21");
			driver.findElement(By.id("other")).sendKeys("abc");
			driver.findElement(By.id("phone")).sendKeys("9811989608");
			driver.findElement(By.id("phone_mobile")).sendKeys("9811989608");
			driver.findElement(By.id("alias")).sendKeys("Imadol,kathmandu");
			WebElement submitbutton = driver.findElement(By.id("submitAccount"));
			submitbutton.click();
			System.out.println("Registration page ended!");
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			driver.findElement(By.className("home")).click();
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	void login() {

		driver.findElement(By.className("login")).click();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys("deepa.thapa887@live.com");
		driver.findElement(By.id("passwd")).sendKeys("Deepa@143");
		driver.findElement(By.id("SubmitLogin")).click();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.findElement(By.className("home")).click();
		//driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	}

	void addToCard() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.className("replace-2x img-responsive")).click();
		

	}

	void paymentGateway() {

	}
}
