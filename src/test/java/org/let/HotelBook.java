package org.let;

import java.io.IOException;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;

public class HotelBook extends BaseClass {

	public void errormsg() throws IOException, InterruptedException {

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
		WebElement statename = FindByXpath("//option[@value='Andhra Pradesh']");
		elementClick(statename);
		WebElement city = FindByXpath("//select[@name='city']");
		selectOptionByText(city, "Visakhapatnam");
		WebElement roomtype = FindByXpath("//select[@name='room_type[]']");
		selectOptionByText(roomtype, "Luxury");
		selectOptionByText(roomtype, "Deluxe");
		selectOptionByText(roomtype, "Suite");
		selectOptionByText(roomtype, "Standard");
		selectOptionByText(roomtype, "Studio");



		WebElement checkin = FindByXpath("//input[@name='check_in']");
		elementSendKeysJs(checkin, "2024-06-03");
		WebElement checkout = FindByXpath("//input[@name='check_out']");
		elementSendKeysJs(checkout, "2024-06-11");
		WebElement noofroom= FindByXpath("//select[@name='no_rooms']");
		selectOptionByText(noofroom, "3-Three");
		WebElement noofadult = FindByXpath("//select[@name='no_adults']");
		selectOptionByText(noofadult, "3-Three");
		Thread.sleep(6000);
		
		WebElement frame = FindByXpath("//iframe[@class='iframe']");
		switchframebywebelement(frame);
		WebElement btn = FindByXpath("//button[@id='searchBtn']");
		elementClick(btn);

						}
	public static void main(String[] args) throws IOException, InterruptedException {
		HotelBook m=new HotelBook();
		m.errormsg();
	}
}
