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

public class Google_existing_paid_login extends BaseClass {

	@Given("User is home pageiii$")
	public void user_is_home_pageiii() throws Throwable {
		BaseClass.ClearGoggleCache();

		driver.get(AppURL);
		driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		log.info("It's opening the website URL");
		BaseClass.ClearBrowserCache();
	}

	@Then("user click on the Popular PPTsiii$")
	public void user_click_on_the_popular_PPsiii() throws InterruptedException {
		Thread.sleep(3000);
		WebElement most_popular_Ppts = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("MOST POPULAR")));
		most_popular_Ppts.click();
		Thread.sleep(3000);
	}

	@Then("User try to download the pptiii$")
	public void user_try_to_download_the_pptiii() throws Throwable {
		try {

			List<WebElement> select_Ppt = driver
					.findElements(By.xpath("//div[@class = 'product-wrapper-row']//a//img"));
			select_Ppt.get(1).click();
			Thread.sleep(3000);

			WebElement download_Ppt = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='download_product']")));
			js.executeScript("arguments[0].scrollIntoView();", download_Ppt);
			download_Ppt.click();
			Thread.sleep(5000);
		} catch (NoSuchElementException e) {

		}
	}

	@Then("user is on Login page and click on Signin with google buttoniii$")
	public void user_is_on_login_page_and_click_on_sigin_with_google_buttoniii() throws Throwable {
		// Click on Sign in with Google Account

		// with login pop-up

		/*
		 * WebElement existingUser = wait
		 * .until(ExpectedConditions.elementToBeClickable(By.
		 * xpath("//a[normalize-space()='Existing Users']")));
		 * 
		 * js.executeScript("arguments[0].click();", existingUser); Thread.sleep(2000);
		 * WebElement sign_in_with_Google = wait.until(
		 * ExpectedConditions.elementToBeClickable(By.
		 * xpath("//div[@class ='is-selected']//ul//li[3]//img"))); Thread.sleep(2000);
		 * js.executeScript("arguments[0].click();", sign_in_with_Google);
		 */

		// without login

		WebElement sign_in_with_Google = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='icon fa fa-google']")));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", sign_in_with_Google);

		Thread.sleep(3000);
	}

	@Then("user enters the username and passwordiii$")
	public void user_enters_the_username_and_passwordiii() throws Throwable {

		driver.manage().window().maximize();

		// Store the CurrentWindow for future reference
		// String handle = " ";
		String currentWindow = driver.getWindowHandle();
		String popupWindowHandle = null;

		// Switch To Popup Window

		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(currentWindow)) {

				popupWindowHandle = handle;
				driver.switchTo().window(popupWindowHandle);
				driver.manage().window().maximize();

				Thread.sleep(5000);

				WebElement g_email = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='identifierId']")));
				Thread.sleep(3000);
				g_email.sendKeys("slidetech.qa@gmail.com");
				Thread.sleep(3000);

				WebElement g_login_btn1 = wait.until(ExpectedConditions
						.elementToBeClickable(By.cssSelector("#identifierNext > div > button > span")));
				Thread.sleep(3000);
				g_login_btn1.click();

				Thread.sleep(3000);

				WebElement g_pass = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']")));
				Thread.sleep(3000);
				g_pass.sendKeys("Himanshi@123");

				Thread.sleep(3000);
				WebElement g_login_btn2 = wait.until(
						ExpectedConditions.elementToBeClickable(By.cssSelector("#passwordNext > div > button > span")));
				Thread.sleep(3000);
				g_login_btn2.click();

				Thread.sleep(3000);
			}
		}
		driver.switchTo().window(currentWindow);
		Thread.sleep(4000);
	}

	@Then("user downloads the PPTiii$")
	public void user_downloads_the_pptiii() throws InterruptedException {
		Thread.sleep(3000);

		WebElement most_popular_Ppts = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("MOST POPULAR")));
		most_popular_Ppts.click();

		try {

			List<WebElement> select_Ppt = driver
					.findElements(By.xpath("//div[@class = 'product-wrapper-row']//a//img"));
			select_Ppt.get(1).click();
			Thread.sleep(3000);

			WebElement download_Ppt = BaseClass.elementToBeClickable(By.linkText("Download this Presentation"));
			js.executeScript("arguments[0].scrollIntoView();", download_Ppt);
			download_Ppt.click();
			Thread.sleep(2000);
		} catch (NoSuchElementException e) {

		}
	}

	@Then("user clicks on the Logout pageiii$")
	public void user_clicks_on_the_logout_pageiii() throws Throwable {
		try {
			Thread.sleep(2000);
			WebElement logout = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Logout']")));
			js.executeScript("arguments[0].click();", logout);
		} catch (NoSuchElementException e) {

		}
	}

}
