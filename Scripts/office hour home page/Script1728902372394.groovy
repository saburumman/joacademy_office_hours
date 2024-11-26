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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import java.util.Random
import java.util.Arrays

WebUI.openBrowser('')

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

if (WebUI.verifyElementPresent(findTestObject('Object Repository/office hour/first subcategory -office hour- home page/splash popup'), 0)) {
    WebUI.click(findTestObject('Object Repository/office hour/first subcategory -office hour- home page/splash popup'))
}

if (!(WebUI.verifyElementText(findTestObject('Object Repository/office hour/home page in tawjihi program/change program selector'), 'برنامج التوجيهي'))){
	WebUI.click(findTestObject('Object Repository/office hour/home page in tawjihi program/change program selector'))	
	WebUI.click(findTestObject('Object Repository/office hour/home page in tawjihi program/program tawjihi from list in bannar'))
}
else {
	WebUI.click(findTestObject('Object Repository/office hour/home page in tawjihi program/tawjihi first sub-category button in home page'))
	WebUI.click(findTestObject('Object Repository/office hour/first subcategory -office hour- home page/office hour first sub-category from home page'))
}

// Find all available office hour elements
List<WebElement> availableOfficehours =
	WebUiCommonHelper.findWebElements(findTestObject('Object Repository/office hour/first subcategory -office hour- home page/add to my calender button'), 10)

if (availableOfficehours.size() > 0) {
	Random random = new Random()
	WebElement randomOfficehours
	String requiredButtonText = "اضف الى رزنامتي"
	boolean validButtonFound = false
	String selectedOfficeHourTime = "" // Added: Define this to store the selected office hour time
    String selectedOfficeHourDate = "" // Added: Define this to store the selected office hour date

	// Loop until a button whose text is "اضف الى رزنامتي" is found
	while (!validButtonFound) {
		// Randomly select an office hour button
		randomOfficehours = availableOfficehours.get(random.nextInt(availableOfficehours.size()))
		
		// Check the text of the randomly selected button
		if (randomOfficehours.getText().equals(requiredButtonText)) {
			validButtonFound = true

			// Added: Extract the selected office hour's time and date from the element
			selectedOfficeHourTime = randomOfficehours.getAttribute("data-time") // Adjust as per your actual HTML structure
			selectedOfficeHourDate = randomOfficehours.getAttribute("data-date") // Adjust as per your actual HTML structure
		}
	}
	
	// Click the valid button found
	WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(randomOfficehours))
	
	// Wait for the potential error message to appear
	WebUI.delay(2) // Adjust delay as needed for the error message to appear
	
	// Check for the specific validation error message
    String errorMessage = "لا يمكنك إضافة هذه الحصة لرزنامتك فهي تتعارض مع موعد حصة مضافة سابقاً لرزنامتك"
    if (WebUI.verifyTextPresent(errorMessage, false, FailureHandling.OPTIONAL)) {
        // If the error message is present, click the calendar link button
        WebUI.click(findTestObject('Object Repository/office hour/my calender side bar/my calender button'))
		WebUI.click(findTestObject('Object Repository/office hour/my calender side bar/office hours inside my calender'))
    }
} else { 
    WebUI.comment("No available office hours to select.")
}

String monthFromTheCalnedr = WebUI.getText(findTestObject('Object Repository/office hour/my calender side bar/Month_Select_in_My_Calnder'))
String English_Month = "0"

switch (monthFromTheCalnedr){
	case 'January':
	
	
	
	
	
	
	
	
}





