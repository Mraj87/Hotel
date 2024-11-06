package org.let;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;

public class HotelOrders extends BaseClass {

	public void orders() throws InterruptedException, IOException {
		// TODO Auto-generated method stub

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
		elementSendKeysJs(checkin, "2024-06-01");
		WebElement checkout = FindByXpath("//input[@name='check_out']");
		elementSendKeysJs(checkout, "2024-06-20");
		WebElement noofroom = FindByXpath("//select[@name='no_rooms']");
		selectOptionByText(noofroom, "3-Three");
		WebElement noofadult = FindByXpath("//select[@name='no_adults']");
		selectOptionByText(noofadult, "3-Three");
		Thread.sleep(6000);

		WebElement frame = FindByXpath("//iframe[@class='iframe']");
		switchframebywebelement(frame);
		WebElement btn = FindByXpath("//button[@id='searchBtn']");
		elementClick(btn);

		WebElement lowprice = FindByXpath("//label[@for='value_pltoh']");
		elementClick(lowprice);
		Thread.sleep(3000);

		List<WebElement> lowprices = findelements("(//div[@class='col-md-5 hotel-suites']//h5)");
		List<String> dev = new ArrayList<String>();

		for (WebElement low : lowprices) {
			String lowtohigh = elementGetText(low);
			dev.add(lowtohigh);

		}
		System.out.println(dev);
		
		List<String> qa = new ArrayList<String>();
		qa.addAll(dev);
		Collections.sort(qa);
		if (qa.equals(dev)) {
			System.out.println("it is valid");
		} else {
System.out.println("is is not valid");
		}

	}

	public static void main(String[] args) throws IOException, InterruptedException {
		HotelOrders m = new HotelOrders();
		m.orders();
	}
}
