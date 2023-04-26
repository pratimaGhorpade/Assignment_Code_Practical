package util;

import com.absli.APIData.ApiData;
import com.absli.base.TestBase;
import com.absli.base.WebDriverFactoryStaticThreadLocal;
//import com.absli.pageObjects.ListingScreenFrontEnd;
import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


import java.io.*;
import java.net.URL;
import java.util.ArrayList;


public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 90;
	public static long IMPLICIT_WAIT = 20;

	public static String TESTDATA_SHEET_PATH = "/Users/smishra226/Desktop/ABSLI-Leap/src/main/java/testdata/TestData.xlsx";

	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;

	public void switchToFrame() {
		WebDriverFactoryStaticThreadLocal.getDriver().switchTo().frame("mainpanel");
	}

	public static Object[][] getTestData(String sheetName) throws InvalidFormatException {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) WebDriverFactoryStaticThreadLocal.getDriver()).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	public static void runTimeInfo(String messageType, String message) throws InterruptedException {
		js = (JavascriptExecutor) WebDriverFactoryStaticThreadLocal.getDriver();
		// Check for jQuery on the page, add it if need be
		js.executeScript("if (!window.jQuery) {"
				+ "var jquery = document.createElement('script'); jquery.type = 'text/javascript';"
				+ "jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
				+ "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");
		Thread.sleep(5000);

		// Use jQuery to add jquery-growl to the page
		js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");

		// Use jQuery to add jquery-growl styles to the page
		js.executeScript("$('head').append('<link rel=\"stylesheet\" "
				+ "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
		Thread.sleep(5000);

		// jquery-growl w/ no frills
		js.executeScript("$.growl({ title: 'GET', message: '/' });");
//'"+color+"'"
		if (messageType.equals("error")) {
			js.executeScript("$.growl.error({ title: 'ERROR', message: '"+message+"' });");
		}else if(messageType.equals("info")){
			js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
		}else if(messageType.equals("warning")){
			js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");
		}else
			System.out.println("no error message");
		// jquery-growl w/ colorized output
//		js.executeScript("$.growl.error({ title: 'ERROR', message: 'your error message goes here' });");
//		js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
//		js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");
		Thread.sleep(5000);
	}
	public static void scrollTillTOPOfPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) WebDriverFactoryStaticThreadLocal.getDriver();
		((JavascriptExecutor) WebDriverFactoryStaticThreadLocal.getDriver()).executeScript("window.scrollTo(document.body.scrollHeight,0)");

	}


	public static void scrollTillEndOfPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) WebDriverFactoryStaticThreadLocal.getDriver();
		((JavascriptExecutor) WebDriverFactoryStaticThreadLocal.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}

	public static void verifyRedbgColor(WebElement element, WebDriver driver) throws InterruptedException {
		((JavascriptExecutor) WebDriverFactoryStaticThreadLocal.getDriver()).executeScript("arguments[0].style.border='3px solid yellow'", element);
		Thread.sleep(2000);
		((JavascriptExecutor) WebDriverFactoryStaticThreadLocal.getDriver()).executeScript("arguments[0].style.border='3px solid crimson'", element);
	}
	public static void verifybgColor(WebElement element, WebDriver driver) throws InterruptedException {
		((JavascriptExecutor) WebDriverFactoryStaticThreadLocal.getDriver()).executeScript("arguments[0].style.border='3px solid yellow'", element);
		Thread.sleep(1000);
		((JavascriptExecutor) WebDriverFactoryStaticThreadLocal.getDriver()).executeScript("arguments[0].style.border='3px solid white'", element);
	}
	public static void scrollToElement(WebDriver driver, WebElement element) {
		Actions a = new Actions(WebDriverFactoryStaticThreadLocal.getDriver());
		a.moveToElement(element).build().perform();
	}
	public static void scrollToTopOfthePage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) WebDriverFactoryStaticThreadLocal.getDriver();
		((JavascriptExecutor) WebDriverFactoryStaticThreadLocal.getDriver()).executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	}
	public static void scrollToTopOfthePagetill255(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) WebDriverFactoryStaticThreadLocal.getDriver();
		js.executeScript("window.scrollBy(0,-255)", "");
	}
	public static void scrollToTopOfthePagetill200(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) WebDriverFactoryStaticThreadLocal.getDriver();
		js.executeScript("window.scrollBy(0,-200)", "");
	}


	public ArrayList<String> openNewTab(WebDriver driver, String url) {
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(WebDriverFactoryStaticThreadLocal.getDriver().getWindowHandles());
		WebDriverFactoryStaticThreadLocal.getDriver().switchTo().window(tabs.get(1));
		WebDriverFactoryStaticThreadLocal.getDriver().get(url);
		return tabs;
	}

	public void chooseActionButton(WebElement element) {

		element.click();
	}

	/*public void pdfUtil(String userName, String passWord, String getappNum,String premium ) throws IOException, InterruptedException {
		ApiData apiData = new ApiData();
		String token = apiData.getToken(userName,passWord);
		String[] splitStr = apiData.getPDF(userName, getappNum,token).split("\\s+");
	//	String urlname = "file:///Users/shubhammishra/Downloads/"+splitStr[0];

		String fileName = System.getProperty("user.dir")+splitStr[0];
		String urlname = "file://"+System.getProperty("user.dir")+splitStr[0];
		String base64 = splitStr[1];
		ListingScreenFrontEnd listingScreenFrontEnd = new ListingScreenFrontEnd(WebDriverFactoryStaticThreadLocal.getDriver());
		readFromPDF(getappNum,premium,listingScreenFrontEnd.getCustomerName(),1, urlname,fileName,base64);
	}
*/


