package StepDefination;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import Setupclass.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;

public class Normal_paid_login extends BaseClass {

	@Given("User is home page_vi$")
	public void user_is_home_page_vi() throws InterruptedException {

		driver.get(AppURL);
		log.info("It's opening the website URL");
		Thread.sleep(2000);
		driver.manage().deleteAllCookies();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
	}

	@Then("user click on the Popular PPTs_vi$")
	public void user_click_on_the_popular_PPts_vi() {
		WebElement most_popular_Ppts = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("MOST POPULAR")));
		most_popular_Ppts.click();
	}

	@Then("User try to download the ppt_vi$")
	public void user_try_to_download_the_ppt_vi() throws InterruptedException {
		try {

			System.out.println("user should be on the login page + " + driver.getCurrentUrl());
			Thread.sleep(3000);

			List<WebElement> select_Ppt = driver
					.findElements(By.xpath("//div[@class = 'product-wrapper-row']//a//img"));
			select_Ppt.get(1).click();
			Thread.sleep(3000);

			Thread.sleep(3000);
			WebElement download_Ppt = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='download_product']")));
			js.executeScript("arguments[0].scrollIntoView();", download_Ppt);
			download_Ppt.click();
			System.out.println("user is on Login page");
			Thread.sleep(3000);

		} catch (NoSuchElementException e) {

		}
	}

	@Then("user is on Login page_vi$")
	public void user_is_on_login_page_vi() {
		log.info("Hi! I am on Home page");
	}

	@Then("user enters the username and password_vi$")
	public void user_enters_the_username_and_password_vi() throws Throwable {

		// with login pop-up
		/*
		 * try { WebElement existingUser = wait.until(
		 * ExpectedConditions.elementToBeClickable(By.
		 * xpath("//a[normalize-space()='Existing Users']"))); Thread.sleep(2000);
		 * js.executeScript("arguments[0].click();", existingUser); Thread.sleep(2000);
		 * 
		 * WebElement email_Address = wait.until(ExpectedConditions
		 * .elementToBeClickable(By.
		 * xpath("//div[@class ='is-selected']//input[@name='site_signin_email']")));
		 * Thread.sleep(2000); email_Address.clear();
		 * email_Address.sendKeys("sumit.kumar@slidetech.in");
		 * 
		 * WebElement password = wait.until(ExpectedConditions.elementToBeClickable(
		 * By.xpath("//div[@class ='is-selected']//input[@name='site_signin_password']")
		 * )); password.clear(); password.sendKeys("redhat2090");
		 * 
		 * WebElement login = wait.until(ExpectedConditions .elementToBeClickable(By.
		 * xpath("//div[@class ='is-selected']//button[@id = 'site_signin_btn']")));
		 * login.click(); Thread.sleep(3000); } catch (NoSuchElementException e) {
		 * 
		 * }
		 */

		try {

			// without login pop-up

			WebElement email_Address = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='E-mail Address']")));
			Thread.sleep(2000);
			email_Address.clear();
			email_Address.sendKeys("sumit.kumar@slidetech.in");

			WebElement password = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Password']")));
			password.clear();
			password.sendKeys("redhat2090");

		} catch (NoSuchElementException e) {

		}

	}

	@Then("user clicks on Login button_vi$")
	public void user_clicks_on_login_button_vi() throws Throwable {
		// without pop-up click on login button

		try {
			WebElement login_btn = BaseClass.elementToBeClickable(By.xpath("//input[@name='Submit']")); //
			js.executeScript("arguments[0].click();", login_btn);
			Thread.sleep(3000);
		} catch (NoSuchElementException e) {

		}

	}

	@Then("user downloads the PPT_vi$")
	public void user_downloads_the_ppt_vi() throws Throwable {

		/*
		 * WebElement most_popular_Ppts =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.linkText("MOST POPULAR"
		 * ))); most_popular_Ppts.click();
		 */
		try {

			/*
			 * Thread.sleep(2000); WebElement select_Ppt = wait.until(ExpectedConditions
			 * .elementToBeClickable(By.xpath(
			 * "//div[2]/div[1]/div[1]/div[1]/a[1]/div[1]/img[1]")));
			 * js.executeScript("arguments[0].scrollIntoView();", select_Ppt);
			 * select_Ppt.click(); Thread.sleep(3000);
			 */

			WebElement download_Ppt = BaseClass.elementToBeClickable(By.linkText("Download this Presentation"));
			js.executeScript("arguments[0].scrollIntoView();", download_Ppt);
			download_Ppt.click();
			System.out.println("user is on Login page");
			Thread.sleep(2000);

		} catch (NoSuchElementException e) {

		}
		if (!driver.findElements(By.xpath("//a[@class='mfp-close roundlink']")).isEmpty()) {
			WebElement close_popup = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='mfp-close roundlink']")));

			close_popup.click();
		}

	}

	@Then("user clicks on the Logout page_vi$")
	public void user_clicks_on_the_logout_page() throws InterruptedException {

		try {
			Thread.sleep(4000);
			WebElement logout = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Logout']")));
			js.executeScript("arguments[0].click();", logout);
		} catch (NoSuchElementException e) {

		}

	}

}