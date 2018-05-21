package com.abc.ejogajog.Utils;

public class XPathUtils {

	public static class Login {
		
		public static final String LOGIN_PAGE_HEADER = "//div/div[2]/div[2]/div/h2[text()='Log in.']";
		public static final String LOGIN_PAGE_SUBHEADER = "//section[@id='loginForm']/form/h4";
		
		public static final String USER_NAME_LABEL = "//section[@id='loginForm']/form/div[1]/label";
		public static final String PASSWORD_LABEL = "//*[@id='loginForm']/form/div[2]/label";	
		
		public static final String EMAIL_TEXTFIELD = "//div[@class='form-group']//input[@id='Email']";
		public static final String PASSWORD_FIELD = "//div[@class='form-group']//input[@id='Password']";
		public static final String BTN_LOGIN = "//*[@id='loginForm']/form/div[3]/div/input";
	}
	
}
