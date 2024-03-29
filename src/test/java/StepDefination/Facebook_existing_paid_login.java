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

public class Facebook_existing_paid_login extends BaseClass {
	WebElement most_popular_Ppts;

	@Given("User is home pagei$")
	public void user_is_home_pagei() throws Throwable {
		BaseClass.ClearfacebookCache();
		driver.get(AppURL);
		log.info("It's opening the website URL");
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		BaseClass.ClearBrowserCache();
	}

	@Then("user clicks on the Popular PPTsi$")
	public void user_clicks_on_the_popular_pp_tsi() throws InterruptedException {
		Thread.sleep(3000);
		most_popular_Ppts = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("MOST POPULAR")));
		most_popular_Ppts.click();
	}

	@Then("User try to Download the ppti$")
	public void user_try_to_Download_the_ppti() throws InterruptedException {

		try {
			Thread.sleep(4000);
			List<WebElement> select_Ppt = driver
					.findElements(By.xpath("//div[@class = 'product-wrapper-row']//a//img"));

			select_Ppt.get(1).click();
			Thread.sleep(3000);
			WebElement download_Ppt = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='download_product']")));
			js.executeScript("arguments[0].scrollIntoView();", download_Ppt);
			download_Ppt.click();
			System.out.println("user is on Login page");
			Thread.sleep(5000);

			// with pop-up

			/*
			 * WebElement existingUser = wait.until(
			 * ExpectedConditions.elementToBeClickable(By.
			 * xpath("//a[normalize-space()='Existing Users']")));
			 * 
			 * js.executeScript("arguments[0].click();", existingUser); Thread.sleep(2000);
			 * WebElement sign_in_with_Facebook = wait.until(
			 * ExpectedConditions.elementToBeClickable(By.
			 * xpath("//div[@class ='is-selected']//ul//li[1]"))); Thread.sleep(2000);
			 * sign_in_with_Facebook.click();
			 */

			// without pop-up

			WebElement sign_in_with_Facebook = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//a[@id='facebook-signin-btn']//i[@class='icon fa fa-facebook']")));
			Thread.sleep(2000);
			sign_in_with_Facebook.click();

			Thread.sleep(3000);
			System.out.println("facebook button clicked");
		} catch (NoSuchElementException e) {

		}
	}

	@Then("user is on Login pagei$")
	public void user_is_on_login_pagei() throws InterruptedException {
		log.info("Hi! I am on Home page");
		System.out.println("Hi! I am on Home page");
	}

	@Then("user Enters the username and passwordi$")
	public void user_Enters_the_username_and_passwordi() throws Throwable {

		driver.manage().window().maximize();
		// String handle = " ";
		String currentWindow = driver.getWindowHandle();
		String popupWindowHandle = null;

		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(currentWindow)) {

				popupWindowHandle = handle;
				driver.switchTo().window(popupWindowHandle);
				driver.manage().window().maximize();

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
					} else if (!driver.findElements(By.xpath("//input[@value='Log In']")).isEmpty()) {
						driver.findElement(By.xpath("//input[@value='Log In']")).click();

					}

					else {
						WebElement fb_login = wait
								.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Log In']")));

						fb_login.click();
						Thread.sleep(3000);
					}
				} catch (NoSuchElementException e) {

				}
				// to verify the continue button
				// button[normalize-space()='Yes, Continue']

			}
		}
		driver.switchTo().window(currentWindow);
	}

	@Then("user downloads the PPTi$")
	public void user_downloads_the_ppti() throws Throwable {
		Thread.sleep(7000);
		WebElement download_Ppt = BaseClass.elementToBeClickable(By.linkText("Download this Presentation"));
		js.executeScript("arguments[0].scrollIntoView();", download_Ppt);
		download_Ppt.click();

		if (!driver.findElements(By.xpath("//a[@class='mfp-close roundlink']")).isEmpty()) {
			WebElement close_popup = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='mfp-close roundlink']")));

			close_popup.click();
		}
	}

	@Then("user clicks on the Logout pagei$")
	public void user_clicks_on_the_logout_pagei() throws InterruptedException {
		try {
			Thread.sleep(4000);
			WebElement logout = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Logout']")));
			js.executeScript("arguments[0].click();", logout);
		} catch (NoSuchElementException e) {

		}

	}

}