//	public void pdfUtil(String userName, String passWord, String getappNum,String premium1,String InstallmentPremium,String sumAssured1, String pptOption, String term, String paymode) throws IOException, InterruptedException {
//		ApiData apiData = new ApiData();
//		String token = apiData.getToken(userName,passWord);
//		String[] splitStr = apiData.getPDF(userName, getappNum,token).split("\\s+");
//		//	String urlname = "file:///Users/shubhammishra/Downloads/"+splitStr[0];
//
//		String fileName = System.getProperty("user.dir")+splitStr[0];
//		String urlname = "file:\\\\"+"\\"+System.getProperty("user.dir")+splitStr[0];
//		System.out.println(urlname);
//		String base64 = splitStr[1];
//		ListingScreenFrontEnd listingScreenFrontEnd = new ListingScreenFrontEnd(WebDriverFactoryStaticThreadLocal.getDriver());
//		readFromPDF(getappNum,premium1,InstallmentPremium,listingScreenFrontEnd.getCustomerName(),1, urlname,fileName,base64,sumAssured1,pptOption,term,paymode);
//	}

	public void readFromPDF(String applicationNum, String premium1, String InstallmentPremium, String Name, int pageNum, String urlname, String fileName, String base64, String sumAssured1, String pptOption, String term, String paymode) throws IOException, InterruptedException {
//		BASE64Decoder decoder = new BASE64Decoder();
//		byte[] decodedBytes = decoder.decodeBuffer(base64);
//		File file = new File(fileName);
//		FileOutputStream fop = new FileOutputStream(fileName);
//		fop.write(decodedBytes);
//		fop.flush();
//		fop.close();
		URL url = new URL(urlname.trim());
		//URL urlobj = (URL)new URL(url.trim());
		System.out.println(url);
		InputStream inputStream = url.openStream();
		BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
		PDDocument pdDocument = PDDocument.load(bufferedInputStream);
		int PageCount = pdDocument.getNumberOfPages();
		System.out.println("==================Started extracting the pdf Content==============");
		PDFTextStripper pdfTextStripper = new PDFTextStripper();
		pdfTextStripper.setStartPage(pageNum);
		String pdfText = pdfTextStripper.getText(pdDocument);
		System.out.println(pdfText);

		//Applicant Name
		String[] nameFromApplication = Name.split("\\s+");
		String changedName = nameFromApplication[0];
		/** Update the assertions as per the requirement **/
		//	Assert.assertTrue(pdfText.contains(applicationNum));
		Assert.assertTrue(pdfText.contains(changedName.toUpperCase()));
		//Assert.assertTrue(pdfText.contains(premium1));
		//Assert.assertTrue(pdfText.contains(InstallmentPremium));
		Assert.assertTrue(pdfText.contains(sumAssured1));
		if (pptOption.equalsIgnoreCase("Regular Pay")) {
			//Assert.assertTrue(pdfText.contains(pptOption.equals(term)));
			Assert.assertTrue(pdfText.contains(term));
		}else {
			Assert.assertTrue(pdfText.contains(pptOption));
			Assert.assertTrue(pdfText.contains(term));
		}
		Assert.assertTrue(pdfText.contains(paymode));
	}

}
