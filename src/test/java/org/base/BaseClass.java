package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;
	Select select;
	Actions actions;

	public byte[] screenshot() {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		byte[] b = takesScreenshot.getScreenshotAs(OutputType.BYTES);
		return b;

	}

	public String getCellData(String sheetName, int rowName, int cellName) throws IOException {
		// TODO Auto-generated method stub
		String res = "";
		File file = new File("C:\\Users\\Mohan\\eclipse-workspace\\HotelLogin\\Excels\\Book1.xlsx");
		FileInputStream filein = new FileInputStream(file);
		Workbook work = new XSSFWorkbook(filein);
		Sheet sheet = work.getSheet(sheetName);
		Row row = sheet.getRow(rowName);
		Cell cell = row.getCell(cellName);
		CellType cellType = cell.getCellType();
		switch (cellType) {
		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				res = date.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long round = Math.round(numericCellValue);
				if (round == numericCellValue) {
					res = String.valueOf(round);
				} else {
					res = String.valueOf(numericCellValue);

				}

			}
		default:
			break;
		}
		return res;
	}

	public String CreateCellData(String sheetName, int rowName, int cellName, String data) throws IOException {
		// TODO Auto-generated method stub
		String res = "";
		File file = new File("C:\\Users\\Mohan\\eclipse-workspace\\HotelLogin\\Excels\\Book1.xlsx");
		FileInputStream fin = new FileInputStream(file);
		Workbook work = new XSSFWorkbook();
		Sheet sheet = work.getSheet(sheetName);
		Row row = sheet.getRow(rowName);
		Cell cell = row.createCell(cellName);
		cell.setCellValue(data);
		FileOutputStream fout = new FileOutputStream(file);
		work.write(fout);

		return res;
	}

	public void browserQuit() {
		driver.quit();

	}

	public void elementSendKeysEnter(WebElement element, String value, Keys enter) {
		element.sendKeys(value, Keys.ENTER);

	}

	public WebElement FindByXpath(String value) {
		return driver.findElement(By.xpath(value));

	}

	public void sleep() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(3000);
	}

	public void parentswitch() {
		// TODO Auto-generated method stub
		driver.switchTo().parentFrame();
	}

	public List<WebElement> findelements(String value) {
		// TODO Auto-generated method stub
		List<WebElement> elements = driver.findElements(By.xpath(value));
		return elements;

	}

	public void switchframebywebelement(WebElement element) {
		driver.switchTo().frame(element);
	}

	public void swithframebystring(String value) {
		// TODO Auto-generated method stub
		driver.switchTo().frame(value);
	}

	public void switchframebyindex(int id) {
		// TODO Auto-generated method stub
		driver.switchTo().frame(id);
	}

	public void elementMosuseOverActions(WebElement element) {
		actions = new Actions(driver);
		visibilityOfElement(element);
		if (elementIsDisplayed(element)) {
			actions.moveToElement(element).perform();
		}
	}

	public void elementDragAndDrop(WebElement sourceElement, WebElement destElement) {
		visibilityOfElement(destElement);
		visibilityOfElement(sourceElement);
		if (elementIsDisplayed(destElement) && elementIsDisplayed(sourceElement)) {

			actions = new Actions(driver);
			actions.dragAndDrop(sourceElement, destElement).perform();
		}
	}

	public void elementClear(WebElement element) {
		visibilityOfElement(element);
		if (elementIsDisplayed(element)) {
			element.clear();
		}
	}

	public void clickokalert() {

		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public List<String> dropdownGetAllOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		List<String> allOPtionsText = new ArrayList<>();
		for (WebElement webElement : allSelectedOptions) {
			String text = webElement.getText();
			allOPtionsText.add(text);

		}
		return allOPtionsText;
	}

	public void screenshot(String sName) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File f = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f,
				new File("C:\\Users\\LENOVO\\eclipse-workspace\\FrameworkClass930AM\\screenshots\\" + sName + ".png"));
	}

	public void screenshot(WebElement element, String sName) throws IOException {
		File f = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f,
				new File("C:\\Users\\LENOVO\\eclipse-workspace\\FrameworkClass930AM\\screenshots\\" + sName + ".png"));
	}

	public void visibilityOfElement(WebElement element) {
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		driverWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void implictWait(int secs) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
	}

	public void webdriverwait(WebDriver driver, Duration a, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, a);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void implictWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	public void elementSendKeysJs(WebElement element, String data) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + data + "')", element);

	}

	public void selectOptionByText(WebElement element, String text) {
		select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectOptionByValue(WebElement element, String text) {
		select = new Select(element);
		select.selectByValue(text);
	}

	public void selectOptionByIndex(WebElement element, int index) {
		visibilityOfElement(element);
		select = new Select(element);
		select.selectByIndex(index);
	}

	public boolean elementIsDisplayed(WebElement element) {
		visibilityOfElement(element);
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	public boolean elementIsEnabled(WebElement element) {
		visibilityOfElement(element);
		boolean displayed = element.isEnabled();
		return displayed;
	}

	public static void browserLaunch() {
		driver = new ChromeDriver();
	}

	public static void enterApplnUrl(String url) {
		driver.get(url);
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void elementSendKeys(WebElement element, String data) {
		visibilityOfElement(element);

		if (elementIsEnabled(element) && elementIsDisplayed(element)) {
			element.sendKeys(data);
		}
	}

	public void elementClick(WebElement element) {
		visibilityOfElement(element);
		if (elementIsEnabled(element) && elementIsDisplayed(element)) {
			element.click();
		}
	}

	public String getApplnTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static WebElement findLocatorById(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}

	public WebElement findLocatorByName(String attributeValue) {
		WebElement element = driver.findElement(By.name(attributeValue));
		return element;
	}

	public String elementGetText(WebElement element) {
		visibilityOfElement(element);
		String text = "";

		if (elementIsDisplayed(element)) {
			text = element.getText();
		}
		return text;
	}

	// 99% value is fixed
	public String elementGetAttribute(WebElement element) {
		visibilityOfElement(element);
		String attribute = "";
		if (elementIsDisplayed(element)) {
			attribute = element.getAttribute("value");
		}
		return attribute;
	}

	// 1% value is NOT fixed
	public String elementGetAttribute(WebElement element, String attributename) {
		visibilityOfElement(element);
		String attribute = element.getAttribute(attributename);
		return attribute;
	}

}
