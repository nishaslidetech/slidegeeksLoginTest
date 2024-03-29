package StepDefination;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Setupclass.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;

public class Facebook_Paid_Login extends BaseClass {
	@Given("Enter the url")
	public void enter_the_url() throws Throwable {

		BaseClass.ClearfacebookCache();
		try {
			driver.get(AppURL);
			log.info("It's opening the website URL");
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			BaseClass.ClearBrowserCache();
			Thread.sleep(3000);
			WebElement Sign_in_with_facebook = BaseClass
					.elementToBeClickable(By.xpath("//ul[@class='social_links']//i[@class='icon fa fa-facebook']"));
			Thread.sleep(1000);
			Sign_in_with_facebook.click();
			System.out.println("facebook button clicked");
		} catch (InterruptedException e) {

			e.printStackTrace();
			System.out.println("message = " + e.getMessage());
		}

	}

	@Given("user enters the Username and passwordiv")
	public void user_enters_the_Username_and_passwordiv() throws InterruptedException {

		driver.manage().window().maximize();
		// String handle = " ";
		String currentWindow = driver.getWindowHandle();
		String popupWindowHandle = null;

		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(currentWindow)) {

				popupWindowHandle = handle;
				driver.switchTo().window(popupWindowHandle);
				// driver.manage().window().maximize();

				Thread.sleep(4000);

				WebElement fb_email = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
				fb_email.clear();
				fb_email.sendKeys("slidetech.qa@gmail.com");
				Thread.sleep(3000);
				WebElement fb_pass = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='pass']")));

				fb_pass.clear();
				fb_pass.sendKeys("himanshi@123");
				Thread.sleep(3000);
				try {
					if (!driver.findElements(By.xpath("//input[@value='Log in']")).isEmpty()) {
						driver.findElement(By.xpath("//input[@value='Log in']")).click();
					} else {
						WebElement fb_login = wait
								.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Log In']")));

						fb_login.click();
						Thread.sleep(2000);
					}
				} catch (NoSuchElementException e) {

				}
				// to verify the continue button
				// button[normalize-space()='Yes, Continue']

			}
		}
		driver.switchTo().window(currentWindow);
		Thread.sleep(6000);
	}

	@Then("user downloads the popular PPTiv")
	public void user_downloads_the_popular_ppiv() throws InterruptedException {
		try {

			Thread.sleep(2000);
			System.out.println("user will download the ppt");

			WebElement most_popular_Ppts = wait
					.until(ExpectedConditions.elementToBeClickable(By.linkText("MOST POPULAR")));
			most_popular_Ppts.click();
			Thread.sleep(3000);

			List<WebElement> select_Ppt = driver
					.findElements(By.xpath("//div[@class = 'product-wrapper-row']//a//img"));
			select_Ppt.get(1).click();
			Thread.sleep(3000);

			WebElement download_Ppt = wait
					.until(ExpectedConditions.elementToBeClickable(By.linkText("Download this Presentation")));
			js.executeScript("arguments[0].scrollIntoView();", download_Ppt);
			download_Ppt.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user clicks on the logout pageiv")
	public void user_clicks_on_the_logout_pageiv() throws InterruptedException {
		try {
			driver.navigate().refresh();
			Thread.sleep(4000);
			WebElement logout = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Logout']")));
			js.executeScript("arguments[0].click();", logout);
		} catch (NoSuchElementException e) {

		}

	}

}
