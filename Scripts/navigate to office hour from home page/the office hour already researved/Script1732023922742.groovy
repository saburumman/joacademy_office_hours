import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor


// Function to create a dynamic TestObject
TestObject createDynamicObject(String xpath) {
	TestObject dynamicObject = new TestObject()
	dynamicObject.addProperty("xpath", ConditionType.EQUALS, xpath)
	return dynamicObject
}




WebUI.openBrowser('')

WebUI.maximizeWindow()

JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getWebDriver()

WebUI.navigateToUrl('https://www.joacademy.com/')

WebUI.click(findTestObject('recording login test case/Page_- joacademy.com/select program from landing page'))

WebUI.click(findTestObject('Object Repository/recording login test case/Page_- joacademy.com/splash popup'))

WebUI.click(findTestObject('recording login test case/Page_- joacademy.com/login button'))

WebUI.click(findTestObject('Object Repository/recording login test case/Page_- joacademy.com/login by email button'))

WebUI.setText(findTestObject('Object Repository/recording login test case/Page_- joacademy.com/input_email'), 'std_9928954@joacademy.com')

WebUI.setEncryptedText(findTestObject('Object Repository/recording login test case/Page_- joacademy.com/input_password'),
	'aeHFOx8jV/A=')

WebUI.click(findTestObject('Object Repository/recording login test case/Page_- joacademy.com/submit login by email button'))

WebUI.verifyElementNotPresent(findTestObject('recording login test case/Page_- joacademy.com/login button'), 0)

WebUI.click(findTestObject('Object Repository/office hour/home page in tawjihi program/joacademy logo'))

if (WebUI.verifyElementPresent(findTestObject('Object Repository/office hour/first subcategory -office hour- home page/splash popup'),
	0)) {
	WebUI.click(findTestObject('Object Repository/office hour/first subcategory -office hour- home page/splash popup'))
}

if (!(WebUI.verifyElementText(findTestObject('Object Repository/office hour/home page in tawjihi program/change program selector'),
	'برنامج التوجيهي'))) {
	WebUI.click(findTestObject('Object Repository/office hour/home page in tawjihi program/change program selector'))

	WebUI.click(findTestObject('Object Repository/office hour/home page in tawjihi program/program tawjihi from list in bannar'))
} else {
	WebUI.click(findTestObject('Object Repository/office hour/home page in tawjihi program/tawjihi first sub-category button in home page'))

	WebUI.click(findTestObject('Object Repository/office hour/first subcategory -office hour- home page/office hour first sub-category from home page'))
}
TestObject officehourdate =findTestObject('Object Repository/office hour/office hour first element/first element in dates of office hours')

// Use JavaScript to center the element on the screen
js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", WebUI.findWebElement(officehourdate))

WebUI.click(findTestObject('Object Repository/office hour/office hour first element/first element in dates of office hours'))

// Find the element
TestObject officehourcard=findTestObject('Object Repository/office hour/office hour first element/first element office hour')

// Use JavaScript to center the element on the screen
js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", WebUI.findWebElement(officehourcard))

String homePageOfficeHourTitle = WebUI.getText(findTestObject('Object Repository/office hour/office hour first element/title of the first office hour'))
// Retrieve Title Text from the homepage
TestObject titleObject = createDynamicObject("//p[contains(@class, 'tw-line-clamp-2')]")
homePageOfficeHourTitle = WebUI.getText(titleObject)
println("Homepage Office Hour Title: " + homePageOfficeHourTitle)


WebUI.verifyElementText(findTestObject('Object Repository/office hour/home page in tawjihi program/redirect to my calender button'), 'الذهاب الى رزنامتي')
WebUI.click(findTestObject('Object Repository/office hour/home page in tawjihi program/redirect to my calender button'))


// Find the element
TestObject officehourcalender = findTestObject('Object Repository/office hour/my calender side bar/office hours inside my calender')
// Use JavaScript to center the element on the screen
js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", WebUI.findWebElement(officehourcalender))
WebUI.click(findTestObject('Object Repository/office hour/my calender side bar/my calender button'))

// Find the element
TestObject cardincalender =findTestObject('Object Repository/office hour/my calender side bar/office hours inside my calender')
// Use JavaScript to center the element on the screen
js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", WebUI.findWebElement(cardincalender))
WebUI.delay(5) // Delays the execution for 5 seconds

// Get the title of the office hour from "My Calendar"
TestObject h2Object = createDynamicObject("//h2[contains(@class, 'tw-font-bold')]")
String myCalendarOfficeHourTitle = WebUI.getText(h2Object)
println("My Calendar Office Hour Title: " + myCalendarOfficeHourTitle)


// Compare the titles
if (homePageOfficeHourTitle == myCalendarOfficeHourTitle) {
	WebUI.comment("The office hour titles match: " + homePageOfficeHourTitle)
} else {
	WebUI.comment("Mismatch in office hour titles! Home Page: " + homePageOfficeHourTitle + ", My Calendar: " + myCalendarOfficeHourTitle)
}
// Close the browser
//WebUI.closeBrowser(
