package com.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;

import com.utils.*;
public class Login_Page {
 
	public class LoginPage extends BrowserUtility {

		private By usernameTextBoxLocator = By.id("username");
		private By passwordTextBoxLocator = By.id("password");
		private By signInButtonLocator = By.xpath("//span[contains(text(),\"Sign in \")]/../..");
	
	public LoginPage(WebDriver wd) {
		super(wd);
		goToWebsite("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26signIn%3D1%26useRedirectOnSuccess%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		// TODO Auto-generated constructor stub
	}

}
}