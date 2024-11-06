package org.let;

import java.io.IOException;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;

public class HotelInvalidMsg extends BaseClass {

	public void messages() throws IOException {

		browserLaunch();
		enterApplnUrl("https://www.omrbranch.com/");
		maximizeWindow();
		implictWait();
		WebElement username = findLocatorById("email");
		elementSendKeys(username, getCellData("Nuts", 1, 0));
		WebElement password = findLocatorById("pass");
		elementSendKeys(password, getCellData("Nuts", 1, 1));
		WebElement login = FindByXpath("(//button[@type='submit'])[1]");
		elementClick(login);
		
		WebElement frame = FindByXpath("//iframe[@class='iframe']");
		switchframebywebelement(frame);
		WebElement btn = FindByXpath("//button[@id='searchBtn']");
		elementClick(btn);
		parentswitch();
		
		WebElement stateerror = findLocatorById("invalid-state");
		String errormsg = elementGetText(stateerror);
		System.out.println(errormsg);
		
		WebElement cityerror = findLocatorById("invalid-city");
	    String text = elementGetText(cityerror);
	    System.out.println(text);

	    WebElement checkin = findLocatorById("invalid-check_in");
	    String msg = elementGetText(checkin);
	    System.out.println(msg);
	    
	    WebElement checkout = findLocatorById("invalid-check_out");
	    String all = elementGetText(checkout);
	    System.out.println(all);
	    
	    WebElement noofroom = findLocatorById("invalid-no_rooms");
	    String room = elementGetText(noofroom);
	    System.out.println(room);
	    
	    WebElement adult = findLocatorById("invalid-no_adults");
	    String adults = elementGetText(adult);
	    System.out.println(adults);
		
		 
		
	}
	public static void main(String[] args) throws IOException {
		
		HotelInvalidMsg m=new HotelInvalidMsg();
		m.messages();
	}
}
