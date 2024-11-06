package org.let;

import java.awt.AWTException;
import java.io.IOException;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;

public class Hotel extends BaseClass {
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
		
		WebElement hotelname = FindByXpath("//h5[text()='Treebo Trend Orchard Suites Luxury']");
		String textname = elementGetText(hotelname);
		System.out.println(textname);
		WebElement amount = FindByXpath("(//strong[@class='total-prize'])[2]");
		String textamount = elementGetText(amount);
		System.out.println(textamount);
		
		WebElement continuebook = FindByXpath("(//a[@class='btn filter_btn'])[2]");
		elementClick(continuebook);
		clickokalert();
		
		WebElement hotelnames = FindByXpath("//h2[text()='Book Hotel - Treebo Trend Orchard Suites Luxury']");
		String names = elementGetText(hotelnames);
		System.out.println(names);
		WebElement btns = FindByXpath("//input[@id='own']");
		elementClick(btns);
		
		WebElement stat = FindByXpath("//select[@id='user_title']");
		selectOptionByValue(stat, "Mr");
		WebElement firstname = FindByXpath("//input[@id='first_name']");
		elementSendKeys(firstname, getCellData("Nuts", 1, 2));
		WebElement lastname = FindByXpath("//input[@id='last_name']");
		elementSendKeys(lastname, getCellData("Nuts", 1, 3));
		WebElement phonenumber = FindByXpath("//input[@id='user_phone']");
		elementSendKeys(phonenumber, getCellData("Nuts", 1, 4));
		WebElement emailid = FindByXpath("//input[@id='user_email']");
		elementSendKeys(emailid, getCellData("Nuts", 1, 5));
		WebElement gst = FindByXpath("//input[@id='gst']");
		elementClick(gst);
		WebElement gstno = FindByXpath("//input[@name='registration']");
		elementSendKeys(gstno, getCellData("Nuts", 1, 6));
		WebElement companyno= FindByXpath("//input[@id='company_name']");
		elementSendKeys(companyno, getCellData("Nuts", 1, 7));
		WebElement address = FindByXpath("//input[@name='company_address']");
		elementSendKeys(address, getCellData("Nuts", 1, 8));
		WebElement btnele = FindByXpath("//button[@id='step1next']");
		btnele.click();
		
		WebElement lateroom= FindByXpath("//input[@id='late']");
		elementClick(lateroom);
		WebElement othereq= FindByXpath("//textarea[@id='other_request']");
		elementSendKeys(othereq, getCellData("Nuts", 1, 9));
		
		WebElement nextbtn = FindByXpath("//button[@id='step2next']");
		elementClick(nextbtn);
		
		WebElement payment = FindByXpath("//div[@class='credit-card pm']");
		elementClick(payment);
		
		WebElement cardtype = FindByXpath("//select[@name='payment_type']");
		selectOptionByValue(cardtype, "debit_card");
		
		WebElement cardvarient= FindByXpath("//select[@name='card_type']");
		selectOptionByValue(cardvarient, "visa");
		
		WebElement cardno = FindByXpath("//input[@id='card_no']");
		elementSendKeys(cardno, getCellData("Nuts", 1, 10));
		
		WebElement nameon = FindByXpath("//input[@id='card_name']");
		elementSendKeys(nameon, getCellData("Nuts", 1, 2));
		
		WebElement month= FindByXpath("//select[@id='card_month']");
		selectOptionByText(month, "January");
		
		WebElement year = FindByXpath("//select[@id='card_year']");
		selectOptionByValue(year, "2027");
		
		WebElement cvv = FindByXpath("//input[@id='cvv']");
		elementSendKeys(cvv, getCellData("Nuts", 1, 11));
		
		WebElement submit = FindByXpath("//button[@id='submitBtn']");
		elementClick(submit);
		
		WebElement bookid = FindByXpath("//h2[@name='booking-code']");
		String book = elementGetText(bookid);
		System.out.println(book);
		
		WebElement mybook = FindByXpath("//button[text()='My Booking']");
		elementClick(mybook);
		
        WebElement hotel = FindByXpath("//h5[text()='Treebo Trend Orchard Suites Luxury']");
        String hotelname1= elementGetText(hotel);
        System.out.println(hotelname1);
        
        WebElement orderprice = FindByXpath("//strong[text()='Rs 12,036']");
        String price = elementGetText(orderprice);
        System.out.println(price);
        
        
        WebElement orderis1 = FindByXpath("//div[@class='room-code']//span[1]");
        String orderid1 = elementGetText(orderis1);
        System.out.println(orderid1);
        
        WebElement edit = FindByXpath("//button[text()='Edit']");
        elementClick(edit);
        
        WebElement checkindate = FindByXpath("//input[@name='check_in']");
        elementSendKeysJs(checkindate, "2024-05-31");
        
		WebElement confirm = FindByXpath("//button[text()='Confirm']");
		elementClick(confirm);
		
		WebElement alertmsg = FindByXpath("//li[text()='Booking updated successfully']");
		String message = elementGetText(alertmsg);
		System.out.println(message);

        WebElement cancelbtn= FindByXpath("//a[contains(text(),'Cancel')]");
        elementClick(cancelbtn);
        clickokalert();
        
        WebElement altmsg = FindByXpath("//li[text()='Your booking cancelled successfully']");
        String meg = elementGetText(altmsg);
        System.out.println(meg);
		
	}

	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
		Hotel c = new Hotel();
		c.orderid();
	}

}
