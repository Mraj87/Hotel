package org.let;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;

public class HotelNames extends BaseClass {
	public void orderid() throws IOException, InterruptedException {
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
		WebElement state = FindByXpath("//select[@name='state']");
		elementClick(state);
		WebElement statename = FindByXpath("//option[@value='Andhra Pradesh']");
		elementClick(statename);
		WebElement city = FindByXpath("//select[@name='city']");
		selectOptionByText(city, "Visakhapatnam");
		WebElement roomtype = FindByXpath("//select[@name='room_type[]']");
		selectOptionByText(roomtype, "Luxury");
		WebElement checkin = FindByXpath("//input[@name='check_in']");
		elementSendKeysJs(checkin, "2024-06-02");
		WebElement checkout = FindByXpath("//input[@name='check_out']");
		elementSendKeysJs(checkout, "2024-06-04");
		WebElement noofroom= FindByXpath("//select[@name='no_rooms']");
		selectOptionByText(noofroom, "3-Three");
		WebElement noofadult = FindByXpath("//select[@name='no_adults']");
		selectOptionByText(noofadult, "3-Three");
		
		WebElement frame = FindByXpath("//iframe[@class='iframe']");
		switchframebywebelement(frame);
		WebElement btn = FindByXpath("//button[@id='searchBtn']");
		elementClick(btn);
		
		WebElement btn1 = FindByXpath("//label[text()='Price High to low']");
		elementClick(btn1);
		
		
		sleep();
		List<String> dev=new ArrayList<String>();
		
		
		List<WebElement> allprices = findelements("(//div[@class='prize']//h2)");
		for (WebElement v: allprices) {
		String text = elementGetText(v);
		dev.add(text);
				}
				
		for (String all : dev) {
			List<String> asList = Arrays.asList(all);	
		    String replace = all.replace("$", "");
			String trim = replace.replace(",", "").trim();
			System.out.println(trim);
			
			
		}
		List<String>qa=new ArrayList<String>();
		qa.addAll(dev);
		
		
		if (qa.equals(dev)) {
			System.out.println("in order");
		}
		else {
			System.out.println("Not in order");
		}
		
		
				}
		
	
	public static void main(String[] args) throws IOException, InterruptedException {
		HotelNames m=new HotelNames();
		m.orderid();
	}
}
