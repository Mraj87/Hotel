package org.let;

import java.io.IOException;
import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;

public class HotelPrices extends BaseClass {

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
		elementSendKeysJs(checkin, "2024-05-30");
		WebElement checkout = FindByXpath("//input[@name='check_out']");
		elementSendKeysJs(checkout, "2024-06-01");
		WebElement noofroom= FindByXpath("//select[@name='no_rooms']");
		selectOptionByText(noofroom, "3-Three");
		WebElement noofadult = FindByXpath("//select[@name='no_adults']");
		selectOptionByText(noofadult, "3-Three");
		
		WebElement frame = FindByXpath("//iframe[@class='iframe']");
		switchframebywebelement(frame);
		WebElement btn = FindByXpath("//button[@id='searchBtn']");
		elementClick(btn);
		
		List<WebElement> price = findelements("(//div[@class='prize']//h2)");
		for (WebElement allprices: price) {
			String prices = elementGetText(allprices);
			System.out.println(prices);
		}
}
	public static void main(String[] args) throws IOException, InterruptedException {
		HotelPrices m=new HotelPrices();
		m.orderid();
		
	}
}
