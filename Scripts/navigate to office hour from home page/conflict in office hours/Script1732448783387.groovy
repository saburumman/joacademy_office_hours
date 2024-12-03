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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.JavascriptExecutor

// Function to create a dynamic TestObject
TestObject createDynamicObject(String xpath) {
    TestObject dynamicObject = new TestObject()
    dynamicObject.addProperty("xpath", ConditionType.EQUALS, xpath)
    return dynamicObject
}

WebUI.openBrowser('')
WebUI.maximizeWindow()

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

WebUI.click(findTestObject('Object Repository/office hour/home page in tawjihi program/joacademy logo new'))

if (WebUI.verifyElementPresent(findTestObject('Object Repository/office hour/first subcategory -office hour- home page/splash popup'), 0)) {
    WebUI.click(findTestObject('Object Repository/office hour/first subcategory -office hour- home page/splash popup'))
}

if (!(WebUI.verifyElementText(findTestObject('Object Repository/office hour/home page in tawjihi program/change program selector'), 'برنامج التوجيهي'))) {
    WebUI.click(findTestObject('Object Repository/office hour/home page in tawjihi program/change program selector'))
    WebUI.click(findTestObject('Object Repository/office hour/home page in tawjihi program/program tawjihi from list in bannar'))
} else {
    WebUI.click(findTestObject('Object Repository/office hour/home page in tawjihi program/tawjihi first sub-category button in home page'))
    WebUI.click(findTestObject('Object Repository/office hour/first subcategory -office hour- home page/office hour first sub-category from home page'))
}

// Find the element and scroll to view
TestObject officehourdates = findTestObject('Object Repository/office hour/office hour first element/first element in dates of office hours')
JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getWebDriver()
// Use JavaScript to center the element on the screen
js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", WebUI.findWebElement(officehourdates))
WebUI.click(officehourdates)

// Find the element
TestObject officehourcard = findTestObject('Object Repository/office hour/office hour first element/first element office hour')
// Use JavaScript to center the element on the screen
js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", WebUI.findWebElement(officehourcard))

// Capture First Office Hour Title from Home Page
TestObject FirstOfficeHourTitleObject = createDynamicObject("//p[contains(@class, 'tw-line-clamp-2')]")
String homePageOfficeHourTitle = WebUI.getText(FirstOfficeHourTitleObject).trim()
println("Homepage Office Hour Title: " + homePageOfficeHourTitle)

TestObject SecondOfficeHourTitleObject = createDynamicObject("(//p[contains(@class, 'tw-line-clamp-2')])[2]")
String secondOfficeHourTitle = WebUI.getText(SecondOfficeHourTitleObject)
println("Second Office Hour Title: ${secondOfficeHourTitle}")

WebUI.click(findTestObject('Object Repository/office hour/office hour first element/first element office hour'))
WebUI.click(findTestObject('Object Repository/office hour/second element office hour'))

TestObject toastMessage = findTestObject('Object Repository/office hour/home page in tawjihi program/Error Message when adding office hour')
String ErrorMessage = "لا يمكنك إضافة هذه الحصة لرزنامتك فهي تتعارض مع موعد حصة مضافة سابقاً لرزنامتك"
WebUI.click(toastMessage)

if (WebUI.waitForElementVisible(toastMessage, 10)) {
    String actualMessage = WebUI.getText(toastMessage)
    if (actualMessage == ErrorMessage) {
        WebUI.comment("Error message detected: " + actualMessage)
		
		// Find the element and scroll to view
		TestObject officehoursidebar =findTestObject('Object Repository/office hour/my calender side bar/my calender button')
		// Use JavaScript to center the element on the screen
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", WebUI.findWebElement(officehoursidebar))
		
        WebUI.click(findTestObject('Object Repository/office hour/my calender side bar/my calender button'))
        WebUI.waitForPageLoad(30)
		
		// Find the element
		TestObject officehourcalender = findTestObject('Object Repository/office hour/my calender side bar/office hours inside my calender')
		// Use JavaScript to center the element on the screen
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", WebUI.findWebElement(officehourcalender))
		WebUI.click(officehourcalender)
		
		// Find the element
		TestObject cardincalender =findTestObject('Object Repository/office hour/my calender side bar/office hours inside my calender')
		// Use JavaScript to center the element on the screen
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", WebUI.findWebElement(cardincalender))
		WebUI.delay(5) // Delays the execution for 5 seconds
		
		// Get the title of the office hour from "My Calendar"
        TestObject myCalendarOfficeHourTitleObject = createDynamicObject("//h2[contains(@class, 'tw-font-bold')]")
        String myCalendarOfficeHourTitle = WebUI.getText(myCalendarOfficeHourTitleObject)
        println("My Calendar Office Hour Title: " + myCalendarOfficeHourTitle)

		
        if (homePageOfficeHourTitle == myCalendarOfficeHourTitle) {
            WebUI.comment("The office hour titles match: " + homePageOfficeHourTitle)
        } else {
            WebUI.comment("Mismatch in office hour titles! Home Page: " + homePageOfficeHourTitle + ", My Calendar: " + myCalendarOfficeHourTitle)
        }

        if (myCalendarOfficeHourTitle.contains(secondOfficeHourTitle)) {
            WebUI.comment("Error: The second office hour title should not appear in the calendar, but it was found: " + secondOfficeHourTitle)
        } else {
            WebUI.comment("The second office hour title is not present in the calendar as expected.")
        }
    }
}
