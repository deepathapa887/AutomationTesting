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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

class Main {

	public WebDriver driver = new FirefoxDriver();;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Program Files\\eclipse\\java-2019-09\\eclipse\\geckodriver-v0.25.0-win64-20190920T141612Z-001\\geckodriver\\geckodriver.exe");

					}

	@BeforeEach
	void setUp() throws Exception {
		driver.get("http://automationpractice.com");
		String expectedTitle = "My Store";
		String actualTitle = driver.getTitle();
		if (expectedTitle.equals(actualTitle)) {
			System.out.println("Verification Successful - The correct title is displayed on the web page.");
		} else {
			System.out.println("Verification Failed - An incorrect title is displayed on the web page.");
		}
	}

	@Test
	void test() {
		registration();
		login();
		addToCard();
		paymentGateway();

	}

	void registration() {
		try {
			System.out.println("Regestration page started!");
			driver.findElement(By.className("login")).click();

			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

			System.out.println("Login page retervied!");
			driver.findElement(By.className("account_input")).sendKeys("deepa7.thapa887@live.com");
			driver.findElement(By.id("SubmitCreate")).click();
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
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		driver.findElement(By.className("home")).click();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	}

	void addToCard() {
		try {
			driver.get("http://automationpractice.com/index.php?id_product=1&controller=product");
			driver.findElement(By.id("add_to_cart")).click();
			System.out.println("execute");
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			driver.findElement(By.className("cross")).click();
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			driver.findElement(By.className("home")).click();
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			driver.get("http://automationpractice.com/index.php?id_product=2&controller=product");
			driver.findElement(By.id("add_to_cart")).click();
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//span(contains[@class='cross']")).click();
			driver.findElement(By.className("home")).click();
			System.out.println("Entered into the homepage");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	void paymentGateway() {

		driver.findElement(By.className("shopping_cart")).click();
		driver.findElement(By.id("button_order_cart")).click();
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click();
		driver.findElement(By.className("button btn btn-default button-medium")).click();
		driver.findElement(By.id("cgv")).click();
		driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span")).click();
		driver.findElement(By.className("cheque")).click();
		driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span")).click();
		System.out.println("Succefully completed");

	}
}
